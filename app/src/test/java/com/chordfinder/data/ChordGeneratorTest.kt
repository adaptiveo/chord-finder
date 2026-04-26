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

    // ===== Полные тесты всех основных аккордов для гитары =====

    @Test
    fun `guitar chords - C major (x32010)`() {
        val position = ChordGenerator.generateChordPosition("C", Instrument.GUITAR, GUITAR_TUNING)
        assertNotNull(position)
        val frets = position!!.frets.map { it.fret }
        assertEquals(listOf(-1, 3, 2, 0, 1, 0), frets)
    }

    @Test
    fun `guitar chords - D major (xx0232)`() {
        val position = ChordGenerator.generateChordPosition("D", Instrument.GUITAR, GUITAR_TUNING)
        assertNotNull(position)
        val frets = position!!.frets.map { it.fret }
        assertEquals(listOf(-1, -1, 0, 2, 3, 2), frets)
    }

    @Test
    fun `guitar chords - E major (022100)`() {
        val position = ChordGenerator.generateChordPosition("E", Instrument.GUITAR, GUITAR_TUNING)
        assertNotNull(position)
        val frets = position!!.frets.map { it.fret }
        assertEquals(listOf(0, 2, 2, 1, 0, 0), frets)
    }

    @Test
    fun `guitar chords - F major (xx3211)`() {
        val position = ChordGenerator.generateChordPosition("F", Instrument.GUITAR, GUITAR_TUNING)
        assertNotNull(position)
        val frets = position!!.frets.map { it.fret }
        assertEquals(listOf(-1, -1, 3, 2, 1, 1), frets)
    }

    @Test
    fun `guitar chords - G major (320003)`() {
        val position = ChordGenerator.generateChordPosition("G", Instrument.GUITAR, GUITAR_TUNING)
        assertNotNull(position)
        val frets = position!!.frets.map { it.fret }
        assertEquals(listOf(3, 2, 0, 0, 0, 3), frets)
    }

    @Test
    fun `guitar chords - A major (x02220)`() {
        val position = ChordGenerator.generateChordPosition("A", Instrument.GUITAR, GUITAR_TUNING)
        assertNotNull(position)
        val frets = position!!.frets.map { it.fret }
        assertEquals(listOf(-1, 0, 2, 2, 2, 0), frets)
    }

    @Test
    fun `guitar chords - Cm (x35543)`() {
        val position = ChordGenerator.generateChordPosition("Cm", Instrument.GUITAR, GUITAR_TUNING)
        assertNotNull(position)
        val frets = position!!.frets.map { it.fret }
        assertEquals(listOf(-1, 3, 5, 5, 4, 3), frets)
    }

    @Test
    fun `guitar chords - Dm (xx0231)`() {
        val position = ChordGenerator.generateChordPosition("Dm", Instrument.GUITAR, GUITAR_TUNING)
        assertNotNull(position)
        val frets = position!!.frets.map { it.fret }
        assertEquals(listOf(-1, -1, 0, 2, 3, 1), frets)
    }

    @Test
    fun `guitar chords - Em (022000)`() {
        val position = ChordGenerator.generateChordPosition("Em", Instrument.GUITAR, GUITAR_TUNING)
        assertNotNull(position)
        val frets = position!!.frets.map { it.fret }
        assertEquals(listOf(0, 2, 2, 0, 0, 0), frets)
    }

    @Test
    fun `guitar chords - Fm (xx3111)`() {
        val position = ChordGenerator.generateChordPosition("Fm", Instrument.GUITAR, GUITAR_TUNING)
        assertNotNull(position)
        val frets = position!!.frets.map { it.fret }
        assertEquals(listOf(-1, -1, 3, 1, 1, 1), frets)
    }

    @Test
    fun `guitar chords - Gm (355333)`() {
        val position = ChordGenerator.generateChordPosition("Gm", Instrument.GUITAR, GUITAR_TUNING)
        assertNotNull(position)
        val frets = position!!.frets.map { it.fret }
        assertEquals(listOf(3, 5, 5, 3, 3, 3), frets)
    }

    @Test
    fun `guitar chords - Am (x02210)`() {
        val position = ChordGenerator.generateChordPosition("Am", Instrument.GUITAR, GUITAR_TUNING)
        assertNotNull(position)
        val frets = position!!.frets.map { it.fret }
        assertEquals(listOf(-1, 0, 2, 2, 1, 0), frets)
    }

    @Test
    fun `guitar chords - C7 (x32310)`() {
        val position = ChordGenerator.generateChordPosition("C7", Instrument.GUITAR, GUITAR_TUNING)
        assertNotNull(position)
        val frets = position!!.frets.map { it.fret }
        assertEquals(listOf(-1, 3, 2, 3, 1, 0), frets)
    }

    @Test
    fun `guitar chords - D7 (xx0212)`() {
        val position = ChordGenerator.generateChordPosition("D7", Instrument.GUITAR, GUITAR_TUNING)
        assertNotNull(position)
        val frets = position!!.frets.map { it.fret }
        assertEquals(listOf(-1, -1, 0, 2, 1, 2), frets)
    }

    @Test
    fun `guitar chords - E7 (020100)`() {
        val position = ChordGenerator.generateChordPosition("E7", Instrument.GUITAR, GUITAR_TUNING)
        assertNotNull(position)
        val frets = position!!.frets.map { it.fret }
        assertEquals(listOf(0, 2, 0, 1, 0, 0), frets)
    }

    @Test
    fun `guitar chords - G7 (320001)`() {
        val position = ChordGenerator.generateChordPosition("G7", Instrument.GUITAR, GUITAR_TUNING)
        assertNotNull(position)
        val frets = position!!.frets.map { it.fret }
        assertEquals(listOf(3, 2, 0, 0, 0, 1), frets)
    }

    @Test
    fun `guitar chords - A7 (x02020)`() {
        val position = ChordGenerator.generateChordPosition("A7", Instrument.GUITAR, GUITAR_TUNING)
        assertNotNull(position)
        val frets = position!!.frets.map { it.fret }
        assertEquals(listOf(-1, 0, 2, 0, 2, 0), frets)
    }

    @Test
    fun `guitar chords - CM7 (x32000)`() {
        val position = ChordGenerator.generateChordPosition("CM7", Instrument.GUITAR, GUITAR_TUNING)
        assertNotNull(position)
        val frets = position!!.frets.map { it.fret }
        assertEquals(listOf(-1, 3, 2, 0, 0, 0), frets)
    }

    @Test
    fun `guitar chords - DM7 (xx0222)`() {
        val position = ChordGenerator.generateChordPosition("DM7", Instrument.GUITAR, GUITAR_TUNING)
        assertNotNull(position)
        val frets = position!!.frets.map { it.fret }
        assertEquals(listOf(-1, -1, 0, 2, 2, 2), frets)
    }

    @Test
    fun `guitar chords - GM7 (320002)`() {
        val position = ChordGenerator.generateChordPosition("GM7", Instrument.GUITAR, GUITAR_TUNING)
        assertNotNull(position)
        val frets = position!!.frets.map { it.fret }
        assertEquals(listOf(3, 2, 0, 0, 0, 2), frets)
    }

    @Test
    fun `guitar chords - AM7 (x02120)`() {
        val position = ChordGenerator.generateChordPosition("AM7", Instrument.GUITAR, GUITAR_TUNING)
        assertNotNull(position)
        val frets = position!!.frets.map { it.fret }
        assertEquals(listOf(-1, 0, 2, 1, 2, 0), frets)
    }

    @Test
    fun `guitar chords - Asus2 (x02200)`() {
        val position = ChordGenerator.generateChordPosition("Asus2", Instrument.GUITAR, GUITAR_TUNING)
        assertNotNull(position)
        val frets = position!!.frets.map { it.fret }
        assertEquals(listOf(-1, 0, 2, 2, 0, 0), frets)
    }

    @Test
    fun `guitar chords - Dsus2 (xx0230)`() {
        val position = ChordGenerator.generateChordPosition("Dsus2", Instrument.GUITAR, GUITAR_TUNING)
        assertNotNull(position)
        val frets = position!!.frets.map { it.fret }
        assertEquals(listOf(-1, -1, 0, 2, 3, 0), frets)
    }

    @Test
    fun `guitar chords - Asus4 (x02230)`() {
        val position = ChordGenerator.generateChordPosition("Asus4", Instrument.GUITAR, GUITAR_TUNING)
        assertNotNull(position)
        val frets = position!!.frets.map { it.fret }
        assertEquals(listOf(-1, 0, 2, 2, 3, 0), frets)
    }

    @Test
    fun `guitar chords - Dsus4 (xx0233)`() {
        val position = ChordGenerator.generateChordPosition("Dsus4", Instrument.GUITAR, GUITAR_TUNING)
        assertNotNull(position)
        val frets = position!!.frets.map { it.fret }
        assertEquals(listOf(-1, -1, 0, 2, 3, 3), frets)
    }

    @Test
    fun `guitar chords - Cadd9 (x32030)`() {
        val position = ChordGenerator.generateChordPosition("Cadd9", Instrument.GUITAR, GUITAR_TUNING)
        assertNotNull(position)
        val frets = position!!.frets.map { it.fret }
        assertEquals(listOf(-1, 3, 2, 0, 3, 0), frets)
    }

    @Test
    fun `guitar chords - Ddim (xx0101)`() {
        val position = ChordGenerator.generateChordPosition("Ddim", Instrument.GUITAR, GUITAR_TUNING)
        assertNotNull(position)
        val frets = position!!.frets.map { it.fret }
        assertEquals(listOf(-1, -1, 0, 1, 0, 1), frets)
    }

    @Test
    fun `guitar chords - Edim (010100)`() {
        val position = ChordGenerator.generateChordPosition("Edim", Instrument.GUITAR, GUITAR_TUNING)
        assertNotNull(position)
        val frets = position!!.frets.map { it.fret }
        assertEquals(listOf(0, 1, 0, 1, 0, 0), frets)
    }

    @Test
    fun `guitar chords - C5 (x35500)`() {
        val position = ChordGenerator.generateChordPosition("C5", Instrument.GUITAR, GUITAR_TUNING)
        assertNotNull(position)
        val frets = position!!.frets.map { it.fret }
        assertEquals(listOf(-1, 3, 5, 5, 0, 0), frets)
    }

    @Test
    fun `guitar chords - D5 (xx0230)`() {
        val position = ChordGenerator.generateChordPosition("D5", Instrument.GUITAR, GUITAR_TUNING)
        assertNotNull(position)
        val frets = position!!.frets.map { it.fret }
        assertEquals(listOf(-1, -1, 0, 2, 3, 0), frets)
    }

    @Test
    fun `guitar chords - E5 (022000)`() {
        val position = ChordGenerator.generateChordPosition("E5", Instrument.GUITAR, GUITAR_TUNING)
        assertNotNull(position)
        val frets = position!!.frets.map { it.fret }
        assertEquals(listOf(0, 2, 2, 0, 0, 0), frets)
    }

    @Test
    fun `guitar chords - G5 (355000)`() {
        val position = ChordGenerator.generateChordPosition("G5", Instrument.GUITAR, GUITAR_TUNING)
        assertNotNull(position)
        val frets = position!!.frets.map { it.fret }
        assertEquals(listOf(3, 5, 5, 0, 0, 0), frets)
    }

    @Test
    fun `guitar chords - A5 (x02200)`() {
        val position = ChordGenerator.generateChordPosition("A5", Instrument.GUITAR, GUITAR_TUNING)
        assertNotNull(position)
        val frets = position!!.frets.map { it.fret }
        assertEquals(listOf(-1, 0, 2, 2, 0, 0), frets)
    }

    // ===== Тесты основных аккордов для укулеле =====

    @Test
    fun `ukulele chords - C major`() {
        val position = ChordGenerator.generateChordPosition("C", Instrument.UKULELE, UKULELE_TUNING)
        assertNotNull(position)
        // Проверяем, что все ноты аккорда присутствуют
        val playedNotes = position!!.frets
            .filter { it.fret >= 0 }
            .map { fret -> (UKULELE_TUNING[fret.string - 1] + fret.fret) % 12 }
            .toSet()
        assertTrue(playedNotes.contains(0)) // C
        assertTrue(playedNotes.contains(4)) // E
        assertTrue(playedNotes.contains(7)) // G
    }

    @Test
    fun `ukulele chords - D major`() {
        val position = ChordGenerator.generateChordPosition("D", Instrument.UKULELE, UKULELE_TUNING)
        assertNotNull(position)
        val playedNotes = position!!.frets
            .filter { it.fret >= 0 }
            .map { fret -> (UKULELE_TUNING[fret.string - 1] + fret.fret) % 12 }
            .toSet()
        assertTrue(playedNotes.contains(2))  // D
        assertTrue(playedNotes.contains(6))  // F#
        assertTrue(playedNotes.contains(9))  // A
    }

    @Test
    fun `ukulele chords - E major`() {
        val position = ChordGenerator.generateChordPosition("E", Instrument.UKULELE, UKULELE_TUNING)
        assertNotNull(position)
        val playedNotes = position!!.frets
            .filter { it.fret >= 0 }
            .map { fret -> (UKULELE_TUNING[fret.string - 1] + fret.fret) % 12 }
            .toSet()
        assertTrue(playedNotes.contains(4))  // E
        assertTrue(playedNotes.contains(8))  // G#
        assertTrue(playedNotes.contains(11)) // B
    }

    @Test
    fun `ukulele chords - F major`() {
        val position = ChordGenerator.generateChordPosition("F", Instrument.UKULELE, UKULELE_TUNING)
        assertNotNull(position)
        val playedNotes = position!!.frets
            .filter { it.fret >= 0 }
            .map { fret -> (UKULELE_TUNING[fret.string - 1] + fret.fret) % 12 }
            .toSet()
        assertTrue(playedNotes.contains(5))  // F
        assertTrue(playedNotes.contains(9))  // A
        assertTrue(playedNotes.contains(0))  // C
    }

    @Test
    fun `ukulele chords - G major`() {
        val position = ChordGenerator.generateChordPosition("G", Instrument.UKULELE, UKULELE_TUNING)
        assertNotNull(position)
        val playedNotes = position!!.frets
            .filter { it.fret >= 0 }
            .map { fret -> (UKULELE_TUNING[fret.string - 1] + fret.fret) % 12 }
            .toSet()
        assertTrue(playedNotes.contains(7))  // G
        assertTrue(playedNotes.contains(11)) // B
        assertTrue(playedNotes.contains(2))  // D
    }

    @Test
    fun `ukulele chords - A major`() {
        val position = ChordGenerator.generateChordPosition("A", Instrument.UKULELE, UKULELE_TUNING)
        assertNotNull(position)
        val playedNotes = position!!.frets
            .filter { it.fret >= 0 }
            .map { fret -> (UKULELE_TUNING[fret.string - 1] + fret.fret) % 12 }
            .toSet()
        assertTrue(playedNotes.contains(9))  // A
        assertTrue(playedNotes.contains(1))  // C#
        assertTrue(playedNotes.contains(4))  // E
    }

    @Test
    fun `ukulele chords - Am`() {
        val position = ChordGenerator.generateChordPosition("Am", Instrument.UKULELE, UKULELE_TUNING)
        assertNotNull(position)
        val playedNotes = position!!.frets
            .filter { it.fret >= 0 }
            .map { fret -> (UKULELE_TUNING[fret.string - 1] + fret.fret) % 12 }
            .toSet()
        assertTrue(playedNotes.contains(9))  // A
        assertTrue(playedNotes.contains(0))  // C
        assertTrue(playedNotes.contains(4))  // E
    }

    @Test
    fun `ukulele chords - Em`() {
        val position = ChordGenerator.generateChordPosition("Em", Instrument.UKULELE, UKULELE_TUNING)
        assertNotNull(position)
        val playedNotes = position!!.frets
            .filter { it.fret >= 0 }
            .map { fret -> (UKULELE_TUNING[fret.string - 1] + fret.fret) % 12 }
            .toSet()
        assertTrue(playedNotes.contains(4))  // E
        assertTrue(playedNotes.contains(7))  // G
        assertTrue(playedNotes.contains(11)) // B
    }

    @Test
    fun `ukulele chords - Dm`() {
        val position = ChordGenerator.generateChordPosition("Dm", Instrument.UKULELE, UKULELE_TUNING)
        assertNotNull(position)
        val playedNotes = position!!.frets
            .filter { it.fret >= 0 }
            .map { fret -> (UKULELE_TUNING[fret.string - 1] + fret.fret) % 12 }
            .toSet()
        assertTrue(playedNotes.contains(2))  // D
        assertTrue(playedNotes.contains(5))  // F
        assertTrue(playedNotes.contains(9))  // A
    }

    @Test
    fun `ukulele chords - C7`() {
        val position = ChordGenerator.generateChordPosition("C7", Instrument.UKULELE, UKULELE_TUNING)
        assertNotNull(position)
        val playedNotes = position!!.frets
            .filter { it.fret >= 0 }
            .map { fret -> (UKULELE_TUNING[fret.string - 1] + fret.fret) % 12 }
            .toSet()
        assertTrue(playedNotes.contains(0))  // C
        assertTrue(playedNotes.contains(4))  // E
        assertTrue(playedNotes.contains(7))  // G
        assertTrue(playedNotes.contains(10)) // Bb
    }

    @Test
    fun `ukulele chords - G7`() {
        val position = ChordGenerator.generateChordPosition("G7", Instrument.UKULELE, UKULELE_TUNING)
        assertNotNull(position)
        val playedNotes = position!!.frets
            .filter { it.fret >= 0 }
            .map { fret -> (UKULELE_TUNING[fret.string - 1] + fret.fret) % 12 }
            .toSet()
        assertTrue(playedNotes.contains(7))  // G
        assertTrue(playedNotes.contains(11)) // B
        assertTrue(playedNotes.contains(2))  // D
        assertTrue(playedNotes.contains(10)) // F
    }

    @Test
    fun `ukulele chords - D7`() {
        val position = ChordGenerator.generateChordPosition("D7", Instrument.UKULELE, UKULELE_TUNING)
        assertNotNull(position)
        val playedNotes = position!!.frets
            .filter { it.fret >= 0 }
            .map { fret -> (UKULELE_TUNING[fret.string - 1] + fret.fret) % 12 }
            .toSet()
        assertTrue(playedNotes.contains(2))  // D
        assertTrue(playedNotes.contains(6))  // F#
        assertTrue(playedNotes.contains(9))  // A
        assertTrue(playedNotes.contains(1))  // C
    }
}
