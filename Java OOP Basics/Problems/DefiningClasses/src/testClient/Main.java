package testClient;

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

            int id = Integer.valueOf(tokens[1]);

            switch (tokens[0]) {
                case "Create":
                    if (accounts.containsKey(id)) {
                        System.out.println("Account already exists");
                        break;
                    }
                    accounts.put(id, new BankAccount(id));
                    break;
                case "Deposit":
                    if (accounts.get(id) == null) {
                        System.out.println("Account does not exist");
                        break;
                    }
                    double amountToDeposit = Double.valueOf(tokens[2]);
                    accounts.get(id).deposit(amountToDeposit);
                    break;
                case "Withdraw":
                    if (accounts.get(id) == null) {
                        System.out.println("Account does not exist");
                        break;
                    }
                    double amountToWithdraw = Double.valueOf(tokens[2]);
                    try {
                        accounts.get(id).withdraw(amountToWithdraw);
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "Print":
                    if (accounts.get(id) == null) {
                        System.out.println("Account does not exist");
                        break;
                    }
                    System.out.println(accounts.get(id).toString());
                    break;
            }

            line = reader.readLine();
        }
    }
}
