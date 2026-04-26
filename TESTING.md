# Тесты в проекте Chord Finder

## Обзор

В проекте настроена система модульного тестирования для проверки основной бизнес-логики.

## Структура тестов

```
app/src/test/java/com/chordfinder/
├── data/
│   ├── ChordGeneratorTest.kt    # Тесты генератора аккордов
│   └── ChordDataTest.kt         # Тесты обработки данных аккордов
└── ui/components/
    └── ChordDiagramTest.kt      # Тесты компонентов отрисовки
```

## Запуск тестов

### Все тесты
```bash
./gradlew test
```

### Только debug тесты
```bash
./gradlew testDebugUnitTest
```

### Только release тесты
```bash
./gradlew testReleaseUnitTest
```

### Тесты с очисткой кеша
```bash
./gradlew cleanTest test --rerun-tasks
```

## Покрытие тестами

### ChordGeneratorTest (45 тестов)

| Категория | Тесты |
|-----------|-------|
| Парсинг названий аккордов | 10 |
| Формулы аккордов | 6 |
| Генерация позиций для гитары | 9 |
| Генерация позиций для укулеле | 2 |
| Поиск позиций нот | 2 |
| Тесты барре | 2 |
| generateMissingPositions | 2 |

**Ключевые тестируемые функции:**
- `parseChordName()` - разбор названий аккордов (C, Cm, C7, Csus2, etc.)
- `getChordNotes()` - получение нот аккорда по формуле
- `generateChordPosition()` - генерация аппликатуры для инструмента
- `findNotePositions()` - поиск позиций ноты на грифе
- `findBarres()` - определение барре
- `generateMissingPositions()` - генерация недостающих позиций

### ChordDataTest (20 тестов)

| Категория | Тесты |
|-----------|-------|
| Нормализация названий | 14 |
| Поиск аккордов (regex) | 4 |
| Поиск по префиксу | 3 |

**Ключевые тестируемые функции:**
- `getNormalizedName()` - нормализация названий аккордов
- `findChordByKey()` - поиск аккорда по ключу
- `searchChords()` - поиск аккордов по префиксу

### ChordDiagramTest (10 тестов)

| Категория | Тесты |
|-----------|-------|
| Проверка данных барре | 4 |
| Логика isCoveredByBarre | 6 |

**Ключевые тестируемые сценарии:**
- Проверка правильности данных барре
- Проверка покрытия струн барре
- Логика исключения пальцев под барре

## Зависимости для тестирования

В `build.gradle.kts` добавлены:

```kotlin
testImplementation("junit:junit:4.13.2")
testImplementation("org.junit.jupiter:junit-jupiter:5.10.1")
testImplementation("org.mockito:mockito-core:5.8.0")
testImplementation("androidx.test:core-ktx:1.5.0")
```

## Конфигурация

В `build.gradle.kts` настроено:

```kotlin
testOptions {
    unitTests {
        isIncludeAndroidResources = true
    }
}
```

## Результаты тестов

Отчеты о тестах сохраняются в:
- `app/build/test-results/testDebugUnitTest/`
- `app/build/test-results/testReleaseUnitTest/`

HTML-отчет (при настройке):
- `app/build/reports/tests/`

## Примеры тестов

### Тест парсинга аккорда
```kotlin
@Test
fun `parseChordName - минорные аккорды`() {
    val result = ChordGenerator.parseChordName("Cm")
    assertNotNull(result)
    assertEquals(0, result!!.first)
    assertEquals("M", result.second) // M = minor
}
```

### Тест генерации позиции
```kotlin
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
```

## Добавление новых тестов

1. Создайте файл теста в соответствующей директории
2. Используйте аннотации `@Test` из JUnit 5
3. Используйте утверждения из `org.junit.jupiter.api.Assertions.*`
4. Запустите тесты командой `./gradlew test`

## Непрерывная интеграция

Тесты автоматически запускаются при:
- Сборке debug версии
- Сборке release версии
- Запросе `./gradlew test`
