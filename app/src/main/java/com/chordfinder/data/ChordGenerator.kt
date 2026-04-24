package com.chordfinder.data

/**
 * Генератор аккордов на основе музыкальной теории.
 * Создаёт аппликатуры для гитары и укулеле если они отсутствуют в JSON.
 */
object ChordGenerator {

    // Стройки инструментов (в полутонах относительно C, от низкой струны к высокой)
    val GUITAR_TUNING = listOf(4, 9, 2, 7, 11, 4) // E A D G B e
    val UKULELE_TUNING = listOf(7, 0, 4, 9)       // G C E A

    private val NOTE_NAMES = listOf("C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B")

    // Формулы аккордов (интервалы в полутонах от тоники)
    private val CHORD_FORMULAS = mapOf(
        // Основные трезвучия
        "" to listOf(0, 4, 7),           // Major (C = C, E, G)
        "M" to listOf(0, 3, 7),          // Minor (Cm = C, Eb, G) - matches JSON format
        "DIM" to listOf(0, 3, 6),        // Diminished (Cdim = C, Eb, Gb)
        "AUG" to listOf(0, 4, 8),        // Augmented (Caug = C, E, G#)

        // Септаккорды
        "7" to listOf(0, 4, 7, 10),      // Dominant 7 (C7 = C, E, G, Bb)
        "M7" to listOf(0, 4, 7, 11),     // Major 7 (CM7 = C, E, G, B)
        "MAJ7" to listOf(0, 4, 7, 11),   // Major 7 (альтернативное название)
        "DIM7" to listOf(0, 3, 6, 9),    // Diminished 7 (Cdim7 = C, Eb, Gb, A)

        // Sus и Add
        "SUS2" to listOf(0, 2, 7),       // Sus2 (Csus2 = C, D, G)
        "SUS4" to listOf(0, 5, 7),       // Sus4 (Csus4 = C, F, G)
        "SUS" to listOf(0, 5, 7),        // Sus = Sus4
        "ADD9" to listOf(0, 4, 7, 14),   // Add9 (Cadd9 = C, E, G, D)
        "ADD2" to listOf(0, 2, 4, 7),    // Add2 (Cadd2 = C, D, E, G)
        "ADD11" to listOf(0, 4, 5, 7),   // Add11 (Cadd11 = C, E, F, G)
        "ADD" to listOf(0, 4, 7, 14),    // Add = Add9

        // Другие
        "6" to listOf(0, 4, 7, 9),       // Major 6 (C6 = C, E, G, A)
        "M6" to listOf(0, 3, 7, 9),      // Minor 6 (Cm6 = C, Eb, G, A)
        "9" to listOf(0, 4, 7, 10, 14),  // Dominant 9 (C9 = C, E, G, Bb, D)
        "5" to listOf(0, 7),             // Power chord (C5 = C, G)
        "7NO3" to listOf(0, 7, 10),      // 7no3 (C7no3 = C, G, Bb - без трети)
        "7NO5" to listOf(0, 4, 10),      // 7no5 (C7no5 = C, E, Bb - без квинты)
    )

    /**
     * Разобрать название аккорда на составляющие
     * @return Pair(базовая нота в полутонах, суффикс аккорда)
     */
    fun parseChordName(name: String): Pair<Int, String>? {
        val normalized = name.uppercase()
            .replace("MAJOR", "")
            .replace("MINOR", "M")
            .replace("MAJ", "")
            .replace("MIN", "M")

        // Регулярное выражение для разбора: нота + опциональные знаки + суффикс
        val regex = Regex("^([A-G])([#♯S]?)([B♭]?)(.*)$")
        val match = regex.find(normalized) ?: return null

        val noteLetter = match.groupValues[1]
        val sharp = match.groupValues[2]
        val flat = match.groupValues[3]
        val suffix = match.groupValues[4]
            .replace("SUS2", "SUS2")
            .replace("SUS4", "SUS4")
            .replace("SUS", "SUS4") // По умолчанию sus = sus4
            .replace("MAJ7", "M7")
            .replace("MAJOR7", "M7")
            .replace("ADD9", "ADD9")
            .replace("ADD", "ADD9")
            .replace("B5", "MAJ7S5") // Специальный случай

        // Вычислить базовую ноту
        val baseNoteIndex = NOTE_NAMES.indexOf(noteLetter)
        if (baseNoteIndex == -1) return null

        val accidental = when {
            sharp.isNotEmpty() -> 1
            flat.isNotEmpty() -> -1
            else -> 0
        }

        val rootNote = (baseNoteIndex + accidental + 12) % 12
        val cleanSuffix = if (suffix == "M") "M" else suffix

        return Pair(rootNote, cleanSuffix)
    }

