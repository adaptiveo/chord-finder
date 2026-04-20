package com.chordfinder.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.dp
import com.chordfinder.data.Chord
import com.chordfinder.data.ChordPosition
import com.chordfinder.data.Fret
import com.chordfinder.data.Instrument

@Composable
fun GuitarChordDiagram(chord: Chord) {
    val position = chord.positions.find { it.instrument == Instrument.GUITAR }
        ?: chord.positions.firstOrNull()

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Guitar: ${chord.name}",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        if (position != null) {
            ChordDiagramCanvas(
                position = position,
                strings = 6,
                frets = 5,
                stringLabels = listOf("E", "A", "D", "G", "B", "e"),
                showFretNumbers = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        ChordInfo(position)
    }
}

@Composable
fun UkuleleChordDiagram(chord: Chord) {
    val position = chord.positions.find { it.instrument == Instrument.UKULELE }
        ?: chord.positions.firstOrNull()

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Ukulele: ${chord.name}",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        if (position != null) {
            ChordDiagramCanvas(
                position = position,
                strings = 4,
                frets = 5,
                stringLabels = listOf("G", "C", "E", "A"),
                showFretNumbers = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        ChordInfo(position)
    }
}

@Composable
fun PianoChordDiagram(chord: Chord) {
    val position = chord.positions.find { it.instrument == Instrument.PIANO }
        ?: chord.positions.firstOrNull()

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Piano: ${chord.name}",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        if (position != null) {
            PianoKeyboard(
                position = position,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        ChordInfo(position)
    }
}

