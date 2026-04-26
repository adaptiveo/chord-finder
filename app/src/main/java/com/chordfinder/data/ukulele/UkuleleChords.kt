package com.chordfinder.data.ukulele

import com.chordfinder.data.*

/**
 * Канонические позиции аккордов для укулеле.
 * Формат: [струна G, струна C, струна E, струна A]
 * -1 = не играет (X), 0 = открытая, >0 = лад
 *
 * Tuning: G4 C4 E4 A4 (ре-ентрантный, G выше C)
 */
object UkuleleChords {

    /**
     * Проверить, есть ли каноническая позиция для аккорда
     */
    fun getCanonicalPosition(chordName: String): List<Int>? {
        val (rootNote, suffix) = parseChordName(chordName) ?: return null
        val key = "${getNoteName(rootNote)}$suffix"

        return CANONICAL_POSITIONS[key]
    }

    private fun getNoteName(semitone: Int): String {
        val names = listOf("C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B")
        return names[semitone]
    }

    private fun parseChordName(name: String): Pair<Int, String>? {
        val normalized = name.uppercase()
            .replace("MAJOR", "")
            .replace("MINOR", "M")
            .replace("MAJ", "")
            .replace("MIN", "M")

        val regex = Regex("^([A-G])([#♯S]?)([B♭]?)(.*)$")
        val match = regex.find(normalized) ?: return null

        val noteLetter = match.groupValues[1]
        val sharp = match.groupValues[2]
        val flat = match.groupValues[3]
        val suffix = match.groupValues[4]

        val noteMap = mapOf(
            "C" to 0, "C#" to 1, "Db" to 1,
            "D" to 2, "D#" to 3, "Eb" to 3,
            "E" to 4, "Fb" to 4,
            "F" to 5, "F#" to 6, "Gb" to 6,
            "G" to 7, "G#" to 8, "Ab" to 8,
            "A" to 9, "A#" to 10, "Bb" to 10,
            "B" to 11, "Cb" to 11
        )

        val baseNote = noteMap[noteLetter] ?: return null
        val accidental = when {
            sharp.isNotEmpty() -> 1
            flat.isNotEmpty() -> -1
            else -> 0
        }

        val rootNote = (baseNote + accidental + 12) % 12
        return Pair(rootNote, suffix)
    }

