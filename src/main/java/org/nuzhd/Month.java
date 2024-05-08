package org.nuzhd;

public class Month {

    private MonthName name;
    private Day[] monthDays;
    private int daysCount;

    public Month(MonthName name, Day[] monthDays, int daysCount) {
        this.name = name;
        this.monthDays = monthDays;
        this.daysCount = daysCount;
    }

    public MonthName getName() {
        return name;
    }

    public void setName(MonthName name) {
        this.name = name;
    }

    public Day[] getMonthDays() {
        return monthDays;
    }

    public int getDaysCount() {
        return daysCount;
    }

    public void setDaysCount(int daysCount) {
        this.daysCount = daysCount;
    }
}
