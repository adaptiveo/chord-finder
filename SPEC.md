# Chord Finder — Specification

## 1. Project Overview

- **Name**: Chord Finder
- **Type**: Android Native Application
- **Core Functionality**: User enters a chord name (e.g., "C", "Am", "G7") and the app displays all possible fingerings for guitar, piano, and ukulele.

## 2. Technology Stack

- **Framework**: Android Native (Kotlin 1.9 + Jetpack Compose)
- **Min SDK**: 26 (Android 8.0)
- **Target SDK**: 34 (Android 14)
- **UI**: Jetpack Compose with Material Design 3
- **Architecture**: MVVM (ViewModel + StateFlow)
- **Build**: Gradle 8.4 with Kotlin DSL

## 3. Feature List

1. **Chord Input** — Text field for chord name (e.g., "C", "Dm7", "F#m")
2. **Instrument Tabs** — Segmented tabs: Guitar | Piano | Ukulele
3. **Chord Diagram Display** — Visual diagram with finger positions
4. **Multiple Positions** — Scroll through all available positions

## 4. UI/UX Design

- Material Design 3, clean minimal style
- Dynamic color / dark-light theme support
- Single screen: search bar → tabs → scrollable diagram area
