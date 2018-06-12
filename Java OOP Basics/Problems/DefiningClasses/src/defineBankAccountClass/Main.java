package defineBankAccountClass;

public class Main {
    public static void main(String[] args) {

        BankAccount acc = new BankAccount();

        acc.id = 1;
        acc.balance = 10.25;

        System.out.printf("Account ID%d, balance %.2f", acc.id, acc.balance);
    }
}