    // Канонические позиции для основных аккордов
    // Формат: [G, C, E, A] - от 4-й струны к 1-й
    private val CANONICAL_POSITIONS = mapOf(
        // ===== Мажорные трезвучия =====
        "C" to listOf(0, 0, 0, 3),   // 0003 - классический C
        "D" to listOf(2, 2, 2, 0),   // 2220
        "E" to listOf(1, 4, 0, 2),   // 1402
        "F" to listOf(2, 0, 1, 0),   // 2010
        "G" to listOf(0, 2, 3, 2),   // 0232 - классический G
        "A" to listOf(2, 1, 0, 0),   // 2100

        // ===== Минорные трезвучия =====
        "CM" to listOf(0, 0, 0, 3),  // 0003 (как C, минор не виден на укулеле)
        "DM" to listOf(2, 2, 1, 0),  // 2210
        "EM" to listOf(0, 4, 0, 2),  // 0402
        "FM" to listOf(1, 0, 1, 0),  // 1010
        "GM" to listOf(0, 2, 3, 1),  // 0231
        "AM" to listOf(2, 0, 0, 0),  // 2000

        // ===== Септаккорды (dominant 7) =====
        "C7" to listOf(0, 0, 0, 1),  // 0001
        "D7" to listOf(2, 2, 1, 3),  // 2213
        "E7" to listOf(1, 2, 0, 2),  // 1202
        "F7" to listOf(2, 3, 1, 3),  // 2313
        "G7" to listOf(0, 2, 1, 2),  // 0212
        "A7" to listOf(0, 1, 0, 0),  // 0100

        // ===== Мажорный септаккорд (M7) =====
        "CM7" to listOf(0, 0, 0, 2), // 0002
        "DM7" to listOf(2, 2, 2, 3), // 2223
        "EM7" to listOf(1, 3, 0, 2), // 1302
        "FM7" to listOf(2, 0, 0, 0), // 2000
        "GM7" to listOf(0, 2, 2, 2), // 0222
        "AM7" to listOf(2, 1, 0, 3), // 2103

        // ===== Sus2 аккорды =====
        "CSUS2" to listOf(0, 0, 0, 2), // 0002
        "DSUS2" to listOf(2, 2, 2, 3), // 2223
        "ESUS2" to listOf(1, 4, 0, 0), // 1400
        "FSUS2" to listOf(2, 0, 0, 0), // 2000
        "GSUS2" to listOf(0, 2, 0, 2), // 0202
        "ASUS2" to listOf(2, 1, 0, 2), // 2102

        // ===== Sus4 аккорды =====
        "CSUS4" to listOf(0, 0, 1, 3), // 0013
        "DSUS4" to listOf(2, 2, 3, 0), // 2230
        "ESUS4" to listOf(1, 4, 0, 2), // 1402 (как E)
        "FSUS4" to listOf(2, 0, 1, 3), // 2013
        "GSUS4" to listOf(0, 2, 3, 3), // 0233
        "ASUS4" to listOf(2, 1, 0, 3), // 2103

        // ===== Add9 аккорды =====
        "CADD9" to listOf(0, 0, 0, 2), // 0002 (как Csus2)
        "DADD9" to listOf(2, 2, 2, 0), // 2220 (как D)
        "EADD9" to listOf(1, 4, 0, 2), // 1402 (как E)
        "FADD9" to listOf(2, 0, 1, 0), // 2010 (как F)
        "GADD9" to listOf(0, 2, 3, 2), // 0232 (как G)
        "AADD9" to listOf(2, 1, 0, 0), // 2100 (как A)

        // ===== Уменьшенные (DIM) =====
        "CDIM" to listOf(0, 0, 0, 2),  // 0002
        "DDIM" to listOf(2, 2, 1, 3),  // 2213 (как D7)
        "EDIM" to listOf(1, 2, 0, 2),  // 1202 (как E7)
        "FDIM" to listOf(2, 3, 1, 3),  // 2313 (как F7)
        "GDIM" to listOf(0, 2, 1, 2),  // 0212 (как G7)
        "ADIM" to listOf(0, 1, 0, 0),  // 0100 (как A7)

        // ===== Увеличенные (AUG) =====
        "CAUG" to listOf(0, 0, 0, 4),  // 0004
        "DAUG" to listOf(2, 2, 2, 1),  // 2221
        "EAUG" to listOf(1, 4, 0, 3),  // 1403
        "FAUG" to listOf(2, 0, 1, 1),  // 2011
        "GAUG" to listOf(0, 2, 3, 3),  // 0233
        "AAUG" to listOf(2, 1, 0, 1),  // 2101

        // ===== Квинтаккорды (5) =====
        "C5" to listOf(0, 0, 0, 3),    // 0003 (как C)
        "D5" to listOf(2, 2, 2, 0),    // 2220 (как D)
        "E5" to listOf(1, 4, 0, 2),    // 1402 (как E)
        "F5" to listOf(2, 0, 1, 0),    // 2010 (как F)
        "G5" to listOf(0, 2, 3, 2),    // 0232 (как G)
        "A5" to listOf(2, 1, 0, 0),    // 2100 (как A)

        // ===== Диезные мажорные аккорды =====
        "C#" to listOf(1, 1, 1, 4),    // 1114
        "D#" to listOf(3, 3, 3, 1),    // 3331
        "F#" to listOf(3, 1, 2, 1),    // 3121
        "G#" to listOf(1, 3, 4, 3),    // 1343
        "A#" to listOf(3, 2, 1, 1),    // 3211

        // ===== Бемольные мажорные аккорды =====
        "DB" to listOf(2, 2, 2, 0),    // 2220 (как D)
        "EB" to listOf(1, 4, 0, 2),    // 1402 (как E)
        "GB" to listOf(0, 2, 3, 2),    // 0232 (как G)
        "AB" to listOf(2, 1, 0, 0),    // 2100 (как A)
        "BB" to listOf(3, 3, 3, 2),    // 3332

        // ===== Диезные минорные аккорды =====
        "C#M" to listOf(1, 1, 1, 3),   // 1113
        "D#M" to listOf(3, 3, 2, 1),   // 3321
        "F#M" to listOf(3, 1, 2, 4),   // 3124
        "G#M" to listOf(1, 3, 4, 2),   // 1342
        "A#M" to listOf(3, 2, 1, 4),   // 3214

        // ===== 7#5 аккорды (dominant 7th augmented 5th) =====
        "C7#5" to listOf(0, 0, 0, 2),  // 0002
        "D7#5" to listOf(2, 2, 2, 1),  // 2221
        "E7#5" to listOf(1, 4, 0, 3),  // 1403
        "F7#5" to listOf(2, 0, 1, 1),  // 2011
        "G7#5" to listOf(0, 2, 3, 3),  // 0233
        "A7#5" to listOf(2, 1, 0, 1),  // 2101

        // ===== 7b5 аккорды (dominant 7th diminished 5th) =====
        "C7B5" to listOf(0, 0, 0, 0),  // 0000 (все открытые)
        "D7B5" to listOf(2, 2, 1, 2),  // 2212
        "E7B5" to listOf(1, 2, 0, 1),  // 1201
        "F7B5" to listOf(2, 3, 1, 2),  // 2312
        "G7B5" to listOf(0, 2, 1, 1),  // 0211
        "A7B5" to listOf(0, 1, 0, 3),  // 0103

        // ===== Минорные септаккорды (m7) =====
        "Cm7" to listOf(0, 0, 0, 1),   // 0001 (как C7)
        "Dm7" to listOf(2, 2, 1, 3),   // 2213 (как D7)
        "Em7" to listOf(1, 2, 0, 2),   // 1202 (как E7)
        "Fm7" to listOf(2, 3, 1, 3),   // 2313 (как F7)
        "Gm7" to listOf(0, 2, 1, 2),   // 0212 (как G7)
        "Am7" to listOf(0, 1, 0, 0),   // 0100 (как A7)

        // ===== Half-diminished (m7b5) =====
        "Cm7B5" to listOf(0, 0, 0, 0), // 0000
        "Dm7B5" to listOf(2, 2, 1, 2), // 2212
        "Em7B5" to listOf(1, 2, 0, 1), // 1201
        "Fm7B5" to listOf(2, 3, 1, 2), // 2312
        "Gm7B5" to listOf(0, 2, 1, 1), // 0211
        "Am7B5" to listOf(0, 1, 0, 3), // 0103

        // ===== Мажорные септаккорды с альтерированной квинтой =====
        "CM7#5" to listOf(0, 0, 0, 2), // 0002
        "DM7#5" to listOf(2, 2, 2, 1), // 2221
        "EM7#5" to listOf(1, 4, 0, 3), // 1403
        "FM7#5" to listOf(2, 0, 1, 1), // 2011
        "GM7#5" to listOf(0, 2, 3, 3), // 0233
        "AM7#5" to listOf(2, 1, 0, 1), // 2101

        // ===== Power chords для всех нот =====
        "B5" to listOf(3, 3, 3, 2),    // 3332
        "C#5" to listOf(1, 1, 1, 4),   // 1114
        "D#5" to listOf(3, 3, 3, 1),   // 3331
        "F#5" to listOf(3, 1, 2, 1),   // 3121
        "G#5" to listOf(1, 3, 4, 3),   // 1343
        "A#5" to listOf(3, 2, 1, 1),   // 3211

        // ===== Полные диезные/бемольные аккорды с септаккордами =====
        "C#7" to listOf(1, 1, 1, 2),   // 1112
        "D#7" to listOf(3, 3, 2, 4),   // 3324
        "F#7" to listOf(3, 1, 2, 4),   // 3124
        "G#7" to listOf(1, 3, 4, 5),   // 1345
        "A#7" to listOf(3, 2, 1, 4),   // 3214

        "DB7" to listOf(2, 2, 1, 3),   // 2213 (как D7)
        "EB7" to listOf(1, 2, 0, 2),   // 1202 (как E7)
        "GB7" to listOf(0, 2, 1, 2),   // 0212 (как G7)
        "AB7" to listOf(0, 1, 0, 0),   // 0100 (как A7)
        "BB7" to listOf(3, 3, 3, 2),   // 3332 (как B5)

        // ===== Sus2 и Sus4 для диезных/бемольных нот =====
        "C#SUS2" to listOf(1, 1, 1, 3), // 1113
        "D#SUS2" to listOf(3, 3, 2, 1), // 3321
        "F#SUS2" to listOf(3, 1, 2, 0), // 3120
        "G#SUS2" to listOf(1, 3, 4, 2), // 1342
        "A#SUS2" to listOf(3, 2, 1, 0), // 3210

        "C#SUS4" to listOf(1, 1, 2, 4), // 1124
        "D#SUS4" to listOf(3, 3, 3, 1), // 3331
        "F#SUS4" to listOf(3, 1, 2, 3), // 3123
        "G#SUS4" to listOf(1, 3, 4, 4), // 1344
        "A#SUS4" to listOf(3, 2, 1, 3), // 3213

        // ===== Add9 для диезных/бемольных нот =====
        "C#ADD9" to listOf(1, 1, 1, 3), // 1113
        "D#ADD9" to listOf(3, 3, 3, 1), // 3331
        "F#ADD9" to listOf(3, 1, 2, 1), // 3121
        "G#ADD9" to listOf(1, 3, 4, 3), // 1343
        "A#ADD9" to listOf(3, 2, 1, 1), // 3211

        // ===== Diminished для диезных/бемольных нот =====
        "C#DIM" to listOf(1, 1, 1, 3),  // 1113
        "D#DIM" to listOf(3, 3, 2, 4),  // 3324
        "F#DIM" to listOf(3, 1, 2, 4),  // 3124
        "G#DIM" to listOf(1, 3, 4, 5),  // 1345
        "A#DIM" to listOf(3, 2, 1, 4),  // 3214

        // ===== Augmented для диезных/бемольных нот =====
        "C#AUG" to listOf(1, 1, 1, 4),  // 1114
        "D#AUG" to listOf(3, 3, 3, 1),  // 3331
        "F#AUG" to listOf(3, 1, 2, 1),  // 3121
        "G#AUG" to listOf(1, 3, 4, 3),  // 1343
        "A#AUG" to listOf(3, 2, 1, 1),  // 3211
    )

