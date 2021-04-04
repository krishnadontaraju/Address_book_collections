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
                long changer_phone = fetch.nextLong();
                this.phone_no = changer_phone;
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

            default:
                break;
        }

    }
