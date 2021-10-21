package dao;

import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileNationalHolidayDao implements NationalHolidayDao {

    private List<LocalDate> nationalHolidays;

    public FileNationalHolidayDao(String file) throws Exception {
        nationalHolidays= new ArrayList<>();
        try {
            Scanner reader = new Scanner(Paths.get(file));
            while (reader.hasNextLine()) {
                // Dates are expcected to be in the format of Day.Month.Year e.g. 1.1.2021
                String[] parts = reader.nextLine().split("\\.");
                LocalDate d = LocalDate.of(
                    Integer.parseInt(parts[2]),
                    Integer.parseInt(parts[1]),
                    Integer.parseInt(parts[0])
                );
                nationalHolidays.add(d);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        
    }

    @Override
    public List<LocalDate> getAll() {
        return nationalHolidays;
    }
    
}
