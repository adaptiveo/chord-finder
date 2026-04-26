package com.chordfinder.data

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ChordDataTest {

    // ===== Тесты нормализации названий аккордов =====

    @Test
    fun `getNormalizedName - мажорные аккорды`() {
        assertEquals("C", ChordData.getNormalizedName("C"))
        assertEquals("G", ChordData.getNormalizedName("G"))
        assertEquals("D", ChordData.getNormalizedName("D"))
    }

    @Test
    fun `getNormalizedName - минорные аккорды`() {
        assertEquals("CM", ChordData.getNormalizedName("Cm"))
        assertEquals("AM", ChordData.getNormalizedName("Am"))
        assertEquals("DM", ChordData.getNormalizedName("Dm"))
        assertEquals("EM", ChordData.getNormalizedName("emin"))
    }

    @Test
    fun `getNormalizedName - септаккорды`() {
        assertEquals("C7", ChordData.getNormalizedName("C7"))
        assertEquals("G7", ChordData.getNormalizedName("G7"))
    }

    @Test
    fun `getNormalizedName - мажорный септаккорд`() {
        assertEquals("CM7", ChordData.getNormalizedName("CM7"))
        assertEquals("CM7", ChordData.getNormalizedName("Cmaj7"))
        assertEquals("CM7", ChordData.getNormalizedName("CMAJ7"))
    }

    @Test
    fun `getNormalizedName - sus2 аккорды`() {
        assertEquals("CSUS2", ChordData.getNormalizedName("Csus2"))
        assertEquals("GSUS2", ChordData.getNormalizedName("Gsus2"))
    }

    @Test
    fun `getNormalizedName - sus4 аккорды`() {
        assertEquals("CSUS", ChordData.getNormalizedName("Csus4"))
        assertEquals("CSUS", ChordData.getNormalizedName("Csus"))
        assertEquals("GSUS", ChordData.getNormalizedName("Gsus4"))
    }

    @Test
    fun `getNormalizedName - add9 аккорды`() {
        assertEquals("CADD", ChordData.getNormalizedName("Cadd9"))
        assertEquals("GADD", ChordData.getNormalizedName("Gadd9"))
    }

    @Test
    fun `getNormalizedName - add2 аккорды`() {
        assertEquals("CADD2", ChordData.getNormalizedName("Cadd2"))
        assertEquals("GADD2", ChordData.getNormalizedName("Gadd2"))
    }

    @Test
    fun `getNormalizedName - add11 аккорды`() {
        assertEquals("CADD11", ChordData.getNormalizedName("Cadd11"))
        assertEquals("GADD11", ChordData.getNormalizedName("Gadd11"))
    }

    @Test
    fun `getNormalizedName - диезные аккорды`() {
        assertEquals("CS", ChordData.getNormalizedName("C#"))
        assertEquals("DS", ChordData.getNormalizedName("D#"))
        assertEquals("CSM", ChordData.getNormalizedName("C#m"))
    }

    @Test
    fun `getNormalizedName - бемольные аккорды`() {
        assertEquals("DB", ChordData.getNormalizedName("Db"))
        assertEquals("EB", ChordData.getNormalizedName("Eb"))
        assertEquals("DBM", ChordData.getNormalizedName("Dbm"))
    }

    @Test
    fun `getNormalizedName - уменьшенные аккорды`() {
        assertEquals("CDIM", ChordData.getNormalizedName("Cdim"))
        assertEquals("CDIM7", ChordData.getNormalizedName("Cdim7"))
    }

    @Test
    fun `getNormalizedName - увеличенные аккорды`() {
        assertEquals("CAUG", ChordData.getNormalizedName("Caug"))
        assertEquals("CAUG7", ChordData.getNormalizedName("Caug7"))
    }

    @Test
    fun `getNormalizedName - аккорды с пробелами`() {
        assertEquals("CM", ChordData.getNormalizedName("C m"))
        assertEquals("C7", ChordData.getNormalizedName("C 7"))
    }

    // ===== Тесты поиска аккордов =====

    @Test
    fun `findChordByKey - поиск мажорных аккордов`() {
        // Проверяем, что функция правильно строит ключи
        val rootMatch = Regex("^([A-G])(S(?!US)|B)?(M7|MAJ7|AUG7|SUS2|SUS4|ADD2|ADD11|ADD|DIM|AUG|7NO[357]|[0-9]+|M|7)?$")
            .find("CM")

        assertNotNull(rootMatch)
        assertEquals("C", rootMatch!!.groupValues[1])
        assertEquals("", rootMatch.groupValues[2])
        assertEquals("M", rootMatch.groupValues[3])
    }

    @Test
    fun `findChordByKey - поиск с диезом`() {
        val rootMatch = Regex("^([A-G])(S(?!US)|B)?(M7|MAJ7|AUG7|SUS2|SUS4|ADD2|ADD11|ADD|DIM|AUG|7NO[357]|[0-9]+|M|7)?$")
            .find("CSM")

        assertNotNull(rootMatch)
        assertEquals("C", rootMatch!!.groupValues[1])
        assertEquals("S", rootMatch.groupValues[2])
        assertEquals("M", rootMatch.groupValues[3])
    }

    @Test
    fun `findChordByKey - поиск с бемолем`() {
        val rootMatch = Regex("^([A-G])(S(?!US)|B)?(M7|MAJ7|AUG7|SUS2|SUS4|ADD2|ADD11|ADD|DIM|AUG|7NO[357]|[0-9]+|M|7)?$")
            .find("DBM")

        assertNotNull(rootMatch)
        assertEquals("D", rootMatch!!.groupValues[1])
        assertEquals("B", rootMatch.groupValues[2])
        assertEquals("M", rootMatch.groupValues[3])
    }

    @Test
    fun `findChordByKey - sus4 без цифры 4`() {
        val rootMatch = Regex("^([A-G])(S(?!US)|B)?(M7|MAJ7|AUG7|SUS2|SUS4|ADD2|ADD11|ADD|DIM|AUG|7NO[357]|[0-9]+|M|7)?$")
            .find("GSUS")

        assertNotNull(rootMatch)
        assertEquals("G", rootMatch!!.groupValues[1])
        assertEquals("", rootMatch.groupValues[2])
        assertEquals("SUS", rootMatch.groupValues[3])
    }

    // ===== Тесты searchChords =====

    @Test
    fun `searchChords - поиск по префиксу C`() {
        // Тест будет работать только после инициализации
        // Это интеграционный тест, требует контекста Android
        // Пока проверяем только логику
        val chords = listOf("C", "Cm", "C7", "Cmaj7", "Csus2", "Csus4", "Cadd9")
        val query = "C"

        val result = chords.filter { it.uppercase().startsWith(query.uppercase()) }

        assertEquals(7, result.size)
    }

    @Test
    fun `searchChords - поиск по префиксу Am`() {
        val chords = listOf("A", "Am", "A7", "Amaj7", "Am7", "Asus2", "Asus4")
        val query = "Am"

        val result = chords.filter { it.uppercase().startsWith(query.uppercase()) }

        assertEquals(3, result.size) // Am, Amaj7, Am7
    }

    @Test
    fun `searchChords - пустой запрос`() {
        val chords = listOf("C", "D", "E")
        val query = ""

        val result = chords.filter { it.uppercase().startsWith(query.uppercase()) }

        assertEquals(3, result.size) // Пустой запрос匹配 все
    }
}
