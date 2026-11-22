package oops.abstraction;

public class SavingAccount extends BankAccount  {
    // ham ec=xtends ka use nahi karenge .. ham override ka use karenge

    //abstract ki vajah se in dono ki implimentaaaaaaan karni padi
    @Override
    public void deposit(double amount) {
        System.out.println("Deposited");
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("Withdrawn");
    }
}
