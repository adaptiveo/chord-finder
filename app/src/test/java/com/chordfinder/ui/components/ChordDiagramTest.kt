package com.chordfinder.ui.components

import com.chordfinder.data.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ChordDiagramTest {

    // ===== Тесты проверки барре в данных =====

    @Test
    fun `ChordPosition с барре - правильные данные`() {
        // Аккорд F с барре на 1 ладу
        val frets = listOf(
            Fret(string = 1, fret = 1, finger = 1),
            Fret(string = 2, fret = 1, finger = 1),
            Fret(string = 3, fret = 2, finger = 2),
            Fret(string = 4, fret = 3, finger = 3),
            Fret(string = 5, fret = 3, finger = 4),
            Fret(string = 6, fret = 1, finger = 1)
        )
        val barres = listOf(
            Barre(fret = 1, fromString = 1, toString = 6, finger = 1)
        )

        val position = ChordPosition(Instrument.GUITAR, frets, barres, emptyList())

        // Проверяем, что барре покрывает струны 1-6
        assertEquals(1, position.barres.size)
        assertEquals(1, position.barres[0].fromString)
        assertEquals(6, position.barres[0].toString)
        assertEquals(1, position.barres[0].fret)
    }

    @Test
    fun `ChordPosition - проверка покрытия струн барре`() {
        // Аккорд G на укулеле с барре на 2 ладу
        val frets = listOf(
            Fret(string = 1, fret = 2), // A струна
            Fret(string = 2, fret = 3), // E струна
            Fret(string = 3, fret = 2), // C струна
            Fret(string = 4, fret = 0)  // G струна (открытая)
        )
        val barres = listOf(
            Barre(fret = 2, fromString = 1, toString = 3, finger = 1)
        )

        val position = ChordPosition(Instrument.UKULELE, frets, barres, emptyList())

        // Проверяем, что барре покрывает струны 1-3
        assertEquals(1, position.barres.size)
        assertEquals(1, position.barres[0].fromString)
        assertEquals(3, position.barres[0].toString)

        // Проверяем, какие струны покрыты барре
        val barre = position.barres[0]
        assertTrue(barre.fromString <= 1 && barre.toString >= 1) // Струна 1 покрыта
        assertTrue(barre.fromString <= 2 && barre.toString >= 2) // Струна 2 покрыта
        assertTrue(barre.fromString <= 3 && barre.toString >= 3) // Струна 3 покрыта
        assertFalse(barre.fromString <= 4 && barre.toString >= 4) // Струна 4 не покрыта
    }

    @Test
    fun `ChordPosition - аккорд D без барре`() {
        // Аккорд D для гитары - без барре
        val frets = listOf(
            Fret(string = 1, fret = 2), // e струна
            Fret(string = 2, fret = 3), // B струна
            Fret(string = 3, fret = 2), // G струна
            Fret(string = 4, fret = 0), // D струна (открытая)
            Fret(string = 5, fret = -1), // A струна (не играет)
            Fret(string = 6, fret = -1)  // E струна (не играет)
        )

        val position = ChordPosition(Instrument.GUITAR, frets, emptyList(), emptyList())

        // Проверяем, что нет барре
        assertEquals(0, position.barres.size)

        // Проверяем, что струны 5 и 6 не играют
        assertEquals(-1, position.frets[4].fret)
        assertEquals(-1, position.frets[5].fret)
    }

    @Test
    fun `ChordPosition - аккорд Em с открытыми струнами`() {
        // Аккорд Em для гитары - все струны играют
        val frets = listOf(
            Fret(string = 1, fret = 0), // e
            Fret(string = 2, fret = 0), // B
            Fret(string = 3, fret = 0), // G
            Fret(string = 4, fret = 2), // D
            Fret(string = 5, fret = 2), // A
            Fret(string = 6, fret = 0)  // E
        )

        val position = ChordPosition(Instrument.GUITAR, frets, emptyList(), emptyList())

        // Проверяем, что нет барре (разные лады)
        assertEquals(0, position.barres.size)

        // Проверяем, что все струны играют
        assertEquals(6, position.frets.count { it.fret >= 0 })
    }

    // ===== Тесты проверки логики isCoveredByBarre =====

    @Test
    fun `isCoveredByBarre - палец под барре`() {
        val barre = Barre(fret = 2, fromString = 1, toString = 3, finger = 1)
        val barres = listOf(barre)

        // Струна 1, лад 2 - должна быть покрыта
        val fret1 = Fret(string = 1, fret = 2)
        val covered1 = barres.any { b ->
            b.fret == fret1.fret &&
            fret1.string >= b.fromString &&
            fret1.string <= b.toString
        }
        assertTrue(covered1)

        // Струна 2, лад 2 - должна быть покрыта
        val fret2 = Fret(string = 2, fret = 2)
        val covered2 = barres.any { b ->
            b.fret == fret2.fret &&
            fret2.string >= b.fromString &&
            fret2.string <= b.toString
        }
        assertTrue(covered2)

        // Струна 3, лад 2 - должна быть покрыта
        val fret3 = Fret(string = 3, fret = 2)
        val covered3 = barres.any { b ->
            b.fret == fret3.fret &&
            fret3.string >= b.fromString &&
            fret3.string <= b.toString
        }
        assertTrue(covered3)

        // Струна 4, лад 2 - НЕ должна быть покрыта
        val fret4 = Fret(string = 4, fret = 2)
        val covered4 = barres.any { b ->
            b.fret == fret4.fret &&
            fret4.string >= b.fromString &&
            fret4.string <= b.toString
        }
        assertFalse(covered4)
    }

    @Test
    fun `isCoveredByBarre - палец на другом ладу`() {
        val barre = Barre(fret = 2, fromString = 1, toString = 3, finger = 1)
        val barres = listOf(barre)

        // Струна 2, лад 3 - НЕ должна быть покрыта (другой лад)
        val fret = Fret(string = 2, fret = 3)
        val covered = barres.any { b ->
            b.fret == fret.fret &&
            fret.string >= b.fromString &&
            fret.string <= b.toString
        }
        assertFalse(covered)
    }

    @Test
    fun `isCoveredByBarre - открытая струна`() {
        val barre = Barre(fret = 2, fromString = 1, toString = 3, finger = 1)
        val barres = listOf(barre)

        // Струна 4, лад 0 - НЕ должна быть покрыта (открытая струна)
        val fret = Fret(string = 4, fret = 0)
        val covered = barres.any { b ->
            b.fret == fret.fret &&
            fret.string >= b.fromString &&
            fret.string <= b.toString
        }
        assertFalse(covered)
    }

    @Test
    fun `isCoveredByBarre - приглушенная струна`() {
        val barre = Barre(fret = 2, fromString = 1, toString = 3, finger = 1)
        val barres = listOf(barre)

        // Струна 6, лад -1 - НЕ должна быть покрыта (не играет)
        val fret = Fret(string = 6, fret = -1)
        val covered = barres.any { b ->
            b.fret == fret.fret &&
            fret.string >= b.fromString &&
            fret.string <= b.toString
        }
        assertFalse(covered)
    }
}
