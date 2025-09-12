package bank_system.transactions;
import bank_system.models.Account;
import bank_system.exceptions.*;
public interface Transaction {
    void deposit(double amount) throws BankTransactionException;
    void withdraw(double amount) throws InsufficientFundsException, BankTransactionException;
    void transfer(Account toAccount, double amount) throws InsufficientFundsException, BankTransactionException;
}