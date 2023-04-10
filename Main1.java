import java.util.*;


class Account {
    private String id;
    private String pin;
    private double balance;

    public Account(String id, String pin, double balance) {
        this.id = id;
        this.pin = pin;
        this.balance = balance;
    }
    
    public String getId() {
        return id;
    }

    public String getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid amount or insufficient funds.");
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid amount.");
        }
    }

    public void transfer(Account recipient, double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            recipient.balance += amount;
            System.out.println("Transfer successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid amount or insufficient funds.");
        }
    }
}

class ATM {
    private Account account;

    public ATM(Account account) {
        this.account = account;
    }

    public void showBalance() {
        System.out.println("Your current balance is: $" + account.getBalance());
    }

    public void withdraw() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter amount to withdraw: $");
        double amount = input.nextDouble();
        account.withdraw(amount);
    }

    public void deposit() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter amount to deposit: $");
        double amount = input.nextDouble();
        account.deposit(amount);
    }

    public void transfer() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter recipient account id: ");
        String recipientId = input.nextLine();
        System.out.print("Enter amount to transfer: $");
        double amount = input.nextDouble();
        // create a recipient account object here using recipientId
        Account recipient = new Account(recipientId, "", 0);
        account.transfer(recipient, amount);
    }
}

public class Main1 {
    public static void main(String[] args) {
        // create a sample account object for testing purposes
        Account account = new Account("123456789", "yash", 5000.0);
        // create a new ATM object using the account object
        ATM atm = new ATM(account);

        // prompt the user to enter their user id and pin
        Scanner input = new Scanner(System.in);
        System.out.print("Enter user id: ");
        String id = input.nextLine();
        System.out.print("Enter user pin: ");
        String pin = input.nextLine();

        // authenticate user
        if (id.equals(account.getId()) && pin.equals(account.getPin())) {
            // show menu of available options
            System.out.println("Welcome to the ATM.");
            System.out.println("1. Show balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            int choice;
            do {
                System.out.print("Enter choice: ");
                choice = input.nextInt();
                switch (choice) {
                    case 1:
                        atm.showBalance();
                        break;
                    case 2:
                        atm.withdraw();
                        break;
                    case 3:
                        atm.deposit();
                        break;
                    case 4:
                        atm.transfer();
                        break;
                    case 5:
                        System.out.println("Thank you for using the ATM.");
                        break;
                        
                }
                if (choice == 5) {
                    break;
                }
            }while(true);
        }
    }
}
