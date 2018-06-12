package staticIDAndRate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, BankAccount> accounts = new LinkedHashMap<>();

        String line = reader.readLine();

        while (!"End".equals(line)) {
            String[] tokens = line.split(" ");

            switch (tokens[0]) {
                case "Create":
                    BankAccount acc = new BankAccount();
                    accounts.put(acc.getId(), acc);
                    System.out.printf("Account %s created%n", acc.toString());
                    break;
                case "Deposit":
                    int id = Integer.valueOf(tokens[1]);
                    double amount = Double.valueOf(tokens[2]);
                    if (accounts.get(id) == null) {
                        System.out.println("Account does not exist");
                        break;
                    }
                    accounts.get(id).deposit(amount);
                    System.out.printf("Deposited %.0f to %s%n", amount, accounts.get(id).toString());
                    break;
                case "SetInterest":
                    double interest = Double.valueOf(tokens[1]);
                    BankAccount.setInterestRate(interest);
                    break;
                case "GetInterest":
                    int accId = Integer.valueOf(tokens[1]);
                    int years = Integer.valueOf(tokens[2]);
                    if (accounts.get(accId) == null) {
                        System.out.println("Account does not exist");
                        break;
                    }

                    double interestRate = accounts.get(accId).getInterest(years);
                    System.out.printf("%.2f%n", interestRate);
                    break;
            }

            line = reader.readLine();
        }
    }
}
