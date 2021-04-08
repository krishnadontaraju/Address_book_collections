import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AdBookMapOperations {

    private static Scanner fetch = new Scanner(System.in);
    private static Map<String, AdBookMain> addressBookMap = new HashMap<>();

    public static void main(String[] args) {

        System.out.println("Proceed with the given below options");
        boolean userSatisfied = false;

        while (!userSatisfied) {

            System.out.println("1.create a new Book \n2.Add contacts to existing Book\n3.exit");
            int choice = fetch.nextInt();
            System.out.println(choice);
            switch (choice) {
                case 1://Create new Address Book case
                    System.out.println("What name do you want the name of the Address Book to be ?");
                    addressBookMap.put(fetch.next(), new AdBookMain());
                    System.out.println(addressBookMap.toString());
                    break;
                case 2://Add to existing book case
                    System.out.println("To which Address Book do you want to add the contacts to ?");
                    String addressBookName = fetch.next();

                    if (addressBookMap.containsKey(addressBookName)) {
                        AdBookMain bookSystem = addressBookMap.get(addressBookName);
                        bookSystem.contactOperations();
                    }
                    else {
                        System.out.println("Address Book not found with your inputs");
                    }

                    System.out.println(addressBookMap.toString());
                    break;
                default:
                    userSatisfied = true;
                    break;
            }
        }
    }
}