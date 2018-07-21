package weekdays;

import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        WeeklyCalendar calendar = new WeeklyCalendar() {
            {
                addEntry("Friday", "Sleep");
                addEntry("Monday", "Sport");
            }
        };

        Iterable<WeeklyEntry> schedule = calendar.getWeeklySchedule();

        for (WeeklyEntry weeklyEntry : schedule) {
            System.out.println(weeklyEntry);
        }
    }
}
