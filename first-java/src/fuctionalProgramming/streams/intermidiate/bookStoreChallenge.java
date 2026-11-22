package fuctionalProgramming.streams.intermidiate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class bookStoreChallenge {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();

        books.add(new Book("Fiction", 19.99, 1988, "The Alchemist"));
        books.add(new Book("Programming", 14.50, 2008, "Clean Code"));
        books.add(new Book("Programming", 20.00, 2018, "Effective Java"));
        books.add(new Book("Self Help", 50.00, 2018, "Atomic Habits"));
        books.add(new Book("Finance", 15.00, 1997, "Rich Dad Poor Dad"));
        books.add(new Book("Motivation", 390.00, 1937, "Think and Grow Rich"));
        books.add(new Book("Computer Science", 13.00, 2022, "Introduction to Algorithms"));
        books.add(new Book("Programming", 16.70, 2019, "The Pragmatic Programmer"));
        books.add(new Book("Fantasy", 23.00, 1997, "Harry Potter and the Philosopher's Stone"));
        books.add(new Book("Science Fiction", 18.50, 1965, "Dune"));

         // Discounted Books:The bookstore is planning a sale.
         // Identify all books that are priced over $20. Display these books.
        // using filtering method
        Stream<Book> filterBooks  = books.stream()
                .filter(book -> book.price > 20);
        filterBooks.forEach(System.out::println);


         // Classics Collection:The bookstore is launching a classics collection.
        //Identify and display books that were published before the year 2000.
        System.out.println("books that were published before the year 2000");
        Stream<Book> filterYear  = books.stream()
                .filter(book -> book.publicationsYear < 2000);
        filterYear.forEach(System.out::println);

         // Upcoming Titles: Generate a list of future book titles for the next year
         // by adding the suffix "(Coming Soon)" to all the current titles.
        System.out.println("adding the suffix \"(Coming Soon)\" to all the current titles");
         books.stream().map( book->book.title+"(coming soon)").forEach(System.out::println);

         //Sort by Price:The bookstore wants to print price tags for all the books.
         // The bookstore wants to print price tags for all the books.
         // Display the books sorted by their prices in ascending order.
        System.out.println("Display the books sorted by their prices in ascending order.");
        Stream<Book>  shortByPrice  = books.stream()
                .sorted(Comparator.comparingDouble(book->book.price));
        shortByPrice.forEach(System.out::println);

        // Rare Books: The bookstore believes there might be rare books in the collection.
         // A rare book is one where the title has more than 20 characters.Identify and display these books.
        System.out.println(" A rare book is one where the title has more than 20 characters.Identify and display these books");
        books.stream()
                .filter(book -> book.title.length() > 20)
                .forEach(System.out::println);

    }
}
