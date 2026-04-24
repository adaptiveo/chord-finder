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
            // Handle add chords - keep numbers for ADD2/ADD11, ADD9 stays as ADD
            .replace("ADD9", "ADD")
            .replace("ADD2", "")  // temporary placeholder
            .replace("ADD11", "")
            .replace("", "ADD2")
            .replace("", "ADD11")
            .replace("b", "B")
            .replace("#", "S")
            .replace("♯", "S")
            .replace("", "SUS2")
            .replace("", "SUS4")
    }

    fun getChord(name: String): Chord? {
        if (!::chords.isInitialized) return null

        val normalized = getNormalizedName(name)

        var chord = chords[normalized]
            ?: chords[normalized]?.let { it }
            ?: findChordByKey(normalized)

        if (chord != null) {
            // Проверить и сгенерировать недостающие позиции для гитары и укулеле
            val updatedPositions = generateMissingPositions(chord)
            if (updatedPositions != chord.positions) {
                chord = Chord(chord.name, updatedPositions)
            }
        }

        return chord
    }

    /**
     * Поиск аккорда по различным вариантам ключа
     */
    private fun findChordByKey(normalized: String): Chord? {
        // Try full match first
        chords.keys.find { it == normalized }?.let { return chords[it] }

        // Handle sus4 chords - JSON uses GSUS instead of GSUS4
        if (normalized.endsWith("SUS4")) {
            val susKey = normalized.replace("SUS4", "SUS")
            chords[susKey]?.let { return it }
        }

        // Parse chord: root + optional sharp/flat + suffix
        val rootMatch = Regex("^([A-G])(S(?!US)|B)?(M7|MAJ7|AUG7|SUS2|SUS4|ADD2|ADD11|ADD|DIM|AUG|7NO[357]|[0-9]+|M|7)?$").find(normalized)
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
                suffix == "SUS4" -> "${root}SUS"  // JSON uses GSUS for Gsus4
                suffix.startsWith("M") && suffix.endsWith("7") -> "${root}M7"
                suffix == "DIM" -> "${root}DIM"
                suffix == "DIM7" -> "${root}DIM7"
                suffix == "AUG" -> "${root}AUG"
                suffix == "AUG7" -> "${root}AUG7"
                suffix == "ADD" -> "${root}ADD"
                suffix == "ADD2" -> "${root}ADD2"
                suffix == "ADD11" -> "${root}ADD11"
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

    /**
     * Генерировать недостающие или невалидные позиции для гитары и укулеле
     */
    private fun generateMissingPositions(chord: Chord): List<ChordPosition> {
        val positions = chord.positions.toMutableList()

        // Проверить гитару - если нет или все лады = 0, сгенерировать
        val guitarPos = positions.find { it.instrument == Instrument.GUITAR }
        val needsGuitar = guitarPos == null || guitarPos.frets.all { it.fret == 0 }

        if (needsGuitar) {
            positions.removeAll { it.instrument == Instrument.GUITAR }
            ChordGenerator.generateChordPosition(
                chord.name,
                Instrument.GUITAR,
                ChordGenerator.GUITAR_TUNING,
                maxFret = 12
            )?.let { positions.add(it) }
        }

        // Проверить укулеле - если нет или все лады = 0, сгенерировать
        val ukulelePos = positions.find { it.instrument == Instrument.UKULELE }
        val needsUkulele = ukulelePos == null || ukulelePos.frets.all { it.fret == 0 }

        if (needsUkulele) {
            positions.removeAll { it.instrument == Instrument.UKULELE }
            ChordGenerator.generateChordPosition(
                chord.name,
                Instrument.UKULELE,
                ChordGenerator.UKULELE_TUNING,
                maxFret = 12
            )?.let { positions.add(it) }
        }

        return positions
    }

    /**
     * Returns list of all chord names for autocomplete
     */
    fun getAllChordNames(): List<String> {
        if (!::chords.isInitialized) return getDefaultChordNames()
        return chords.values.map { it.name }.sorted()
    }

    /**
     * Fallback list of common chords for autocomplete when data not loaded
     */
    private fun getDefaultChordNames(): List<String> {
        return listOf(
            "C", "Cm", "C7", "Cmaj7", "Cm7", "Cadd9", "Csus2", "Csus4",
            "D", "Dm", "D7", "Dmaj7", "Dm7", "Dadd9", "Dsus2", "Dsus4",
            "E", "Em", "E7", "Emaj7", "Em7", "Eadd9", "Esus2", "Esus4",
            "F", "Fm", "F7", "Fmaj7", "Fm7", "Fadd9", "Fsus2", "Fsus4",
            "G", "Gm", "G7", "Gmaj7", "Gm7", "Gadd9", "Gsus2", "Gsus4",
            "A", "Am", "A7", "Amaj7", "Am7", "Aadd9", "Asus2", "Asus4",
            "B", "Bm", "B7", "Bmaj7", "Bm7", "Badd9", "Bsus2", "Bsus4"
        )
    }

    /**
     * Search chords by query string (case-insensitive prefix match)
     * Returns up to maxResults matching chord names
     */
    fun searchChords(query: String, maxResults: Int = 10): List<String> {
        if (!::chords.isInitialized || query.isBlank()) return emptyList()

        val normalizedQuery = query.trim().uppercase()
        val allNames = getAllChordNames()

        return allNames
            .filter { it.uppercase().startsWith(normalizedQuery) }
            .take(maxResults)
    }
}
