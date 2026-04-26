package com.chordfinder.data

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ChordGeneratorTest {

    private val GUITAR_TUNING = ChordGenerator.GUITAR_TUNING
    private val UKULELE_TUNING = ChordGenerator.UKULELE_TUNING

    // ===== Тесты парсинга названий аккордов =====

    @Test
    fun `parseChordName - мажорные аккорды`() {
        val result = ChordGenerator.parseChordName("C")
        assertNotNull(result)
        assertEquals(0, result!!.first) // C = 0 полутонов
        assertEquals("", result.second) // пустой суффикс = мажор
    }

    @Test
    fun `parseChordName - минорные аккорды`() {
        val result = ChordGenerator.parseChordName("Cm")
        assertNotNull(result)
        assertEquals(0, result!!.first)
        assertEquals("M", result.second) // M = minor
    }

    @Test
    fun `parseChordName - септаккорды`() {
        val result = ChordGenerator.parseChordName("C7")
        assertNotNull(result)
        assertEquals(0, result!!.first)
        assertEquals("7", result.second)
    }

    @Test
    fun `parseChordName - мажорный септаккорд`() {
        val result = ChordGenerator.parseChordName("CM7")
        assertNotNull(result)
        assertEquals(0, result!!.first)
        assertEquals("M7", result.second)
    }

    @Test
    fun `parseChordName - диезные аккорды`() {
        val result = ChordGenerator.parseChordName("C#")
        assertNotNull(result)
        assertEquals(1, result!!.first) // C# = 1 полутон
    }

    @Test
    fun `parseChordName - бемольные аккорды`() {
        val result = ChordGenerator.parseChordName("Db")
        assertNotNull(result)
        assertEquals(1, result!!.first) // Db = 1 полутон
    }

    @Test
    fun `parseChordName - sus2 аккорды`() {
        val result = ChordGenerator.parseChordName("Csus2")
        assertNotNull(result)
        assertEquals("SUS2", result!!.second)
    }

    @Test
    fun `parseChordName - sus4 аккорды`() {
        val result = ChordGenerator.parseChordName("Csus4")
        assertNotNull(result)
        assertEquals("SUS4", result!!.second)
    }

    @Test
    fun `parseChordName - add9 аккорды`() {
        val result = ChordGenerator.parseChordName("Cadd9")
        assertNotNull(result)
        assertEquals("ADD9", result!!.second)
    }

    // ===== Тесты формул аккордов =====

    @Test
    fun `getChordNotes - мажорное трезвучие`() {
        // C major = C(0), E(4), G(7)
        val notes = ChordGenerator.getChordNotes(0, "")
        assertEquals(listOf(0, 4, 7), notes)
    }

    @Test
    fun `getChordNotes - минорное трезвучие`() {
        // C minor = C(0), Eb(3), G(7)
        val notes = ChordGenerator.getChordNotes(0, "M")
        assertEquals(listOf(0, 3, 7), notes)
    }

    @Test
    fun `getChordNotes - доминантсептаккорд`() {
        // C7 = C(0), E(4), G(7), Bb(10)
        val notes = ChordGenerator.getChordNotes(0, "7")
        assertEquals(listOf(0, 4, 7, 10), notes)
    }

    @Test
    fun `getChordNotes - мажорный септаккорд`() {
        // CM7 = C(0), E(4), G(7), B(11)
        val notes = ChordGenerator.getChordNotes(0, "M7")
        assertEquals(listOf(0, 4, 7, 11), notes)
    }

    @Test
    fun `getChordNotes - уменьшенное трезвучие`() {
        // Cdim = C(0), Eb(3), Gb(6)
        val notes = ChordGenerator.getChordNotes(0, "DIM")
        assertEquals(listOf(0, 3, 6), notes)
    }

    @Test
    fun `getChordNotes - увеличенное трезвучие`() {
        // Caug = C(0), E(4), G#(8)
        val notes = ChordGenerator.getChordNotes(0, "AUG")
        assertEquals(listOf(0, 4, 8), notes)
    }

    // ===== Тесты генерации позиций для гитары =====

    @Test
    fun `generateChordPosition - аккорд C мажор для гитары`() {
        val position = ChordGenerator.generateChordPosition(
            "C", Instrument.GUITAR, GUITAR_TUNING
        )
        assertNotNull(position)

        // Проверяем, что все ноты аккорда присутствуют (C=0, E=4, G=7)
        val playedNotes = position!!.frets
            .filter { it.fret >= 0 }
            .map { fret -> (GUITAR_TUNING[fret.string - 1] + fret.fret) % 12 }
            .toSet()

        assertTrue(playedNotes.contains(0)) // C
        assertTrue(playedNotes.contains(4)) // E
        assertTrue(playedNotes.contains(7)) // G
    }

    @Test
    fun `generateChordPosition - аккорд D мажор для гитары`() {
        val position = ChordGenerator.generateChordPosition(
            "D", Instrument.GUITAR, GUITAR_TUNING
        )
        assertNotNull(position)

        // Проверяем ноты аккорда D (D=2, F#=6, A=9)
        val playedNotes = position!!.frets
            .filter { it.fret >= 0 }
            .map { fret -> (GUITAR_TUNING[fret.string - 1] + fret.fret) % 12 }
            .toSet()

        assertTrue(playedNotes.contains(2))  // D
        assertTrue(playedNotes.contains(6))  // F#
        assertTrue(playedNotes.contains(9))  // A
    }

    @Test
    fun `generateChordPosition - аккорд G мажор для гитары`() {
        val position = ChordGenerator.generateChordPosition(
            "G", Instrument.GUITAR, GUITAR_TUNING
        )
        assertNotNull(position)

        // Проверяем ноты аккорда G (G=7, B=11, D=2)
        val playedNotes = position!!.frets
            .filter { it.fret >= 0 }
            .map { fret -> (GUITAR_TUNING[fret.string - 1] + fret.fret) % 12 }
            .toSet()

        assertTrue(playedNotes.contains(7))  // G
        assertTrue(playedNotes.contains(11)) // B
        assertTrue(playedNotes.contains(2))  // D
    }

    @Test
    fun `generateChordPosition - аккорд E мажор для гитары`() {
        val position = ChordGenerator.generateChordPosition(
            "E", Instrument.GUITAR, GUITAR_TUNING
        )
        assertNotNull(position)

        // Проверяем ноты аккорда E (E=4, G#=8, B=11)
        val playedNotes = position!!.frets
            .filter { it.fret >= 0 }
            .map { fret -> (GUITAR_TUNING[fret.string - 1] + fret.fret) % 12 }
            .toSet()

        assertTrue(playedNotes.contains(4))  // E
        assertTrue(playedNotes.contains(8))  // G#
        assertTrue(playedNotes.contains(11)) // B
    }

    @Test
    fun `generateChordPosition - аккорд A мажор для гитары`() {
        val position = ChordGenerator.generateChordPosition(
            "A", Instrument.GUITAR, GUITAR_TUNING
        )
        assertNotNull(position)

        // Проверяем ноты аккорда A (A=9, C#=1, E=4)
        val playedNotes = position!!.frets
            .filter { it.fret >= 0 }
            .map { fret -> (GUITAR_TUNING[fret.string - 1] + fret.fret) % 12 }
            .toSet()

        assertTrue(playedNotes.contains(9))  // A
        assertTrue(playedNotes.contains(1))  // C#
        assertTrue(playedNotes.contains(4))  // E
    }

    @Test
    fun `generateChordPosition - аккорд Am для гитары`() {
        val position = ChordGenerator.generateChordPosition(
            "Am", Instrument.GUITAR, GUITAR_TUNING
        )
        assertNotNull(position)

        // Проверяем ноты аккорда Am (A=9, C=0, E=4)
        val playedNotes = position!!.frets
            .filter { it.fret >= 0 }
            .map { fret -> (GUITAR_TUNING[fret.string - 1] + fret.fret) % 12 }
            .toSet()

        assertTrue(playedNotes.contains(9))  // A
        assertTrue(playedNotes.contains(0))  // C
        assertTrue(playedNotes.contains(4))  // E
    }

    @Test
    fun `generateChordPosition - аккорд Em для гитары`() {
        val position = ChordGenerator.generateChordPosition(
            "Em", Instrument.GUITAR, GUITAR_TUNING
        )
        assertNotNull(position)

        // Проверяем ноты аккорда Em (E=4, G=7, B=11)
        val playedNotes = position!!.frets
            .filter { it.fret >= 0 }
            .map { fret -> (GUITAR_TUNING[fret.string - 1] + fret.fret) % 12 }
            .toSet()

        assertTrue(playedNotes.contains(4))  // E
        assertTrue(playedNotes.contains(7))  // G
        assertTrue(playedNotes.contains(11)) // B
    }

    @Test
    fun `generateChordPosition - аккорд F мажор для гитары`() {
        val position = ChordGenerator.generateChordPosition(
            "F", Instrument.GUITAR, GUITAR_TUNING
        )
        assertNotNull(position)

        // Проверяем ноты аккорда F (F=5, A=9, C=0)
        val playedNotes = position!!.frets
            .filter { it.fret >= 0 }
            .map { fret -> (GUITAR_TUNING[fret.string - 1] + fret.fret) % 12 }
            .toSet()

        assertTrue(playedNotes.contains(5))  // F
        assertTrue(playedNotes.contains(9))  // A
        assertTrue(playedNotes.contains(0))  // C
    }

    // ===== Тесты генерации позиций для укулеле =====

    @Test
    fun `generateChordPosition - аккорд C мажор для укулеле`() {
        val position = ChordGenerator.generateChordPosition(
            "C", Instrument.UKULELE, UKULELE_TUNING
        )
        assertNotNull(position)

        // Проверяем ноты аккорда C (C=0, E=4, G=7)
        val playedNotes = position!!.frets
            .filter { it.fret >= 0 }
            .map { fret -> (UKULELE_TUNING[fret.string - 1] + fret.fret) % 12 }
            .toSet()

        assertTrue(playedNotes.contains(0)) // C
        assertTrue(playedNotes.contains(4)) // E
        assertTrue(playedNotes.contains(7)) // G
    }

    @Test
    fun `generateChordPosition - аккорд G мажор для укулеле`() {
        val position = ChordGenerator.generateChordPosition(
            "G", Instrument.UKULELE, UKULELE_TUNING
        )
        assertNotNull(position)

        // Проверяем ноты аккорда G (G=7, B=11, D=2)
        val playedNotes = position!!.frets
            .filter { it.fret >= 0 }
            .map { fret -> (UKULELE_TUNING[fret.string - 1] + fret.fret) % 12 }
            .toSet()

        assertTrue(playedNotes.contains(7))  // G
        assertTrue(playedNotes.contains(11)) // B
        assertTrue(playedNotes.contains(2))  // D
    }

    // ===== Тесты поиска позиций нот =====

    @Test
    fun `findNotePositions - поиск ноты C на гитаре`() {
        val positions = ChordGenerator.findNotePositions(0, GUITAR_TUNING, 5)
        assertTrue(positions.isNotEmpty())

        // Проверяем, что все позиции дают ноту C (0)
        positions.forEach { (stringIndex, fret) ->
            val note = (GUITAR_TUNING[stringIndex] + fret) % 12
            assertEquals(0, note)
        }
    }

    @Test
    fun `findNotePositions - поиск ноты E на укулеле`() {
        val positions = ChordGenerator.findNotePositions(4, UKULELE_TUNING, 5)
        assertTrue(positions.isNotEmpty())

        // Проверяем, что все позиции дают ноту E (4)
        positions.forEach { (stringIndex, fret) ->
            val note = (UKULELE_TUNING[stringIndex] + fret) % 12
            assertEquals(4, note)
        }
    }

    // ===== Тесты барре =====

    @Test
    fun `findBarres - барре для соседних струн`() {
        // Аккорд F: струны 5,4,3,2 на ладу 1 должны создать барре
        val frets = listOf(1, 1, 1, 1, -1, -1) // 6 струн, первые 4 на ладу 1

        // Используем рефлекссию для доступа к private функции
        val method = ChordGenerator::class.java.getDeclaredMethod(
            "findBarres", List::class.java, Int::class.java
        )
        method.isAccessible = true

        @Suppress("UNCHECKED_CAST")
        val barres = method.invoke(null, frets, 1) as List<Barre>

        assertTrue(barres.isNotEmpty())
        assertEquals(1, barres[0].fret)
    }

    @Test
    fun `findBarres - нет барре для несмежных струн`() {
        // Струны 1 и 6 на ладу 1 - не должны создавать барре
        val frets = listOf(1, -1, -1, -1, -1, 1) // 6 струн, 1 и 6 на ладу 1

        val method = ChordGenerator::class.java.getDeclaredMethod(
            "findBarres", List::class.java, Int::class.java
        )
        method.isAccessible = true

        @Suppress("UNCHECKED_CAST")
        val barres = method.invoke(null, frets, 1) as List<Barre>

        assertTrue(barres.isEmpty())
    }

    // ===== Тесты generateMissingPositions =====

    @Test
    fun `generateMissingPositions - генерация для гитары`() {
        val chord = Chord("C", listOf(
            ChordPosition(Instrument.PIANO, listOf(
                Fret(string = 1, fret = 0),
                Fret(string = 2, fret = 4),
                Fret(string = 3, fret = 7)
            ))
        ))

        val positions = ChordGenerator.generateMissingPositions(chord)

        // Должна появиться позиция для гитары
        val guitarPos = positions.find { it.instrument == Instrument.GUITAR }
        assertNotNull(guitarPos)
    }

    @Test
    fun `generateMissingPositions - замена невалидной гитары`() {
        // Создаем аккорд с невалидной гитарной позицией (все лады = 0)
        val chord = Chord("D", listOf(
            ChordPosition(Instrument.GUITAR, listOf(
                Fret(string = 1, fret = 0),
                Fret(string = 2, fret = 0),
                Fret(string = 3, fret = 0),
                Fret(string = 4, fret = 0),
                Fret(string = 5, fret = 0),
                Fret(string = 6, fret = 0)
            ))
        ))

        val positions = ChordGenerator.generateMissingPositions(chord)
        val guitarPos = positions.find { it.instrument == Instrument.GUITAR }

        // Ноты аккорда D: D(2), F#(6), A(9)
        val playedNotes = guitarPos!!.frets
            .filter { it.fret >= 0 }
            .map { fret -> (GUITAR_TUNING[fret.string - 1] + fret.fret) % 12 }
            .toSet()

        // Проверяем, что позиция была перегенерирована (не все лады = 0)
        assertTrue(guitarPos.frets.any { it.fret > 0 })
        assertTrue(playedNotes.contains(2))  // D
        assertTrue(playedNotes.contains(6))  // F#
        assertTrue(playedNotes.contains(9))  // A
    }
}
