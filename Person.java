import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Person {
    private static List<Person> extent = new ArrayList<>();
    private String name;
    private String surname;
    private String email;
    private String telephoneNumber;
    private Date dateOfBirth;

    public Person(){}

    public Person(String name, String surname, String email, String telephoneNumber, Date dateOfBirth){
        setName(name);
        setSurname(surname);
        setEmail(email);
        setTelephoneNumber(telephoneNumber);
        setDateOfBirth(dateOfBirth);
        extent.add(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

}
