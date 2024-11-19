# Email Notification API

Простое приложение для отправки email-уведомлений с поддержкой автоматической отправки по расписанию. Используется Spring Boot и встроенные возможности планировщика задач.

## Возможности

- **Единичная отправка писем**: Отправьте письмо на указанный email-адрес через HTTP-запрос.
- **Автоматическая отправка**: Уведомления отправляются на регулярной основе, время отправки можно настроить.
- **Гибкость настройки**: Возможность изменения расписания через cron-выражения.

---

## Требования

Для запуска вам понадобятся:

1. Java версии 17 или выше.
2. Maven для сборки приложения.
3. Учетные данные SMTP-сервера (например, Gmail).

---

## Настройка

Откройте файл `application.properties` и настройте его следующим образом:

```properties
```json
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=<ваш-email>
spring.mail.password=<пароль-для-приложения>
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true

scheduler.enabled=true
```

Замените <ваш-email> и <пароль-для-приложения> на свои данные. Для Gmail потребуется создать пароль для приложения через настройки безопасности аккаунта.
Использование API
Отправка email
Метод: GET
URL: /send-email

Параметры запроса:

Параметр	Тип	Описание
toEmail	String	Email-адрес получателя
Пример запроса:
```json
perl
Copy code
http://localhost:8080/send-email?toEmail=example@example.com
Ответ:
Успешный запрос: Успех!
```
Вместо example@example.com замените на тот email на который вы хотите отправить сообщение!

Автоматическая отправка писем
С помощью аннотации @Scheduled 
Расписание по умолчанию
Планировщик настроен на отправку писем каждые 10 секунд.

java
```json
@Scheduled(cron = "*/10 * * * * *", zone = "Asia/Bishkek")
public void sendScheduledEmail() {
    // Логика отправки email
}
```
Для отключения планировщика необходимо в application.properties
scheduler.enabled с true на false 
```json
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=<ваш-email>
spring.mail.password=<пароль-для-приложения>
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true

scheduler.enabled=false
