# Chord Finder

Android-приложение для отображения аппликатур аккордов на гитаре, фортепиано и укулеле.

Пользователь вводит название аккорда (например, "C", "Am", "G7") и приложение отображает все возможные позиции для выбранного инструмента.

**GitHub:** https://github.com/adaptiveo/chord-finder

## Функции

- **Autocomplete dropdown** — подсказки при вводе названия аккорда
- **Три инструмента** — гитара, фортепиано, укулеле
- **Визуальные диаграммы** — аппликатуры с позициями пальцев и баррэ
- **Material Design 3** — современный UI с поддержкой темной темы
- **Генерация аппликатур** — автоматическая генерация правильных позиций для гитары и укулеле

## Сборка

```bash
# Debug версия
./gradlew assembleDebug

# Release версия (требуется chord-finder.jks)
./gradlew assembleRelease
```

APK файлы:
- Debug: `app/build/outputs/apk/debug/app-debug.apk`
- Release: `app/build/outputs/apk/release/app-release.apk`

## Структура проекта

```
app/src/main/java/com/chordfinder/
├── data/
│   ├── Chord.kt                    # Модели данных (Chord, ChordPosition, Fret, Barre, Finger)
│   ├── ChordData.kt                # Загрузка JSON, нормализация названий, fallback на генератор
│   ├── ChordGenerator.kt           # Генерация аппликатур для всех инструментов
│   ├── guitar/
│   │   └── GuitarChords.kt         # Канонические позиции для гитары (60+ аккордов)
│   ├── ukulele/
│   │   └── UkuleleChords.kt        # Канонические позиции для укулеле (80+ аккордов)
│   └── piano/
│       └── PianoChords.kt          # Канонические позиции для пианино (ноты + пальцы)
├── ui/
│   ├── ChordFinderApp.kt           # Главный экран с ViewModel
│   ├── components/
│   │   ├── ChordDiagram.kt         # Отрисовка диаграмм (гитара, укулеле, пианино)
│   │   └── InstrumentTabs.kt       # Табы инструментов
│   └── theme/
└── MainActivity.kt
```

## Документация

- [PROJECT.md](docs/PROJECT.md) — описание проекта, стек, архитектура
- [SPEC.md](SPEC.md) — спецификация требований
- [BACKLOG.md](docs/BACKLOG.md) — предложения по улучшению
- [ERRORLOG.md](ERRORLOG.md) — журнал ошибок и решений
- [NB.md](NB.md) — важные заметки и инсайты
