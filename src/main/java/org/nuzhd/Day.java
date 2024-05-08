package org.nuzhd;

public class Day {

    private DayOfWeek name;
    private boolean isDayOff;
    private boolean isShortDay;

    public Day(DayOfWeek name, boolean isDayOff, boolean isShortDay) {
        this.name = name;
        this.isDayOff = isDayOff;
        this.isShortDay = isShortDay;
    }

    public static Day dayOff(DayOfWeek name) {
        return new Day(
                name,
                true,
                false
        );
    }

    public DayOfWeek getName() {
        return name;
    }

    public boolean isDayOff() {
        return isDayOff;
    }

    public boolean isShortDay() {
        return isShortDay;
    }
}
