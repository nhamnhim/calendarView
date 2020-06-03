package com.quankb.calendar.materialcalendar.format;

import com.quankb.calendar.materialcalendar.CalendarUtils;

public interface WeekDayFormatter {
    CharSequence format(int dayOfWeek);

    public static final WeekDayFormatter DEFAULT = new CalendarWeekDayFormatter(CalendarUtils.getInstance());
}
