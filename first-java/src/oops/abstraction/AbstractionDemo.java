package oops.abstraction;

public class AbstractionDemo {
    public static void main(String[] args) {

        SavingAccount savingAccount = new SavingAccount();
        savingAccount.deposit(100);

        BankAccount savingsAccount1 =  new SavingAccount();
        savingsAccount1 =  new CurrentAccount();
        savingsAccount1.deposit(200);

    }
}
