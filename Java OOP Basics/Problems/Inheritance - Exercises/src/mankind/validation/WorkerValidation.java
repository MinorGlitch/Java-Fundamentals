package mankind.validation;

public final class WorkerValidation {
    public final static String INVALID_WORKER_LAST_NAME_LENGTH_MESSAGE =
            "Expected length more than 3 symbols!Argument: lastName";
    public final static String INVALID_WEEK_SALARY_MESSAGE = "Expected value mismatch!Argument: weekSalary";
    public final static String INVALID_WORKING_HOURS_MESSAGE = "Expected value mismatch!Argument: workHoursPerDay";

    public static boolean isValidLastName(String lastName) {
        return lastName.length() > 3;
    }

    public static boolean isValidSalary(double salary) {
        return salary > 10;
    }

    public static boolean areValidWorkHoursPerDay(double workHours) {
        return workHours > 0 && workHours < 13;
    }
}
