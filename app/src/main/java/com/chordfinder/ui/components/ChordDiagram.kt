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
    val stringColor = Color(0xFF1976D2)

    Canvas(modifier = modifier) {
        val padding = 40.dp.toPx()
        val topPadding = if (showFretNumbers) 30.dp.toPx() else 20.dp.toPx()
        val leftPadding = 30.dp.toPx()

        val diagramWidth = size.width - leftPadding - padding
        val diagramHeight = size.height - topPadding - padding

        val stringSpacing = diagramWidth / (strings - 1)
        val fretSpacing = diagramHeight / frets

        // Draw nut (left thick line) - rotated 90 degrees
        drawLine(
            color = onSurfaceColor,
            start = Offset(leftPadding, topPadding),
            end = Offset(leftPadding, topPadding + diagramHeight),
            strokeWidth = 6.dp.toPx()
        )

        // Draw horizontal lines (strings) - now brighter and thicker
        for (i in 0 until strings) {
            val y = topPadding + i * stringSpacing
            drawLine(
                color = stringColor,
                start = Offset(leftPadding, y),
                end = Offset(leftPadding + diagramHeight, y),
                strokeWidth = if (i == 0 || i == strings - 1) 3.5.dp.toPx() else 3.dp.toPx()
            )
        }

        // Draw vertical lines (frets)
        for (i in 0..frets) {
            val x = leftPadding + i * fretSpacing
            drawLine(
                color = onSurfaceColor,
                start = Offset(x, topPadding),
                end = Offset(x, topPadding + diagramHeight),
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
                val x = leftPadding + (i - 0.5f) * fretSpacing
                drawContext.canvas.nativeCanvas.drawText(i.toString(), x, topPadding - 8.dp.toPx(), fretPaint)
            }
        }

        // Draw string labels on right side
        val labelPaint = android.graphics.Paint().apply {
            color = android.graphics.Color.GRAY
            textSize = 12.dp.toPx()
            textAlign = android.graphics.Paint.Align.CENTER
        }
        stringLabels.forEachIndexed { i, label ->
            val y = topPadding + i * stringSpacing
            drawContext.canvas.nativeCanvas.drawText(label, leftPadding + diagramHeight + 15.dp.toPx(), y + 4.dp.toPx(), labelPaint)
        }

        // Draw finger positions (rotated 90 degrees)
        position.frets.forEach { fret ->
            val stringIndex = strings - fret.string
            val y = topPadding + stringIndex * stringSpacing
            val x = leftPadding + (fret.fret - 0.5f) * fretSpacing

            when {
                fret.fret == -1 -> {
                    val redPaint = android.graphics.Paint().apply {
                        color = android.graphics.Color.RED
                        textSize = 18.dp.toPx()
                        textAlign = android.graphics.Paint.Align.CENTER
                        isFakeBoldText = true
                    }
                    drawContext.canvas.nativeCanvas.drawText("X", leftPadding - 10.dp.toPx(), y + 4.dp.toPx(), redPaint)
                }
                fret.fret == 0 -> {
                    drawCircle(
                        color = Color(0xFF1976D2),
                        radius = 6.dp.toPx(),
                        center = Offset(leftPadding + 15.dp.toPx(), y)
                    )
                }
                fret.fret in 1..frets -> {
                    val fingerNum = fret.finger ?: 0
                    drawCircle(
                        color = if (fingerNum > 0) primaryColor else Color.Gray,
                        radius = 12.dp.toPx(),
                        center = Offset(x, y)
                    )
                    if (fingerNum > 0) {
                        val whitePaint = android.graphics.Paint().apply {
                            color = android.graphics.Color.WHITE
                            textSize = 14.dp.toPx()
                            textAlign = android.graphics.Paint.Align.CENTER
                            isFakeBoldText = true
                        }
                        drawContext.canvas.nativeCanvas.drawText(fingerNum.toString(), x, y + 5.dp.toPx(), whitePaint)
                    }
                }
            }
        }

        // Draw barres (rotated 90 degrees)
        position.barres.forEach { barre ->
            val startY = topPadding + (strings - barre.fromString) * stringSpacing
            val endY = topPadding + (strings - barre.toString) * stringSpacing
            val x = leftPadding + (barre.fret - 0.5f) * fretSpacing

            drawLine(
                color = primaryColor,
                start = Offset(x, startY),
                end = Offset(x, endY),
                strokeWidth = 20.dp.toPx()
            )

            val whitePaint = android.graphics.Paint().apply {
                color = android.graphics.Color.WHITE
                textSize = 14.dp.toPx()
                textAlign = android.graphics.Paint.Align.CENTER
                isFakeBoldText = true
            }
            drawContext.canvas.nativeCanvas.drawText(barre.finger.toString(), x, (startY + endY) / 2 + 6.dp.toPx(), whitePaint)
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
        for (i in 0 until 7) {
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

        // Black keys positions: between 0-1, 1-2, 3-4, 4-5, 5-6
        val blackKeyPositions = listOf(0, 1, 3, 4, 5)

        for (i in blackKeyPositions.indices) {
            val x = (blackKeyPositions[i] + 1) * whiteKeyWidth - blackKeyWidth / 2
            drawRect(
                color = onSurfaceColor,
                topLeft = Offset(x, 0f),
                size = Size(blackKeyWidth, blackKeyHeight)
            )
        }

        // Highlight keys that are in the chord
        val activeFrets = position.frets.filter { it.fret > 0 }
        activeFrets.forEach { fret ->
            val keyIndex = (fret.fret - 1) % 7
            if (keyIndex in 0 until 7) {
                val x = keyIndex * whiteKeyWidth
                drawRect(
                    color = primaryColor.copy(alpha = 0.7f),
                    topLeft = Offset(x + 2f, 2f),
                    size = Size(whiteKeyWidth - 4, whiteKeyHeight - 4)
                )
            }
        }
    }
}