package com.quankb.calendar.materialcalendar;

import androidx.annotation.NonNull;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by Manh Quan on 4/28/2016.
 */
public class HaftMonthAdapter extends CalendarPagerAdapter<HaftMonthView> {

    HaftMonthAdapter(MaterialCalendarView mcv) {
        super(mcv);
    }
    @Override
    protected HaftMonthView createView(int position) {
        return new HaftMonthView(mcv, getItem(position), getFirstDayOfWeek());
    }

    @Override
    protected int indexOf(HaftMonthView view) {
        CalendarDay month = view.getMonth();
        return getRangeIndex().indexOf(month);
    }

    @Override
    protected boolean isInstanceOfView(Object object) {
        return object instanceof HaftMonthView;
    }

    @Override
    protected DateRangeIndex createRangeIndex(CalendarDay min, CalendarDay max) {
        return new HaftMonthly(min, max, getFirstDayOfWeek());
    }

    public static class HaftMonthly implements DateRangeIndex {


        private static final int DAYS_IN_WEEK = 14;
        private final CalendarDay min;
        private final int count;

        public HaftMonthly(@NonNull CalendarDay min, @NonNull CalendarDay max, int firstDayOfWeek) {
            this.min = getFirstDayOfWeek(min, firstDayOfWeek);
            this.count = weekNumberDifference(min, max);
        }

        @Override
        public int getCount() {
            return count;
        }

        @Override
        public int indexOf(CalendarDay day) {
            return weekNumberDifference(min, day);
        }

        @Override
        public CalendarDay getItem(int position) {
            long minMillis = min.getDate().getTime();
            long millisOffset = TimeUnit.MILLISECONDS.convert(
                    position * DAYS_IN_WEEK,
                    TimeUnit.DAYS);
            long positionMillis = minMillis + millisOffset;
            return CalendarDay.from(new Date(positionMillis));
        }

        private int weekNumberDifference(@NonNull CalendarDay min, @NonNull CalendarDay max) {
            long millisDiff = max.getDate().getTime() - min.getDate().getTime();
            long dayDiff = TimeUnit.DAYS.convert(millisDiff, TimeUnit.MILLISECONDS);
            return (int) (dayDiff /DAYS_IN_WEEK);
        }

        /*
         * Necessary because of how Calendar handles getting the first day of week internally.
         */
        private CalendarDay getFirstDayOfWeek(@NonNull CalendarDay min, int wantedFirstDayOfWeek) {
            Calendar calendar = Calendar.getInstance();
            min.copyTo(calendar);
            while (calendar.get(Calendar.DAY_OF_WEEK) != wantedFirstDayOfWeek) {
                calendar.add(Calendar.DAY_OF_WEEK, -1);
            }
            return CalendarDay.from(calendar);
        }
    }
}
