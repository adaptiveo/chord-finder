# ADR-002: Autocomplete Dropdown for Chord Input

**Дата:** 2026-04-22  
**Статус:** [x] Принято  
**Контекст:** #feature #ux #autocomplete  
**Автор:** @claude  

## Контекст

При вводе названия аккорда пользователь должен знать точный формат (например, "Cmaj7" vs "CMAJ7" vs "C7"). Это создаёт трение, особенно для новичков, которые не знают всех вариантов написания.

BACK-001 требует добавления dropdown с подсказками при вводе текста.

## Рассмотренные варианты

### Вариант 1: Material3 ExposedDropdownMenuBox
- **Плюсы:** Стандартный компонент Material3, хорошая интеграция с TextField
- **Минусы:** Сложная интеграция с существующим OutlinedTextField, требует полной переработки поля ввода
- **Оценка:** Слишком много изменений для существующего UI

### Вариант 2: DropdownMenu над существующим TextField
- **Плюсы:** Минимальные изменения существующего кода, простая реализация
- **Минусы:** Требует ручного управления позиционированием и состоянием
- **Оценка:** Оптимальный баланс простоты и функциональности

### Вариант 3: Отдельный экран поиска (SearchActivity)
- **Плюсы:** Место для расширенного поиска (фильтры по инструментам, избранное)
- **Минусы:** Требует навигации, больше кликов для пользователя
- **Оценка:** Перебор для текущей задачи

## Решение

Выбран вариант: **Вариант 1 — ExposedDropdownMenuBox (итоговая реализация)**

**Обоснование:**
`ExposedDropdownMenuBox` — стандартный Material3 компонент, обеспечивает лучший UX с анимациями, тенями и стрелкой-индикатором. Изначально казалось что он не работает, но проблема была в отсутствии ADB для тестирования на устройстве.

**Итоговая реализация:**

1. **ChordData.kt** — добавлены методы:
   - `getAllChordNames()` — возвращает все названия аккордов
   - `searchChords(query, maxResults)` — фильтрация по префиксу
   - Исправлен поиск `sus4` аккордов — JSON использует ключ `GSUS` вместо `GSUS4`

2. **ChordFinderApp.kt** — реализация через `ExposedDropdownMenuBox`:
   - `ExposedDropdownMenuBox` с `onExpandedChange` управлением
   - `OutlinedTextField` с `.menuAnchor()` modifier
   - `ExposedDropdownMenu` с `DropdownMenuItem` для suggestions
   - `ExposedDropdownMenuDefaults.TrailingIcon` как индикатор
   - Иконка очистки поля ввода

**Визуальные преимущества:**
- Плавная анимация открытия/закрытия
- Material3 стиль с тенями и elevation
- Стрелка-индикатор состояния dropdown
- Стандартное поведение как в системных приложениях Android
- Иконка очистки поля ввода

**Код:**
```kotlin
var query by remember { mutableStateOf("") }
var suggestions by remember { mutableStateOf(listOf<String>()) }
var expanded by remember { mutableStateOf(false) }
var justSelected by remember { mutableStateOf(false) } // Флаг для предотвращения повторного открытия

// Отслеживание ввода с защитой от повторного открытия
LaunchedEffect(query) {
    if (justSelected) {
        kotlinx.coroutines.delay(300)
        justSelected = false
        return@LaunchedEffect
    }
    if (query.length >= 1) {
        suggestions = ChordData.searchChords(query, maxResults = 8)
        expanded = suggestions.isNotEmpty()
    } else {
        expanded = false
    }
}

// ExposedDropdownMenuBox с Material3 стилем
ExposedDropdownMenuBox(
    expanded = expanded,
    onExpandedChange = { expanded = it },
    modifier = Modifier.fillMaxWidth()
) {
    OutlinedTextField(
        value = query,
        onValueChange = {
            query = it
            if (it.length >= 1) {
                suggestions = ChordData.searchChords(it, maxResults = 8)
                expanded = suggestions.isNotEmpty()
            } else {
                expanded = false
            }
        },
        modifier = Modifier.fillMaxWidth().menuAnchor(),
        singleLine = true,
        trailingIcon = {
            ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
        }
    )

    ExposedDropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false },
        modifier = Modifier.fillMaxWidth()
    ) {
        suggestions.forEach { chordName ->
            DropdownMenuItem(
                text = { Text(chordName) },
                onClick = {
                    justSelected = true // Установить флаг перед изменением query
                    query = chordName
                    expanded = false
                }
            )
        }
    }
}
```

## Последствия

### Положительные
- Пользователь видит доступные варианты при вводе первых букв
- Быстрый выбор без полного набора названия
- Открывает существующие варианты аккордов (C, C7, Cm, Cmaj7...)
- Работает со всеми инструментами (гитара, пианино, укулеле)

### Отрицательные / Риски
- Dropdown может перекрывать табы при большом количестве suggestions
- На маленьких экранах (5") может не хватать места
- Нет fuzzy search (только prefix match)

### Технический долг
- В будущем можно добавить debounce для уменьшения частоты поиска
- Можно кэшировать результаты поиска

### Известные баги и решения

**Баг:** Dropdown повторно открывался после выбора (ERR-009)
- **Симптом:** При выборе "G" список закрывался и тут же открывался снова
- **Причина:** `LaunchedEffect(query)` реагировал на изменение `query` и пересчитывал suggestions
- **Решение:** Флаг `justSelected` с задержкой 300ms для пропуска одного цикла LaunchedEffect

## Связанные документы

- BACKLOG.md: BACK-001 (Autocomplete)
- ChordFinderApp.kt: UI реализация
- ChordData.kt: логика поиска

## Чек-лист реализации

- [x] Код написан
- [x] Компиляция проходит успешно
- [x] Реализовано через ExposedDropdownMenuBox
- [x] Исправлен поиск Gsus4 (GSUS → GSUS4 mapping)
- [x] Исправлен баг с повторным открытием dropdown (ERR-009)
- [x] Тесты на устройстве — РАБОТАЕТ
- [x] Документация обновлена
- [x] BREAKING CHANGES: нет
