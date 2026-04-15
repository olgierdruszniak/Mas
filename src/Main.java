import java.io.FileNotFoundException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args) throws Exception {
        /*
        1. class extent -> in classes: Person, Customer, Driver
        2. class extent persistence -> working for Driver, Customer classes
        3. Complex attribute -> Vehicle in Driver class
        4. Optional attribute -> rating in class Driver
        5. Multi-value attribute -> favourite cuisines in class Customer
        6. Class attribute -> base salary in driver class
        7. Derived attribute -> getDiscount in Customer class
        8. Class method -> showAvailableDrivers
        9. Method overriding and overloading -> overriding in Driver toString() and overloading in
        */

        Driver driver1 = new Driver("James", "Smith", "james@smith.com", "799526881", Date.valueOf("1992-10-05"), "Cupra Formentor", "WPI1435L");
        System.out.println(Driver.getExtent());
        Driver driver2 = new Driver("Mark", "Smith", "mark@smith.com", "799552881", Date.valueOf("1990-11-13"), "Cupra Formentor", "WP25531", 2.0);
        System.out.println(Driver.getExtent());
        Customer customer = new Customer("Rose", "James", "rose@james.com", "222735947", Date.valueOf("2004-10-05"), 0, "Some street", new ArrayList<>(List.of("Polish", "Italy")));
        System.out.println(customer.getName() + "'s discount: " + customer.getDiscount());
        System.out.println(driver1.getName() + "'s base salary: " + driver1.getBaseSalary());
        System.out.println(driver2.getName() + "'s base salary: " + driver2.getBaseSalary());
        customer.addFavouriteCuisine("Spanish");
        customer.addFavouriteCuisine("Kurdish", "Turkish");
        customer.addFavouriteCuisine(new ArrayList<>(List.of("German", "Dutch")));
        customer.displayFavouriteCuisines();
        Extent.saveExtents();
//        System.out.println(Driver.getExtent());
//        Extent.loadExtents();
//        System.out.println(Driver.getExtent());
//        Driver.showAvailableDrivers();
    }
}