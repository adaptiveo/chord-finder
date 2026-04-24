package com.chordfinder.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.chordfinder.data.Chord
import com.chordfinder.data.Instrument

/**
 * Компонент табов для выбора инструмента.
 * Показывает доступность аккорда для каждого инструмента.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InstrumentTabs(
    selectedTab: Int,
    onTabSelected: (Int) -> Unit,
    chord: Chord?,
    modifier: Modifier = Modifier
) {
    val instruments = listOf(
        InstrumentTabData(
            index = 0,
            name = "Guitar",
            icon = "🎸",
            instrument = Instrument.GUITAR
        ),
        InstrumentTabData(
            index = 1,
            name = "Piano",
            icon = "🎹",
            instrument = Instrument.PIANO
        ),
        InstrumentTabData(
            index = 2,
            name = "Ukulele",
            icon = "🎸",
            instrument = Instrument.UKULELE
        )
    )

    // Проверяем доступность аккорда для каждого инструмента
    val instrumentAvailability = remember(chord) {
        instruments.associate { tabData ->
            tabData.index to isChordAvailableForInstrument(chord, tabData.instrument)
        }
    }

    PrimaryTabRow(
        selectedTabIndex = selectedTab,
        modifier = modifier.fillMaxWidth()
    ) {
        instruments.forEach { tabData ->
            val isAvailable = instrumentAvailability[tabData.index] ?: true
            val isSelected = selectedTab == tabData.index

            Tab(
                selected = isSelected,
                onClick = {
                    if (isAvailable) {
                        onTabSelected(tabData.index)
                    }
                },
                enabled = isAvailable,
                text = {
                    InstrumentTabContent(
                        name = tabData.name,
                        icon = tabData.icon,
                        isAvailable = isAvailable,
                        isSelected = isSelected
                    )
                }
            )
        }
    }
}

/**
 * Проверяет, есть ли валидная позиция аккорда для инструмента
 */
private fun isChordAvailableForInstrument(chord: Chord?, instrument: Instrument): Boolean {
    if (chord == null) return true // Если аккорд не выбран, показываем все табы

    val position = chord.positions.find { it.instrument == instrument }
    return position != null && position.frets.isNotEmpty() && position.frets.any { it.fret > 0 }
}

/**
 * Данные о табе инструмента
 */
private data class InstrumentTabData(
    val index: Int,
    val name: String,
    val icon: String,
    val instrument: Instrument
)

/**
 * Содержимое таба с индикацией доступности
 */
@Composable
private fun InstrumentTabContent(
    name: String,
    icon: String,
    isAvailable: Boolean,
    isSelected: Boolean
) {
    val colorScheme = MaterialTheme.colorScheme

    val textColor = when {
        !isAvailable -> colorScheme.onSurface.copy(alpha = 0.38f) // Disabled
        isSelected -> colorScheme.primary
        else -> colorScheme.onSurfaceVariant
    }

    Row(
        modifier = Modifier.padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "$icon $name",
            style = MaterialTheme.typography.labelLarge,
            color = textColor
        )

        // Индикатор недоступности
        if (!isAvailable) {
            Text(
                text = " —",
                style = MaterialTheme.typography.labelSmall,
                color = colorScheme.onSurface.copy(alpha = 0.38f),
                modifier = Modifier.padding(start = 4.dp)
            )
        }
    }
}

/**
 * Компонент отображения диаграммы в зависимости от выбранного инструмента
 */
@Composable
fun InstrumentChordDiagram(
    chord: Chord,
    selectedInstrument: Int,
    modifier: Modifier = Modifier
) {
    when (selectedInstrument) {
        0 -> GuitarChordDiagram(chord = chord)
        1 -> PianoChordDiagram(chord = chord)
        2 -> UkuleleChordDiagram(chord = chord)
        else -> PianoChordDiagram(chord = chord)
    }
}

/**
 * Сообщение об отсутствии аккорда для инструмента
 */
@Composable
fun NoChordAvailableMessage(instrumentName: String) {
    val colorScheme = MaterialTheme.colorScheme

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        contentAlignment = androidx.compose.ui.Alignment.Center
    ) {
        Column(
            horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = androidx.compose.material.icons.Icons.Outlined.Info,
                contentDescription = null,
                modifier = Modifier.size(48.dp),
                tint = colorScheme.onSurfaceVariant.copy(alpha = 0.5f)
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Not available for $instrumentName",
                style = MaterialTheme.typography.bodyLarge,
                color = colorScheme.onSurfaceVariant.copy(alpha = 0.7f)
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Try another instrument or chord",
                style = MaterialTheme.typography.bodySmall,
                color = colorScheme.onSurfaceVariant.copy(alpha = 0.5f)
            )
        }
    }
}
