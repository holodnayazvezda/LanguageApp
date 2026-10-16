# LanguageApp

Учебное приложение для изучения языков на Kotlin и Jetpack Compose. Включает выбор языка, вводный сценарий, авторизацию, упражнения, результат ответа и профиль. Сетевой слой использует Retrofit, зависимости связываются через Koin.

## Сборка и запуск

Откройте корень проекта в Android Studio, установите Android SDK 36 и выполните синхронизацию Gradle. Используйте JDK, совместимый с версией Android Gradle Plugin проекта; настройки Java указаны в `app/build.gradle.kts`. Минимальная версия устройства — Android API 27.

Для сборки отладочного APK:

```sh
sh gradlew :app:assembleDebug
```

В Windows: `gradlew.bat :app:assembleDebug`. APK появится в `app/build/outputs/apk/debug/`. Для запуска выберите модуль `app` и устройство или эмулятор в Android Studio.

## Устройство проекта

API настраивается в `app/src/main/java/com/example/languageapp/data/di/NetworkModule.kt`. По умолчанию используется `http://10.0.2.2:5000/`: в Android Emulator это адрес компьютера с запущенным сервером. Для физического устройства укажите доступный ему адрес. Контракт API находится в `data/network/LanguageAppApi.kt`; часть демонстрационных данных — в `common/Constants.kt`.
