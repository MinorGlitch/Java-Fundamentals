package mankind;

import mankind.validation.WorkerValidation;

public class Worker extends Human {
    private double weekSalary;
    private double workHoursPerDay;

    public Worker(String firstName, String lastName, double weekSalary, double workHoursPerDay) {
        super(firstName, lastName);
        this.setWeekSalary(weekSalary);
        this.setWorkHoursPerDay(workHoursPerDay);
    }

    private void setWorkHoursPerDay(double workHoursPerDay) {
        if (!WorkerValidation.areValidWorkHoursPerDay(workHoursPerDay)) {
            throw new IllegalArgumentException(WorkerValidation.INVALID_WORKING_HOURS_MESSAGE);
        }

        this.workHoursPerDay = workHoursPerDay;
    }

    private void setWeekSalary(double weekSalary) {
        if (!WorkerValidation.isValidSalary(weekSalary)) {
            throw new IllegalArgumentException(WorkerValidation.INVALID_WEEK_SALARY_MESSAGE);
        }

        this.weekSalary = weekSalary;
    }

    @Override
    protected void setLastName(String lastName) {
        if (!WorkerValidation.isValidLastName(lastName)) {
            throw new IllegalArgumentException(WorkerValidation.INVALID_WORKER_LAST_NAME_LENGTH_MESSAGE);
        }

        super.lastName = lastName;
    }

    private double getWeekSalary() {
        return weekSalary;
    }

    private double getWorkHoursPerDay() {
        return workHoursPerDay;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString());
        sb.append(String.format("Week Salary: %.2f%n", this.getWeekSalary()));
        sb.append(String.format("Hours per day: %.2f%n", this.getWorkHoursPerDay()));
        sb.append(String.format("Salary per hour: %.2f%n", this.calculateSalaryPerHour()));

        return sb.toString();
    }

    private double calculateSalaryPerHour() {
        return this.getWeekSalary() / (this.getWorkHoursPerDay() * 7);
    }
}
