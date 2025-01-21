FROM openjdk:17-jdk-slim

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем файл gradlew и другие необходимые файлы
COPY ./gradlew .
COPY ./gradle gradle
COPY ./build.gradle .
COPY ./settings.gradle .
COPY ./src ./src

# Устанавливаем права на выполнение для gradlew
RUN chmod +x gradlew

# Устанавливаем зависимости
RUN ./gradlew build --no-daemon

# Указываем команду для запуска приложения
CMD ["./gradlew", "bootRun"]
