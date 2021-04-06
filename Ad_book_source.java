import java.util.Scanner;

public class Ad_book_source {

    String first_name;
    String last_name;
    Long mobile;
    int zip_code;
    String email;
    String city;
    String state;
    int number;
    private Scanner fetch = new Scanner(System.in);

    //Using constructor to take in values
    Ad_book_source() {
    }

    Ad_book_source(String first_name, String last_name, long mobile, String email, String city, String state, int zip_code) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.mobile = mobile;
        this.email = email;
        this.city = city;
        this.state = state;
        this.zip_code = zip_code;
    }

    public void setLast_name() {
        System.out.println("GIVE ME THE LAST NAME :");
        this.last_name = fetch.next();
    }

    public void setMobile() {
        System.out.println("GIVE ME THE PHONE NO. :");
        this.mobile = fetch.nextLong();
    }

    public void setZip_code() {
        System.out.println("GIVE ME THE ZIP CODE");
        this.zip_code = fetch.nextInt();
    }

    public void setEmail() {
        System.out.println("GIVE ME THE EMAIL: ");
        this.email = fetch.next();
    }

    public void setCity() {
        System.out.println("GIVE ME THE CITY :");
        this.city = fetch.next();
    }

    public void setState() {
        System.out.println("GIVE ME THE STATE");
        this.state = fetch.next();
    }

    public void setFirst_name() {
        System.out.println("GIVE ME THE FIRST NAME :");
        this.first_name = fetch.nextLine();
    }

    public void setDetails() {
        setFirst_name();
        setLast_name();
        setMobile();
        setEmail();
        setCity();
        setState();
        setZip_code();
    }

    //Overriding toString method to return values as per desire
    public String toString() {

        return (getName() + "," + getLast_name() + "," + getMobile() + "," + getEmail() + "," + getCity() + "," + getState() + "," + getZip_code());
    }

    public String getName() {

        return this.first_name;
    }


    public void change_details() {
        System.out.println("WHICH DETAiLS DO YOU WAnT TO CHANGE ? :");
        System.out.println("1.FIRST NAME\n2.LAST NAME\n3.PHONE NO.\n4.EMAIL\n5.ZIP CODE\n6.CITY\n7.EXIT");
        int change_choice = fetch.nextInt();
        switch (change_choice) {

            case 1://changes the First name
                System.out.println("CHANGE THE FIRST NAME TO :");//Allowing user to change First name
                String changer_fname = fetch.next();
                this.first_name = changer_fname;
                break;
            case 2://changes the last name
                System.out.println("CHANGE THE LAST NAME TO :");//Allowing user to change Last name
                String changer_lname = fetch.next();
                this.last_name = changer_lname;
                break;
            case 3://changes the Phone no.
                System.out.println("CHANGE THE PHONE NUMBER TO :");//Allowing user to change Contact number
                Long changer_phone = fetch.nextLong();
                this.mobile = changer_phone;
                break;

            case 4://changes the Email
                System.out.println("CHANGE THE EMAIL ID TO :");//Allowing user to change the email
                String changer_email = fetch.next();
                this.email = changer_email;
                break;


            case 5://changes the ZIP code
                System.out.println("CHANGE THE ZIP CODE TO :");//Allowing user to change the Zip code
                int changer_zip = fetch.nextInt();
                this.zip_code = changer_zip;
                break;

            case 6://changes the City
                System.out.println("CHANGE THE CITY TO :");//Allowing user to change the City
                String changer_city = fetch.next();
                this.city = changer_city;
                break;
            case 7:
                System.out.println("CHANGE THE STATE TO :");//Allowing user to change the State
                String changer_state = fetch.next();
                this.city = changer_state;
                break;

            default:
                break;
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ad_book_source that = (Ad_book_source) o;
        return first_name.equals(that.first_name);
    }


    public String getLast_name() {

        return this.last_name;
    }

    public String getEmail() {

        return this.email;
    }

    public String getCity() {

        return this.city;
    }

    public long getMobile() {

        return this.mobile;
    }

    public int getZip_code() {

        return this.zip_code;
    }

    public String getState() {

        return this.state;
    }

    public void zero_set() {

        this.number = 0;

    }
}
