package bank_system.transactions;
import bank_system.models.*;
import bank_system.enums.BankAccountType;
import bank_system.exceptions.*;
public class BankAccountTransaction implements Transaction {
    private BankAccount account;
    public BankAccountTransaction(BankAccount account) { this.account = account; }
    @Override
    public void deposit(double amount) throws BankTransactionException {
        if (account.getAccountType() != BankAccountType.DEBIT)
            throw new BankTransactionException("Only DEBIT accounts can accept deposits.");
        account.setBalance(account.getBalance() + amount);
    }
    @Override
    public void withdraw(double amount) throws InsufficientFundsException, BankTransactionException {
        if (account.getAccountType() != BankAccountType.CREDIT)
            throw new BankTransactionException("Only CREDIT accounts can withdraw money.");
        if (amount > account.getBalance()) throw new InsufficientFundsException("Not enough balance.");
        account.setBalance(account.getBalance() - amount);
    }
    @Override
    public void transfer(Account toAccount, double amount) throws InsufficientFundsException, BankTransactionException {
        if (account.getAccountType() != BankAccountType.DEBIT || !(toAccount instanceof BankAccount))
            throw new BankTransactionException("Transfers must be from DEBIT to CREDIT account.");
        if (amount > account.getBalance()) throw new InsufficientFundsException("Not enough balance to transfer.");
        account.setBalance(account.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);
    }
}