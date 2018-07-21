package weekdays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class WeeklyCalendar {
    List<WeeklyEntry> weeklyEntries;

    public WeeklyCalendar() {
        this.weeklyEntries = new ArrayList<>();
    }

    public void addEntry(String weekday, String notes) {
        this.weeklyEntries.add(new WeeklyEntry(weekday, notes));
    }

    public Iterable<WeeklyEntry> getWeeklySchedule() {
        this.weeklyEntries.sort(WeeklyEntry.getComparatorByDay());
        return weeklyEntries;
    }
}
