package weekdays;

import java.util.Comparator;

public class WeeklyEntry{
    private Weekday weekday;
    private String notes;

    public WeeklyEntry(String weekday, String notes) {
        this.weekday = Enum.valueOf(Weekday.class, weekday.toUpperCase());
        this.notes = notes;
    }

    public Weekday getWeekday() {
        return weekday;
    }

    public String getNotes() {
        return notes;
    }

    @Override
    public String toString() {
        return this.weekday + " - " + this.notes;
    }

    public static Comparator<WeeklyEntry> getComparatorByDay() {
        return (a, b) -> a.weekday.ordinal() - b.weekday.ordinal();
    }
}
