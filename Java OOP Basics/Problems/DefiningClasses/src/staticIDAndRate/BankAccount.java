package staticIDAndRate;

public class BankAccount {
    private int id;
    private static int idCount;
    private double balance;
    private static final double INTEREST_RATE = 0.02;
    private static double interestRate;

    public BankAccount() {
        this.id = ++idCount;
        interestRate = INTEREST_RATE;
    }

    public int getId() {
        return this.id;
    }

    public static void setInterestRate(double interest) {
        interestRate = interest;
    }

    public double getInterest(int years) {
        return interestRate * this.balance * years;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    @Override
    public String toString() {
        return "ID" + this.id;
    }
}