@Composable
fun ChordInfo(position: ChordPosition?) {
    if (position == null) return

    val fingers = position.fingers
    if (fingers.isNotEmpty()) {
        Text(
            text = "Fingers: ${fingers.map { it.fingerNumber }.sorted().joinToString(", ")}",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
fun ChordDiagramCanvas(
    position: ChordPosition,
    strings: Int,
    frets: Int,
    stringLabels: List<String>,
    showFretNumbers: Boolean,
    modifier: Modifier = Modifier
) {
    val primaryColor = MaterialTheme.colorScheme.primary
    val onSurfaceColor = MaterialTheme.colorScheme.onSurface
    val surfaceVariant = MaterialTheme.colorScheme.surfaceVariant

    Canvas(modifier = modifier) {
        val padding = 40.dp.toPx()
        val topPadding = if (showFretNumbers) 30.dp.toPx() else 20.dp.toPx()
        val leftPadding = 30.dp.toPx()

        val diagramWidth = size.width - leftPadding - padding
        val diagramHeight = size.height - topPadding - padding

        val stringSpacing = diagramWidth / (strings - 1)
        val fretSpacing = diagramHeight / frets

        // Draw nut (top thick line)
        drawLine(
            color = onSurfaceColor,
            start = Offset(leftPadding, topPadding),
            end = Offset(leftPadding + diagramWidth, topPadding),
            strokeWidth = 6.dp.toPx()
        )

        // Draw vertical lines (strings)
        for (i in 0 until strings) {
            val x = leftPadding + i * stringSpacing
            drawLine(
                color = if (i == 0 || i == strings - 1) onSurfaceColor else surfaceVariant,
                start = Offset(x, topPadding),
                end = Offset(x, topPadding + diagramHeight),
                strokeWidth = if (i == 0 || i == strings - 1) 2.dp.toPx() else 1.dp.toPx()
            )
        }

        // Draw horizontal lines (frets)
        for (i in 0..frets) {
            val y = topPadding + i * fretSpacing
            drawLine(
                color = onSurfaceColor,
                start = Offset(leftPadding, y),
                end = Offset(leftPadding + diagramWidth, y),
                strokeWidth = 1.5.dp.toPx()
            )
        }

        // Draw string labels at bottom
        stringLabels.forEachIndexed { i, label ->
            val x = leftPadding + i * stringSpacing
            drawContext.canvas.nativeCanvas.drawText(
                label,
                x,
                size.height - 5.dp.toPx(),
                android.graphics.Paint().apply {
                    color = android.graphics.Color.GRAY
                    textSize = 12.dp.toPx()
                    textAlign = android.graphics.Paint.Align.CENTER
                }
            )
        }

        // Draw finger positions
        position.frets.forEach { fret ->
            val stringIndex = strings - fret.string // Reverse for display
            val x = leftPadding + stringIndex * stringSpacing
            val y = topPadding + (fret.fret - 0.5f) * fretSpacing

            when {
                fret.fret == -1 -> {
                    // Muted string - draw X
                    drawContext.canvas.nativeCanvas.drawText(
                        "X",
                        x,
                        topPadding - 10.dp.toPx(),
                        android.graphics.Paint().apply {
                            color = android.graphics.Color.RED
                            textSize = 18.dp.toPx()
                            textAlign = android.graphics.Paint.Align.CENTER
                            isFakeBoldText = true
                        }
                    )
                }
                fret.fret == 0 -> {
                    // Open string - draw O
                    drawCircle(
                        color = Color.Blue,
                        radius = 6.dp.toPx(),
                        center = Offset(x, topPadding - 15.dp.toPx())
                    )
                }
                fret.fret in 1..frets -> {
                    // Fretted note
                    val fingerNum = fret.finger ?: 0
                    drawCircle(
                        color = if (fingerNum > 0) primaryColor else Color.Gray,
                        radius = 12.dp.toPx(),
                        center = Offset(x, y)
                    )
                    if (fingerNum > 0) {
                        drawContext.canvas.nativeCanvas.drawText(
                            fingerNum.toString(),
                            x,
                            y + 5.dp.toPx(),
                            android.graphics.Paint().apply {
                                color = android.graphics.Color.WHITE
                                textSize = 14.dp.toPx()
                                textAlign = android.graphics.Paint.Align.CENTER
                                isFakeBoldText = true
                            }
                        )
                    }
                }
            }
        }

        // Draw barres
        position.barres.forEach { barre ->
            val startX = leftPadding + (strings - barre.fromString) * stringSpacing
            val endX = leftPadding + (strings - barre.toString) * stringSpacing
            val y = topPadding + (barre.fret - 0.5f) * fretSpacing

            drawLine(
                color = primaryColor,
                start = Offset(startX, y),
                end = Offset(endX, y),
                strokeWidth = 20.dp.toPx()
            )

            drawContext.canvas.nativeCanvas.drawText(
                barre.finger.toString(),
                (startX + endX) / 2,
                y + 6.dp.toPx(),
                android.graphics.Paint().apply {
                    color = android.graphics.Color.WHITE
                    textSize = 14.dp.toPx()
                    textAlign = android.graphics.Paint.Align.CENTER
                    isFakeBoldText = true
                }
            )
        }
    }
}

@Composable
fun PianoKeyboard(
    position: ChordPosition,
    modifier: Modifier = Modifier
) {
    val primaryColor = MaterialTheme.colorScheme.primary
    val onSurfaceColor = MaterialTheme.colorScheme.onSurface

    Canvas(modifier = modifier) {
        val whiteKeyWidth = size.width / 7
        val whiteKeyHeight = size.height
        val blackKeyWidth = whiteKeyWidth * 0.6f
        val blackKeyHeight = whiteKeyHeight * 0.6f

        // White keys: C D E F G A B (indices 0-6)
        val whiteKeyNotes = listOf("C", "D", "E", "F", "G", "A", "B")
        for (i in 0 until 7) {
            val x = i * whiteKeyWidth
            // Draw key outline
            drawRect(
                color = Color.White,
                topLeft = Offset(x, 0f),
                size = androidx.compose.ui.geometry.Size(whiteKeyWidth - 2, whiteKeyHeight)
            )
            drawRect(
                color = onSurfaceColor,
                topLeft = Offset(x, 0f),
                size = androidx.compose.ui.geometry.Size(whiteKeyWidth - 2, whiteKeyHeight),
                style = androidx.compose.ui.graphics.drawscope.Stroke(width = 1.dp.toPx())
            )
        }

        // Black keys positions: between 0-1, 1-2, 3-4, 4-5, 5-6
        val blackKeyPositions = listOf(0, 1, 3, 4, 5)
        val blackKeyNotes = listOf("C#", "D#", "F#", "G#", "A#")

        for (i in blackKeyPositions.indices) {
            val x = (blackKeyPositions[i] + 1) * whiteKeyWidth - blackKeyWidth / 2
            drawRect(
                color = onSurfaceColor,
                topLeft = Offset(x, 0f),
                size = androidx.compose.ui.geometry.Size(blackKeyWidth, blackKeyHeight)
            )
        }

        // Highlight keys that are in the chord
        val activeFrets = position.frets.filter { it.fret > 0 }
        activeFrets.forEach { fret ->
            // Map fret to key index (fret 1 = C, fret 3 = D, etc. in first octave)
            // Simplified: just show which white keys are active
            val keyIndex = (fret.fret - 1) % 7
            if (keyIndex in 0 until 7) {
                val x = keyIndex * whiteKeyWidth
                drawRect(
                    color = primaryColor.copy(alpha = 0.7f),
                    topLeft = Offset(x + 2, 2),
                    size = androidx.compose.ui.geometry.Size(whiteKeyWidth - 4, whiteKeyHeight - 4)
                )
            }
        }
    }
}
