package oops.abstraction;

abstract public class BankAccount {
    private String accountNumber;
    private double balance;

    // abstract  -->  jab ye class se ke sath use hota hai to object nahi bna sakte hai and jab ye method ke sath use  hota hai to ise imlimentation dene ji jarurat nahi hai
      public abstract  void deposit(double amount);
    public abstract  void withdraw(double amount);
}
