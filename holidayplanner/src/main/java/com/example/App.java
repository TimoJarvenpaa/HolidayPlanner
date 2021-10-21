package com.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import domain.*;
import ui.*;
import dao.*;

public class App {
    public static void main( String[] args ) {

        IO io = new ConsoleIO();
        List<LocalDate> nationalHolidays = new ArrayList<LocalDate>();

        // The national holidays used by the app will be taken from holidays.txt file in the root directory of the project
        try {
            FileNationalHolidayDao dao = new FileNationalHolidayDao("holidays.txt");
            nationalHolidays = dao.getAll();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        HolidayPlanner planner = new HolidayPlanner(nationalHolidays);
        ConsoleUI ui = new ConsoleUI(io, planner);
        ui.run();
    }
}
