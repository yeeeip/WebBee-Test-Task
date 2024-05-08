package org.nuzhd.task1;

import org.junit.jupiter.api.Test;
import org.nuzhd.ProductionCalendarService;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ProductionCalendarServiceTest {

    private final ProductionCalendarService productionCalendarService = new ProductionCalendarService();

    @Test
    void checkDate_WhenDayOff_ShouldReturnTrue() {

        // given
        LocalDate date = LocalDate.of(2024, 5, 1);

        // when
        boolean isDayOff = productionCalendarService.checkDate(date);

        // then
        assertTrue(isDayOff);
    }

    @Test
    void checkDate_WhenShortDay_ShouldReturnFalse() {

        // given
        LocalDate date = LocalDate.of(2024, 5, 8);

        // when
        boolean isDayOff = productionCalendarService.checkDate(date);

        //then
        assertFalse(isDayOff);
    }

    @Test
    void checkDate_WhenWorkDay_ShouldReturnFalse() {

        // given
        LocalDate date = LocalDate.of(2024, 5, 13);

        // when
        boolean isDayOff = productionCalendarService.checkDate(date);

        //then
        assertFalse(isDayOff);
    }

    @Test
    void checkDate_WhenWrongDate_ShouldThrow() {

        // given
        LocalDate date = LocalDate.of(2024, 6, 1);

        // then
        assertThrows(IllegalArgumentException.class, () ->
                productionCalendarService.checkDate(date)
        );
    }

}
