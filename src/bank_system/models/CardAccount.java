package bank_system.models;
import bank_system.enums.*;
public class CardAccount extends Account {
    private String cvv;
    private String expirationDate;
    private CardType cardType;
    private CardStatus cardStatus;
    public CardAccount(String accountNumber, Currency currency, double balance,
                       String cvv, String expirationDate, CardType cardType, CardStatus cardStatus) {
        super(accountNumber, currency, balance);
        if (cvv.length() != 3) throw new IllegalArgumentException("CVV must be 3 digits");
        this.cvv = cvv; this.expirationDate = expirationDate;
        this.cardType = cardType; this.cardStatus = cardStatus;
    }
    public CardStatus getCardStatus() { return cardStatus; }
    public void setCardStatus(CardStatus cardStatus) { this.cardStatus = cardStatus; }
}