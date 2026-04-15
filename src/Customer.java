import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.Serializable;
import java.util.*;

public class Customer extends Person implements Serializable {
    private static List<Customer> extent = new ArrayList<>();
    private int loyaltyPoints;
    private String address;
    private List<String> favouriteCuisines;

    public Customer(){}

    public Customer(String name, String surname, String email, String telephoneNumber, Date dateOfBirth, int startingLoyaltyPoints, String address, List favouriteCuisines){
        super(name, surname, email, telephoneNumber, dateOfBirth);
        setLoyaltyPoints(startingLoyaltyPoints);
        setAddress(address);
        this.favouriteCuisines = new ArrayList<>(favouriteCuisines);
        extent.add(this);
    }

    public void addFavouriteCuisine(String cuisine) {
        if (cuisine == null || cuisine.isEmpty()) {
            throw new IllegalArgumentException("Cuisine cannot be empty");
        }
        favouriteCuisines.add(cuisine);
    }

    public void addFavouriteCuisine(String... cuisines) {
        for (String c : cuisines) {
            addFavouriteCuisine(c);
        }
    }

    public void addFavouriteCuisine(List<String> cuisines) {
        for (String c : cuisines) {
            addFavouriteCuisine(c);
        }
    }

    public void displayFavouriteCuisines(){
        if(favouriteCuisines == null || favouriteCuisines.isEmpty()){
            System.out.println("There aren't any favourite cuisines entered yet");
            return;
        }
        System.out.println("Favourite cuisines:");
        for (String cuisine : favouriteCuisines) {
            System.out.println("- " + cuisine);
        }
    }

    public int getDiscount(){
        return 10+loyaltyPoints/100;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    private void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public String getAddress() {
        return address;
    }

    private void setAddress(String address) {
        this.address = address;
    }

    public List<String> getFavouriteCuisines() {
        return favouriteCuisines;
    }

    private void setFavouriteCuisines(List<String> favouriteCuisines) {
        this.favouriteCuisines = favouriteCuisines;
    }

    public static void addToExtent(Customer customer){
        if(customer == null){
            throw new IllegalArgumentException("Customer cannot be null");
        }
        extent.add(customer);
    }

    public static List<Customer> getExtent(){
        return Collections.unmodifiableList(extent);
    }

    public static void removeFromExtent(Customer customer){
        extent.remove(customer);
    }

    public static void clearExtent(){
        extent.clear();
    }

    public static void writeExtent(XMLEncoder out){
        out.writeObject(extent);
    }

    public static void readExtent(XMLDecoder in){
        extent = (List<Customer>) in.readObject();
    }
}