    /**
     * Получить ноты аккорда по формуле
     */
    fun getChordNotes(rootNote: Int, suffix: String): List<Int> {
        val formula = CHORD_FORMULAS[suffix] ?: CHORD_FORMULAS[""] ?: listOf(0, 4, 7)
        return formula.map { (rootNote + it) % 12 }
    }

    /**
     * Найти все возможные позиции ноты на струнах инструмента
     * @return список пар (струна, лад), струна 0-индексирована (0 = первая/толстая)
     */
    fun findNotePositions(note: Int, tuning: List<Int>, maxFret: Int = 12): List<Pair<Int, Int>> {
        val positions = mutableListOf<Pair<Int, Int>>()

        for ((stringIndex, openNote) in tuning.withIndex()) {
            for (fret in 0..maxFret) {
                val fretNote = (openNote + fret) % 12
                if (fretNote == note) {
                    positions.add(Pair(stringIndex, fret))
                }
            }
        }

        return positions
    }

    /**
     * Генерировать позицию аккорда для инструмента
     * @return ChordPosition или null если невозможно построить
     */
    fun generateChordPosition(
        chordName: String,
        instrument: Instrument,
        tuning: List<Int>,
        maxFret: Int = 12,
        maxStretch: Int = 4 // Максимальное растяжение пальцев
    ): ChordPosition? {
        val (rootNote, suffix) = parseChordName(chordName) ?: return null
        val chordNotes = getChordNotes(rootNote, suffix)

        val stringsCount = tuning.size

        // Для каждой струны найти подходящие позиции
        val stringOptions = (0 until stringsCount).map { stringIndex ->
            val openNote = tuning[stringIndex]
            (0..maxFret).mapNotNull { fret ->
                val note = (openNote + fret) % 12
                if (note in chordNotes || fret == 0) {
                    Pair(stringIndex, fret)
                } else null
            }
        }

        // Попробовать найти позицию с аккордом в открытой позиции или ближе к началу
        val bestPosition = findBestPosition(stringOptions, chordNotes, stringsCount, maxStretch, tuning)
            ?: findAnyValidPosition(stringOptions, chordNotes, stringsCount, maxStretch, tuning)

        return bestPosition?.let { (frets, barres, fingers) ->
            ChordPosition(
                instrument = instrument,
                frets = frets.mapIndexed { index, fret ->
                    Fret(
                        string = index + 1, // 1-индексированная струна
                        fret = fret,
                        finger = fingers[index]
                    )
                },
                barres = barres,
                fingers = fingers.mapIndexedNotNull { index, finger ->
                    finger?.let { Finger(it, index + 1, frets[index]) }
                }
            )
        }
    }

    /**
     * Найти лучшую позицию (с минимальным барре, ближе к началу)
     */
    private fun findBestPosition(
        stringOptions: List<List<Pair<Int, Int>>>,
        chordNotes: List<Int>,
        stringsCount: Int,
        maxStretch: Int,
        tuning: List<Int>
    ): Triple<List<Int>, List<Barre>, List<Int?>>? {

        // Пробуем открытую позицию сначала (лад 0-5)
        for (baseFret in 0..5) {
            val result = tryPositionAtFret(stringOptions, chordNotes, stringsCount, baseFret, maxStretch, tuning)
            if (result != null) return result
        }
        return null
    }

    private fun findAnyValidPosition(
        stringOptions: List<List<Pair<Int, Int>>>,
        chordNotes: List<Int>,
        stringsCount: Int,
        maxStretch: Int,
        tuning: List<Int>
    ): Triple<List<Int>, List<Barre>, List<Int?>>? {
        // Пробуем любую позицию до 12 лада
        for (baseFret in 0..12) {
            val result = tryPositionAtFret(stringOptions, chordNotes, stringsCount, baseFret, maxStretch, tuning)
            if (result != null) return result
        }
        return null
    }

