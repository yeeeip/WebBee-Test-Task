package org.nuzhd.task2;

import org.nuzhd.ProductionCalendarService;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in)) {

            DateTimeFormatter f = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss O");

            String input = getUserInput(in);

            ZonedDateTime zonedDateTime = ZonedDateTime.from(f.parse(input));
            ProductionCalendarService calendarService = new ProductionCalendarService();

            System.out.println(calendarService.checkDateAndLocalTime(zonedDateTime) ?
                    "Дата и время являются рабочими" :
                    "Дата и время не являются рабочими"
            );
        } catch (DateTimeParseException e) {
            System.out.println("Некорректный формат даты");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String getUserInput(Scanner in) {
        System.out.print("Введите дату, время, часовой пояс в мае 2024 года в формате дд.ММ.гггг чч:мм:сс пояс (пример 01.05.2024 16:15:30 GMT+4): ");

        String input = in.nextLine();

        return input;
    }
}
