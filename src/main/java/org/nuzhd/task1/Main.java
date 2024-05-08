package org.nuzhd.task1;

import org.nuzhd.ProductionCalendarService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in)) {

            DateTimeFormatter f = DateTimeFormatter.ofPattern("dd.MM.yyyy");

            String input = getUserInput(in);

            LocalDate formattedDate = LocalDate.from(f.parse(input));
            ProductionCalendarService calendarService = new ProductionCalendarService();

            System.out.println(calendarService.checkDate(formattedDate) ?
                    "Дата является выходным" :
                    "Дата не является выходным"
            );
        } catch (DateTimeParseException e) {
            System.out.println("Некорректный формат даты");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String getUserInput(Scanner in) {
        System.out.print("Введите дату в мае 2024 года в формате дд.мм.гггг (пример 01.05.2024): ");

        String input = in.nextLine();

        return input;
    }
}