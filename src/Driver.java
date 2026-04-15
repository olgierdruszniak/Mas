import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;

public class Driver extends Person implements Serializable {
    private static List<Driver> extent = new ArrayList<>();
    private final BigDecimal baseSalary = BigDecimal.valueOf(3000);;
    private boolean occupied;
    private Vehicle vehicle;
    private Double rating;
    private int ratingCount;

    public Driver(){
    }

    public Driver(String name, String surname, String email, String telephoneNumber, Date dateOfBirth, String model, String plate){
        super(name, surname, email, telephoneNumber, dateOfBirth);
        setOccupied(false);
        setVehicle(new Vehicle(model, plate));
        rating = null;
        ratingCount = 0;
        occupied = false;
        extent.add(this);
    }

    public Driver(String name, String surname, String email, String telephoneNumber, Date dateOfBirth, String model, String plate, double startRating) throws Exception {
        super(name, surname, email, telephoneNumber, dateOfBirth);
        setOccupied(false);
        setVehicle(new Vehicle(model, plate));
        rating = null;
        ratingCount = 0;
        occupied = false;
        addRating(startRating);
        extent.add(this);
    }

    public static void showAvailableDrivers(){
        for(Driver driver : extent){
            if(!driver.isOccupied()){
                System.out.println(driver);
            }
        }
    }

    public void addRating(double rating) throws Exception {
        if(rating > 5.0 || rating < 0.0){
            throw new Exception("Rating has to be a number between 0 and 5");
        }
        if(this.rating == null){
            this.rating = rating;
            ratingCount = 1;
        }else {
            this.rating = (this.rating * ratingCount + rating) / (++ratingCount);
        }
    }

    public BigDecimal getBaseSalary() {
        return baseSalary;
    }

    public boolean isOccupied() {
        return occupied;
    }

    private void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    private void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public int getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(int ratingCount) {
        this.ratingCount = ratingCount;
    }

    class Vehicle{
        private String model;
        private String licensePlate;

        public Vehicle(String model, String licensePlate){
            setModel(model);
            setLicensePlate(licensePlate);
        }

        public String getModel() {
            return model;
        }

        private void setModel(String model) {
            this.model = model;
        }

        public String getLicensePlate() {
            return licensePlate;
        }

        private void setLicensePlate(String licensePlate) {
            this.licensePlate = licensePlate;
        }
    }

    public static void addToExtent(Driver driver){
        if(driver == null){
            throw new IllegalArgumentException("Driver cannot be null");
        }
        extent.add(driver);
    }

    public static List<Driver> getExtent(){
        return Collections.unmodifiableList(extent);
    }

    public static void removeFromExtent(Driver driver){
        extent.remove(driver);
    }

    public static void clearExtent(){
        extent.clear();
    }

    public static void writeExtent(XMLEncoder out){
        out.writeObject(extent);
    }

    public static void readExtent(XMLDecoder in){
        extent = (List<Driver>) in.readObject();
    }

    @Override
    public String toString() {
        return "Driver{" +
                "name='" + getName() + '\'' +
                ", surname='" + getSurname() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", telephone='" + getTelephoneNumber() + '\'' +
                ", dateOfBirth=" + getDateOfBirth() +
                ", occupied=" + occupied +
                ", vehicle=" + (vehicle != null ? vehicle.getModel() + " (" + vehicle.getLicensePlate() + ")" : "none") +
                ", baseSalary=" + baseSalary +
                ", rating=" + (rating != null ? String.format("%.2f", rating) : "N/A") +
                ", ratingCount=" + ratingCount +
                '}';
    }
}
