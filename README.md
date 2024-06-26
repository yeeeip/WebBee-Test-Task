# Описание заданий

**1 уровень:**  
Необходимо разработать метод, который будет получать на вход дату, а на выходе возвращать true или false в соответствии с производственным календарем на май 2024 года (https://www.consultant.ru/law/ref/calendar/proizvodstvennye/2024/).  
**true** - если дата является выходным (не рабочим днем)  
**false** - если дата является рабочим днем.  

**2 уровень:**
Добавить еще один метод для проверки даты и времени с учетом часового пояса на принадлежность к рабочему времени в соответствии с установленным графиком работы и производственным календарем. 
Дополнительно необходимо осуществлять проверку на время и возвращать:  
**true** - если дата и время НЕ являются рабочими в соответствии с производственным календарем и установленным графиком работы  
**false** - если дата и время являются рабочими в соответствии с производственным календарем и установленным графиком работы
Установленный график работы: 40-часовая 5-дневная рабочая неделя с двумя выходными днями (суббота и воскресенье). Рабочее время с 9.00 до 18.00 по Московскому времени, с 45-ти минутным перерывом на обед (может быть использован в любое время в течении рабочего дня, на результат работы метода не влияет).

## Структура проекта

В проекте есть два пакета: **org.nuzhd.task1** и **org.nuzhd.task2**  
В первом демонстрируется работа метода для первого уровня, во втором пакете - для второго.
Реализации обоих методов находятся в классе **ProductionCalendarService**.

Помимо этого, код сервиса покрыт unit - тестами, их можно найти в директории **test**.  
Чтобы запустить unit тесты вам понадобиться фреймворк JUnit v.5.8.1, его можно скачать прямо в IDE (если вы используете Intellij IDEA), либо загрузить отдельно и подключить к проекту.