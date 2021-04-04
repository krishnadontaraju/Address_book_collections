import java.util.Scanner;

public class Ad_book_source {

    String first_name;
    String last_name;
    long mobile;
    int zip_code;
    String email;
    String city;
    String state;
    private Scanner fetch = new Scanner(System.in);

    //Using constructor to take in values
    public Ad_book_source() {
        System.out.println("GIVE ME THE FIRST NAME :");
        this.first_name = fetch.nextLine();
        System.out.println("GIVE ME THE LAST NAME :");
        this.last_name = fetch.nextLine();
        System.out.println("GIVE ME THE PHONE NO. :");
        this.mobile = fetch.nextLong();
        System.out.println("GIVE ME THE EMAIL: ");
        this.email = fetch.next();
        System.out.println("GIVE ME THE ZIP CODE");
        this.zip_code = fetch.nextInt();
        System.out.println("GIVE ME THE CITY :");
        this.city = fetch.next();
    }

    //Overriding toString method to return values as per desire
    public String toString() {

        return ("FIRST NAME : " + first_name + "\nLAST NAME : " + last_name + "\nPHONE : " + mobile + "\nEMAIL : " + email + "\nZIP CODE : " + zip_code + "\nCITY : " + city);
    }
}
