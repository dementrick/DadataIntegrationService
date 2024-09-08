# Проект "Интеграция с сервисом Dadata"

Данный проект выполнен с использованием spring - boot. Реализация содержит два эндпоинта: post и get.

Post метод позволяет получить полное имя и гендер на основе подсказок по ФИО сервиса dadata.

Get метод позволяет получить полный адрес состоящий из полей: полный адрес, страна, город, почтовый индекс. Получение осуществляется за счет интеграции с сервисом подсказок по адресам dadata.

## Стек технологий

В данном проекте интеграция с сервисом dadata реализована при помощи restTemplate, также в проекте содержится swagger для описания api.

Конфигурация проекта реализована при помощи application.yml файлов.

Настроена базовая аутентификация с использованием SpringSecurity. 

Проект протестирован интеграционными тестами, в которых мокируется интеграция с dadata.
