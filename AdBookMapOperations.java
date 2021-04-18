import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AdBookMapOperations {

    private static Scanner fetch = new Scanner(System.in);
    private static Map<String, AddressBook> addressBookMap = new HashMap<>();
    private Map<String, Contact> cityToPersonMap = new HashMap<>();

    public static void main(String[] args) {

        System.out.println("Proceed with the given below options");
        boolean userSatisfied = false;

        while (!userSatisfied) {

            System.out.println("1.create a new Book \n2.Add contacts to existing Book\n3.Find Contacts by City or State\n5.Exit from the Program");
            int choice = fetch.nextInt();
            System.out.println(choice);
            switch (choice) {
                case 1://Create new Address Book case
                    System.out.println("What name do you want the name of the Address Book to be ?");
                    addressBookMap.put(fetch.next(), new AddressBook());
                    System.out.println(addressBookMap.toString());

                    break;
                case 2://Add to existing book case
                    System.out.println("To which Address Book do you want to add the contacts to ?");
                    String addressBookName = fetch.next();

                    if (addressBookMap.containsKey(addressBookName)) {//Checking if List is present

                        System.out.println("Type the first name for checking");
                        String tempFirstName = fetch.next();

                        System.out.println("Type the last name for more checking");
                        String tempLastName = fetch.next();
                        System.out.println(addressBookMap.entrySet().stream().filter(value -> (value.getValue().duplicateCheck(tempFirstName, tempLastName)) == false).findAny());
                        //Checking for Duplicates inside multiple address Books
                        if (addressBookMap.keySet().stream().filter(value -> (value.equals(addressBookName))).findAny() == null) {

                        } else {
                            System.out.println("Address Book not found with your inputs");
                            break;
                        }//Checking if AddressBook is empty
                        if (addressBookMap.isEmpty()) {
                            AddressBook bookSystem = addressBookMap.get(addressBookName);
                            bookSystem.contactOperations();
                            break;
                        } else {
                            if (addressBookMap.entrySet().stream().filter(value -> (value.getValue().duplicateCheck(tempFirstName, tempLastName)) == false).findAny() == null) {
                                System.out.println("Duplicates found Please try Again");
                                break;
                            } else {

                                AddressBook bookSystem = addressBookMap.get(addressBookName);
                                bookSystem.contactOperations();
                            }
                        }

                        System.out.println(addressBookMap.toString());
                        break;
                    }
                case 3:

                    Map<String, Contact> cityToPersonMap = new HashMap<>();

                    System.out.println("In which state or City you want to Search ?");

                    String cityOrState = fetch.next();

                    /*  Using Streams to filter out the Contacts with the desired cityOrState or state  */
                    addressBookMap.entrySet().stream().forEach(value -> { Contact temporaryContact = value.getValue().findByCityReturnContact(cityOrState);
                                                                            cityToPersonMap.put(cityOrState,temporaryContact);});

                    System.out.println("The People Matching with your "+cityOrState+"are\n"+cityToPersonMap+"\nThe count is "+cityToPersonMap.size());
                    break;

                default:
                    userSatisfied = true;
                    break;

            }

        }
    }
}
