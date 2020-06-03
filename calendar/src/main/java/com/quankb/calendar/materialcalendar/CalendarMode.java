package com.quankb.calendar.materialcalendar;

public enum CalendarMode {

    MONTHS(6),HAFTMONTH(2),
    WEEKS(1);

    final int visibleWeeksCount;

    CalendarMode(int visibleWeeksCount) {
        this.visibleWeeksCount = visibleWeeksCount;
    }
}
