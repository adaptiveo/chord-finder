package com.chordfinder.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.nativeCanvas
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
                    .height(120.dp)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))
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
    val stringColor = Color(0xFF1976D2)

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

        // Draw vertical lines (strings) - bright blue
        for (i in 0 until strings) {
            val x = leftPadding + i * stringSpacing
            drawLine(
                color = stringColor,
                start = Offset(x, topPadding),
                end = Offset(x, topPadding + diagramHeight),
                strokeWidth = if (i == 0 || i == strings - 1) 3.5.dp.toPx() else 3.dp.toPx()
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

        // Draw fret numbers on left side
        if (showFretNumbers) {
            val fretPaint = android.graphics.Paint().apply {
                color = android.graphics.Color.GRAY
                textSize = 12.dp.toPx()
                textAlign = android.graphics.Paint.Align.CENTER
            }
            for (i in 1..frets) {
                val y = topPadding + (i - 0.5f) * fretSpacing
                drawContext.canvas.nativeCanvas.drawText(i.toString(), leftPadding - 10.dp.toPx(), y + 4.dp.toPx(), fretPaint)
            }
        }

        // Draw string labels at bottom
        val labelPaint = android.graphics.Paint().apply {
            color = android.graphics.Color.GRAY
            textSize = 12.dp.toPx()
            textAlign = android.graphics.Paint.Align.CENTER
        }
        stringLabels.forEachIndexed { i, label ->
            val x = leftPadding + i * stringSpacing
            drawContext.canvas.nativeCanvas.drawText(label, x, size.height - 5.dp.toPx(), labelPaint)
        }

        // Draw finger positions
        position.frets.forEach { fret ->
            val stringIndex = strings - fret.string
            val x = leftPadding + stringIndex * stringSpacing
            val y = topPadding + (fret.fret - 0.5f) * fretSpacing

            val fingerNum = fret.finger ?: position.fingers.find { it.string == fret.string && it.fret == fret.fret }?.fingerNumber ?: 0

            when {
                fret.fret == -1 -> {
                    val redPaint = android.graphics.Paint().apply {
                        color = android.graphics.Color.RED
                        textSize = 18.dp.toPx()
                        textAlign = android.graphics.Paint.Align.CENTER
                        isFakeBoldText = true
                    }
                    drawContext.canvas.nativeCanvas.drawText("X", x, topPadding - 10.dp.toPx(), redPaint)
                }
                fret.fret == 0 -> {
                    drawCircle(
                        color = stringColor,
                        radius = 6.dp.toPx(),
                        center = Offset(x, topPadding - 15.dp.toPx())
                    )
                }
                fret.fret in 1..frets -> {
                    drawCircle(
                        color = if (fingerNum > 0) primaryColor else Color.Gray,
                        radius = 14.dp.toPx(),
                        center = Offset(x, y)
                    )
                    val textPaint = android.graphics.Paint().apply {
                        color = android.graphics.Color.BLACK
                        textSize = 16.dp.toPx()
                        textAlign = android.graphics.Paint.Align.CENTER
                        isFakeBoldText = true
                    }
                    drawContext.canvas.nativeCanvas.drawText(fingerNum.toString(), x, y + 6.dp.toPx(), textPaint)
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

            val textPaint = android.graphics.Paint().apply {
                color = android.graphics.Color.BLACK
                textSize = 14.dp.toPx()
                textAlign = android.graphics.Paint.Align.CENTER
                isFakeBoldText = true
            }
            drawContext.canvas.nativeCanvas.drawText(barre.finger.toString(), (startX + endX) / 2, y + 6.dp.toPx(), textPaint)
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
        val whiteKeyWidth = size.width / 14
        val whiteKeyHeight = size.height
        val blackKeyWidth = whiteKeyWidth * 0.6f
        val blackKeyHeight = whiteKeyHeight * 0.6f

        // White keys: C D E F G A B C D E F G A B (2 octaves, indices 0-13)
        for (i in 0 until 14) {
            val x = i * whiteKeyWidth
            drawRect(
                color = Color.White,
                topLeft = Offset(x, 0f),
                size = Size(whiteKeyWidth - 2, whiteKeyHeight)
            )
            drawRect(
                color = onSurfaceColor,
                topLeft = Offset(x, 0f),
                size = Size(whiteKeyWidth - 2, whiteKeyHeight),
                style = androidx.compose.ui.graphics.drawscope.Stroke(width = 1.dp.toPx())
            )
        }

        // Black keys positions in first octave: between 0-1, 1-2, 3-4, 4-5, 5-6
        // Second octave same pattern offset by 7
        val blackKeyDrawIndices = listOf(0, 1, 3, 4, 5, 7, 8, 10, 11, 12)

        for (i in blackKeyDrawIndices.indices) {
            val x = (blackKeyDrawIndices[i] + 1) * whiteKeyWidth - blackKeyWidth / 2
            drawRect(
                color = Color.Black,
                topLeft = Offset(x, 0f),
                size = Size(blackKeyWidth, blackKeyHeight)
            )
        }

        // Highlight keys that are in the chord
        val whiteKeyNoteOffsets = listOf(0, 2, 4, 5, 7, 9, 11) // C, D, E, F, G, A, B
        val blackKeyNoteOffsets = listOf(1, 3, 6, 8, 10) // C#, D#, F#, G#, A#
        val blackKeyDrawPositions = listOf(1, 2, 4, 5, 6) // white key indices where black keys appear (between white keys)

        position.frets.forEach { fret ->
            if (fret.fret < 0) return@forEach

            val noteOffset = fret.fret % 12
            val octave = fret.fret / 12

            // Check if it's a white key
            val whitePosIndex = whiteKeyNoteOffsets.indexOf(noteOffset)
            if (whitePosIndex >= 0) {
                val keyIndex = octave * 7 + whitePosIndex
                if (keyIndex in 0 until 14) {
                    val x = keyIndex * whiteKeyWidth
                    drawRect(
                        color = primaryColor.copy(alpha = 0.7f),
                        topLeft = Offset(x + 2f, 2f),
                        size = Size(whiteKeyWidth - 4, whiteKeyHeight - 4)
                    )
                }
            }

            // Check if it's a black key
            val blackPosIndex = blackKeyNoteOffsets.indexOf(noteOffset)
            if (blackPosIndex >= 0) {
                val keyIndex = octave * 7 + blackKeyDrawPositions[blackPosIndex]
                if (keyIndex in 1 until 14) {
                    val x = keyIndex * whiteKeyWidth - blackKeyWidth / 2
                    drawRect(
                        color = primaryColor.copy(alpha = 0.9f),
                        topLeft = Offset(x + 1f, 0f),
                        size = Size(blackKeyWidth - 2, blackKeyHeight - 2)
                    )
                }
            }
        }
    }
}