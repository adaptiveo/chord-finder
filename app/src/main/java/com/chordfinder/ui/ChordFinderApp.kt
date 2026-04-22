package com.chordfinder.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.chordfinder.data.Chord
import com.chordfinder.data.ChordData
import com.chordfinder.ui.components.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChordFinderApp() {
    var query by remember { mutableStateOf("") }
    var selectedTab by remember { mutableIntStateOf(1) } // Default to Piano
    val tabs = listOf("Guitar", "Piano", "Ukulele")
    val colorScheme = MaterialTheme.colorScheme

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .padding(top = 16.dp, bottom = 8.dp)
    ) {
        // Header with app name
        Text(
            text = "Chord Finder",
            style = MaterialTheme.typography.headlineLarge,
            color = colorScheme.primary,
            modifier = Modifier.padding(bottom = 4.dp)
        )

        Text(
            text = "Find piano, guitar & ukulele chords",
            style = MaterialTheme.typography.bodyMedium,
            color = colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Search field with Material 3 styling
        OutlinedTextField(
            value = query,
            onValueChange = { query = it },
            label = { Text("Enter chord") },
            placeholder = { Text("e.g. C, Am, G7, Fsus2") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search",
                    tint = colorScheme.onSurfaceVariant
                )
            },
            trailingIcon = if (query.isNotEmpty()) {
                {
                    IconButton(onClick = { query = "" }) {
                        Icon(
                            imageVector = Icons.Outlined.Info,
                            contentDescription = "Clear",
                            tint = colorScheme.onSurfaceVariant
                        )
                    }
                }
            } else null,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(onSearch = { }),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = colorScheme.surface,
                unfocusedContainerColor = colorScheme.surfaceVariant.copy(alpha = 0.3f),
                focusedIndicatorColor = colorScheme.primary,
                unfocusedIndicatorColor = colorScheme.outline
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Tab row with icons
        PrimaryTabRow(
            selectedTabIndex = selectedTab,
            modifier = Modifier.fillMaxWidth()
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTab == index,
                    onClick = { selectedTab = index },
                    text = {
                        Text(
                            text = title,
                            style = MaterialTheme.typography.labelLarge
                        )
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Content area
        val chordName = query.trim().uppercase()
        val chord = ChordData.getChord(chordName)

        if (chord != null) {
            // Chord found - display in Card
            Card(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = colorScheme.surfaceVariant.copy(alpha = 0.5f)
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .padding(16.dp)
                ) {
                    // Chord title with style
                    Surface(
                        color = colorScheme.primaryContainer,
                        shape = MaterialTheme.shapes.medium
                    ) {
                        Text(
                            text = chord.name,
                            style = MaterialTheme.typography.headlineMedium,
                            color = colorScheme.onPrimaryContainer,
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Instrument diagram
                    when (selectedTab) {
                        0 -> GuitarChordDiagram(chord)
                        1 -> PianoChordDiagram(chord)
                        2 -> UkuleleChordDiagram(chord)
                    }
                }
            }
        } else {
            // Empty state
            Card(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = colorScheme.surfaceVariant.copy(alpha = 0.3f)
                )
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Info,
                            contentDescription = null,
                            modifier = Modifier.size(48.dp),
                            tint = colorScheme.onSurfaceVariant
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = if (query.isBlank()) {
                                "Enter a chord name above"
                            } else {
                                "\"$chordName\" not found"
                            },
                            style = MaterialTheme.typography.bodyLarge,
                            color = colorScheme.onSurfaceVariant
                        )
                        if (query.isNotBlank()) {
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "Try: C, Dm, F7, Gmaj7, Am9",
                                style = MaterialTheme.typography.bodySmall,
                                color = colorScheme.outline
                            )
                        }
                    }
                }
            }
        }
    }
}
