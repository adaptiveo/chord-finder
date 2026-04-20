package com.chordfinder.data

data class Chord(
    val name: String,
    val positions: List<ChordPosition>
)

data class ChordPosition(
    val instrument: Instrument,
    val frets: List<Fret>,
    val barres: List<Barre> = emptyList(),
    val fingers: List<Finger> = emptyList()
)

data class Fret(
    val string: Int,  // 1-based (1 = high E for guitar)
    val fret: Int,    // 0 = open, -1 = muted, >0 = fret number
    val finger: Int? = null
)

data class Barre(
    val fret: Int,
    val fromString: Int,
    val toString: Int,
    val finger: Int
)

data class Finger(
    val fingerNumber: Int,
    val string: Int,
    val fret: Int
)

enum class Instrument {
    GUITAR, PIANO, UKULELE
}
