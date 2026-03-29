import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Customer extends Person{
    private static List<Customer> extent = new ArrayList<>();
    private int loyaltyPoints;
    private String address;
    private List favouriteCuisines;

    public Customer(String name, String surname, String email, String telephoneNumber, Date dateOfBirth, int startingLoyaltyPoints, String address, List favouriteCuisines){
        super(name, surname, email, telephoneNumber, dateOfBirth);
        setLoyaltyPoints(startingLoyaltyPoints);
        setAddress(address);
        this.favouriteCuisines = new ArrayList(favouriteCuisines);
        extent.add(this);
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

    public List getFavouriteCuisines() {
        return favouriteCuisines;
    }

    private void setFavouriteCuisines(List favouriteCuisines) {
        this.favouriteCuisines = favouriteCuisines;
    }
}

