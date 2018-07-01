package militaryElite.privateSoldier;

import militaryElite.soldier.BaseSoldier;

public class Private extends BaseSoldier implements IPrivate {
    private double salary;

    public Private(String id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName);
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return this.salary;
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s Id: %s Salary: %.2f", super.getFirstName(),
                super.getLastName(), super.getId(), this.getSalary());
    }
}
