package bank_system;
import bank_system.models.*;
import bank_system.enums.*;
import bank_system.transactions.*;
public class Main {
    public static void main(String[] args) {
        try {
            Address bankAddress = new Address("Armenia", "Yerevan", "Yerevan", "Baghramyan", "12");
            Bank bank = new Bank("ACBA Bank", bankAddress);
            BankAccount debitAccount = new BankAccount("1234567890123456", Currency.AMD, 50000, BankAccountType.DEBIT);
            BankAccount creditAccount = new BankAccount("1111222233334444", Currency.AMD, 20000, BankAccountType.CREDIT);
            CardHolder holder = new CardHolder("AB123456", "Avag Arakelyan", bankAddress, debitAccount);
            CardAccount card = new CardAccount("5555666677778888", Currency.AMD, 10000, "123", "12/27", CardType.VISA, CardStatus.ACTIVE);
            holder.addCard(card);
            bank.addCardHolder(holder);
            CardTransaction cardTx = new CardTransaction(card);
            cardTx.deposit(5000);
            cardTx.withdraw(2000);
            BankAccountTransaction bankTx = new BankAccountTransaction(debitAccount);
            bankTx.deposit(10000);
            bankTx.transfer(creditAccount, 5000);
            System.out.println("Card Balance: " + card.getBalance());
            System.out.println("Debit Account Balance: " + debitAccount.getBalance());
            System.out.println("Credit Account Balance: " + creditAccount.getBalance());
        } catch (Exception e) {
            System.out.println("Transaction failed: " + e.getMessage());
        }
    }
}