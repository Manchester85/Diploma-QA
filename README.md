## ПРЕДУСЛОВИЯ

* IntelliJ IDEA Community Edition
* AdoptOpenJDK 
* Docker
* Node.js

### Установка и запуск SUT

1. Склонировать репозиторий.
2. Скачать на локальный компьютер Node.js
3. Перейти в папку gate-simulator командой cd gate-simulator
4. Запустить node.js командой npm start
5. Запуcтить контейнер с базой данных PostgreSQL docker-compose up -d
6. Запустить джарник, java -jar aqa-shop.jar 
7. Запустить автотесты ./gradlew clean test

### Для переключения базы данных на MySQL:

включить SUT командой
java -jar aqa-shop.jar --spring.datasource.url=jdbc:mysql://localhost:3306/app

запустить автотесты командой
./gradlew clean test -Ddb.url=jdbc:mysql://localhost:3306/app
