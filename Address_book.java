import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Address_book {


    public static void main(String[] args) {
        Scanner fetch = new Scanner(System.in);
        //Creating an arraylist instance of Ad_book_source
        List<Ad_book_source> user = new ArrayList<>();
        List<Ad_book_source> removable_list = new ArrayList<>();
        Ad_book_source new_ad_book = new Ad_book_source();
        user.add(new_ad_book);
        //Printing out the users added
        System.out.println(user.toString());

        //Calling whose details the user wants to edit
        System.out.println("Do you want to edit details of someone\ngive me a Yes or no");
        String first_choice = fetch.nextLine();
        if (first_choice == "yes" || first_choice == "Yes") {
            boolean entry_found = false;
            System.out.println("Whose details do you want to change ?");
            String change_input = fetch.next();
            for (Ad_book_source i : user) {
                //When found user's desired choice call change details method
                if (i.getName().equals(change_input)) {

                    i.change_details();
                }

            }


        }

        System.out.println("Do you want to edit details of someone\ngive me a Yes or no");
        String second_choice = fetch.nextLine();
        if (second_choice == "yes" || second_choice == "Yes") {
            System.out.println("WHOSE DETAILS DO YOU WANT TO DELETE");
            String delete_input = fetch.next();
            for (Ad_book_source i : user) {//iterating through the arraylist until finds user's input

                if (i.getName().equals(delete_input)) {

                    removable_list.add(i);// Using to_remove instance to store remove properties
                    System.out.println("DELETED " + i.getName());
                    break;
                } else {
                    System.out.println("WRONG INPUT");
                    i.zero_set();
                }


            }
            user.removeAll(removable_list);// removing stored user details


        }

    }

}



