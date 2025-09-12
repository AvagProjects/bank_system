package bank_system.models;
import bank_system.enums.*;
public class BankAccount extends Account {
    private BankAccountType accountType;
    public BankAccount(String accountNumber, Currency currency, double balance, BankAccountType accountType) {
        super(accountNumber, currency, balance);
        this.accountType = accountType;
    }
    public BankAccountType getAccountType() { return accountType; }
}