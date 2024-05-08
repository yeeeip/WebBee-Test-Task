package org.nuzhd.task2;

import org.junit.jupiter.api.Test;
import org.nuzhd.ProductionCalendarService;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ProductionCalendarServiceTest {

    private final ProductionCalendarService productionCalendarService = new ProductionCalendarService();

    @Test
    void checkDateAndLocalTime_WhenDayOff_ShouldReturnTrue() {

        // given
        ZonedDateTime zonedDateTime = ZonedDateTime.of(
                2024, 5, 1, 12, 0, 0, 0, ZoneId.of("Europe/Moscow")
        );

        // when
        boolean isDayOff = productionCalendarService.checkDateAndLocalTime(zonedDateTime);

        //then
        assertTrue(isDayOff);
    }

    @Test
    void checkDateAndLocalTime_WhenWorkDateAndTime_ShouldReturnFalse() {

        // given
        ZonedDateTime zonedDateTime = ZonedDateTime.of(
                2024, 5, 6, 12, 0, 0, 0, ZoneId.of("Europe/Moscow")
        );

        // when
        boolean isDayOff = productionCalendarService.checkDateAndLocalTime(zonedDateTime);

        //then
        assertFalse(isDayOff);
    }

    @Test
    void checkDateAndLocalTime_WhenWorkDayAndNotWorkTime_ShouldReturnTrue() {

        // given
        ZonedDateTime zonedDateTime = ZonedDateTime.of(
                2024, 5, 6, 18, 0, 30, 0, ZoneId.of("Europe/Moscow")
        );

        // when
        boolean isDayOff = productionCalendarService.checkDateAndLocalTime(zonedDateTime);

        //then
        assertTrue(isDayOff);
    }

    @Test
    void checkDateAndLocalTime_WhenWorkDayAndWorkTimeConsideringTimeZone_ShouldReturnFalse() {

        // given
        ZonedDateTime zonedDateTime = ZonedDateTime.of(
                2024, 5, 6, 19, 30, 0, 0, ZoneId.of("GMT+5")
        );

        // when
        boolean isDayOff = productionCalendarService.checkDateAndLocalTime(zonedDateTime);

        //then
        assertFalse(isDayOff);
    }

    @Test
    void checkDateAndLocalTime_WhenShortDayAndNotWorkTime_ShouldReturnTrue() {

        // given
        ZonedDateTime zonedDateTime = ZonedDateTime.of(
                2024, 5, 8, 17, 30, 0, 0, ZoneId.of("GMT+3")
        );

        // when
        boolean isDayOff = productionCalendarService.checkDateAndLocalTime(zonedDateTime);

        //then
        assertTrue(isDayOff);
    }

    @Test
    void checkDateAndLocalTime_WhenShortDayAndWorkTimeConsideringTimeZone_ShouldReturnFalse() {

        // given
        ZonedDateTime zonedDateTime = ZonedDateTime.of(
                2024, 5, 8, 5, 45, 50, 0, ZoneId.of("GMT-1")
        );

        // when
        boolean isDayOff = productionCalendarService.checkDateAndLocalTime(zonedDateTime);

        //then
        assertFalse(isDayOff);
    }

    @Test
    void checkDateAndLocalTime_WhenWrongDate_ShouldThrow() {

        // given
        ZonedDateTime zonedDateTime = ZonedDateTime.of(
                2024, 6, 8, 17, 30, 0, 0, ZoneId.of("GMT+3")
        );

        // then
        assertThrows(IllegalArgumentException.class, () ->
                productionCalendarService.checkDateAndLocalTime(zonedDateTime));
    }
}
