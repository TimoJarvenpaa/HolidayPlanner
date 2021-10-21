package dao;

import java.time.LocalDate;
import java.util.List;

public interface NationalHolidayDao {
    List<LocalDate> getAll();
}
