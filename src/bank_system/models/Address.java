package bank_system.models;
public class Address {
    private String country, region, city, street, house;
    public Address(String country, String region, String city, String street, String house) {
        this.country = country; this.region = region; this.city = city;
        this.street = street; this.house = house;
    }
    @Override
    public String toString() {
        return country + ", " + region + ", " + city + ", " + street + " " + house;
    }
}