package domain;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class HolidayPlannerTest {

    List<LocalDate> nationalHolidays;
    HolidayPlanner planner;

    @Before
    public void setUp() {
        // Generate a mock national holiday list for injection
        nationalHolidays = new ArrayList<LocalDate>();
        nationalHolidays.add(LocalDate.of(2021, 1, 1));
        nationalHolidays.add(LocalDate.of(2021, 1, 6));
        nationalHolidays.add(LocalDate.of(2021, 4, 2));
        nationalHolidays.add(LocalDate.of(2021, 4, 5));
        nationalHolidays.add(LocalDate.of(2021, 5, 13));
        nationalHolidays.add(LocalDate.of(2021, 6, 20));
        nationalHolidays.add(LocalDate.of(2021, 12, 6));
        nationalHolidays.add(LocalDate.of(2021, 12, 24));

        planner = new HolidayPlanner(nationalHolidays);

    }
    
    @Test
    public void JanuaryHolidayDaysAreCountedCorrectly() {
        // 1.1.2021 - 8.1.2021 includes 8 total days but also two national holidays and a Sunday that do not consume holiday days hence the result should be 5
        LocalDate startDate = LocalDate.of(2021, 1, 1);
        LocalDate endDate = LocalDate.of(2021, 1, 8);
        int result = planner.countHolidayDays(startDate, endDate);
        assertEquals(5, result);
    }

    @Test
    public void DecemberHolidayDaysAreCountedCorrectly() {
        // 3.12.2021 - 17.12.2021 includes 15 total days but also one national holiday and two Sundays that do not consume holiday days hence the result should be 12
        LocalDate startDate = LocalDate.of(2021, 12, 3);
        LocalDate endDate = LocalDate.of(2021, 12, 17);
        int result = planner.countHolidayDays(startDate, endDate);
        assertEquals(12, result);
    }
}