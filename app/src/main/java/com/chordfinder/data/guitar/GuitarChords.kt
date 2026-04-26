package com.chordfinder.data.guitar

import com.chordfinder.data.*

/**
 * Канонические позиции аккордов для гитары.
 * Формат: [струна 6, струна 5, струна 4, струна 3, струна 2, струна 1]
 * -1 = не играет (X), 0 = открытая, >0 = лад
 */
object GuitarChords {

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
    // Формат: [E, A, D, G, B, e] - от 6-й струны к 1-й
    private val CANONICAL_POSITIONS = mapOf(
        // Мажорные трезвучия
        "C" to listOf(-1, 3, 2, 0, 1, 0),   // x32010
        "D" to listOf(-1, -1, 0, 2, 3, 2),  // xx0232
        "E" to listOf(0, 2, 2, 1, 0, 0),    // 022100
        "F" to listOf(-1, -1, 3, 2, 1, 1),  // xx3211 (без барре, упрощенная)
        "G" to listOf(3, 2, 0, 0, 0, 3),    // 320003
        "A" to listOf(-1, 0, 2, 2, 2, 0),   // x02220

        // Минорные трезвучия
        "CM" to listOf(-1, 3, 5, 5, 4, 3),  // x35543 (Cm барре)
        "DM" to listOf(-1, -1, 0, 2, 3, 1), // xx0231
        "EM" to listOf(0, 2, 2, 0, 0, 0),   // 022000
        "FM" to listOf(-1, -1, 3, 1, 1, 1), // xx3111 (Fm барре)
        "GM" to listOf(3, 5, 5, 3, 3, 3),   // 355333 (Gm барре)
        "AM" to listOf(-1, 0, 2, 2, 1, 0),  // x02210

        // Септаккорды (dominant 7)
        "C7" to listOf(-1, 3, 2, 3, 1, 0),  // x32310
        "D7" to listOf(-1, -1, 0, 2, 1, 2), // xx0212
        "E7" to listOf(0, 2, 0, 1, 0, 0),   // 020100
        "F7" to listOf(-1, -1, 1, 2, 1, 1), // xx1211 (F7 барре)
        "G7" to listOf(3, 2, 0, 0, 0, 1),   // 320001
        "A7" to listOf(-1, 0, 2, 0, 2, 0),  // x02020

        // Мажорный септаккорд (M7)
        "CM7" to listOf(-1, 3, 2, 0, 0, 0), // x32000
        "DM7" to listOf(-1, -1, 0, 2, 2, 2),// xx0222
        "EM7" to listOf(0, 2, 0, 1, 0, 0),  // 020100 (как E7)
        "FM7" to listOf(-1, -1, 3, 2, 1, 0),// xx3210
        "GM7" to listOf(3, 2, 0, 0, 0, 2),  // 320002
        "AM7" to listOf(-1, 0, 2, 1, 2, 0), // x02120

        // Sus2 аккорды
        "CSUS2" to listOf(-1, 3, 5, 5, 3, 3), // x35533
        "DSUS2" to listOf(-1, -1, 0, 2, 3, 0),// xx0230
        "ESUS2" to listOf(0, 2, 2, 0, 0, 0), // 022000 (как E)
        "FSUS2" to listOf(-1, -1, 3, 5, 6, 6),// xx3566
        "GSUS2" to listOf(3, 5, 5, 4, 3, 3), // 355433
        "ASUS2" to listOf(-1, 0, 2, 2, 0, 0),// x02200

        // Sus4 аккорды
        "CSUS4" to listOf(-1, 3, 5, 5, 6, 6), // x35566
        "DSUS4" to listOf(-1, -1, 0, 2, 3, 3),// xx0233
        "ESUS4" to listOf(0, 2, 2, 2, 0, 0), // 022200
        "FSUS4" to listOf(-1, -1, 3, 5, 6, 6),// xx3566 (как Fsus2)
        "GSUS4" to listOf(3, 5, 5, 5, 3, 3), // 355533
        "ASUS4" to listOf(-1, 0, 2, 2, 3, 0),// x02230

        // Add9 аккорды
        "CADD9" to listOf(-1, 3, 2, 0, 3, 0), // x32030
        "DADD9" to listOf(-1, -1, 0, 2, 3, 2),// xx0232 (как D)
        "EADD9" to listOf(0, 2, 2, 1, 0, 2), // 022102
        "FADD9" to listOf(-1, -1, 3, 2, 1, 3),// xx3213
        "GADD9" to listOf(3, 2, 0, 0, 0, 2), // 320002 (как GM7)
        "AADD9" to listOf(-1, 0, 2, 2, 2, 2),// x02222

        // Уменьшенные (DIM)
        "CDIM" to listOf(-1, 3, 4, 5, 4, 3), // x34543
        "DDIM" to listOf(-1, -1, 0, 1, 0, 1),// xx0101
        "EDIM" to listOf(0, 1, 0, 1, 0, 0), // 010100
        "FDIM" to listOf(-1, -1, 0, 1, 1, 1),// xx0111
        "GDIM" to listOf(3, 4, 5, 4, 5, 3), // 345453
        "ADIM" to listOf(-1, 0, 1, 0, 1, 0),// x01010

        // Увеличенные (AUG)
        "CAUG" to listOf(-1, 3, 5, 5, 4, 0), // x35540
        "DAUG" to listOf(-1, -1, 0, 2, 3, 0),// xx0230 (как Dsus2)
        "EAUG" to listOf(0, 2, 2, 1, 0, 0), // 022100 (как E)
        "FAUG" to listOf(-1, -1, 3, 2, 1, 0),// xx3210 (как FM7)
        "GAUG" to listOf(3, 2, 0, 1, 0, 3), // 320103
        "AAUG" to listOf(-1, 0, 2, 1, 1, 0),// x02110

        // Квинтаккорды (5)
        "C5" to listOf(-1, 3, 5, 5, 0, 0),  // x35500
        "D5" to listOf(-1, -1, 0, 2, 3, 0), // xx0230
        "E5" to listOf(0, 2, 2, 0, 0, 0),   // 022000
        "F5" to listOf(-1, -1, 3, 5, 5, 0), // xx3550
        "G5" to listOf(3, 5, 5, 0, 0, 0),   // 355000
        "A5" to listOf(-1, 0, 2, 2, 0, 0),  // x02200
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
            instrument = Instrument.GUITAR,
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
