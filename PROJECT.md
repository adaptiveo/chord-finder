# PROJECT - Chord Finder

**Статус:** [x] В разработке / [ ] В продакшене / [ ] Заморожен  
**Последнее обновление:** 2026-04-24 (загружено на GitHub)  
**Ответственный:** @user  
**GitHub:** https://github.com/adaptiveo/chord-finder  

## Описание

Android-приложение для отображения аппликатур аккордов на гитаре, фортепиано и укулеле.

Пользователь вводит название аккорда (например, "C", "Am", "G7") и приложение отображает все возможные позиции для выбранного инструмента.

## Стек технологий

- **Язык:** Kotlin 1.9
- **Фреймворк:** Android Native + Jetpack Compose
- **UI:** Jetpack Compose with Material Design 3
- **Архитектура:** MVVM (ViewModel + StateFlow)
- **Min SDK:** 26 (Android 8.0)
- **Target SDK:** 34 (Android 14)
- **Сборка:** Gradle 8.4 с Kotlin DSL
- **Build tool:** Gradle

## Структура проекта

```
chord-finder/
├── app/
│   ├── src/main/java/com/chordfinder/
│   │   ├── MainActivity.kt
│   │   ├── data/
│   │   │   ├── Chord.kt
│   │   │   └── ChordData.kt
│   │   └── ui/
│   │       ├── ChordFinderApp.kt
│   │       ├── components/
│   │       │   └── ChordDiagram.kt
│   │       └── theme/
│   │           ├── Color.kt
│   │           └── Theme.kt
│   └── build.gradle.kts
├── docs/              # Документация
│   ├── PROJECT.md     # Этот файл
│   ├── ERRORLOG.md    # Журнал ошибок
│   ├── NB.md          # Nota Bene (важные заметки)
│   ├── BACKLOG.md     # Предложения по улучшению
│   └── adr/           # Architecture Decision Records
│       ├── ADR-001-*.md
│       └── ADR-002-*.md
├── gradle/
├── build.gradle.kts
├── settings.gradle.kts
└── README.md
```

## Запуск локально

```bash
# Установка зависимостей
# Android Studio автоматически подтянет зависимости Gradle

# Настройка окружения
# Убедитесь, что установлен Android SDK

# Сборка Debug APK
./gradlew assembleDebug
```

## Сборка и деплой

```bash
# Debug сборка
./gradlew assembleDebug

# Release сборка
./gradlew assembleRelease

# APK располагается:
# Debug:   app/build/outputs/apk/debug/app-debug.apk
# Release: app/build/outputs/apk/release/app-release.apk
```

## Основные команды

| Команда | Описание |
|---------|----------|
| `./gradlew assembleDebug` | Сборка Debug APK |
| `./gradlew assembleRelease` | Сборка Release APK |
| `./gradlew clean` | Очистка сборки |
| `./gradlew build` | Полная сборка проекта |

## Последние изменения

| Дата | Событие |
|------|---------|
| 2026-04-24 | Проект загружен на GitHub (публичный репозиторий) |
| 2026-04-22 | Добавлено автодополнение с dropdown (BACK-001) |
| 2026-04-22 | Исправлен баг dropdown (ERR-009) |
| 2026-04-22 | Реализована генерация аппликатур для гитары/укулеле |

## Функциональность

### Основные фичи
1. **Chord Input** — Поле ввода для названия аккорда (например, "C", "Dm7", "F#m")
2. **Autocomplete Dropdown** — Подсказки при вводе (C → C, C7, Cm, Cmaj7...)
3. **Instrument Tabs** — Табы: Guitar | Piano | Ukulele
4. **Chord Diagram Display** — Визуальная диаграмма с позициями пальцев
5. **Multiple Positions** — Прокрутка всех доступных позиций

### UI/UX
- Material Design 3, чистый минималистичный стиль
- Поддержка динамических цветов / темная и светлая темы
- Один экран: поиск → табы → область диаграммы

## Архитектурные решения (ADR)

| ADR | Дата | Тема | Статус |
|-----|------|------|--------|
| [ADR-001](docs/adr/ADR-001-material3-dynamic-colors.md) | 2026-04-22 | Material 3 Dynamic Colors | ✅ Принято |
| [ADR-002](docs/adr/ADR-002-autocomplete-dropdown.md) | 2026-04-22 | Autocomplete Dropdown | ✅ Принято |

> Каждое значимое изменение (не багфикс) оформляется как ADR в папке `adr/`

## Известные баги (ERRORLOG)

| ERR | Дата | Описание | Статус |
|-----|------|----------|--------|
| [ERR-010](ERRORLOG.md) | 2026-04-22 | Неверные данные аппликатур для гитары и укулеле | ❌ Требует исправления |
| [ERR-009](ERRORLOG.md) | 2026-04-22 | Dropdown открывался повторно после выбора | ✅ Исправлено |
| [ERR-008](ERRORLOG.md) | 2026-04-22 | Gadd11 показывался как Gadd9 | ✅ Исправлено |
| [ERR-007](ERRORLOG.md) | 2026-04-22 | MethodTooLargeException при добавлении аккордов | ✅ Исправлено |
| [ERR-006](ERRORLOG.md) | 2026-04-22 | SUS2 парсился как SUS2SUS (двойная замена) | ✅ Исправлено |

## Активные задачи (BACKLOG)

| ID | Приоритет | Описание | Статус |
|----|-----------|----------|--------|
| [BACK-018](docs/BACKLOG.md) | P2 | Корректные данные аппликатур для гитары и укулеле | 📋 В плане |
| [BACK-017](docs/BACKLOG.md) | P2 | Отключение табов для несуществующих аккордов | 📋 В плане |
| [BACK-016](docs/BACKLOG.md) | P1 | Автоопределение раскладки клавиатуры (Cyrillic → Latin) | 📋 В плане |
| [BACK-002](docs/BACKLOG.md) | P1 | История и избранное | 📋 В плане |

> Полный список ошибок в файле [ERRORLOG.md](ERRORLOG.md)

## Ссылки

- Локальный репозиторий: `C:\gvv\AI\projects\chord-finder`
- GitHub: https://github.com/adaptiveo/chord-finder
- Документация: [SPEC.md](SPEC.md), [PROJECT.md](docs/PROJECT.md)

## Контакты

- Разработчик: User