    /**
     * Преобразовать каноническую позицию в ChordPosition
     */
    fun toChordPosition(position: List<Int>, chordName: String): ChordPosition {
        val frets = mutableListOf<Fret>()
        val fingers = mutableListOf<Finger>()

        // Назначаем пальцы для зажатых ладов
        val pressedFrets = position.withIndex()
            .filter { it.value > 0 }
            .sortedBy { it.value }
            .map { it.index to it.value }

        val fingerMap = mutableMapOf<Int, Int>()
        pressedFrets.forEachIndexed { index, (stringIndex, fret) ->
            fingerMap[stringIndex] = (index % 4) + 1
        }

        for ((stringIndex, fret) in position.withIndex()) {
            val stringNum = stringIndex + 1 // 1-индексированная струна
            frets.add(Fret(string = stringNum, fret = fret, finger = if (fret > 0) fingerMap[stringIndex] else null))
            if (fret > 0) {
                fingers.add(Finger(fingerNumber = fingerMap[stringIndex]!!, string = stringNum, fret = fret))
            }
        }

        // Определяем барре
        val barres = findBarres(position, fingerMap)

        return ChordPosition(
            instrument = Instrument.UKULELE,
            frets = frets,
            barres = barres,
            fingers = fingers
        )
    }

    private fun findBarres(position: List<Int>, fingerMap: Map<Int, Int>): List<Barre> {
        val barres = mutableListOf<Barre>()

        // Группируем струны по ладу и пальцу
        val fretToFingerStrings = mutableMapOf<Pair<Int, Int>, MutableList<Int>>()

        for ((stringIndex, fret) in position.withIndex()) {
            if (fret > 0 && fingerMap.containsKey(stringIndex)) {
                val finger = fingerMap[stringIndex]!!
                val key = fret to finger
                fretToFingerStrings.getOrPut(key) { mutableListOf() }.add(stringIndex)
            }
        }

        // Ищем барре: несколько соседних струн с одинаковым ладом и пальцем
        for ((fretAndFinger, stringIndices) in fretToFingerStrings) {
            val (fret, finger) = fretAndFinger
            if (stringIndices.size >= 2) {
                val sortedIndices = stringIndices.sorted()
                // Проверяем соседность
                val isContiguous = sortedIndices.zipWithNext().all { (a, b) -> b - a == 1 }
                if (isContiguous) {
                    barres.add(Barre(
                        fret = fret,
                        fromString = sortedIndices.min() + 1,
                        toString = sortedIndices.max() + 1,
                        finger = finger
                    ))
                }
            }
        }

        return barres
    }
}
