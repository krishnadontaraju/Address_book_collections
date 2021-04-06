import java.io.*;
import java.util.*;

public class Address_book {
    static PrintWriter startFileMapStorage;
    Scanner fetch = new Scanner(System.in);

    public static void main(String[] args) {
        //Giving the file input to startFileMapstorage for future use
        {
            try {
                startFileMapStorage = new PrintWriter(new FileOutputStream("C:\\Users\\manik\\Desktop\\new\\Program_tester\\JAVA_content\\IntelliJ_java\\ad_book_collections\\mainMap.csv", true), true);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }


        //Creating an arraylist instance of Ad_book_source
        List<Ad_book_source> user = new ArrayList<>();
        List<Ad_book_source> removable_list = new ArrayList<>();

        HashMap<String, String> parent_book = new HashMap<>();
        System.out.println("Pre-Existing Book's Identifier name");
        //Loading Data from file to map
        new Address_book().read_data_from_file_pass_to_map(parent_book, "C:\\Users\\manik\\Desktop\\new\\Program_tester\\JAVA_content\\IntelliJ_java\\ad_book_collections\\mainMap.csv");

        //If map is empty i.e. no addressBooks exist
        if (parent_book.isEmpty()) {
            try {
                new Address_book().emptyMapAction(user, parent_book);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            //Else do this
        } else {
            try {
                new Address_book().existingMapAction(user, parent_book);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        //Printing out the users added
        System.out.println("THE FINAL LIST OF CONTACTS CREATED ARE :");
        System.out.println(user.toString());

        new Address_book().changeDetailsRequestByUser(user);

        //Printing out the users added
        System.out.println("THE FINAL LIST OF CONTACTS CREATED ARE :");
        System.out.println(user.toString());

        new Address_book().askingIfDeleteEntry(user, removable_list);

    }

    public static Ad_book_source get_user(String[] details) {

        String first_name = details[0];

        String last_name = details[1];
        long mobile = Long.parseLong(details[2]);
        String email = details[3];
        String city = details[4];
        String state = details[5];
        int zip_code = Integer.parseInt(details[6]);
        Ad_book_source new_book = new Ad_book_source(first_name, last_name, mobile, email, city, state, zip_code);

        return new_book;

    }

    //Change details method allows user to change the entered details
    public void changeDetailsRequestByUser(List<Ad_book_source> argumentBook) {
        System.out.println("Do you want to edit details of someone\ngive me a Yes or no");
        String first_choice = fetch.next();
        if (first_choice == "yes" || first_choice == "Yes") {
            boolean entry_found = false;
            System.out.println("Whose details do you want to change ?");
            String change_input = fetch.next();
            for (Ad_book_source i : argumentBook) {
                //When found user's desired choice call change details method
                if (i.getName().equals(change_input)) {

                    i.change_details();
                }

            }


        }
    }

    // Delete method allows user to delete entries
    public void askingIfDeleteEntry(List<Ad_book_source> argumentBook, List<Ad_book_source> deletableList) {
        System.out.println("Do you want to delete details of someone\ngive me a Yes or no");
        String secondChoice = fetch.nextLine();
        if (secondChoice == "yes" || secondChoice == "Yes") {
            System.out.println("WHOSE DETAILS DO YOU WANT TO DELETE");
            String delete_input = fetch.next();
            for (Ad_book_source i : argumentBook) {//iterating through the arraylist until finds user's input

                if (i.getName().equals(delete_input)) {

                    deletableList.add(i);// Using to_remove instance to store remove properties
                    System.out.println("DELETED " + i.getName());
                    break;
                } else {
                    System.out.println("WRONG INPUT");
                    i.zero_set();
                }


            }
            argumentBook.removeAll(deletableList);// removing stored user details


        }

    }

    //if the map is empty then the the main method calls this method
    public void emptyMapAction(List<Ad_book_source> argumentBook, Map<String, String> argumentMap) throws FileNotFoundException {
        System.out.println("Create an Address book to get Started");
        for (int i = 0; i < 1; i++) {
            System.out.println("what do you want the Address book name to be \nPlease type .csv files");
            String book_name = fetch.next();


            PrintWriter temp_file = new PrintWriter(new FileOutputStream(book_name, true), true);

            System.out.println("FILE HAS BEEN CREATED WITH : " + book_name);
            System.out.println("Next,add contacts to your new book\nFirst stat by creating a new Address Book");

            contactsAddition(argumentBook, argumentMap, temp_file, book_name);


        }

    }

    //Method to add Contacts
    public void contactsAddition(List<Ad_book_source> argumentBook, Map<String, String> argumentMap, PrintWriter printFile, String listRealName) {
        System.out.println("How many contacts do you want to add ?");
        int new_book_choice = fetch.nextInt();
        for (int rotater = 0; rotater < new_book_choice; rotater++) {
            Ad_book_source new_ad_book = new Ad_book_source();
            new_ad_book.setDetails();
            argumentBook.add(new_ad_book);

            printFile.println(new_ad_book.getName() + "," + new_ad_book.getLast_name() + "," + new_ad_book.getMobile() + "," + new_ad_book.getEmail() + "," + new_ad_book.getCity() + "," + new_ad_book.getState() + "," + new_ad_book.getZip_code());
        }
        System.out.println("For future Identification, add a Nickname to your brand new Address book ");
        String book_nick_name = fetch.next();
        argumentMap.put(book_nick_name, listRealName);

        startFileMapStorage.println(book_nick_name + "," + listRealName);
    }

    //If the map is not empty then this method will be called
    public void existingMapAction(List<Ad_book_source> argumentBook, Map<String, String> argumentMap) throws FileNotFoundException {

        System.out.println(argumentMap.keySet());
        System.out.println("What do you want to do 1.Create new Address Book\n2.Add to existing\n3.Just get out ");
        int parent_book_choice = fetch.nextInt();
        switch (parent_book_choice) {
            case 1:
                emptyMapAction(argumentBook, argumentMap);
                break;
            case 2:
                System.out.println("   IDENTIFICATION NAME     -     FILE NAME  ");
                argumentMap.entrySet().forEach(entry -> {
                    System.out.println("       " + entry.getKey() + "               " + entry.getValue());
                });
                System.out.println("TO Which Book you want to add the contact ? \n(please type the exact IDENTIFICATION NAME )");
                String identificationName = fetch.next();
                readData_FromFile_PassTo_List(argumentBook, argumentMap.get(identificationName));
                System.out.println("How many contacts do you want to add ?");
                int new_book_choice = fetch.nextInt();
                for (int rotater = 0; rotater < new_book_choice; rotater++) {
                    Ad_book_source new_ad_book = new Ad_book_source();
                    new_ad_book.setDetails();
                    argumentBook.add(new_ad_book);

                    PrintWriter iterable_file = null;
                    try {
                        iterable_file = new PrintWriter(new FileOutputStream(argumentMap.get(identificationName), true), true);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    iterable_file.println(new_ad_book.getName() + "," + new_ad_book.getLast_name() + "," + new_ad_book.getMobile() + "," + new_ad_book.getEmail() + "," + new_ad_book.getCity() + "," + new_ad_book.getState() + "," + new_ad_book.getZip_code());
                }
                break;

            default:
                break;

        }

    }

    public void read_data_from_file_pass_to_map(Map<String, String> test_book, String file_location) {
        String line = "";
        try {

            BufferedReader file_read = new BufferedReader(new FileReader(file_location));
            while ((line = file_read.readLine()) != null) {
                String[] new_values = line.split(",");
                test_book.put(new_values[0], new_values[1]);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void readData_FromFile_PassTo_List(List<Ad_book_source> test_book, String file_location) {
        String line = "";
        try {

            BufferedReader file_read = new BufferedReader(new FileReader(file_location));

            while ((line = file_read.readLine()) != null) {
                String[] new_values = line.split(",");
                Ad_book_source test_booked = get_user(new_values);
                test_book.add(test_booked);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

