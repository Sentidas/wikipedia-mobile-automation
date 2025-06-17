
# 📱 Wikipedia Mobile Automation Framework

Автоматизированный проект для тестирования мобильного приложения Wikipedia (Android) с использованием:

✅ Appium (Mobile Automation)  
✅ Selenide (UI-обертка)  
✅ JUnit 5 (тестовый фреймворк)  
✅ Gradle (сборка)  
✅ Java 17+  
✅ Allure (отчёты)  
✅ Jenkins (планируется для CI/CD)  
✅ Android Emulator API 30+

---

## ⚙️ Установка

1. Клонировать репозиторий:

```bash
git clone https://github.com/Sentidas/wikipedia-mobile-automation.git
```

2. Установить зависимости (Node.js, npm, Appium).

3. Запустить Appium сервер:

```bash
appium server
```

4. Запустить Android эмулятор

---
### Запуск через Gradle

#### Запуск всех тестов:

```bash
./gradlew clean test
```

#### Запуск отдельного теста:

```bash
./gradlew clean test --tests tests.SearchTest
```

---

## 📊 Генерация отчётов Allure

#### Формирование отчёта:

```bash
allure generate build/allure-results --clean -o build/allure-report
```

#### Запуск локального сервера отчёта:

```bash
allure serve build/allure-results
```

#### Примеры Allure-отчётов:

## 📊 Примеры Allure-отчётов

### Общая сводка:

<a href="https://raw.githubusercontent.com/Sentidas/wikipedia-mobile-automation/main/media/screen2.png">
  <img src="media/screen2.png" width="700">
</a>

### Тесты:

<a href="https://raw.githubusercontent.com/Sentidas/wikipedia-mobile-automation/main/media/screen1.png">
  <img src="media/screen2.png" width="700">
</a>

### Пример упавшего теста:

<a href="https://raw.githubusercontent.com/Sentidas/wikipedia-mobile-automation/main/media/screen3.png">
  <img src="media/screen2.png" width="700">
</a>

---

## 🎞 Демонстрация выполнения тестов

<div align="center">

### 📌 Примеры сценариев

<table>
  <tr>
    <td align="center"><b>Удаление сохраненной статьи</b></td>
    <td align="center"><b>Сохранение результатов поиска после сворачивания</b></td>
  </tr>
  <tr>
    <td><img src="media/mobile_test1.gif" width="300"></td>
    <td><img src="media/mobile_test2.gif" width="300"></td>
  </tr>
</table>

</div>

