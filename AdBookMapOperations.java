import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AdBookMapOperations {

    static final String FILE_LOCATION = "C:\\Users\\manik\\Desktop\\new\\Program_tester\\JAVA_content\\FileFolder\\AddressBookFiles";
    static final String MAP_FILE = "mapLink.txt";
    static PrintWriter mapToFile;
    static String mapPath = "C:\\Users\\manik\\Desktop\\new\\Program_tester\\JAVA_content\\FileFolder\\AddressBookFiles" + "\\" + MAP_FILE;
    private static Scanner fetch = new Scanner(System.in);
    private static Map<String, AddressBook> addressBookMap = new HashMap<>();
    private Map<String, Contact> cityToPersonMap = new HashMap<>();

    public static void main(String[] args) {

        try {
            readDataFromFilePassToMap(MAP_FILE, addressBookMap);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            e.printStackTrace();
        }
        System.out.println("Proceed with the given below options");
        boolean userSatisfied = false;

        while (!userSatisfied) {

            System.out.println("1.create a new Book \n2.Add contacts to existing Book\n3.Find Contacts by City or State\n4.Sort the contacts by First Name\n5.Sort the contacts by City\n6.Sort the contacts by State\n7.Sort the contacts by Zip\n8.Exit from the Program");
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
                        System.out.println(addressBookMap.entrySet().stream().filter(value -> !(value.getValue().duplicateCheck(tempFirstName, tempLastName))).findAny());
                        //Checking for Duplicates inside multiple address Books
                        if (addressBookMap.keySet().stream().noneMatch(value -> (value.equals(addressBookName)))) {

                        } else {
                            System.out.println("Address Book not found with your inputs");
                            break;
                        }//Checking if AddressBook is empty
                        if (addressBookMap.isEmpty()) {
                            AddressBook bookSystem = addressBookMap.get(addressBookName);
                            bookSystem.contactOperations();
                            break;
                        } else {
                            if (addressBookMap.entrySet().stream().allMatch(value -> value.getValue().duplicateCheck(tempFirstName, tempLastName))) {
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
                    addressBookMap.forEach((key, value1) -> {
                        Contact temporaryContact = value1.findByCityReturnContact(cityOrState);
                        cityToPersonMap.put(cityOrState, temporaryContact);
                    });

                    System.out.println("The People Matching with your " + cityOrState + "are\n" + cityToPersonMap + "\nThe count is " + cityToPersonMap.size());
                    break;

                case 4:

                    /*  Stream to sort Contacts by First names */

                    addressBookMap.forEach((key1, value2) -> value2.sortByFirstName());

                    System.out.println("Your Contact Book is sorted " + addressBookMap.toString());

                    break;

                case 5:

                    /*  Stream to sort Contacts by City */

                    addressBookMap.forEach((key1, value2) -> value2.sortByCity());

                    System.out.println("Your Contact Book is sorted " + addressBookMap.toString());

                    break;

                case 6:

                    /*  Stream to sort Contacts by State */

                    addressBookMap.forEach((key, value1) -> value1.sortByState());

                    System.out.println("Your Contact Book is sorted " + addressBookMap.toString());

                    break;

                case 7:

                    /*  Stream to sort Contacts by Zip Codes */

                    addressBookMap.forEach((key, value1) -> value1.sortByZipCode());

                    System.out.println("Your Contact Book is sorted " + addressBookMap.toString());

                    break;

                default:
                    userSatisfied = true;
                    writeData(FILE_LOCATION+mapToFile);
                    break;

            }

        }
    }

    public static Map readDataFromFilePassToMap(String filePath, Map testMap) throws IOException, CsvValidationException {

        try (var fileReader = new FileReader(filePath);
             var csvFileReader = new CSVReader(fileReader)) {

            String[] nextLine;

            while ((nextLine = csvFileReader.readNext()) != null) {

                for (var e : nextLine) {

                    testMap.put(nextLine[0], nextLine[1]);

                }
            }
        }

        return testMap;

    }

    public static void writeData(String filePath) {

        try {
            CSVWriter mapWriter = new CSVWriter(new FileWriter(String.valueOf(Path.of(filePath))));
            mapWriter.writeAll((List<String[]>) addressBookMap);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
