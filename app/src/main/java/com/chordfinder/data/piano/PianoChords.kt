package com.chordfinder.data.piano

import com.chordfinder.data.*

/**
 * Канонические позиции аккордов для пианино.
 * Для пианино "позиция" — это список нот (в полутонах) с назначением пальцев.
 *
 * Формула пальцев (правая рука, базовая позиция):
 * - Большой палец = 1
 * - Указательный = 2
 * - Средний = 3
 * - Безымянный = 4
 * - Мизинец = 5
 *
 * Базовая позиция C: C(0)-E(4)-G(7) → пальцы 5-3-1 или 1-3-5 в зависимости от контекста
 */
object PianoChords {

    data class PianoPosition(
        val notes: List<Int>,      // Ноты в полутонах (0 = C, 1 = C#, etc.)
        val fingers: List<Int>     // Номера пальцев для каждой ноты
    )

    /**
     * Получить каноническую позицию для аккорда
     */
    fun getCanonicalPosition(chordName: String): PianoPosition? {
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
    // Ноты указаны в полутонах от C (0 = C, 1 = C#, 2 = D, etc.)
    // Пальцы: 1 = большой, 5 = мизинец
    private val CANONICAL_POSITIONS = mapOf(
        // ===== Мажорные трезвучия (правая рука, базовая позиция) =====
        "C" to PianoPosition(listOf(0, 4, 7), listOf(1, 3, 5)),      // C, E, G
        "D" to PianoPosition(listOf(2, 6, 9), listOf(1, 3, 5)),      // D, F#, A
        "E" to PianoPosition(listOf(4, 8, 11), listOf(1, 3, 5)),     // E, G#, B
        "F" to PianoPosition(listOf(5, 9, 0), listOf(1, 3, 5)),      // F, A, C (октава выше)
        "G" to PianoPosition(listOf(7, 11, 2), listOf(1, 3, 5)),     // G, B, D (октава выше)
        "A" to PianoPosition(listOf(9, 1, 4), listOf(1, 3, 5)),      // A, C#, E (октава выше)
        "B" to PianoPosition(listOf(11, 3, 6), listOf(1, 3, 5)),     // B, D#, F# (октава выше)

        // ===== Минорные трезвучия =====
        "CM" to PianoPosition(listOf(0, 3, 7), listOf(1, 3, 5)),     // C, Eb, G
        "DM" to PianoPosition(listOf(2, 5, 9), listOf(1, 3, 5)),     // D, F, A
        "EM" to PianoPosition(listOf(4, 7, 11), listOf(1, 3, 5)),    // E, G, B
        "FM" to PianoPosition(listOf(5, 8, 0), listOf(1, 3, 5)),     // F, Ab, C
        "GM" to PianoPosition(listOf(7, 10, 2), listOf(1, 3, 5)),    // G, Bb, D
        "AM" to PianoPosition(listOf(9, 0, 4), listOf(1, 3, 5)),     // A, C, E
        "BM" to PianoPosition(listOf(11, 2, 6), listOf(1, 3, 5)),    // B, D, F#

        // ===== Септаккорды (dominant 7) =====
        "C7" to PianoPosition(listOf(0, 4, 7, 10), listOf(1, 2, 3, 5)),  // C, E, G, Bb
        "D7" to PianoPosition(listOf(2, 6, 9, 1), listOf(1, 2, 3, 5)),   // D, F#, A, C
        "E7" to PianoPosition(listOf(4, 8, 11, 2), listOf(1, 2, 3, 5)),  // E, G#, B, D
        "F7" to PianoPosition(listOf(5, 9, 0, 3), listOf(1, 2, 3, 5)),   // F, A, C, Eb
        "G7" to PianoPosition(listOf(7, 11, 2, 5), listOf(1, 2, 3, 5)),  // G, B, D, F
        "A7" to PianoPosition(listOf(9, 1, 4, 7), listOf(1, 2, 3, 5)),   // A, C#, E, G
        "B7" to PianoPosition(listOf(11, 3, 6, 9), listOf(1, 2, 3, 5)),  // B, D#, F#, A

        // ===== Мажорный септаккорд (M7) =====
        "CM7" to PianoPosition(listOf(0, 4, 7, 11), listOf(1, 2, 3, 5)), // C, E, G, B
        "DM7" to PianoPosition(listOf(2, 6, 9, 1), listOf(1, 2, 3, 5)),  // D, F#, A, C#
        "EM7" to PianoPosition(listOf(4, 8, 11, 2), listOf(1, 2, 3, 5)), // E, G#, B, D#
        "FM7" to PianoPosition(listOf(5, 9, 0, 4), listOf(1, 2, 3, 5)),  // F, A, C, E
        "GM7" to PianoPosition(listOf(7, 11, 2, 6), listOf(1, 2, 3, 5)), // G, B, D, F#
        "AM7" to PianoPosition(listOf(9, 1, 4, 8), listOf(1, 2, 3, 5)),  // A, C#, E, G#
        "BM7" to PianoPosition(listOf(11, 3, 6, 10), listOf(1, 2, 3, 5)),// B, D#, F#, A#

        // ===== Минорный септаккорд (m7) =====
        "Cm7" to PianoPosition(listOf(0, 3, 7, 10), listOf(1, 2, 3, 5)), // C, Eb, G, Bb
        "Dm7" to PianoPosition(listOf(2, 5, 9, 1), listOf(1, 2, 3, 5)),  // D, F, A, C
        "Em7" to PianoPosition(listOf(4, 7, 11, 2), listOf(1, 2, 3, 5)), // E, G, B, D
        "Fm7" to PianoPosition(listOf(5, 8, 0, 3), listOf(1, 2, 3, 5)),  // F, Ab, C, Eb
        "Gm7" to PianoPosition(listOf(7, 10, 2, 5), listOf(1, 2, 3, 5)), // G, Bb, D, F
        "Am7" to PianoPosition(listOf(9, 0, 4, 7), listOf(1, 2, 3, 5)),  // A, C, E, G
        "Bm7" to PianoPosition(listOf(11, 2, 6, 9), listOf(1, 2, 3, 5)), // B, D, F#, A

        // ===== Sus2 аккорды =====
        "CSUS2" to PianoPosition(listOf(0, 2, 7), listOf(1, 3, 5)),      // C, D, G
        "DSUS2" to PianoPosition(listOf(2, 4, 9), listOf(1, 3, 5)),      // D, E, A
        "ESUS2" to PianoPosition(listOf(4, 6, 11), listOf(1, 3, 5)),     // E, F#, B
        "FSUS2" to PianoPosition(listOf(5, 7, 0), listOf(1, 3, 5)),      // F, G, C
        "GSUS2" to PianoPosition(listOf(7, 9, 2), listOf(1, 3, 5)),      // G, A, D
        "ASUS2" to PianoPosition(listOf(9, 11, 4), listOf(1, 3, 5)),     // A, B, E
        "BSUS2" to PianoPosition(listOf(11, 1, 6), listOf(1, 3, 5)),     // B, C#, F#

        // ===== Sus4 аккорды =====
        "CSUS4" to PianoPosition(listOf(0, 5, 7), listOf(1, 3, 5)),      // C, F, G
        "DSUS4" to PianoPosition(listOf(2, 7, 9), listOf(1, 3, 5)),      // D, G, A
        "ESUS4" to PianoPosition(listOf(4, 9, 11), listOf(1, 3, 5)),     // E, A, B
        "FSUS4" to PianoPosition(listOf(5, 10, 0), listOf(1, 3, 5)),     // F, Bb, C
        "GSUS4" to PianoPosition(listOf(7, 0, 2), listOf(1, 3, 5)),      // G, C, D
        "ASUS4" to PianoPosition(listOf(9, 2, 4), listOf(1, 3, 5)),      // A, D, E
        "BSUS4" to PianoPosition(listOf(11, 4, 6), listOf(1, 3, 5)),     // B, E, F#

        // ===== Add9 аккорды =====
        "CADD9" to PianoPosition(listOf(0, 4, 7, 14), listOf(1, 2, 3, 5)), // C, E, G, D (октава)
        "DADD9" to PianoPosition(listOf(2, 6, 9, 16), listOf(1, 2, 3, 5)), // D, F#, A, E
        "EADD9" to PianoPosition(listOf(4, 8, 11, 18), listOf(1, 2, 3, 5)),// E, G#, B, F#
        "FADD9" to PianoPosition(listOf(5, 9, 0, 19), listOf(1, 2, 3, 5)), // F, A, C, G
        "GADD9" to PianoPosition(listOf(7, 11, 2, 21), listOf(1, 2, 3, 5)),// G, B, D, A
        "AADD9" to PianoPosition(listOf(9, 1, 4, 23), listOf(1, 2, 3, 5)), // A, C#, E, B
        "BADD9" to PianoPosition(listOf(11, 3, 6, 25), listOf(1, 2, 3, 5)),// B, D#, F#, C#

        // ===== Уменьшенные (DIM) =====
        "CDIM" to PianoPosition(listOf(0, 3, 6), listOf(1, 3, 5)),       // C, Eb, Gb
        "DDIM" to PianoPosition(listOf(2, 5, 8), listOf(1, 3, 5)),       // D, F, Ab
        "EDIM" to PianoPosition(listOf(4, 7, 10), listOf(1, 3, 5)),      // E, G, Bb
        "FDIM" to PianoPosition(listOf(5, 8, 11), listOf(1, 3, 5)),      // F, Ab, B
        "GDIM" to PianoPosition(listOf(7, 10, 1), listOf(1, 3, 5)),      // G, Bb, Db
        "ADIM" to PianoPosition(listOf(9, 0, 4), listOf(1, 3, 5)),       // A, C, Eb
        "BDIM" to PianoPosition(listOf(11, 2, 6), listOf(1, 3, 5)),      // B, D, F

        // ===== Увеличенные (AUG) =====
        "CAUG" to PianoPosition(listOf(0, 4, 8), listOf(1, 3, 5)),       // C, E, G#
        "DAUG" to PianoPosition(listOf(2, 6, 10), listOf(1, 3, 5)),      // D, F#, A#
        "EAUG" to PianoPosition(listOf(4, 8, 0), listOf(1, 3, 5)),       // E, G#, C
        "FAUG" to PianoPosition(listOf(5, 9, 1), listOf(1, 3, 5)),       // F, A, C#
        "GAUG" to PianoPosition(listOf(7, 11, 3), listOf(1, 3, 5)),      // G, B, D#
        "AAUG" to PianoPosition(listOf(9, 1, 5), listOf(1, 3, 5)),       // A, C#, F
        "BAUG" to PianoPosition(listOf(11, 3, 7), listOf(1, 3, 5)),      // B, D#, G

        // ===== Квинтаккорды (5 / Power chords) =====
        "C5" to PianoPosition(listOf(0, 7), listOf(1, 5)),               // C, G
        "D5" to PianoPosition(listOf(2, 9), listOf(1, 5)),               // D, A
        "E5" to PianoPosition(listOf(4, 11), listOf(1, 5)),              // E, B
        "F5" to PianoPosition(listOf(5, 0), listOf(1, 5)),               // F, C
        "G5" to PianoPosition(listOf(7, 2), listOf(1, 5)),               // G, D
        "A5" to PianoPosition(listOf(9, 4), listOf(1, 5)),               // A, E
        "B5" to PianoPosition(listOf(11, 6), listOf(1, 5)),              // B, F#

        // ===== Диезные мажорные аккорды =====
        "C#" to PianoPosition(listOf(1, 5, 8), listOf(1, 3, 5)),         // C#, F, G#
        "D#" to PianoPosition(listOf(3, 7, 10), listOf(1, 3, 5)),        // D#, G#, A#
        "F#" to PianoPosition(listOf(6, 10, 1), listOf(1, 3, 5)),        // F#, A#, C#
        "G#" to PianoPosition(listOf(8, 0, 3), listOf(1, 3, 5)),         // G#, C, D#
        "A#" to PianoPosition(listOf(10, 2, 5), listOf(1, 3, 5)),        // A#, D, F

        // ===== Бемольные мажорные аккорды =====
        "DB" to PianoPosition(listOf(1, 5, 8), listOf(1, 3, 5)),         // Db = C#
        "EB" to PianoPosition(listOf(3, 7, 10), listOf(1, 3, 5)),        // Eb = D#
        "GB" to PianoPosition(listOf(6, 10, 1), listOf(1, 3, 5)),        // Gb = F#
        "AB" to PianoPosition(listOf(8, 0, 3), listOf(1, 3, 5)),         // Ab = G#
        "BB" to PianoPosition(listOf(10, 2, 5), listOf(1, 3, 5)),        // Bb = A#

        // ===== Диезные минорные аккорды =====
        "C#M" to PianoPosition(listOf(1, 4, 8), listOf(1, 3, 5)),        // C#, E, G#
        "D#M" to PianoPosition(listOf(3, 6, 10), listOf(1, 3, 5)),       // D#, G, A#
        "F#M" to PianoPosition(listOf(6, 10, 1), listOf(1, 3, 5)),       // F#, A#, C#
        "G#M" to PianoPosition(listOf(8, 11, 3), listOf(1, 3, 5)),       // G#, B, D#
        "A#M" to PianoPosition(listOf(10, 1, 5), listOf(1, 3, 5)),       // A#, C#, F

        // ===== 7#5 аккорды (dominant 7th augmented 5th) =====
        "C7#5" to PianoPosition(listOf(0, 4, 8, 10), listOf(1, 2, 3, 5)), // C, E, G#, Bb
        "D7#5" to PianoPosition(listOf(2, 6, 10, 1), listOf(1, 2, 3, 5)), // D, F#, A#, C
        "E7#5" to PianoPosition(listOf(4, 8, 0, 2), listOf(1, 2, 3, 5)),  // E, G#, C, D
        "F7#5" to PianoPosition(listOf(5, 9, 1, 3), listOf(1, 2, 3, 5)),  // F, A, C#, Eb
        "G7#5" to PianoPosition(listOf(7, 11, 3, 5), listOf(1, 2, 3, 5)), // G, B, D#, F
        "A7#5" to PianoPosition(listOf(9, 1, 5, 7), listOf(1, 2, 3, 5)),  // A, C#, F, G
        "B7#5" to PianoPosition(listOf(11, 3, 7, 9), listOf(1, 2, 3, 5)), // B, D#, G, A

        // ===== 7b5 аккорды (dominant 7th diminished 5th) =====
        "C7B5" to PianoPosition(listOf(0, 4, 6, 10), listOf(1, 2, 3, 5)), // C, E, Gb, Bb
        "D7B5" to PianoPosition(listOf(2, 6, 8, 1), listOf(1, 2, 3, 5)),  // D, F#, Ab, C
        "E7B5" to PianoPosition(listOf(4, 8, 10, 2), listOf(1, 2, 3, 5)), // E, G#, A#, D
        "F7B5" to PianoPosition(listOf(5, 9, 11, 3), listOf(1, 2, 3, 5)), // F, A, B, Eb
        "G7B5" to PianoPosition(listOf(7, 11, 1, 5), listOf(1, 2, 3, 5)), // G, B, Db, F
        "A7B5" to PianoPosition(listOf(9, 1, 3, 7), listOf(1, 2, 3, 5)),  // A, C#, D#, G
        "B7B5" to PianoPosition(listOf(11, 3, 5, 9), listOf(1, 2, 3, 5)), // B, D#, E, A

        // ===== Half-diminished (m7b5) =====
        "Cm7B5" to PianoPosition(listOf(0, 3, 6, 10), listOf(1, 2, 3, 5)), // C, Eb, Gb, Bb
        "Dm7B5" to PianoPosition(listOf(2, 5, 8, 1), listOf(1, 2, 3, 5)),  // D, F, Ab, C
        "Em7B5" to PianoPosition(listOf(4, 7, 10, 2), listOf(1, 2, 3, 5)), // E, G, Bb, D
        "Fm7B5" to PianoPosition(listOf(5, 8, 11, 3), listOf(1, 2, 3, 5)), // F, Ab, B, Eb
        "Gm7B5" to PianoPosition(listOf(7, 10, 1, 5), listOf(1, 2, 3, 5)), // G, Bb, Db, F
        "Am7B5" to PianoPosition(listOf(9, 0, 4, 7), listOf(1, 2, 3, 5)),  // A, C, Eb, G
        "Bm7B5" to PianoPosition(listOf(11, 2, 6, 9), listOf(1, 2, 3, 5)), // B, D, F, A

        // ===== Мажорные септаккорды с альтерированной квинтой =====
        "CM7#5" to PianoPosition(listOf(0, 4, 8, 11), listOf(1, 2, 3, 5)), // C, E, G#, B
        "DM7#5" to PianoPosition(listOf(2, 6, 10, 1), listOf(1, 2, 3, 5)), // D, F#, A#, C#
        "EM7#5" to PianoPosition(listOf(4, 8, 0, 2), listOf(1, 2, 3, 5)),  // E, G#, C, D#
        "FM7#5" to PianoPosition(listOf(5, 9, 1, 4), listOf(1, 2, 3, 5)),  // F, A, C#, E
        "GM7#5" to PianoPosition(listOf(7, 11, 3, 6), listOf(1, 2, 3, 5)), // G, B, D#, F#
        "AM7#5" to PianoPosition(listOf(9, 1, 5, 8), listOf(1, 2, 3, 5)),  // A, C#, F, G#
        "BM7#5" to PianoPosition(listOf(11, 3, 7, 10), listOf(1, 2, 3, 5)),// B, D#, G, A#
    )

    /**
     * Преобразовать каноническую позицию в ChordPosition для отображения
     */
    fun toChordPosition(pianoPos: PianoPosition, chordName: String): ChordPosition {
        val frets = mutableListOf<Fret>()
        val fingers = mutableListOf<Finger>()

        // Для пианино "string" используется как номер пальца, "fret" как нота (семитон)
        pianoPos.notes.forEachIndexed { index, note ->
            val finger = pianoPos.fingers[index]
            frets.add(Fret(string = finger, fret = note, finger = finger))
            fingers.add(Finger(fingerNumber = finger, string = finger, fret = note))
        }

        return ChordPosition(
            instrument = Instrument.PIANO,
            frets = frets,
            barres = emptyList(), // Барре не применимо к пианино
            fingers = fingers
        )
    }
}
