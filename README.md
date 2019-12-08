# propeller-qa-battle
 Propeller Championship task

Баглист собран в файле
PropellerBugList.xlsx

Для запуска тестов используется BDDRunner.
Настройки тут: BDDRunnerSettings.png

Для запуска всех тестов:
-ea -Dcucumber.options="--tags @all

Для запуска тестов по авторизации:
-ea -Dcucumber.options="--tags @authorization

Для запуска тестов по статьям:
-ea -Dcucumber.options="--tags @articles


Браузер задается в test.properties

Путь к файлу со скачанной статьей задается в test.properties

Собираются логи и снимки экрана:
в папку logs
в папку allure-reuslts
в папку resources/screenshots
