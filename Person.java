import java.util.Scanner;

public class Person {
    private Scanner fetch = new Scanner(System.in);
    private String firstName;
    private String lastName;
    private String city;
    private String state;
    private int zipCode;
    private String email;
    private long phoneNumber;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setMobile(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setDetails() {

        System.out.println("Give the First Name : ");
        setFirstName(fetch.next());

        System.out.println("Give the Last Name : ");
        setLastName(fetch.next());

        System.out.println("Give the Mobile number : ");
        setMobile(fetch.nextLong());

        System.out.println("Give the Email : ");
        setEmail(fetch.next());

        System.out.println("Give the City : ");
        setCity(fetch.next());

        System.out.println("Give the State : ");
        setState(fetch.next());

        System.out.println("Give the Zip Code : ");
        setZipCode(fetch.nextInt());

    }

    @Override
    public String toString() {
        return
                        "firstName='" + firstName + '\'' +
                        ", lastName='" + lastName + '\'' +
                        ", phoneNumber='" + phoneNumber + '\'' +
                        ", email='" + email + '\'' +
                        ", city='" + city + '\'' +
                        ", state='" + state + '\'' +
                        ", zip=" + zipCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person that = (Person) o;
        return firstName.equals(that.firstName) && lastName.equals(that.lastName);
    }


}
