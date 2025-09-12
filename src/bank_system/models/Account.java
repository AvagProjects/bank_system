package bank_system.models;
import bank_system.enums.Currency;
public class Account {
    protected String accountNumber;
    protected Currency currency;
    protected double balance;
    public Account(String accountNumber, Currency currency, double balance) {
        if (accountNumber.length() != 16) throw new IllegalArgumentException("Account number must be 16 digits");
        this.accountNumber = accountNumber; this.currency = currency; this.balance = balance;
    }
    public String getAccountNumber() { return accountNumber; }
    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }
    public Currency getCurrency() { return currency; }
}