    /**
     * Попробовать построить позицию начиная с определённого лада
     */
    private fun tryPositionAtFret(
        stringOptions: List<List<Pair<Int, Int>>>,
        chordNotes: List<Int>,
        stringsCount: Int,
        baseFret: Int,
        maxStretch: Int,
        tuning: List<Int>
    ): Triple<List<Int>, List<Barre>, List<Int?>>? {
        val frets = MutableList(stringsCount) { -1 } // -1 = не играется
        val fingers = MutableList<Int?>(stringsCount) { null }

        var minFret = 100
        var maxFret = -1

        // Для каждой струны выбрать подходящий лад
        for (stringIndex in 0 until stringsCount) {
            val openNote = tuning[stringIndex]

            // Фильтруем только ноты аккорда (открытые струны только если входят в аккорд)
            val options = stringOptions[stringIndex].filter { (_, fret) ->
                val note = (openNote + fret) % 12
                note in chordNotes && (fret == 0 || (fret >= baseFret && fret <= baseFret + maxStretch))
            }

            // Выбираем наименьший подходящий лад
            val bestOption = options.firstOrNull()

            if (bestOption != null) {
                val (_, fret) = bestOption
                frets[stringIndex] = fret
                if (fret > 0) {
                    minFret = minOf(minFret, fret)
                    maxFret = maxOf(maxFret, fret)
                }
            }
            // Если нет подходящих опций для струны - оставляем -1 (не играет)
        }

        // Проверяем что все ноты аккорда присутствуют в позиции
        val playedNoteSet = mutableSetOf<Int>()
        for ((stringIndex, fret) in frets.withIndex()) {
            if (fret >= 0) {
                val openNote = tuning[stringIndex]
                val note = (openNote + fret) % 12
                playedNoteSet.add(note)
            }
        }

        // Должны присутствовать все ноты аккорда
        if (!chordNotes.all { it in playedNoteSet }) return null

        // Если позиция валидна (минимум 3 струны играют для гитары, 4 для укулеле)
        val playedStrings = frets.count { it >= 0 }
        if (playedStrings < 3) return null

        // Расставляем пальцы (упрощённо)
        assignFingers(frets, fingers, minFret, maxFret)

        // Определяем барре если нужно
        val barres = findBarres(frets, minFret)

        return Triple(frets, barres, fingers)
    }

    private fun assignFingers(frets: List<Int>, fingers: MutableList<Int?>, minFret: Int, maxFret: Int) {
        // Упрощённая логика: 1-й палец на минимальном ладу, остальные по порядку
        var nextFinger = 1
        val sortedIndices = frets.withIndex().filter { it.value > 0 }.sortedBy { it.value }

        for ((index, fret) in sortedIndices) {
            fingers[index] = nextFinger
            nextFinger++
            if (nextFinger > 4) nextFinger = 1 // Переиспользуем пальцы (не идеально, но работает)
        }
    }

    private fun findBarres(frets: List<Int>, minFret: Int): List<Barre> {
        val barres = mutableListOf<Barre>()

        // Ищем струны с одинаковым ладом = minFret (потенциальный барре)
        val barreStrings = frets.withIndex().filter { it.value == minFret && minFret > 0 }

        if (barreStrings.size >= 2) {
            val fromString = barreStrings.minOf { it.index } + 1
            val toString = barreStrings.maxOf { it.index } + 1

            barres.add(Barre(
                fret = minFret,
                fromString = fromString,
                toString = toString,
                finger = 1 // Указательный палец
            ))
        }

        return barres
    }

    /**
     * Генерировать или исправить позиции для всех инструментов
     */
    fun generateMissingPositions(chord: Chord): List<ChordPosition> {
        val positions = chord.positions.toMutableList()

        // Проверить и сгенерировать для гитары
        val hasGuitar = positions.any { it.instrument == Instrument.GUITAR }
        val hasValidGuitar = hasGuitar && positions.find { it.instrument == Instrument.GUITAR }?.frets?.all { it.fret == 0 } == false

        if (!hasValidGuitar) {
            // Удалить существующую невалидную позицию гитары
            positions.removeAll { it.instrument == Instrument.GUITAR }

            // Сгенерировать новую
            generateChordPosition(chord.name, Instrument.GUITAR, GUITAR_TUNING)?.let {
                positions.add(it)
            }
        }

        // Проверить и сгенерировать для укулеле
        val hasUkulele = positions.any { it.instrument == Instrument.UKULELE }
        val hasValidUkulele = hasUkulele && positions.find { it.instrument == Instrument.UKULELE }?.frets?.all { it.fret == 0 } == false

        if (!hasValidUkulele) {
            // Удалить существующую невалидную позицию укулеле
            positions.removeAll { it.instrument == Instrument.UKULELE }

            // Сгенерировать новую
            generateChordPosition(chord.name, Instrument.UKULELE, UKULELE_TUNING)?.let {
                positions.add(it)
            }
        }

        return positions
    }
}
