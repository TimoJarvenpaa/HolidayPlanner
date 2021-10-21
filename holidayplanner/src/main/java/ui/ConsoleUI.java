package ui;

import java.time.DateTimeException;
import java.time.LocalDate;

import domain.HolidayPlanner;

public class ConsoleUI {

    private IO io;
    private HolidayPlanner holidayPlanner;

    public ConsoleUI(IO io, HolidayPlanner holidayPlanner) {
        this.io = io;
        this.holidayPlanner = holidayPlanner;
    }

    public void run() {
        while (true) {
            try {

                LocalDate startDate;
                LocalDate endDate;

                io.println("----------");
                io.println("Enter the start date of the holiday.");
                io.print("Year: ");
                int y = io.nextInt();
                io.print("Month: ");
                int m = io.nextInt();
                io.print("Day: ");
                int d = io.nextInt();
                try {
                    startDate = LocalDate.of(y, m, d);
                }
                catch (DateTimeException e) {
                    System.err.println("Invalid date.");
                    continue;
                }
                io.println("----------");

                io.println("Enter the end date of the holiday.");
                io.print("Year: ");
                int y2 = io.nextInt();
                io.print("Month: ");
                int m2 = io.nextInt();
                io.print("Day: ");
                int d2 = io.nextInt();
                try {
                    endDate = LocalDate.of(y2, m2, d2);
                }
                catch (DateTimeException e) {
                    System.err.println("Invalid date.");
                    continue;
                }
                io.println("----------");

                if (!holidayPlanner.validChronology(startDate, endDate)) {
                    io.println("The dates must be given in chronological order.");
                    continue;
                }

                if (!holidayPlanner.validSpanLength(startDate, endDate)) {
                    io.println("The maximum length of the time span is 50 days.");
                    continue;
                }

                if (!holidayPlanner.validHolidayPeriod(startDate, endDate)) {
                    io.println("The selected time span can't exceed the yearly holiday period.");
                    continue;
                }

                int result = holidayPlanner.countHolidayDays(startDate, endDate);
                io.println("The selected time span will consume " + result + " holiday days.");

            }
            catch (NumberFormatException e) {
                System.err.println("Invalid input. Please use numbers only.");
                continue;
            }
        }
    }
    
}
