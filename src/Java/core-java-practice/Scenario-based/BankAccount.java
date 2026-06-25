public class BankAccount {

    private String accountNumber;
    private String holder;
    private double balance;

    private static int totalAccounts = 0;

    public BankAccount(String accountNumber, String holder, double balance) {
        this.accountNumber = accountNumber;
        this.holder = holder;
        this.balance = balance;
        totalAccounts++;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(holder + " deposited ₹" + amount);
        }
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println(holder + " withdrew ₹" + amount);
        } else {
            System.out.println("Overdraft not allowed for " + holder);
        }
    }

    public void getStatement() {
        System.out.println("\nAccount Number : " + accountNumber);
        System.out.println("Holder Name    : " + holder);
        System.out.println("Balance        : ₹" + balance);
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public static void main(String[] args) {

        BankAccount acc1 =
                new BankAccount("A101", "Lavanya", 10000);

        BankAccount acc2 =
                new BankAccount("A102", "Rahul", 15000);

        BankAccount acc3 =
                new BankAccount("A103", "Priya", 20000);

        // Account 1 Transactions
        acc1.deposit(2000);
        acc1.withdraw(1000);
        acc1.deposit(500);
        acc1.withdraw(3000);
        acc1.deposit(1000);

        // Account 2 Transactions
        acc2.deposit(3000);
        acc2.withdraw(2000);
        acc2.deposit(1500);
        acc2.withdraw(4000);
        acc2.deposit(500);

        // Account 3 Transactions
        acc3.deposit(5000);
        acc3.withdraw(2500);
        acc3.deposit(1000);
        acc3.withdraw(3000);
        acc3.deposit(2000);

        acc1.getStatement();
        acc2.getStatement();
        acc3.getStatement();

        System.out.println("\nTotal Accounts Created = "
                + BankAccount.getTotalAccounts());
    }
}
