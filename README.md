## ПРЕДУСЛОВИЯ

* IntelliJ IDEA Community Edition
* AdoptOpenJDK 
* Docker
* Node.js

### Установка и запуск SUT

1. Склонировать репозиторий.
2. Запуcтить контейнер с базой данных MySQL/ PostgreSQL docker-compose up -d
3. Запустить джарник, java -jar aqa-shop.jar 
4. Запустить автотесты ./gradlew clean test
