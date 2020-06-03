package com.quankb.calendar.materialcalendar.format;

import androidx.annotation.NonNull;

import com.quankb.calendar.materialcalendar.CalendarDay;

public interface DayFormatter {

    @NonNull
    String format(@NonNull CalendarDay day);

    public static final DayFormatter DEFAULT = new DateFormatDayFormatter();
}
