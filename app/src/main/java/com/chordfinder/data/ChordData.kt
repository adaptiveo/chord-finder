package com.chordfinder.data

object ChordData {
    private val chords = mapOf(
        // ============ MAJOR CHORDS ============
        "C" to Chord("C", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 0), Fret(2, 1), Fret(3, 0), Fret(4, 2), Fret(5, 3), Fret(6, -1)
            ), emptyList(), listOf(Finger(1, 2, 1), Finger(2, 4, 2), Finger(3, 5, 3))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 0), Fret(2, 4), Fret(3, 7),
                Fret(4, -1), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 0), Fret(2, 3), Fret(3, 2), Fret(4, 0)
            ), emptyList(), listOf(Finger(1, 2, 3), Finger(2, 3, 2)))
        )),

        "C#" to Chord("C#", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 1), Fret(2, 3), Fret(3, 3), Fret(4, 3), Fret(5, 1), Fret(6, -1)
            ), listOf(Barre(1, 1, 5, 1)), listOf(Finger(2, 2, 3), Finger(3, 3, 3), Finger(4, 4, 3))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 1), Fret(2, 5), Fret(3, 8),
                Fret(4, -1), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 1), Fret(2, 4), Fret(3, 3), Fret(4, 1)
            ), emptyList(), listOf(Finger(1, 1, 1), Finger(2, 2, 4), Finger(3, 3, 3)))
        )),

        "D" to Chord("D", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 2), Fret(2, 3), Fret(3, 2), Fret(4, 0), Fret(5, -1), Fret(6, -1)
            ), emptyList(), listOf(Finger(1, 1, 2), Finger(2, 2, 3), Finger(3, 3, 2))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 2), Fret(2, 6), Fret(3, 9),
                Fret(4, -1), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 2), Fret(2, 2), Fret(3, 1), Fret(4, 0)
            ), emptyList(), listOf(Finger(1, 1, 2), Finger(2, 2, 2), Finger(3, 3, 1)))
        )),

        "D#" to Chord("D#", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 3), Fret(2, -1), Fret(3, 3), Fret(4, 1), Fret(5, -1), Fret(6, -1)
            ), emptyList(), listOf(Finger(1, 1, 3), Finger(2, 3, 1))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 3), Fret(2, 7), Fret(3, 10),
                Fret(4, -1), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 3), Fret(2, 1), Fret(3, 1), Fret(4, 3)
            ), emptyList(), listOf(Finger(1, 1, 3), Finger(2, 3, 1), Finger(3, 4, 3)))
        )),

        "E" to Chord("E", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 0), Fret(2, 0), Fret(3, 1), Fret(4, 2), Fret(5, 2), Fret(6, 0)
            ), emptyList(), listOf(Finger(1, 3, 1), Finger(2, 4, 2), Finger(3, 5, 2))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 4), Fret(2, 8), Fret(3, 11),
                Fret(4, -1), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 4), Fret(2, 3), Fret(3, 1), Fret(4, 2)
            ), emptyList(), listOf(Finger(1, 1, 4), Finger(2, 2, 3), Finger(3, 4, 2)))
        )),

        "F" to Chord("F", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 1), Fret(2, 1), Fret(3, 2), Fret(4, 3), Fret(5, 3), Fret(6, 1)
            ), listOf(Barre(1, 1, 6, 1)), listOf(Finger(2, 3, 2), Finger(3, 4, 3), Finger(4, 5, 3))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 5), Fret(2, 9), Fret(3, 0),
                Fret(4, -1), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 2), Fret(2, 1), Fret(3, 0), Fret(4, 0)
            ), emptyList(), listOf(Finger(1, 1, 2), Finger(2, 2, 1)))
        )),

        "F#" to Chord("F#", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 2), Fret(2, 2), Fret(3, 3), Fret(4, 4), Fret(5, 4), Fret(6, 2)
            ), listOf(Barre(2, 1, 6, 1)), listOf(Finger(2, 3, 3), Finger(3, 4, 4), Finger(4, 5, 4))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 6), Fret(2, 10), Fret(3, 1),
                Fret(4, -1), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 3), Fret(2, 1), Fret(3, 1), Fret(4, 2)
            ), emptyList(), listOf(Finger(1, 1, 3), Finger(2, 3, 1), Finger(3, 4, 2)))
        )),

        "G" to Chord("G", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 3), Fret(2, 2), Fret(3, 0), Fret(4, 0), Fret(5, 0), Fret(6, 3)
            ), emptyList(), listOf(Finger(1, 1, 3), Finger(2, 2, 2), Finger(3, 6, 3))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 7), Fret(2, 11), Fret(3, 2),
                Fret(4, -1), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 2), Fret(2, 0), Fret(3, 0), Fret(4, 3)
            ), emptyList(), listOf(Finger(1, 1, 2), Finger(2, 4, 3)))
        )),

        "G#" to Chord("G#", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 4), Fret(2, -1), Fret(3, 4), Fret(4, 2), Fret(5, -1), Fret(6, -1)
            ), emptyList(), listOf(Finger(1, 1, 4), Finger(2, 3, 2))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 8), Fret(2, 0), Fret(3, 3),
                Fret(4, -1), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 4), Fret(2, 1), Fret(3, 2), Fret(4, 1)
            ), emptyList(), listOf(Finger(1, 1, 4), Finger(2, 3, 2)))
        )),

        "A" to Chord("A", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 0), Fret(2, 2), Fret(3, 2), Fret(4, 2), Fret(5, 0), Fret(6, -1)
            ), emptyList(), listOf(Finger(1, 2, 2), Finger(2, 3, 2), Finger(3, 4, 2))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 9), Fret(2, 1), Fret(3, 4),
                Fret(4, -1), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 0), Fret(2, 2), Fret(3, 1), Fret(4, 0)
            ), emptyList(), listOf(Finger(1, 2, 2), Finger(2, 3, 1)))
        )),

        "A#" to Chord("A#", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 1), Fret(2, 3), Fret(3, 3), Fret(4, 3), Fret(5, 1), Fret(6, -1)
            ), listOf(Barre(1, 1, 5, 1)), listOf(Finger(2, 2, 3), Finger(3, 3, 3), Finger(4, 4, 3))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 10), Fret(2, 2), Fret(3, 5),
                Fret(4, -1), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 1), Fret(2, 3), Fret(3, 2), Fret(4, 1)
            ), emptyList(), listOf(Finger(1, 1, 1), Finger(2, 2, 3), Finger(3, 3, 2)))
        )),

        "B" to Chord("B", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 2), Fret(2, 4), Fret(3, 4), Fret(4, 4), Fret(5, 2), Fret(6, -1)
            ), listOf(Barre(2, 1, 5, 1)), listOf(Finger(2, 2, 4), Finger(3, 3, 4), Finger(4, 4, 4))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 11), Fret(2, 3), Fret(3, 6),
                Fret(4, -1), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 2), Fret(2, 4), Fret(3, 3), Fret(4, 2)
            ), emptyList(), listOf(Finger(1, 1, 2), Finger(2, 2, 4), Finger(3, 3, 3)))
        )),

        // ============ MINOR CHORDS ============
        "CM" to Chord("Cm", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 3), Fret(2, 5), Fret(3, 5), Fret(4, 5), Fret(5, 3), Fret(6, -1)
            ), listOf(Barre(3, 1, 5, 1)), listOf(Finger(2, 2, 5), Finger(3, 3, 5), Finger(4, 4, 5))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 0), Fret(2, 3), Fret(3, 7),
                Fret(4, -1), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 3), Fret(2, 0), Fret(3, 2), Fret(4, 3)
            ), emptyList(), listOf(Finger(1, 1, 3), Finger(2, 3, 2), Finger(3, 4, 3)))
        )),

        "CSM" to Chord("C#m", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 4), Fret(2, -1), Fret(3, 4), Fret(4, 2), Fret(5, -1), Fret(6, -1)
            ), emptyList(), listOf(Finger(1, 1, 4), Finger(2, 3, 2))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 1), Fret(2, 4), Fret(3, 8),
                Fret(4, -1), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 4), Fret(2, 1), Fret(3, 2), Fret(4, 1)
            ), emptyList(), listOf(Finger(1, 1, 4), Finger(2, 3, 2)))
        )),

        "DM" to Chord("Dm", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 1), Fret(2, 3), Fret(3, 2), Fret(4, 0), Fret(5, -1), Fret(6, -1)
            ), emptyList(), listOf(Finger(1, 1, 1), Finger(2, 2, 3), Finger(3, 3, 2))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 2), Fret(2, 5), Fret(3, 9),
                Fret(4, -1), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 2), Fret(2, 1), Fret(3, 0), Fret(4, 0)
            ), emptyList(), listOf(Finger(1, 1, 2), Finger(2, 2, 1)))
        )),

        "DSM" to Chord("D#m", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 3), Fret(2, -1), Fret(3, 3), Fret(4, 1), Fret(5, -1), Fret(6, -1)
            ), emptyList(), listOf(Finger(1, 1, 3), Finger(2, 3, 1))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 3), Fret(2, 7), Fret(3, 10),
                Fret(4, -1), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 3), Fret(2, 1), Fret(3, 1), Fret(4, 2)
            ), emptyList(), listOf(Finger(1, 1, 3), Finger(2, 3, 1), Finger(3, 4, 2)))
        )),

        "EM" to Chord("Em", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 0), Fret(2, 0), Fret(3, 0), Fret(4, 2), Fret(5, 2), Fret(6, 0)
            ), emptyList(), listOf(Finger(1, 4, 2), Finger(2, 5, 2))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 4), Fret(2, 7), Fret(3, 11),
                Fret(4, -1), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 0), Fret(2, 0), Fret(3, 0), Fret(4, 3)
            ), emptyList(), listOf(Finger(1, 4, 3)))
        )),

        "FM" to Chord("Fm", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 1), Fret(2, 1), Fret(3, 1), Fret(4, 3), Fret(5, 3), Fret(6, 1)
            ), listOf(Barre(1, 1, 6, 1)), listOf(Finger(2, 4, 3), Finger(3, 5, 3))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 5), Fret(2, 8), Fret(3, 12),
                Fret(4, -1), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 1), Fret(2, 1), Fret(3, 0), Fret(4, 0)
            ), emptyList(), listOf(Finger(1, 1, 1), Finger(2, 2, 1)))
        )),

        "FSM" to Chord("F#m", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 2), Fret(2, 2), Fret(3, 2), Fret(4, 4), Fret(5, 4), Fret(6, 2)
            ), listOf(Barre(2, 1, 6, 1)), listOf(Finger(2, 4, 4), Finger(3, 5, 4))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 6), Fret(2, 9), Fret(3, 1),
                Fret(4, -1), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 2), Fret(2, 1), Fret(3, 1), Fret(4, 2)
            ), emptyList(), listOf(Finger(1, 1, 2), Finger(2, 4, 2)))
        )),

        "GM" to Chord("Gm", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 3), Fret(2, 3), Fret(3, 3), Fret(4, 5), Fret(5, 5), Fret(6, 3)
            ), listOf(Barre(3, 1, 6, 1)), listOf(Finger(2, 4, 5), Finger(3, 5, 5))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 7), Fret(2, 10), Fret(3, 2),
                Fret(4, -1), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 3), Fret(2, 0), Fret(3, 1), Fret(4, 3)
            ), emptyList(), listOf(Finger(1, 1, 3), Finger(2, 3, 1), Finger(3, 4, 3)))
        )),

        "GSM" to Chord("G#m", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 4), Fret(2, 4), Fret(3, 4), Fret(4, 6), Fret(5, 6), Fret(6, 4)
            ), listOf(Barre(4, 1, 6, 1)), listOf(Finger(2, 5, 6), Finger(3, 6, 6))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 8), Fret(2, 11), Fret(3, 3),
                Fret(4, -1), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 4), Fret(2, 1), Fret(3, 2), Fret(4, 1)
            ), emptyList(), listOf(Finger(1, 1, 4), Finger(2, 3, 2)))
        )),

        "AM" to Chord("Am", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 0), Fret(2, 1), Fret(3, 2), Fret(4, 2), Fret(5, 0), Fret(6, -1)
            ), emptyList(), listOf(Finger(1, 2, 1), Finger(2, 3, 2), Finger(3, 4, 2))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 9), Fret(2, 0), Fret(3, 4),
                Fret(4, -1), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 2), Fret(2, 0), Fret(3, 1), Fret(4, 0)
            ), emptyList(), listOf(Finger(1, 1, 2), Finger(2, 3, 1)))
        )),

        "ASM" to Chord("A#m", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 1), Fret(2, 2), Fret(3, 3), Fret(4, 3), Fret(5, 1), Fret(6, -1)
            ), listOf(Barre(1, 1, 5, 1)), listOf(Finger(2, 2, 2), Finger(3, 3, 3), Finger(4, 4, 3))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 10), Fret(2, 1), Fret(3, 5),
                Fret(4, -1), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 1), Fret(2, 2), Fret(3, 1), Fret(4, 1)
            ), emptyList(), listOf(Finger(1, 1, 1), Finger(2, 2, 2), Finger(3, 4, 1)))
        )),

        "BM" to Chord("Bm", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 2), Fret(2, 3), Fret(3, 4), Fret(4, 4), Fret(5, 2), Fret(6, -1)
            ), listOf(Barre(2, 1, 5, 1)), listOf(Finger(2, 3, 4), Finger(3, 4, 4))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 11), Fret(2, 2), Fret(3, 6),
                Fret(4, -1), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 2), Fret(2, 3), Fret(3, 2), Fret(4, 2)
            ), emptyList(), listOf(Finger(1, 1, 2), Finger(2, 2, 3), Finger(3, 4, 2)))
        )),

        // ============ SEVENTH CHORDS ============
        "C7" to Chord("C7", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 0), Fret(2, 1), Fret(3, 3), Fret(4, 2), Fret(5, 3), Fret(6, -1)
            ), emptyList(), listOf(Finger(1, 2, 1), Finger(2, 3, 3), Finger(3, 4, 2), Finger(4, 5, 3))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 0), Fret(2, 4), Fret(3, 7), Fret(4, 10), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 0), Fret(2, 3), Fret(3, 2), Fret(4, 1)
            ), emptyList(), listOf(Finger(1, 2, 3), Finger(2, 3, 2), Finger(3, 4, 1)))
        )),

        "CS7" to Chord("C#7", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 1), Fret(2, 3), Fret(3, 1), Fret(4, 2), Fret(5, 1), Fret(6, -1)
            ), emptyList(), listOf(Finger(1, 1, 1), Finger(2, 3, 1), Finger(3, 4, 2), Finger(4, 5, 1))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 1), Fret(2, 5), Fret(3, 8), Fret(4, 11), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 1), Fret(2, 3), Fret(3, 2), Fret(4, 1)
            ), emptyList(), listOf(Finger(1, 1, 1), Finger(2, 2, 3), Finger(3, 3, 2), Finger(4, 4, 1)))
        )),

        "D7" to Chord("D7", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 2), Fret(2, 1), Fret(3, 2), Fret(4, 0), Fret(5, -1), Fret(6, -1)
            ), emptyList(), listOf(Finger(1, 1, 2), Finger(2, 2, 1), Finger(3, 3, 2))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 2), Fret(2, 6), Fret(3, 9), Fret(4, 0), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 2), Fret(2, 1), Fret(3, 2), Fret(4, 0)
            ), emptyList(), listOf(Finger(1, 1, 2), Finger(2, 2, 1), Finger(3, 3, 2)))
        )),

        "DS7" to Chord("D#7", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 3), Fret(2, -1), Fret(3, 1), Fret(4, 1), Fret(5, -1), Fret(6, -1)
            ), emptyList(), listOf(Finger(1, 1, 3), Finger(2, 3, 1), Finger(3, 4, 1))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 3), Fret(2, 7), Fret(3, 10), Fret(4, 1), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 3), Fret(2, 1), Fret(3, 1), Fret(4, 2)
            ), emptyList(), listOf(Finger(1, 1, 3), Finger(2, 3, 1), Finger(3, 4, 1)))
        )),

        "E7" to Chord("E7", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 0), Fret(2, 0), Fret(3, 1), Fret(4, 0), Fret(5, 2), Fret(6, 0)
            ), emptyList(), listOf(Finger(1, 3, 1), Finger(2, 5, 2))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 4), Fret(2, 8), Fret(3, 11), Fret(4, 2), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 0), Fret(2, 3), Fret(3, 1), Fret(4, 2)
            ), emptyList(), listOf(Finger(1, 2, 3), Finger(2, 4, 2)))
        )),

        "F7" to Chord("F7", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 1), Fret(2, 1), Fret(3, 2), Fret(4, 1), Fret(5, 3), Fret(6, 1)
            ), listOf(Barre(1, 1, 6, 1)), listOf(Finger(2, 3, 2), Finger(3, 5, 3))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 5), Fret(2, 9), Fret(3, 0), Fret(4, 3), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 2), Fret(2, 1), Fret(3, 0), Fret(4, 1)
            ), emptyList(), listOf(Finger(1, 1, 2), Finger(2, 2, 1), Finger(3, 4, 1)))
        )),

        "FS7" to Chord("F#7", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 2), Fret(2, 2), Fret(3, 3), Fret(4, 2), Fret(5, -1), Fret(6, -1)
            ), emptyList(), listOf(Finger(1, 1, 2), Finger(2, 2, 2), Finger(3, 3, 3), Finger(4, 4, 2))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 6), Fret(2, 10), Fret(3, 1), Fret(4, 4), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 3), Fret(2, 1), Fret(3, 1), Fret(4, 1)
            ), emptyList(), listOf(Finger(1, 1, 3), Finger(2, 3, 1), Finger(3, 4, 1)))
        )),

        "G7" to Chord("G7", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 1), Fret(2, 0), Fret(3, 0), Fret(4, 0), Fret(5, 2), Fret(6, 3)
            ), emptyList(), listOf(Finger(1, 1, 1), Finger(2, 5, 2), Finger(3, 6, 3))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 7), Fret(2, 11), Fret(3, 2), Fret(4, 5), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 1), Fret(2, 0), Fret(3, 0), Fret(4, 2)
            ), emptyList(), listOf(Finger(1, 1, 1), Finger(2, 4, 2)))
        )),

        "GS7" to Chord("G#7", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 4), Fret(2, -1), Fret(3, 2), Fret(4, 3), Fret(5, -1), Fret(6, -1)
            ), emptyList(), listOf(Finger(1, 1, 4), Finger(2, 3, 2), Finger(3, 4, 3))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 8), Fret(2, 0), Fret(3, 3), Fret(4, 6), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 4), Fret(2, 1), Fret(3, 1), Fret(4, 2)
            ), emptyList(), listOf(Finger(1, 1, 4), Finger(2, 3, 1), Finger(3, 4, 2)))
        )),

        "A7" to Chord("A7", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 0), Fret(2, 2), Fret(3, 0), Fret(4, 2), Fret(5, 0), Fret(6, -1)
            ), emptyList(), listOf(Finger(1, 2, 2), Finger(2, 4, 2))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 9), Fret(2, 1), Fret(3, 4), Fret(4, 7), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 0), Fret(2, 2), Fret(3, 1), Fret(4, 0)
            ), emptyList(), listOf(Finger(1, 2, 2), Finger(2, 3, 1)))
        )),

        "AS7" to Chord("A#7", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 1), Fret(2, 3), Fret(3, 1), Fret(4, 2), Fret(5, 1), Fret(6, -1)
            ), listOf(Barre(1, 1, 5, 1)), listOf(Finger(2, 3, 1), Finger(3, 4, 2))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 10), Fret(2, 2), Fret(3, 5), Fret(4, 8), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 1), Fret(2, 3), Fret(3, 2), Fret(4, 1)
            ), emptyList(), listOf(Finger(1, 1, 1), Finger(2, 2, 3), Finger(3, 3, 2), Finger(4, 4, 1)))
        )),

        "B7" to Chord("B7", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 2), Fret(2, 0), Fret(3, 2), Fret(4, 1), Fret(5, 2), Fret(6, -1)
            ), emptyList(), listOf(Finger(1, 1, 2), Finger(2, 4, 1), Finger(3, 5, 2))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 11), Fret(2, 3), Fret(3, 6), Fret(4, 9), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 2), Fret(2, 3), Fret(3, 1), Fret(4, 2)
            ), emptyList(), listOf(Finger(1, 1, 2), Finger(2, 2, 3), Finger(3, 3, 1), Finger(4, 4, 2)))
        )),

        // ============ MAJOR 7TH CHORDS ============
        "CMAJ7" to Chord("Cmaj7", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 0), Fret(2, 0), Fret(3, 0), Fret(4, 2), Fret(5, 3), Fret(6, -1)
            ), emptyList(), listOf(Finger(1, 4, 2), Finger(2, 5, 3))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 0), Fret(2, 4), Fret(3, 7), Fret(4, 11), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 0), Fret(2, 2), Fret(3, 0), Fret(4, 0)
            ), emptyList(), listOf(Finger(1, 2, 2)))
        )),

        "DMAJ7" to Chord("Dmaj7", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 2), Fret(2, 2), Fret(3, 2), Fret(4, 0), Fret(5, -1), Fret(6, -1)
            ), emptyList(), listOf(Finger(1, 1, 2), Finger(2, 2, 2), Finger(3, 3, 2))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 2), Fret(2, 6), Fret(3, 9), Fret(4, 1), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 2), Fret(2, 2), Fret(3, 1), Fret(4, 2)
            ), emptyList(), listOf(Finger(1, 1, 2), Finger(2, 2, 2), Finger(3, 4, 2)))
        )),

        "EMAJ7" to Chord("Emaj7", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 0), Fret(2, 0), Fret(3, 1), Fret(4, 1), Fret(5, 2), Fret(6, 0)
            ), emptyList(), listOf(Finger(1, 3, 1), Finger(2, 4, 1), Finger(3, 5, 2))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 4), Fret(2, 8), Fret(3, 11), Fret(4, 3), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 4), Fret(2, 2), Fret(3, 1), Fret(4, 2)
            ), emptyList(), listOf(Finger(1, 1, 4), Finger(2, 2, 2), Finger(3, 4, 2)))
        )),

        "GMAJ7" to Chord("Gmaj7", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 3), Fret(2, 2), Fret(3, 0), Fret(4, 0), Fret(5, 0), Fret(6, 2)
            ), emptyList(), listOf(Finger(1, 1, 3), Finger(2, 2, 2), Finger(3, 6, 2))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 7), Fret(2, 11), Fret(3, 2), Fret(4, 6), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 2), Fret(2, 0), Fret(3, 0), Fret(4, 2)
            ), emptyList(), listOf(Finger(1, 1, 2), Finger(2, 4, 2)))
        )),

        "AMAJ7" to Chord("Amaj7", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 0), Fret(2, 2), Fret(3, 1), Fret(4, 2), Fret(5, 0), Fret(6, -1)
            ), emptyList(), listOf(Finger(1, 2, 2), Finger(2, 3, 1), Finger(3, 4, 2))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 9), Fret(2, 1), Fret(3, 4), Fret(4, 8), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 0), Fret(2, 2), Fret(3, 0), Fret(4, 0)
            ), emptyList(), listOf(Finger(1, 2, 2)))
        )),

        "BMAJ7" to Chord("Bmaj7", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 2), Fret(2, 2), Fret(3, 4), Fret(4, 4), Fret(5, 2), Fret(6, -1)
            ), listOf(Barre(2, 1, 5, 1)), listOf(Finger(3, 3, 4), Finger(4, 4, 4))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 11), Fret(2, 3), Fret(3, 6), Fret(4, 10), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 2), Fret(2, 2), Fret(3, 1), Fret(4, 2)
            ), emptyList(), listOf(Finger(1, 1, 2), Finger(2, 2, 2), Finger(3, 4, 2)))
        )),

        // ============ MINOR 7TH CHORDS ============
        "CM7" to Chord("Cm7", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 3), Fret(2, 5), Fret(3, 3), Fret(4, 3), Fret(5, 3), Fret(6, -1)
            ), listOf(Barre(3, 1, 5, 1)), listOf(Finger(2, 2, 5))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 0), Fret(2, 3), Fret(3, 7), Fret(4, 10), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 3), Fret(2, 1), Fret(3, 2), Fret(4, 1)
            ), emptyList(), listOf(Finger(1, 1, 3), Finger(2, 2, 1), Finger(3, 3, 2), Finger(4, 4, 1)))
        )),

        "DM7" to Chord("Dm7", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 1), Fret(2, 3), Fret(3, 1), Fret(4, 1), Fret(5, 1), Fret(6, -1)
            ), emptyList(), listOf(Finger(1, 1, 1), Finger(2, 2, 3), Finger(3, 3, 1), Finger(4, 4, 1))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 2), Fret(2, 5), Fret(3, 9), Fret(4, 0), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 2), Fret(2, 1), Fret(3, 0), Fret(4, 1)
            ), emptyList(), listOf(Finger(1, 1, 2), Finger(2, 2, 1), Finger(3, 4, 1)))
        )),

        "EM7" to Chord("Em7", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 0), Fret(2, 0), Fret(3, 0), Fret(4, 3), Fret(5, 2), Fret(6, 0)
            ), emptyList(), listOf(Finger(1, 4, 3), Finger(2, 5, 2))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 4), Fret(2, 7), Fret(3, 11), Fret(4, 2), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 0), Fret(2, 0), Fret(3, 0), Fret(4, 1)
            ), emptyList(), listOf(Finger(1, 4, 1)))
        )),

        "GM7" to Chord("Gm7", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 3), Fret(2, 3), Fret(3, 3), Fret(4, 3), Fret(5, 1), Fret(6, -1)
            ), listOf(Barre(3, 1, 5, 1)), listOf()),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 7), Fret(2, 10), Fret(3, 2), Fret(4, 5), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 3), Fret(2, 0), Fret(3, 1), Fret(4, 1)
            ), emptyList(), listOf(Finger(1, 1, 3), Finger(2, 3, 1), Finger(3, 4, 1)))
        )),

        "AM7" to Chord("Am7", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 0), Fret(2, 1), Fret(3, 2), Fret(4, 0), Fret(5, 0), Fret(6, -1)
            ), emptyList(), listOf(Finger(1, 2, 1), Finger(2, 3, 2))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 9), Fret(2, 0), Fret(3, 4), Fret(4, 7), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 2), Fret(2, 0), Fret(3, 1), Fret(4, 0)
            ), emptyList(), listOf(Finger(1, 1, 2), Finger(2, 3, 1)))
        )),

        "BM7" to Chord("Bm7", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 2), Fret(2, 3), Fret(3, 2), Fret(4, 2), Fret(5, 2), Fret(6, -1)
            ), listOf(Barre(2, 1, 5, 1)), listOf()),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 11), Fret(2, 2), Fret(3, 6), Fret(4, 9), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 2), Fret(2, 3), Fret(3, 2), Fret(4, 2)
            ), emptyList(), listOf(Finger(1, 1, 2), Finger(2, 2, 3), Finger(3, 4, 2)))
        )),

        // ============ DIMINISHED ============
        "CDIM" to Chord("Cdim", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 3), Fret(2, 4), Fret(3, 2), Fret(4, 3), Fret(5, 1), Fret(6, -1)
            ), emptyList(), listOf(Finger(1, 1, 3), Finger(2, 2, 4), Finger(3, 3, 2), Finger(4, 5, 1))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 0), Fret(2, 3), Fret(3, 6),
                Fret(4, -1), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 3), Fret(2, 1), Fret(3, 2), Fret(4, 1)
            ), emptyList(), listOf(Finger(1, 1, 3), Finger(2, 2, 1), Finger(3, 3, 2), Finger(4, 4, 1)))
        )),

        "DDIM" to Chord("Ddim", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 1), Fret(2, 2), Fret(3, 0), Fret(4, 1), Fret(5, -1), Fret(6, -1)
            ), emptyList(), listOf(Finger(1, 1, 1), Finger(2, 2, 2), Finger(3, 4, 1))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 2), Fret(2, 5), Fret(3, 8),
                Fret(4, -1), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 1), Fret(2, 2), Fret(3, 0), Fret(4, 1)
            ), emptyList(), listOf(Finger(1, 1, 1), Finger(2, 2, 2), Finger(3, 4, 1)))
        )),

        "EDIM" to Chord("Edim", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 0), Fret(2, 0), Fret(3, 1), Fret(4, 2), Fret(5, 0), Fret(6, -1)
            ), emptyList(), listOf(Finger(1, 3, 1), Finger(2, 4, 2))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 4), Fret(2, 7), Fret(3, 10),
                Fret(4, -1), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 3), Fret(2, 1), Fret(3, 1), Fret(4, 2)
            ), emptyList(), listOf(Finger(1, 1, 3), Finger(2, 3, 1), Finger(3, 4, 2)))
        )),

        "GDIM" to Chord("Gdim", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 3), Fret(2, 4), Fret(3, 2), Fret(4, 3), Fret(5, 1), Fret(6, -1)
            ), emptyList(), listOf(Finger(1, 1, 3), Finger(2, 2, 4), Finger(3, 3, 2), Finger(4, 5, 1))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 7), Fret(2, 10), Fret(3, 1),
                Fret(4, -1), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 1), Fret(2, 2), Fret(3, 1), Fret(4, 2)
            ), emptyList(), listOf(Finger(1, 1, 1), Finger(2, 2, 2), Finger(3, 3, 1), Finger(4, 4, 2)))
        )),

        // ============ AUGMENTED ============
        "CAUG" to Chord("Caug", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 0), Fret(2, 1), Fret(3, 0), Fret(4, 3), Fret(5, 3), Fret(6, -1)
            ), emptyList(), listOf(Finger(1, 2, 1), Finger(2, 4, 3), Finger(3, 5, 3))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 0), Fret(2, 4), Fret(3, 8),
                Fret(4, -1), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 0), Fret(2, 3), Fret(3, 3), Fret(4, 1)
            ), emptyList(), listOf(Finger(1, 1, 1), Finger(2, 2, 3), Finger(3, 3, 3), Finger(4, 4, 1)))
        )),

        "DAUG" to Chord("Daug", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 2), Fret(2, 3), Fret(3, 2), Fret(4, 1), Fret(5, -1), Fret(6, -1)
            ), emptyList(), listOf(Finger(1, 1, 2), Finger(2, 2, 3), Finger(3, 3, 2), Finger(4, 4, 1))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 2), Fret(2, 6), Fret(3, 10),
                Fret(4, -1), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 2), Fret(2, 2), Fret(3, 2), Fret(4, 1)
            ), emptyList(), listOf(Finger(1, 1, 2), Finger(2, 2, 2), Finger(3, 3, 2), Finger(4, 4, 1)))
        )),

        "GAUG" to Chord("Gaug", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 3), Fret(2, 2), Fret(3, 1), Fret(4, 0), Fret(5, 0), Fret(6, 3)
            ), emptyList(), listOf(Finger(1, 1, 3), Finger(2, 2, 2), Finger(3, 3, 1), Finger(4, 6, 3))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 7), Fret(2, 11), Fret(3, 3),
                Fret(4, -1), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 2), Fret(2, 0), Fret(3, 1), Fret(4, 3)
            ), emptyList(), listOf(Finger(1, 1, 2), Finger(2, 3, 1), Finger(3, 4, 3)))
        )),

        "AAUG" to Chord("Aaug", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 0), Fret(2, 2), Fret(3, 3), Fret(4, 2), Fret(5, 0), Fret(6, -1)
            ), emptyList(), listOf(Finger(1, 2, 2), Finger(2, 3, 3), Finger(3, 4, 2))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 9), Fret(2, 1), Fret(3, 5),
                Fret(4, -1), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 0), Fret(2, 2), Fret(3, 2), Fret(4, 0)
            ), emptyList(), listOf(Finger(1, 1, 1), Finger(2, 2, 2), Finger(3, 3, 2)))
        )),

        // ============ ADD CHORDS ============
        "CADD9" to Chord("Cadd9", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 0), Fret(2, 3), Fret(3, 0), Fret(4, 2), Fret(5, 3), Fret(6, -1)
            ), emptyList(), listOf(Finger(1, 2, 3), Finger(2, 4, 2), Finger(3, 5, 3))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 0), Fret(2, 4), Fret(3, 7), Fret(4, 14), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 0), Fret(2, 0), Fret(3, 2), Fret(4, 0)
            ), emptyList(), listOf(Finger(1, 3, 2)))
        )),

        "DADD9" to Chord("Dadd9", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 2), Fret(2, 3), Fret(3, 2), Fret(4, 0), Fret(5, 3), Fret(6, -1)
            ), emptyList(), listOf(Finger(1, 1, 2), Finger(2, 2, 3), Finger(3, 3, 2), Finger(4, 5, 3))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 2), Fret(2, 6), Fret(3, 9), Fret(4, 14), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 2), Fret(2, 0), Fret(3, 2), Fret(4, 0)
            ), emptyList(), listOf(Finger(1, 1, 2), Finger(2, 3, 2)))
        )),

        "EADD9" to Chord("Eadd9", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 0), Fret(2, 0), Fret(3, 1), Fret(4, 4), Fret(5, 2), Fret(6, 0)
            ), emptyList(), listOf(Finger(1, 3, 1), Finger(2, 4, 4), Finger(3, 5, 2))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 4), Fret(2, 8), Fret(3, 11), Fret(4, 18), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 4), Fret(2, 2), Fret(3, 1), Fret(4, 0)
            ), emptyList(), listOf(Finger(1, 1, 4), Finger(2, 2, 2), Finger(3, 3, 1)))
        )),

        "GADD9" to Chord("Gadd9", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 3), Fret(2, 0), Fret(3, 0), Fret(4, 0), Fret(5, 0), Fret(6, 3)
            ), emptyList(), listOf(Finger(1, 1, 3), Finger(2, 6, 3))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 7), Fret(2, 11), Fret(3, 14), Fret(4, 19), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 2), Fret(2, 0), Fret(3, 0), Fret(4, 0)
            ), emptyList(), listOf(Finger(1, 1, 2)))
        )),

        "AADD9" to Chord("Aadd9", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 0), Fret(2, 2), Fret(3, 0), Fret(4, 2), Fret(5, 0), Fret(6, -1)
            ), emptyList(), listOf(Finger(1, 2, 2), Finger(2, 4, 2))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 9), Fret(2, 1), Fret(3, 4), Fret(4, 13), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 0), Fret(2, 0), Fret(3, 1), Fret(4, 0)
            ), emptyList(), listOf(Finger(1, 3, 1)))
        )),

        // ============ SUSPENDED ============
        "DSUS2" to Chord("Dsus2", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 3), Fret(2, 3), Fret(3, 2), Fret(4, 0), Fret(5, -1), Fret(6, -1)
            ), emptyList(), listOf(Finger(1, 1, 3), Finger(2, 2, 3), Finger(3, 3, 2))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 2), Fret(2, 4), Fret(3, 9),
                Fret(4, -1), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 2), Fret(2, 0), Fret(3, 0), Fret(4, 0)
            ), emptyList(), listOf(Finger(1, 1, 2)))
        )),

        "DSUS4" to Chord("Dsus4", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 3), Fret(2, 3), Fret(3, 3), Fret(4, 0), Fret(5, -1), Fret(6, -1)
            ), emptyList(), listOf(Finger(1, 1, 3), Finger(2, 2, 3), Finger(3, 3, 3))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 2), Fret(2, 7), Fret(3, 9),
                Fret(4, -1), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 2), Fret(2, 0), Fret(3, 0), Fret(4, 3)
            ), emptyList(), listOf(Finger(1, 1, 2), Finger(2, 4, 3)))
        )),

        "ESUS2" to Chord("Esus2", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 0), Fret(2, 0), Fret(3, 4), Fret(4, 2), Fret(5, 2), Fret(6, 0)
            ), emptyList(), listOf(Finger(1, 3, 4), Finger(2, 4, 2), Finger(3, 5, 2))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 4), Fret(2, 6), Fret(3, 11),
                Fret(4, -1), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 4), Fret(2, 2), Fret(3, 0), Fret(4, 2)
            ), emptyList(), listOf(Finger(1, 1, 4), Finger(2, 2, 2), Finger(3, 4, 2)))
        )),

        "ESUS4" to Chord("Esus4", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 0), Fret(2, 0), Fret(3, 2), Fret(4, 2), Fret(5, 2), Fret(6, 0)
            ), emptyList(), listOf(Finger(1, 3, 2), Finger(2, 4, 2), Finger(3, 5, 2))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 4), Fret(2, 9), Fret(3, 11),
                Fret(4, -1), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 4), Fret(2, 2), Fret(3, 1), Fret(4, 2)
            ), emptyList(), listOf(Finger(1, 1, 4), Finger(2, 2, 2), Finger(3, 4, 2)))
        )),

        "ASUS2" to Chord("Asus2", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 0), Fret(2, 0), Fret(3, 2), Fret(4, 2), Fret(5, 0), Fret(6, -1)
            ), emptyList(), listOf(Finger(1, 3, 2), Finger(2, 4, 2))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 9), Fret(2, 11), Fret(3, 4),
                Fret(4, -1), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 0), Fret(2, 0), Fret(3, 1), Fret(4, 0)
            ), emptyList(), listOf(Finger(1, 3, 1)))
        )),

        "ASUS4" to Chord("Asus4", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 0), Fret(2, 3), Fret(3, 2), Fret(4, 2), Fret(5, 0), Fret(6, -1)
            ), emptyList(), listOf(Finger(1, 2, 3), Finger(2, 3, 2), Finger(3, 4, 2))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 9), Fret(2, 2), Fret(3, 4),
                Fret(4, -1), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 0), Fret(2, 1), Fret(3, 1), Fret(4, 0)
            ), emptyList(), listOf(Finger(1, 2, 1), Finger(2, 3, 1)))
        )),

        "GSUS4" to Chord("Gsus4", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 3), Fret(2, 3), Fret(3, 0), Fret(4, 0), Fret(5, 1), Fret(6, 3)
            ), emptyList(), listOf(Finger(1, 1, 3), Finger(2, 2, 3), Finger(3, 5, 1), Finger(4, 6, 3))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 7), Fret(2, 0), Fret(3, 2),
                Fret(4, -1), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 1), Fret(2, 0), Fret(3, 0), Fret(4, 3)
            ), emptyList(), listOf(Finger(1, 1, 1), Finger(2, 4, 3)))
        )),

        // ============ SIXTH CHORDS ============
        "C6" to Chord("C6", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 0), Fret(2, 1), Fret(3, 0), Fret(4, 2), Fret(5, 3), Fret(6, -1)
            ), emptyList(), listOf(Finger(1, 2, 1), Finger(2, 4, 2), Finger(3, 5, 3))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 0), Fret(2, 4), Fret(3, 7), Fret(4, 9), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 0), Fret(2, 0), Fret(3, 2), Fret(4, 0)
            ), emptyList(), listOf(Finger(1, 3, 2)))
        )),

        "D6" to Chord("D6", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 2), Fret(2, 0), Fret(3, 2), Fret(4, 0), Fret(5, -1), Fret(6, -1)
            ), emptyList(), listOf(Finger(1, 1, 2), Finger(2, 3, 2))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 2), Fret(2, 6), Fret(3, 9), Fret(4, 11), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 2), Fret(2, 0), Fret(3, 2), Fret(4, 0)
            ), emptyList(), listOf(Finger(1, 1, 2), Finger(2, 3, 2)))
        )),

        "E6" to Chord("E6", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 0), Fret(2, 0), Fret(3, 1), Fret(4, 2), Fret(5, 2), Fret(6, 0)
            ), emptyList(), listOf(Finger(1, 3, 1), Finger(2, 4, 2), Finger(3, 5, 2))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 4), Fret(2, 8), Fret(3, 11), Fret(4, 13), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 4), Fret(2, 2), Fret(3, 1), Fret(4, 2)
            ), emptyList(), listOf(Finger(1, 1, 4), Finger(2, 2, 2), Finger(3, 4, 2)))
        )),

        "A6" to Chord("A6", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 0), Fret(2, 2), Fret(3, 2), Fret(4, 2), Fret(5, 0), Fret(6, -1)
            ), emptyList(), listOf(Finger(1, 2, 2), Finger(2, 3, 2), Finger(3, 4, 2))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 9), Fret(2, 1), Fret(3, 4), Fret(4, 7), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 0), Fret(2, 2), Fret(3, 1), Fret(4, 0)
            ), emptyList(), listOf(Finger(1, 2, 2), Finger(2, 3, 1)))
        )),

        "AM6" to Chord("Am6", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 0), Fret(2, 1), Fret(3, 2), Fret(4, 0), Fret(5, 0), Fret(6, -1)
            ), emptyList(), listOf(Finger(1, 2, 1), Finger(2, 3, 2))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 9), Fret(2, 0), Fret(3, 4), Fret(4, 9), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 2), Fret(2, 0), Fret(3, 0), Fret(4, 0)
            ), emptyList(), listOf(Finger(1, 1, 2)))
        )),

        // ============ ADD11 CHORDS ============
        "CADD11" to Chord("Cadd11", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 3), Fret(2, 3), Fret(3, 3), Fret(4, 3), Fret(5, 3), Fret(6, -1)
            ), listOf(Barre(3, 1, 5, 1)), listOf()),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 0), Fret(2, 4), Fret(3, 7), Fret(4, 17), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 0), Fret(2, 3), Fret(3, 2), Fret(4, 1)
            ), emptyList(), listOf(Finger(1, 2, 3), Finger(2, 3, 2), Finger(3, 4, 1)))
        )),

        "DADD11" to Chord("Dadd11", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 3), Fret(2, 3), Fret(3, 2), Fret(4, 0), Fret(5, -1), Fret(6, -1)
            ), emptyList(), listOf(Finger(1, 1, 3), Finger(2, 2, 3), Finger(3, 3, 2))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 2), Fret(2, 6), Fret(3, 9), Fret(4, 19), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 2), Fret(2, 2), Fret(3, 1), Fret(4, 2)
            ), emptyList(), listOf(Finger(1, 1, 2), Finger(2, 2, 2), Finger(3, 4, 2)))
        )),

        "EADD11" to Chord("Eadd11", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 0), Fret(2, 0), Fret(3, 1), Fret(4, 2), Fret(5, 2), Fret(6, 3)
            ), emptyList(), listOf(Finger(1, 3, 1), Finger(2, 4, 2), Finger(3, 5, 2), Finger(4, 6, 3))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 4), Fret(2, 8), Fret(3, 11), Fret(4, 21), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 4), Fret(2, 3), Fret(3, 1), Fret(4, 2)
            ), emptyList(), listOf(Finger(1, 1, 4), Finger(2, 2, 3), Finger(3, 4, 2)))
        )),

        "GADD11" to Chord("Gadd11", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 3), Fret(2, 3), Fret(3, 0), Fret(4, 0), Fret(5, 0), Fret(6, 3)
            ), emptyList(), listOf(Finger(1, 1, 3), Finger(2, 2, 3), Finger(3, 6, 3))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 7), Fret(2, 11), Fret(3, 14), Fret(4, 0), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 2), Fret(2, 0), Fret(3, 0), Fret(4, 3)
            ), emptyList(), listOf(Finger(1, 1, 2), Finger(2, 4, 3)))
        )),

        "AADD11" to Chord("Aadd11", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 0), Fret(2, 2), Fret(3, 2), Fret(4, 2), Fret(5, 0), Fret(6, 3)
            ), emptyList(), listOf(Finger(1, 2, 2), Finger(2, 3, 2), Finger(3, 4, 2), Finger(4, 6, 3))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 9), Fret(2, 1), Fret(3, 4), Fret(4, 17), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 0), Fret(2, 2), Fret(3, 1), Fret(4, 0)
            ), emptyList(), listOf(Finger(1, 2, 2), Finger(2, 3, 1)))
        )),

        // ============ ADD13 CHORDS ============
        "CADD13" to Chord("Cadd13", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 3), Fret(2, 3), Fret(3, 3), Fret(4, 3), Fret(5, 3), Fret(6, 3)
            ), listOf(Barre(3, 1, 6, 1)), listOf()),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 0), Fret(2, 4), Fret(3, 7), Fret(4, 9), Fret(5, 21), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 0), Fret(2, 3), Fret(3, 2), Fret(4, 1)
            ), emptyList(), listOf(Finger(1, 2, 3), Finger(2, 3, 2), Finger(3, 4, 1)))
        )),

        "DADD13" to Chord("Dadd13", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 3), Fret(2, 3), Fret(3, 2), Fret(4, 0), Fret(5, 3), Fret(6, -1)
            ), emptyList(), listOf(Finger(1, 1, 3), Finger(2, 2, 3), Finger(3, 3, 2), Finger(4, 5, 3))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 2), Fret(2, 6), Fret(3, 9), Fret(4, 11), Fret(5, 23), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 2), Fret(2, 2), Fret(3, 1), Fret(4, 2)
            ), emptyList(), listOf(Finger(1, 1, 2), Finger(2, 2, 2), Finger(3, 4, 2)))
        )),

        "EADD13" to Chord("Eadd13", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 0), Fret(2, 0), Fret(3, 1), Fret(4, 2), Fret(5, 2), Fret(6, 0)
            ), emptyList(), listOf(Finger(1, 3, 1), Finger(2, 4, 2), Finger(3, 5, 2))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 4), Fret(2, 8), Fret(3, 11), Fret(4, 13), Fret(5, 1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 4), Fret(2, 3), Fret(3, 1), Fret(4, 2)
            ), emptyList(), listOf(Finger(1, 1, 4), Finger(2, 2, 3), Finger(3, 4, 2)))
        )),

        "GADD13" to Chord("Gadd13", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 3), Fret(2, 3), Fret(3, 0), Fret(4, 0), Fret(5, 0), Fret(6, 3)
            ), emptyList(), listOf(Finger(1, 1, 3), Finger(2, 2, 3), Finger(3, 6, 3))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 7), Fret(2, 11), Fret(3, 14), Fret(4, 19), Fret(5, 7), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 2), Fret(2, 0), Fret(3, 0), Fret(4, 3)
            ), emptyList(), listOf(Finger(1, 1, 2), Finger(2, 4, 3)))
        )),

        "AADD13" to Chord("Aadd13", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 0), Fret(2, 2), Fret(3, 2), Fret(4, 2), Fret(5, 0), Fret(6, 0)
            ), emptyList(), listOf(Finger(1, 2, 2), Finger(2, 3, 2), Finger(3, 4, 2))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 9), Fret(2, 1), Fret(3, 4), Fret(4, 7), Fret(5, 21), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 0), Fret(2, 2), Fret(3, 1), Fret(4, 0)
            ), emptyList(), listOf(Finger(1, 2, 2), Finger(2, 3, 1)))
        )),

        // ============ 7TH CHORDS WITH MISSING DEGREES ============
        // 7no3 (dominant 7 without 3rd - power chord + 7)
        "C7NO3" to Chord("C7no3", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 0), Fret(2, 1), Fret(3, 0), Fret(4, 3), Fret(5, 3), Fret(6, -1)
            ), emptyList(), listOf(Finger(1, 2, 1), Finger(2, 4, 3), Finger(3, 5, 3))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 0), Fret(2, 7), Fret(3, 10), Fret(4, -1), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 0), Fret(2, 3), Fret(3, 2), Fret(4, 1)
            ), emptyList(), listOf(Finger(1, 2, 3), Finger(2, 3, 2), Finger(3, 4, 1)))
        )),

        "D7NO3" to Chord("D7no3", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 2), Fret(2, 1), Fret(3, 2), Fret(4, 0), Fret(5, 3), Fret(6, -1)
            ), emptyList(), listOf(Finger(1, 1, 2), Finger(2, 2, 1), Finger(3, 3, 2), Finger(4, 5, 3))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 2), Fret(2, 7), Fret(3, 0), Fret(4, -1), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 2), Fret(2, 1), Fret(3, 2), Fret(4, 0)
            ), emptyList(), listOf(Finger(1, 1, 2), Finger(2, 2, 1), Finger(3, 3, 2)))
        )),

        "E7NO3" to Chord("E7no3", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 0), Fret(2, 0), Fret(3, 0), Fret(4, 0), Fret(5, 2), Fret(6, 0)
            ), emptyList(), listOf(Finger(1, 5, 2))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 4), Fret(2, 7), Fret(3, 10), Fret(4, -1), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 0), Fret(2, 3), Fret(3, 1), Fret(4, 2)
            ), emptyList(), listOf(Finger(1, 2, 3), Finger(2, 4, 2)))
        )),

        "G7NO3" to Chord("G7no3", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 3), Fret(2, 0), Fret(3, 0), Fret(4, 0), Fret(5, 2), Fret(6, 3)
            ), emptyList(), listOf(Finger(1, 1, 3), Finger(2, 5, 2), Finger(3, 6, 3))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 7), Fret(2, 0), Fret(3, 3), Fret(4, -1), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 1), Fret(2, 0), Fret(3, 0), Fret(4, 2)
            ), emptyList(), listOf(Finger(1, 1, 1), Finger(2, 4, 2)))
        )),

        "A7NO3" to Chord("A7no3", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 0), Fret(2, 2), Fret(3, 0), Fret(4, 2), Fret(5, 0), Fret(6, -1)
            ), emptyList(), listOf(Finger(1, 2, 2), Finger(2, 4, 2))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 9), Fret(2, 4), Fret(3, 7), Fret(4, -1), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 0), Fret(2, 2), Fret(3, 1), Fret(4, 0)
            ), emptyList(), listOf(Finger(1, 2, 2), Finger(2, 3, 1)))
        )),

        // 7no5 (dominant 7 without 5th)
        "C7NO5" to Chord("C7no5", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 0), Fret(2, 1), Fret(3, 3), Fret(4, 2), Fret(5, 3), Fret(6, -1)
            ), emptyList(), listOf(Finger(1, 2, 1), Finger(2, 3, 3), Finger(3, 4, 2), Finger(4, 5, 3))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 0), Fret(2, 4), Fret(3, 10), Fret(4, -1), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 0), Fret(2, 3), Fret(3, 2), Fret(4, 1)
            ), emptyList(), listOf(Finger(1, 2, 3), Finger(2, 3, 2), Finger(3, 4, 1)))
        )),

        "D7NO5" to Chord("D7no5", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 2), Fret(2, 1), Fret(3, 2), Fret(4, 0), Fret(5, -1), Fret(6, -1)
            ), emptyList(), listOf(Finger(1, 1, 2), Finger(2, 2, 1), Finger(3, 3, 2))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 2), Fret(2, 6), Fret(3, 0), Fret(4, -1), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 2), Fret(2, 1), Fret(3, 2), Fret(4, 0)
            ), emptyList(), listOf(Finger(1, 1, 2), Finger(2, 2, 1), Finger(3, 3, 2)))
        )),

        "E7NO5" to Chord("E7no5", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 0), Fret(2, 0), Fret(3, 1), Fret(4, 0), Fret(5, 2), Fret(6, 0)
            ), emptyList(), listOf(Finger(1, 3, 1), Finger(2, 5, 2))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 4), Fret(2, 8), Fret(3, 2), Fret(4, -1), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 0), Fret(2, 3), Fret(3, 1), Fret(4, 2)
            ), emptyList(), listOf(Finger(1, 2, 3), Finger(2, 4, 2)))
        )),

        "G7NO5" to Chord("G7no5", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 1), Fret(2, 0), Fret(3, 0), Fret(4, 0), Fret(5, 2), Fret(6, 3)
            ), emptyList(), listOf(Finger(1, 1, 1), Finger(2, 5, 2), Finger(3, 6, 3))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 7), Fret(2, 11), Fret(3, 5), Fret(4, -1), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 1), Fret(2, 0), Fret(3, 0), Fret(4, 2)
            ), emptyList(), listOf(Finger(1, 1, 1), Finger(2, 4, 2)))
        )),

        "A7NO5" to Chord("A7no5", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 0), Fret(2, 2), Fret(3, 0), Fret(4, 2), Fret(5, 0), Fret(6, -1)
            ), emptyList(), listOf(Finger(1, 2, 2), Finger(2, 4, 2))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 9), Fret(2, 1), Fret(3, 7), Fret(4, -1), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 0), Fret(2, 2), Fret(3, 1), Fret(4, 0)
            ), emptyList(), listOf(Finger(1, 2, 2), Finger(2, 3, 1)))
        )),

        // 7no7 (dominant 7 without 7th - just major chord with added 9)
        "C7NO7" to Chord("C7no7", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 0), Fret(2, 1), Fret(3, 0), Fret(4, 2), Fret(5, 3), Fret(6, -1)
            ), emptyList(), listOf(Finger(1, 2, 1), Finger(2, 4, 2), Finger(3, 5, 3))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 0), Fret(2, 4), Fret(3, 7), Fret(4, -1), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 0), Fret(2, 3), Fret(3, 2), Fret(4, 0)
            ), emptyList(), listOf(Finger(1, 2, 3), Finger(2, 3, 2)))
        )),

        "D7NO7" to Chord("D7no7", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 2), Fret(2, 3), Fret(3, 2), Fret(4, 0), Fret(5, -1), Fret(6, -1)
            ), emptyList(), listOf(Finger(1, 1, 2), Finger(2, 2, 3), Finger(3, 3, 2))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 2), Fret(2, 6), Fret(3, 9), Fret(4, -1), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 2), Fret(2, 2), Fret(3, 1), Fret(4, 0)
            ), emptyList(), listOf(Finger(1, 1, 2), Finger(2, 2, 2), Finger(3, 3, 1)))
        )),

        "E7NO7" to Chord("E7no7", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 0), Fret(2, 0), Fret(3, 1), Fret(4, 2), Fret(5, 2), Fret(6, 0)
            ), emptyList(), listOf(Finger(1, 3, 1), Finger(2, 4, 2), Finger(3, 5, 2))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 4), Fret(2, 8), Fret(3, 11), Fret(4, -1), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 4), Fret(2, 3), Fret(3, 1), Fret(4, 2)
            ), emptyList(), listOf(Finger(1, 1, 4), Finger(2, 2, 3), Finger(3, 4, 2)))
        )),

        "G7NO7" to Chord("G7no7", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 3), Fret(2, 2), Fret(3, 0), Fret(4, 0), Fret(5, 0), Fret(6, 3)
            ), emptyList(), listOf(Finger(1, 1, 3), Finger(2, 2, 2), Finger(3, 6, 3))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 7), Fret(2, 11), Fret(3, 14), Fret(4, -1), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 2), Fret(2, 0), Fret(3, 0), Fret(4, 3)
            ), emptyList(), listOf(Finger(1, 1, 2), Finger(2, 4, 3)))
        )),

        "A7NO7" to Chord("A7no7", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 0), Fret(2, 2), Fret(3, 2), Fret(4, 2), Fret(5, 0), Fret(6, -1)
            ), emptyList(), listOf(Finger(1, 2, 2), Finger(2, 3, 2), Finger(3, 4, 2))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 9), Fret(2, 1), Fret(3, 4), Fret(4, -1), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 0), Fret(2, 2), Fret(3, 1), Fret(4, 0)
            ), emptyList(), listOf(Finger(1, 2, 2), Finger(2, 3, 1)))
        )),

        // ============ NINTH CHORDS ============
        "C9" to Chord("C9", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 0), Fret(2, 1), Fret(3, 3), Fret(4, 2), Fret(5, 3), Fret(6, -1)
            ), emptyList(), listOf(Finger(1, 2, 1), Finger(2, 3, 3), Finger(3, 4, 2), Finger(4, 5, 3))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 0), Fret(2, 4), Fret(3, 7), Fret(4, 10), Fret(5, 14), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 0), Fret(2, 3), Fret(3, 2), Fret(4, 1)
            ), emptyList(), listOf(Finger(1, 2, 3), Finger(2, 3, 2), Finger(3, 4, 1)))
        )),

        "D9" to Chord("D9", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 2), Fret(2, 1), Fret(3, 2), Fret(4, 0), Fret(5, 3), Fret(6, -1)
            ), emptyList(), listOf(Finger(1, 1, 2), Finger(2, 2, 1), Finger(3, 3, 2), Finger(4, 5, 3))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 2), Fret(2, 6), Fret(3, 9), Fret(4, 0), Fret(5, 13), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 2), Fret(2, 1), Fret(3, 2), Fret(4, 0)
            ), emptyList(), listOf(Finger(1, 1, 2), Finger(2, 2, 1), Finger(3, 3, 2)))
        )),

        "E9" to Chord("E9", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 0), Fret(2, 0), Fret(3, 1), Fret(4, 0), Fret(5, 2), Fret(6, 0)
            ), emptyList(), listOf(Finger(1, 3, 1), Finger(2, 5, 2))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 4), Fret(2, 8), Fret(3, 11), Fret(4, 2), Fret(5, 6), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 0), Fret(2, 3), Fret(3, 1), Fret(4, 2)
            ), emptyList(), listOf(Finger(1, 2, 3), Finger(2, 4, 2)))
        )),

        "G9" to Chord("G9", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 1), Fret(2, 0), Fret(3, 0), Fret(4, 0), Fret(5, 2), Fret(6, 3)
            ), emptyList(), listOf(Finger(1, 1, 1), Finger(2, 5, 2), Finger(3, 6, 3))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 7), Fret(2, 11), Fret(3, 2), Fret(4, 5), Fret(5, 9), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 1), Fret(2, 0), Fret(3, 0), Fret(4, 2)
            ), emptyList(), listOf(Finger(1, 1, 1), Finger(2, 4, 2)))
        )),

        "A9" to Chord("A9", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 0), Fret(2, 2), Fret(3, 0), Fret(4, 2), Fret(5, 0), Fret(6, -1)
            ), emptyList(), listOf(Finger(1, 2, 2), Finger(2, 4, 2))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 9), Fret(2, 1), Fret(3, 4), Fret(4, 7), Fret(5, 13), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 0), Fret(2, 2), Fret(3, 1), Fret(4, 0)
            ), emptyList(), listOf(Finger(1, 2, 2), Finger(2, 3, 1)))
        )),

        // ============ ELEVENTH CHORDS ============
        "C11" to Chord("C11", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 3), Fret(2, 3), Fret(3, 3), Fret(4, 3), Fret(5, 3), Fret(6, -1)
            ), listOf(Barre(3, 1, 5, 1)), listOf()),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 0), Fret(2, 4), Fret(3, 7), Fret(4, 10), Fret(5, 14), Fret(6, 17),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 0), Fret(2, 3), Fret(3, 2), Fret(4, 1)
            ), emptyList(), listOf(Finger(1, 2, 3), Finger(2, 3, 2), Finger(3, 4, 1)))
        )),

        "D11" to Chord("D11", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 3), Fret(2, 3), Fret(3, 2), Fret(4, 0), Fret(5, -1), Fret(6, -1)
            ), emptyList(), listOf(Finger(1, 1, 3), Finger(2, 2, 3), Finger(3, 3, 2))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 2), Fret(2, 6), Fret(3, 9), Fret(4, 0), Fret(5, 13), Fret(6, 17),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 2), Fret(2, 2), Fret(3, 1), Fret(4, 2)
            ), emptyList(), listOf(Finger(1, 1, 2), Finger(2, 2, 2), Finger(3, 4, 2)))
        )),

        "E11" to Chord("E11", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 0), Fret(2, 0), Fret(3, 1), Fret(4, 2), Fret(5, 2), Fret(6, 0)
            ), emptyList(), listOf(Finger(1, 3, 1), Finger(2, 4, 2), Finger(3, 5, 2))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 4), Fret(2, 8), Fret(3, 11), Fret(4, 2), Fret(5, 6), Fret(6, 9),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 4), Fret(2, 3), Fret(3, 1), Fret(4, 2)
            ), emptyList(), listOf(Finger(1, 1, 4), Finger(2, 2, 3), Finger(3, 4, 2)))
        )),

        "G11" to Chord("G11", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 3), Fret(2, 3), Fret(3, 0), Fret(4, 0), Fret(5, 0), Fret(6, 3)
            ), emptyList(), listOf(Finger(1, 1, 3), Finger(2, 2, 3), Finger(3, 6, 3))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 7), Fret(2, 11), Fret(3, 2), Fret(4, 5), Fret(5, 9), Fret(6, 0),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 2), Fret(2, 0), Fret(3, 0), Fret(4, 3)
            ), emptyList(), listOf(Finger(1, 1, 2), Finger(2, 4, 3)))
        )),

        "A11" to Chord("A11", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 0), Fret(2, 2), Fret(3, 2), Fret(4, 2), Fret(5, 0), Fret(6, 3)
            ), emptyList(), listOf(Finger(1, 2, 2), Finger(2, 3, 2), Finger(3, 4, 2), Finger(4, 6, 3))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 9), Fret(2, 1), Fret(3, 4), Fret(4, 7), Fret(5, 13), Fret(6, 17),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 0), Fret(2, 2), Fret(3, 1), Fret(4, 0)
            ), emptyList(), listOf(Finger(1, 2, 2), Finger(2, 3, 1)))
        )),

        // ============ THIRTEENTH CHORDS ============
        "C13" to Chord("C13", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 3), Fret(2, 3), Fret(3, 3), Fret(4, 3), Fret(5, 3), Fret(6, 3)
            ), listOf(Barre(3, 1, 6, 1)), listOf()),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 0), Fret(2, 4), Fret(3, -1), Fret(4, -1), Fret(5, 2), Fret(6, 3),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 0), Fret(2, 3), Fret(3, 2), Fret(4, 1)
            ), emptyList(), listOf(Finger(1, 2, 3), Finger(2, 3, 2), Finger(3, 4, 1)))
        )),

        "D13" to Chord("D13", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 3), Fret(2, 3), Fret(3, 2), Fret(4, 0), Fret(5, 3), Fret(6, -1)
            ), emptyList(), listOf(Finger(1, 1, 3), Finger(2, 2, 3), Finger(3, 3, 2), Finger(4, 5, 3))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 2), Fret(2, -1), Fret(3, -1), Fret(4, -1), Fret(5, 0), Fret(6, 1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 2), Fret(2, 2), Fret(3, 1), Fret(4, 2)
            ), emptyList(), listOf(Finger(1, 1, 2), Finger(2, 2, 2), Finger(3, 4, 2)))
        )),

        "E13" to Chord("E13", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 0), Fret(2, 0), Fret(3, 1), Fret(4, 2), Fret(5, 2), Fret(6, 0)
            ), emptyList(), listOf(Finger(1, 3, 1), Finger(2, 4, 2), Finger(3, 5, 2))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 4), Fret(2, -1), Fret(3, -1), Fret(4, -1), Fret(5, 2), Fret(6, 3),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 4), Fret(2, 3), Fret(3, 1), Fret(4, 2)
            ), emptyList(), listOf(Finger(1, 1, 4), Finger(2, 2, 3), Finger(3, 4, 2)))
        )),

        "G13" to Chord("G13", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 3), Fret(2, 3), Fret(3, 0), Fret(4, 0), Fret(5, 0), Fret(6, 3)
            ), emptyList(), listOf(Finger(1, 1, 3), Finger(2, 2, 3), Finger(3, 6, 3))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, -1), Fret(2, -1), Fret(3, -1), Fret(4, -1), Fret(5, 2), Fret(6, 3),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 2), Fret(2, 0), Fret(3, 0), Fret(4, 3)
            ), emptyList(), listOf(Finger(1, 1, 2), Finger(2, 4, 3)))
        )),

        "A13" to Chord("A13", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 0), Fret(2, 2), Fret(3, 2), Fret(4, 2), Fret(5, 0), Fret(6, 0)
            ), emptyList(), listOf(Finger(1, 2, 2), Finger(2, 3, 2), Finger(3, 4, 2))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, -1), Fret(2, -1), Fret(3, 0), Fret(4, 4), Fret(5, -1), Fret(6, 1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 0), Fret(2, 2), Fret(3, 1), Fret(4, 0)
            ), emptyList(), listOf(Finger(1, 2, 2), Finger(2, 3, 1)))
        )),

        // ============ MAJOR 7TH FLAT5 ============
        "CMAJ7S5" to Chord("Cmaj7b5", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 0), Fret(2, 1), Fret(3, 0), Fret(4, 2), Fret(5, 3), Fret(6, -1)
            ), emptyList(), listOf(Finger(1, 2, 1), Finger(2, 4, 2), Finger(3, 5, 3))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 0), Fret(2, 4), Fret(3, -1), Fret(4, -1), Fret(5, 1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 0), Fret(2, 2), Fret(3, 0), Fret(4, 0)
            ), emptyList(), listOf(Finger(1, 2, 2)))
        )),

        "DMAJ7S5" to Chord("Dmaj7b5", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 2), Fret(2, 2), Fret(3, 2), Fret(4, 0), Fret(5, -1), Fret(6, -1)
            ), emptyList(), listOf(Finger(1, 1, 2), Finger(2, 2, 2), Finger(3, 3, 2))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 2), Fret(2, -1), Fret(3, -1), Fret(4, -1), Fret(5, 0), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 2), Fret(2, 2), Fret(3, 1), Fret(4, 2)
            ), emptyList(), listOf(Finger(1, 1, 2), Finger(2, 2, 2), Finger(3, 4, 2)))
        )),

        "EMAJ7S5" to Chord("Emaj7b5", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 0), Fret(2, 0), Fret(3, 1), Fret(4, 1), Fret(5, 2), Fret(6, 0)
            ), emptyList(), listOf(Finger(1, 3, 1), Finger(2, 4, 1), Finger(3, 5, 2))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, 4), Fret(2, -1), Fret(3, -1), Fret(4, -1), Fret(5, 2), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 4), Fret(2, 2), Fret(3, 1), Fret(4, 2)
            ), emptyList(), listOf(Finger(1, 1, 4), Finger(2, 2, 2), Finger(3, 4, 2)))
        )),

        "GMAJ7S5" to Chord("Gmaj7b5", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 3), Fret(2, 2), Fret(3, 0), Fret(4, 0), Fret(5, 0), Fret(6, 2)
            ), emptyList(), listOf(Finger(1, 1, 3), Finger(2, 2, 2), Finger(3, 6, 2))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, -1), Fret(2, -1), Fret(3, -1), Fret(4, -1), Fret(5, 2), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 2), Fret(2, 0), Fret(3, 0), Fret(4, 2)
            ), emptyList(), listOf(Finger(1, 1, 2), Finger(2, 4, 2)))
        )),

        "AMAJ7S5" to Chord("Amaj7b5", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(1, 0), Fret(2, 2), Fret(3, 1), Fret(4, 2), Fret(5, 0), Fret(6, -1)
            ), emptyList(), listOf(Finger(1, 2, 2), Finger(2, 3, 1), Finger(3, 4, 2))),
            ChordPosition(Instrument.PIANO, listOf(
                Fret(1, -1), Fret(2, -1), Fret(3, 0), Fret(4, 4), Fret(5, -1), Fret(6, -1),
                Fret(7, -1), Fret(8, -1), Fret(9, -1),
                Fret(10, -1), Fret(11, -1), Fret(12, -1)
            )),
            ChordPosition(Instrument.UKULELE, listOf(
                Fret(1, 0), Fret(2, 2), Fret(3, 0), Fret(4, 0)
            ), emptyList(), listOf(Finger(1, 2, 2)))
        ))
    )

    fun getChord(name: String): Chord? {
        val normalized = name
            .replace("m", "M")
            .uppercase()
            .replace(" ", "")
            .replace("MAJ", "")
            .replace("MIN", "M")
            .replace("b", "B")
            .replace("#", "S")
            .replace("♯", "S")

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
                suffix.startsWith("DIM") -> "${root}DIM"
                suffix.startsWith("AUG") -> "${root}AUG"
                suffix.startsWith("ADD") -> "${root}ADD${suffix.substring(3)}"
                suffix.startsWith("SUS") -> "${root}SUS${suffix.substring(3)}"
                suffix.startsWith("7NO3") -> "${root}7NO3"
                suffix.startsWith("7NO5") -> "${root}7NO5"
                suffix.startsWith("7NO7") -> "${root}7NO7"
                suffix.startsWith("MAJ7S5") || suffix == "MAJ7B5" -> "${root}MAJ7S5"
                suffix.toIntOrNull() != null -> "${root}${suffix}"
                else -> "${root}${suffix}"
            }

            chords[key]?.let { return it }
        }

        return null
    }
}