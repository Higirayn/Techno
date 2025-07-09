# TZ Application

Веб-приложение на Spring Boot с REST API для управления пользователями, контактами, валютой, локациями и картами.

## 🚀 Технологии

- **Java 17**
- **Spring Boot 3.5.3**
- **Spring Security** с JWT аутентификацией
- **Spring Data JPA** для работы с базой данных
- **PostgreSQL** - основная база данных
- **H2** - база данных для тестов
- **Docker & Docker Compose** для контейнеризации
- **Swagger/OpenAPI** для документации API
- **Lombok** для уменьшения boilerplate кода
- **Bucket4j** для rate limiting
- **Spring Mail** для отправки email

## 📋 Функциональность

### 🔐 Аутентификация и авторизация
- Регистрация пользователей
- Вход в систему с JWT токенами
- Получение профиля пользователя

### 📞 Управление контактами
- CRUD операции с контактами

### 💱 Валютные операции
- Работа с валютными курсами
- Конвертация валют

### 📍 Локации
- Управление географическими данными
- Работа с координатами

### 🗺️ Яндекс Карты
- Интеграция с Яндекс Картами
- Управление маркерами на карте

## 🛠️ Установка и запуск

### Предварительные требования
- Java 17 или выше
- Docker и Docker Compose
- Gradle (или используйте gradlew wrapper)

### Запуск с Docker Compose (рекомендуется)

1. Клонируйте репозиторий:
```bash
git clone <repository-url>
cd tz
```

2. Запустите приложение с помощью Docker Compose:
```bash
docker-compose up -d
```

Приложение будет доступно по адресу: http://localhost:8080

### Локальный запуск

1. Установите PostgreSQL и создайте базу данных:
```sql
CREATE DATABASE tz_db;
CREATE USER tz_user WITH PASSWORD 'tz_password';
GRANT ALL PRIVILEGES ON DATABASE tz_db TO tz_user;
```

2. Запустите приложение:
```bash
./gradlew bootRun
```

### Запуск тестов
```bash
./gradlew test
```

## 📚 API Документация

После запуска приложения, Swagger UI доступен по адресу:
- http://localhost:8080/swagger-ui.html

OpenAPI спецификация:
- http://localhost:8080/api-docs

## 🔧 Конфигурация

### Основные настройки (application.properties)

```properties
# База данных
spring.datasource.url=jdbc:postgresql://localhost:5432/tz_db
spring.datasource.username=tz_user
spring.datasource.password=tz_password

# JWT
app.jwt.secret=your-secret-key
app.jwt.expiration-ms=3600000

# CORS
spring.web.cors.allowed-origins=http://localhost:3000
```

### Профили

- **dev** - для разработки
- **test** - для тестирования
- **prod** - для продакшена

## 🏗️ Структура проекта

```
src/main/java/org/example/tz/
├── config/          # Конфигурации
├── controller/      # REST контроллеры
├── dto/            # Data Transfer Objects
├── exception/      # Обработка исключений
├── model/          # Модели данных
├── repository/     # Репозитории JPA
├── security/       # Конфигурация безопасности
├── service/        # Бизнес-логика
└── util/           # Утилиты
```

## 🔒 Безопасность

- JWT токены для аутентификации
- Spring Security для авторизации
- Rate limiting с Bucket4j
- CORS настройки
- Валидация входных данных

## 📊 Мониторинг

Spring Boot Actuator включен для мониторинга:
- http://localhost:8080/actuator

## 🐳 Docker

### Сборка образа
```bash
docker build -t tz-app .
```

### Запуск контейнера
```bash
docker run -p 8080:8080 tz-app
```

## 🤝 Разработка

