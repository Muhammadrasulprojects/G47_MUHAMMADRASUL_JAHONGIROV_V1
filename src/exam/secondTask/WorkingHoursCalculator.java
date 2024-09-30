package exam.secondTask;

import java.time.LocalDate;
import java.time.DayOfWeek;

public class WorkingHoursCalculator {
    public static void main(String[] args) {
        LocalDate startDate = LocalDate.of(2020, 1, 1);
        LocalDate endDate = LocalDate.of(2024, 9, 1);

        int totalHours = calculateTotalWorkingHours(startDate, endDate);
        System.out.println("Olim ishchi: " + totalHours + " soat ishlagan.");
    }

    public static int calculateTotalWorkingHours(LocalDate start, LocalDate end) {
        int totalHours = 0;

        for (LocalDate date = start; !date.isAfter(end); date = date.plusDays(1)) {
            DayOfWeek dayOfWeek = date.getDayOfWeek();

            if (dayOfWeek == DayOfWeek.SATURDAY) {
                totalHours += 4;
            } else if (dayOfWeek != DayOfWeek.SUNDAY) {
                totalHours += 8;
            }
        }

        return totalHours;
    }
}
