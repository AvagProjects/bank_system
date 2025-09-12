package bank_system.transactions;
import bank_system.models.*;
import bank_system.enums.CardStatus;
import bank_system.exceptions.*;
public class CardTransaction implements Transaction {
    private CardAccount card;
    public CardTransaction(CardAccount card) { this.card = card; }
    @Override
    public void deposit(double amount) throws BankTransactionException {
        if (card.getCardStatus() == CardStatus.BLOCKED) throw new BankTransactionException("Cannot deposit: Card is blocked.");
        card.setBalance(card.getBalance() + amount);
    }
    @Override
    public void withdraw(double amount) throws InsufficientFundsException, BankTransactionException {
        if (card.getCardStatus() == CardStatus.BLOCKED) throw new BankTransactionException("Cannot withdraw: Card is blocked.");
        if (amount > card.getBalance()) throw new InsufficientFundsException("Not enough balance.");
        card.setBalance(card.getBalance() - amount);
    }
    @Override
    public void transfer(Account toAccount, double amount) throws InsufficientFundsException, BankTransactionException {
        if (card.getCardStatus() == CardStatus.BLOCKED) throw new BankTransactionException("Cannot transfer: Card is blocked.");
        if (amount > card.getBalance()) throw new InsufficientFundsException("Not enough balance to transfer.");
        card.setBalance(card.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);
    }
    public void blockCard() { card.setCardStatus(CardStatus.BLOCKED); }
}