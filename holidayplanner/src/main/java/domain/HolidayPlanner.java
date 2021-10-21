package domain;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class HolidayPlanner {

    private List<LocalDate> nationalHolidays;

    public HolidayPlanner(List<LocalDate> nationalHolidays) {
        this.nationalHolidays = nationalHolidays;
    }

    // Return the day of the week from a given date where Monday-Sunday corresponds to 1-7
    public static int getDayNumber(LocalDate date) {
        DayOfWeek day = date.getDayOfWeek();
        return day.getValue();
    }

    // Check that the start and end dates given by the user are in the correct chronological order
    public boolean validChronology(LocalDate startDate, LocalDate endDate) {
        return startDate.isBefore(endDate);
    }

    // Check that the selected time span is 50 days at maximum
    public boolean validSpanLength(LocalDate startDate, LocalDate endDate) {
        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
        return daysBetween <= 50;
    }

    // Check that the selected time span is within the same holiday period i.e. April 1st - March 31st
    public boolean validHolidayPeriod(LocalDate startDate, LocalDate endDate) {
        int counter = 0;
        for (LocalDate date = startDate; date.isBefore(endDate) || date.equals(endDate); date = date.plusDays(1)){
            if (date.getMonth().getValue() == 3 && date.getDayOfMonth() == 31) {
                counter++;
            }
        }

        for (LocalDate date = startDate; date.isBefore(endDate) || date.equals(endDate); date = date.plusDays(1)){
            if (date.getMonth().getValue() == 4 && date.getDayOfMonth() == 1) {
                counter++;
            }
        }
        return counter < 2;
    }

    // Return the number of days within the given time span that consume holiday days. Sundays and national holidays do not consume those.
    public int countHolidayDays(LocalDate startDate, LocalDate endDate) {
        int counter = 0;
        for (LocalDate date = startDate; date.isBefore(endDate) || date.equals(endDate); date = date.plusDays(1)){
            if (!(getDayNumber(date) == 7)) {
                if (!nationalHolidays.contains(date))
                    counter++;
            }
        }
        return counter;
    }   
}
