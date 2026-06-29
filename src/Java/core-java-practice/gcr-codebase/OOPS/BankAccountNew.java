class BankAccountNew {

    static String bankName = "SBI Bank";
    static int totalAccounts = 0;

    String accountHolderName;
    final int accountNumber;

    BankAccountNew(String accountHolderName, int accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        totalAccounts++;
    }

    static void getTotalAccounts() {
        System.out.println("Total Accounts: " + totalAccounts);
    }

    void displayDetails() {
        System.out.println("Bank Name: " + bankName);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
    }

    public static void main(String[] args) {

        BankAccountNew b1 = new BankAccountNew("Lavanya", 101);

        if (b1 instanceof BankAccountNew) {
            b1.displayDetails();
        }

        BankAccountNew.getTotalAccounts();
    }
}