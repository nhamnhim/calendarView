package com.quankb.calendar.materialcalendar.format;

import com.quankb.calendar.materialcalendar.CalendarDay;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class DateFormatTitleFormatter implements TitleFormatter {

    private final DateFormat dateFormat;

    public DateFormatTitleFormatter() {
        this.dateFormat = new SimpleDateFormat(
                "MMMM yyyy", Locale.getDefault()
        );
    }

    public DateFormatTitleFormatter(DateFormat format) {
        this.dateFormat = format;
    }
    @Override
    public CharSequence format(CalendarDay day) {
        return dateFormat.format(day.getDate());
    }
}
