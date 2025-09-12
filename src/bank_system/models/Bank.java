package bank_system.models;
import java.util.ArrayList;
import java.util.List;
public class Bank {
    private String bankName;
    private Address address;
    private List<CardHolder> cardHolders = new ArrayList<>();
    public Bank(String bankName, Address address) {
        this.bankName = bankName; this.address = address;
    }
    public void addCardHolder(CardHolder holder) { cardHolders.add(holder); }
}