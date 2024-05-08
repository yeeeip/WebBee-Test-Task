package org.nuzhd;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

public class ProductionCalendarService {

    private Map<String, Month> calendar = new HashMap<>();

    public boolean checkDate(LocalDate date) {

        if (date.getMonth() != java.time.Month.MAY) {
            throw new IllegalArgumentException("Дата не относится к маю 2024 года");
        }

        if (calendar.isEmpty()) {
            initCalendar();
        }

        Month monthMay = calendar.get("MAY");

        int day = date.getDayOfMonth();

        Day dayOfMay = monthMay.getMonthDays()[day - 1];

        return dayOfMay.isDayOff();
    }

    public boolean checkDateAndLocalTime(ZonedDateTime dateTime) {
        if (dateTime.getMonth() != java.time.Month.MAY) {
            throw new IllegalArgumentException("Дата не относится к маю 2024 года");
        }

        if (calendar.isEmpty()) {
            initCalendar();
        }

        Month monthMay = calendar.get("MAY");

        Day dayOfMay = monthMay.getMonthDays()[dateTime.getDayOfMonth() - 1];

        ZonedDateTime moscowTime = dateTime.withZoneSameInstant(
                ZoneId.of("Europe/Moscow")
        );

        ZonedDateTime endOfWorkDay = ZonedDateTime.of(
                moscowTime.toLocalDate(),
                LocalTime.of(18, 0, 0),
                ZoneId.of("Europe/Moscow")
        );

        ZonedDateTime startOfWorkDay = ZonedDateTime.of(
                moscowTime.toLocalDate(),
                LocalTime.of(9, 0, 0),
                ZoneId.of("Europe/Moscow")
        );

        if (!dayOfMay.isDayOff()) {
            if (!dayOfMay.isShortDay()) {
                return moscowTime.isAfter(endOfWorkDay) || moscowTime.isBefore(startOfWorkDay);
            } else {
                return moscowTime.isAfter(endOfWorkDay.minusHours(1)) || moscowTime.isBefore(startOfWorkDay);
            }
        } else {
            return true;
        }
    }

    private void initCalendar() {

        Day[] monthDays = new Day[]{
                Day.dayOff(DayOfWeek.WEDNESDAY),
                new Day(DayOfWeek.THURSDAY, false, false),
                new Day(DayOfWeek.FRIDAY, false, false),
                Day.dayOff(DayOfWeek.SATURDAY),
                Day.dayOff(DayOfWeek.SUNDAY),

                new Day(DayOfWeek.MONDAY, false, false),
                new Day(DayOfWeek.TUESDAY, false, false),
                new Day(DayOfWeek.WEDNESDAY, false, true),
                Day.dayOff(DayOfWeek.THURSDAY),
                Day.dayOff(DayOfWeek.FRIDAY),
                Day.dayOff(DayOfWeek.SATURDAY),
                Day.dayOff(DayOfWeek.SUNDAY),

                new Day(DayOfWeek.MONDAY, false, false),
                new Day(DayOfWeek.TUESDAY, false, false),
                new Day(DayOfWeek.WEDNESDAY, false, false),
                new Day(DayOfWeek.THURSDAY, false, false),
                new Day(DayOfWeek.FRIDAY, false, false),
                Day.dayOff(DayOfWeek.SATURDAY),
                Day.dayOff(DayOfWeek.SUNDAY),

                new Day(DayOfWeek.MONDAY, false, false),
                new Day(DayOfWeek.TUESDAY, false, false),
                new Day(DayOfWeek.WEDNESDAY, false, false),
                new Day(DayOfWeek.THURSDAY, false, false),
                new Day(DayOfWeek.FRIDAY, false, false),
                Day.dayOff(DayOfWeek.SATURDAY),
                Day.dayOff(DayOfWeek.SUNDAY),

                new Day(DayOfWeek.MONDAY, false, false),
                new Day(DayOfWeek.TUESDAY, false, false),
                new Day(DayOfWeek.WEDNESDAY, false, false),
                new Day(DayOfWeek.THURSDAY, false, false),
                new Day(DayOfWeek.FRIDAY, false, false)
        };

        Month may = new Month(
                MonthName.MAY,
                monthDays,
                monthDays.length
        );

        this.calendar.put("MAY", may);
    }
}
