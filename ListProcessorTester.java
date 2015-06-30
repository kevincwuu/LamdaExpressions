package LambdaExpressions;

import GenericsLibrary.*;
import GenericsLibrary.Date;

import java.lang.reflect.Array;
import java.util.*;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class ListProcessorTester {

    public void printArr(ArrayList<LibraryItem> arr) {
        for (LibraryItem l : arr) {
            System.out.println(l);
        }
    }

    public static void main(String[] args) {
        ListProcessor listProc = new ListProcessor();
        LibraryCollection libcol = new LibraryCollection();
        ArrayList<LibraryItem> arr = new ArrayList<>();
        CheckoutCart cart = new CheckoutCart();

        Date d1 = new Date(2015, 05, 03);
        Book book1 = new Book(2, "Enchanting novel about a young Wizard", "Harry Potter by J.K. Rowling", d1);

        Date d2 = new Date(2015, 05, 04);
        Book book2 = new Book(5, "A vivid roaring dissent", "The Circle by Dave Eggers", d2);

        Date d3 = new Date(2015, 05, 15);
        Book book3 = new Book(10, "Harsh words spoken of the greatest among intellecutal leaders", "The Open Society and Its Enemies by Karl R. Popper", d3);

        Date d4 = new Date(2015, 05, 23);
        Book book4 = new Book(15, "Fantasy world with polar bears, yay", "Cloud Atlas by David Mitchell", d4);

        Date d5 = new Date(2015, 05, 15);
        Date d6 = new Date(2015, 04, 12);

        DVD dvd1 = new DVD(22, "The MazeRunner", d5);
        DVD dvd2 = new DVD(24, "Avengers", d6);

        Date d7 = new Date(2015, 04, 25);
        Magazine mag1 = new Magazine(52, "Newest Maxim Edition", d7);

        Date d8 = new Date(2015, 04, 15);
        Magazine mag2 = new Magazine(53, "Newest GQ Edition", d8);

        arr.add(book1);
        arr.add(book2);
        arr.add(book3);
        arr.add(book4);
        arr.add(dvd1);
        arr.add(dvd2);
        arr.add(mag1);
        arr.add(mag2);


        Consumer<Integer> c = (Integer x) -> {
            System.out.println(x);
        };

        System.out.println("#1 Results after printing the list of library items: ");

        listProc.forEach(
                arr,
                (x) -> {
                    System.out.println(x);
                });

        System.out.println();
        System.out.println("===================================");
        System.out.println();


        System.out.println("#2 Results after printing the list of book: ");
        System.out.println(listProc.filter(
                arr,
                p -> (p instanceof Book) == true
        ));


        System.out.println();
        System.out.println("===================================");
        System.out.println();

        System.out.println("#3 Results after printing the list of library items' description: ");

        listProc.forEach(
                arr,
                (LibraryItem x) -> {
                    System.out.println(x.getDescription());
                });

        System.out.println();
        System.out.println("===================================");
        System.out.println();

        Date d9 = new Date(2015, 04, 18);


        System.out.println("#4 Results after printing the list of overdue library items: ");
        listProc.filter(arr,
                (LibraryItem x) -> libcol.isOverdue(d9, x.getD()) == true);

        System.out.println();
        System.out.println("===================================");
        System.out.println();

        System.out.println("#5 Results after printing the list of overdue library items: ");

        cart.getOverDueBooks(LibraryCollection.class, 5, d9, libcol);

        listProc.filter(arr,
                (LibraryItem x) -> libcol.isOverdue(d9, x.getD()) == true && (x instanceof Book
                ));
        
        listProc.map(arr,
                (x) -> cart.getOverDueBooks(LibraryCollection.class, 5, d9, libcol)
        );

        System.out.println();
        System.out.println("===================================");
        System.out.println();
    }
}
