package com.quankb.calendar.materialcalendar.format;

import com.quankb.calendar.materialcalendar.CalendarUtils;

import java.util.Calendar;
import java.util.Locale;

public class CalendarWeekDayFormatter implements WeekDayFormatter {

    private final Calendar calendar;

    public CalendarWeekDayFormatter(Calendar calendar) {
        this.calendar = calendar;
    }

    public CalendarWeekDayFormatter() {
        this(CalendarUtils.getInstance());
    }
    @Override
    public CharSequence format(int dayOfWeek) {
        calendar.set(Calendar.DAY_OF_WEEK, dayOfWeek);
        return calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.getDefault());
    }
}
