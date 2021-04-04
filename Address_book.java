import java.util.ArrayList;
import java.util.List;

public class Address_book {

    public static void main(String[] args) {
        //Creating an arraylist instance of Ad_book_source
        List<Ad_book_source> user = new ArrayList<>();
        Ad_book_source new_ad_book = new Ad_book_source();
        user.add(new_ad_book);
        //Printing out the users added
        System.out.println(user.toString());
    }

}
