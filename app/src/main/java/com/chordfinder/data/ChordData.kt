package com.chordfinder.data

import android.content.Context
import org.json.JSONObject

object ChordData {
    private lateinit var chords: Map<String, Chord>

    fun initialize(context: Context) {
        if (::chords.isInitialized) return

        val jsonString = context.assets.open("chords.json").use { it.readBytes().toString(Charsets.UTF_8) }
        val json = JSONObject(jsonString)
        val chordsJson = json.getJSONObject("chords")

        val tempChords = mutableMapOf<String, Chord>()

        chordsJson.keys().forEach { key ->
            val chordJson = chordsJson.getJSONObject(key)
            val name = chordJson.getString("name")
            val positionsJson = chordJson.getJSONArray("positions")

            val positions = mutableListOf<ChordPosition>()
            for (i in 0 until positionsJson.length()) {
                val posJson = positionsJson.getJSONObject(i)
                val instrument = Instrument.valueOf(posJson.getString("instrument"))

                // Parse frets
                val fretsJson = posJson.getJSONArray("frets")
                val frets = mutableListOf<Fret>()
                for (j in 0 until fretsJson.length()) {
                    val fretJson = fretsJson.getJSONObject(j)
                    frets.add(Fret(
                        string = fretJson.getInt("s"),
                        fret = fretJson.getInt("f"),
                        finger = if (fretJson.has("fn")) fretJson.getInt("fn") else null
                    ))
                }

                // Parse barres
                val barres = mutableListOf<Barre>()
                if (posJson.has("barres")) {
                    val barresJson = posJson.getJSONArray("barres")
                    for (j in 0 until barresJson.length()) {
                        val barreJson = barresJson.getJSONObject(j)
                        barres.add(Barre(
                            fret = barreJson.getInt("f"),
                            fromString = barreJson.getInt("from"),
                            toString = barreJson.getInt("to"),
                            finger = barreJson.getInt("n")
                        ))
                    }
                }

                // Parse fingers
                val fingers = mutableListOf<Finger>()
                if (posJson.has("fingers")) {
                    val fingersJson = posJson.getJSONArray("fingers")
                    for (j in 0 until fingersJson.length()) {
                        val fingerJson = fingersJson.getJSONObject(j)
                        fingers.add(Finger(
                            fingerNumber = fingerJson.getInt("n"),
                            string = fingerJson.getInt("s"),
                            fret = fingerJson.getInt("f")
                        ))
                    }
                }

                positions.add(ChordPosition(instrument, frets, barres, fingers))
            }

            tempChords[key] = Chord(name, positions)
        }

        chords = tempChords
    }

    fun getNormalizedName(name: String): String {
        return name
            .replace("m", "M")
            .uppercase()
            .replace(" ", "")
            .replace("MAJ", "")
            .replace("MIN", "M")
            // Handle sus chords using ASCII placeholder to avoid conflict
            .replace("SUS2", "")
            .replace("SUS4", "")
            .replace("SUS", "")
            .replace("b", "B")
            .replace("#", "S")
            .replace("♯", "S")
            .replace("", "SUS2")
            .replace("", "SUS4")
    }

    fun getChord(name: String): Chord? {
        if (!::chords.isInitialized) return null

        val normalized = getNormalizedName(name)

        chords[normalized]?.let { return it }

        // Try full match first
        val fullMatch = chords.keys.find { it == normalized }
        if (fullMatch != null) return chords[fullMatch]

        // Parse chord: root + optional sharp/flat + suffix
        val rootMatch = Regex("^([A-G])(S(?!US)|B)?(M7|MAJ7|AUG7|SUS2|SUS4|DIM|AUG|ADD[0-9]+|7NO[357]|[0-9]+|M|7)?$").find(normalized)
        if (rootMatch != null) {
            val noteLetter = rootMatch.groupValues[1]
            val accidental = rootMatch.groupValues[2]
            val suffix = rootMatch.groupValues[3]

            val root = when (accidental) {
                "S" -> "${noteLetter}S"
                "B" -> "${noteLetter}B"
                else -> noteLetter
            }

            val key = when {
                suffix == "" || suffix == "MAJ" -> root
                suffix == "M" -> "${root}M"
                suffix == "7" || suffix == "9" || suffix == "11" || suffix == "13" -> "${root}7"
                suffix == "M7" -> "${root}M7"
                suffix == "MAJ7" -> "${root}MAJ7"
                suffix == "AUG7" -> "${root}AUG7"
                suffix == "SUS2" -> "${root}SUS2"
                suffix == "SUS4" -> "${root}SUS4"
                suffix.startsWith("M") && suffix.endsWith("7") -> "${root}M7"
                suffix.startsWith("DIM") -> "${root}DIM"
                suffix.startsWith("AUG") -> "${root}AUG"
                suffix.startsWith("ADD") -> "${root}ADD${suffix.substring(3)}"
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
