package com.chordfinder.data

object ChordData {
    private val chords = mapOf(
        // C Major
        "C" to Chord("C", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 0), Fret(2, 1), Fret(3, 0), Fret(4, 2), Fret(5, 3), Fret(6, -1)
            ), emptyList(), listOf(
                Finger(1, 2, 1), Finger(2, 4, 2), Finger(3, 5, 3)
            )),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 0), Fret(2, 1), Fret(3, 2), Fret(4, 3), Fret(5, -1), Fret(6, -1),
                Fret(7, 0), Fret(8, 1), Fret(9, 2), Fret(10, 3), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 0), Fret(2, 3), Fret(3, 2), Fret(4, 0)
            ), emptyList(), listOf(
                Finger(1, 2, 3), Finger(2, 3, 2)
            ))
        )),

        // A Major
        "A" to Chord("A", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 0), Fret(2, 2), Fret(3, 2), Fret(4, 2), Fret(5, 0), Fret(6, -1)
            ), emptyList(), listOf(
                Finger(1, 2, 2), Finger(2, 3, 2), Finger(3, 4, 2)
            )),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, -1), Fret(2, -1), Fret(3, 0), Fret(4, 2), Fret(5, 4), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, 0), Fret(10, 2), Fret(11, 4), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 0), Fret(2, 2), Fret(3, 1), Fret(4, 0)
            ), emptyList(), listOf(
                Finger(1, 2, 2), Finger(2, 3, 1)
            ))
        )),

        // G Major
        "G" to Chord("G", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 3), Fret(2, 0), Fret(3, 0), Fret(4, 0), Fret(5, 2), Fret(6, 3)
            ), emptyList(), listOf(
                Finger(1, 1, 3), Finger(2, 5, 2), Finger(3, 6, 3)
            )),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, -1), Fret(2, -1), Fret(3, -1), Fret(4, -1), Fret(5, 2), Fret(6, -1),
                Fret(7, 0), Fret(8, -1), Fret(9, -1), Fret(10, -1), Fret(11, 2), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 2), Fret(2, 0), Fret(3, 0), Fret(4, 3)
            ), emptyList(), listOf(
                Finger(1, 1, 2), Finger(2, 4, 3)
            ))
        )),

        // D Major
        "D" to Chord("D", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 2), Fret(2, 3), Fret(3, 2), Fret(4, 0), Fret(5, -1), Fret(6, -1)
            ), emptyList(), listOf(
                Finger(1, 1, 2), Finger(2, 2, 3), Finger(3, 3, 2)
            )),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, -1), Fret(2, -1), Fret(3, -1), Fret(4, -1), Fret(5, 2), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1), Fret(10, -1), Fret(11, 2), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 2), Fret(2, 2), Fret(3, 1), Fret(4, 0)
            ), emptyList(), listOf(
                Finger(1, 1, 2), Finger(2, 2, 2), Finger(3, 3, 1)
            ))
        )),

        // E Major
        "E" to Chord("E", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 0), Fret(2, 0), Fret(3, 1), Fret(4, 2), Fret(5, 2), Fret(6, 0)
            ), emptyList(), listOf(
                Finger(1, 3, 1), Finger(2, 4, 2), Finger(3, 5, 2)
            )),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, -1), Fret(2, -1), Fret(3, 0), Fret(4, -1), Fret(5, 2), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, 0), Fret(10, -1), Fret(11, 2), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 4), Fret(2, 3), Fret(3, 1), Fret(4, 2)
            ), emptyList(), listOf(
                Finger(1, 1, 4), Finger(2, 2, 3), Finger(3, 4, 2)
            ))
        )),

        // F Major
        "F" to Chord("F", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 1), Fret(2, 1), Fret(3, 2), Fret(4, 3), Fret(5, 3), Fret(6, -1)
            ), listOf(
                Barre(1, 1, 6, 1)
            ), listOf(
                Finger(2, 3, 2), Finger(3, 4, 3), Finger(4, 5, 3)
            )),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, -1), Fret(2, -1), Fret(3, -1), Fret(4, -1), Fret(5, 1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1), Fret(10, -1), Fret(11, 1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 2), Fret(2, 1), Fret(3, 0), Fret(4, 0)
            ), emptyList(), listOf(
                Finger(1, 1, 2), Finger(2, 2, 1)
            ))
        )),

        // A Minor
        "AM" to Chord("Am", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 0), Fret(2, 1), Fret(3, 2), Fret(4, 2), Fret(5, 0), Fret(6, -1)
            ), emptyList(), listOf(
                Finger(1, 2, 1), Finger(2, 3, 2), Finger(3, 4, 2)
            )),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, -1), Fret(2, -1), Fret(3, 0), Fret(4, 2), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, 0), Fret(10, 2), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 2), Fret(2, 0), Fret(3, 1), Fret(4, 0)
            ), emptyList(), listOf(
                Finger(1, 1, 2), Finger(2, 3, 1)
            ))
        )),

        // D Minor
        "DM" to Chord("Dm", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 1), Fret(2, 3), Fret(3, 2), Fret(4, 0), Fret(5, -1), Fret(6, -1)
            ), emptyList(), listOf(
                Finger(1, 1, 1), Finger(2, 2, 3), Finger(3, 3, 2)
            )),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, -1), Fret(2, -1), Fret(3, -1), Fret(4, -1), Fret(5, 1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1), Fret(10, -1), Fret(11, 1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 2), Fret(2, 1), Fret(3, 0), Fret(4, 0)
            ), emptyList(), listOf(
                Finger(1, 1, 2), Finger(2, 2, 1)
            ))
        )),

        // E Minor
        "EM" to Chord("Em", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 0), Fret(2, 0), Fret(3, 0), Fret(4, 2), Fret(5, 2), Fret(6, 0)
            ), emptyList(), listOf(
                Finger(1, 4, 2), Finger(2, 5, 2)
            )),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, -1), Fret(2, -1), Fret(3, 0), Fret(4, -1), Fret(5, 2), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, 0), Fret(10, -1), Fret(11, 2), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 0), Fret(2, 0), Fret(3, 0), Fret(4, 3)
            ), emptyList(), listOf(
                Finger(1, 4, 3)
            ))
        )),

        // B7
        "B7" to Chord("B7", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 2), Fret(2, 0), Fret(3, 2), Fret(4, 1), Fret(5, 2), Fret(6, -1)
            ), emptyList(), listOf(
                Finger(1, 1, 2), Finger(2, 4, 1), Finger(3, 5, 2)
            )),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, -1), Fret(2, -1), Fret(3, -1), Fret(4, -1), Fret(5, 2), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1), Fret(10, -1), Fret(11, 2), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 2), Fret(2, 3), Fret(3, 1), Fret(4, 2)
            ), emptyList(), listOf(
                Finger(1, 1, 2), Finger(2, 2, 3), Finger(3, 3, 1), Finger(4, 4, 2)
            ))
        )),

        // G7
        "G7" to Chord("G7", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 1), Fret(2, 0), Fret(3, 0), Fret(4, 0), Fret(5, 2), Fret(6, 3)
            ), emptyList(), listOf(
                Finger(1, 1, 1), Finger(2, 5, 2), Finger(3, 6, 3)
            )),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, -1), Fret(2, -1), Fret(3, -1), Fret(4, -1), Fret(5, 2), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1), Fret(10, -1), Fret(11, 2), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 1), Fret(2, 0), Fret(3, 0), Fret(4, 2)
            ), emptyList(), listOf(
                Finger(1, 1, 1), Finger(2, 4, 2)
            ))
        )),

        // C7
        "C7" to Chord("C7", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 0), Fret(2, 1), Fret(3, 3), Fret(4, 2), Fret(5, 3), Fret(6, -1)
            ), emptyList(), listOf(
                Finger(1, 2, 1), Finger(2, 3, 3), Finger(3, 4, 2), Finger(4, 5, 3)
            )),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, -1), Fret(2, -1), Fret(3, 0), Fret(4, -1), Fret(5, 2), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, 0), Fret(10, -1), Fret(11, 2), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 0), Fret(2, 3), Fret(3, 2), Fret(4, 1)
            ), emptyList(), listOf(
                Finger(1, 2, 3), Finger(2, 3, 2), Finger(3, 4, 1)
            ))
        )),

        // D7
        "D7" to Chord("D7", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 2), Fret(2, 1), Fret(3, 2), Fret(4, 0), Fret(5, -1), Fret(6, -1)
            ), emptyList(), listOf(
                Finger(1, 1, 2), Finger(2, 2, 1), Finger(3, 3, 2)
            )),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, -1), Fret(2, -1), Fret(3, -1), Fret(4, -1), Fret(5, 2), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1), Fret(10, -1), Fret(11, 2), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 2), Fret(2, 1), Fret(3, 2), Fret(4, 0)
            ), emptyList(), listOf(
                Finger(1, 1, 2), Finger(2, 2, 1), Finger(3, 3, 2)
            ))
        )),

        // A7
        "A7" to Chord("A7", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 0), Fret(2, 2), Fret(3, 0), Fret(4, 2), Fret(5, 0), Fret(6, -1)
            ), emptyList(), listOf(
                Finger(1, 2, 2), Finger(2, 4, 2)
            )),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, -1), Fret(2, -1), Fret(3, 0), Fret(4, 2), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, 0), Fret(10, 2), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 0), Fret(2, 2), Fret(3, 1), Fret(4, 0)
            ), emptyList(), listOf(
                Finger(1, 2, 2), Finger(2, 3, 1)
            ))
        )),

        // E7
        "E7" to Chord("E7", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 0), Fret(2, 0), Fret(3, 1), Fret(4, 0), Fret(5, 2), Fret(6, 0)
            ), emptyList(), listOf(
                Finger(1, 3, 1), Finger(2, 5, 2)
            )),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, -1), Fret(2, -1), Fret(3, 0), Fret(4, -1), Fret(5, 2), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, 0), Fret(10, -1), Fret(11, 2), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 0), Fret(2, 3), Fret(3, 1), Fret(4, 2)
            ), emptyList(), listOf(
                Finger(1, 2, 3), Finger(2, 4, 2)
            ))
        ))
    )

    fun getChord(name: String): Chord? {
        val normalized = name
            .replace("m", "M")
            .uppercase()
            .replace(" ", "")
            .replace("MAJ", "")
            .replace("MIN", "M")
            .replace("♭", "B")
            .replace("#", "S")

        chords[normalized]?.let { return it }

        val rootMatch = Regex("^([A-G])(M|[0-9]|B|S)*$").find(normalized)
        if (rootMatch != null) {
            val root = rootMatch.groupValues[1]
            val suffix = rootMatch.groupValues[2]

            val key = when {
                suffix == "" || suffix == "MAJ" -> root
                suffix == "M" -> "${root}M"
                suffix == "7" || suffix == "9" || suffix == "11" || suffix == "13" -> "${root}7"
                suffix == "M7" -> "${root}M7"
                suffix.startsWith("M") && suffix.endsWith("7") -> "${root}M7"
                suffix.toIntOrNull() != null -> "${root}${suffix}"
                else -> "${root}${suffix}"
            }

            chords[key]?.let { return it }
        }

        return null
    }
}