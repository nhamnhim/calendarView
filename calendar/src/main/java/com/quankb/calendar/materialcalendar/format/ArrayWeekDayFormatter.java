package com.quankb.calendar.materialcalendar.format;

public class ArrayWeekDayFormatter implements WeekDayFormatter {

    private final CharSequence[] weekDayLabels;

    public ArrayWeekDayFormatter(CharSequence[] weekDayLabels) {
        if (weekDayLabels == null) {
            throw new IllegalArgumentException("Cannot be null");
        }
        if (weekDayLabels.length != 7) {
            throw new IllegalArgumentException("Array must contain exactly 7 elements");
        }
        this.weekDayLabels = weekDayLabels;
    }
    @Override
    public CharSequence format(int dayOfWeek) {
        return weekDayLabels[dayOfWeek - 1];
    }
}
