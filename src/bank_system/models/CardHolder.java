package bank_system.models;
import java.util.ArrayList;
import java.util.List;
public class CardHolder {
    private String passportNumber, fullName;
    private Address address;
    private List<CardAccount> cards = new ArrayList<>();
    private BankAccount bankAccount;
    public CardHolder(String passportNumber, String fullName, Address address, BankAccount bankAccount) {
        this.passportNumber = passportNumber; this.fullName = fullName;
        this.address = address; this.bankAccount = bankAccount;
    }
    public void addCard(CardAccount card) { cards.add(card); }
    public List<CardAccount> getCards() { return cards; }
    public BankAccount getBankAccount() { return bankAccount; }
}