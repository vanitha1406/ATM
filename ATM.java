import java.util.ArrayList;
import java.util.Scanner;

public class ATM {

    static double balance = 10000;
    static final int PIN = 1234;
    static ArrayList<String> history = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int attempts = 3;
        boolean authenticated = false;

        System.out.println("===== WELCOME TO JAVA ATM =====");

        while (attempts > 0) {

            System.out.print("Enter PIN: ");
            int enteredPin = sc.nextInt();

            if (enteredPin == PIN) {
                authenticated = true;
                break;
            } else {
                attempts--;
                System.out.println("Wrong PIN!");
                System.out.println("Attempts Left: " + attempts);
            }
        }

        if (!authenticated) {
            System.out.println("Account Locked!");
            sc.close();
            return;
        }

        int choice;

        do {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");

            System.out.print("Choose Option: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Current Balance: ₹" + balance);
                    break;

                case 2:
                    System.out.print("Enter Deposit Amount: ₹");
                    double deposit = sc.nextDouble();

                    if (deposit > 0) {
                        balance += deposit;
                        history.add("Deposited ₹" + deposit);
                        System.out.println("Deposit Successful!");
                    } else {
                        System.out.println("Invalid Amount!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Withdrawal Amount: ₹");
                    double withdraw = sc.nextDouble();

                    if (withdraw <= balance && withdraw > 0) {
                        balance -= withdraw;
                        history.add("Withdrawn ₹" + withdraw);
                        System.out.println("Withdrawal Successful!");
                    } else {
                        System.out.println("Insufficient Balance!");
                    }
                    break;

                case 4:
                    System.out.println("\n--- Transaction History ---");

                    if (history.isEmpty()) {
                        System.out.println("No Transactions Yet.");
                    } else {
                        for (String transaction : history) {
                            System.out.println(transaction);
                        }
                    }
                    break;

                case 5:
                    System.out.println("Thank You For Using ATM!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}