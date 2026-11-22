package fuctionalProgramming.streams.intermidiate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class intermediateDemo {
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

        //1. Filtering: books cheaper than $20
//        Stream<Book>  stream1= books.stream();
//        Stream<Book> stream2 = stream1.filter(book -> book.price <  20);
//        stream2.forEach(System.out::println);

        Stream<Book>  filteredBook= books.stream()
         .filter(book -> book.price <  20);
        filteredBook.forEach(System.out::println);

        //2. Mapping:  Convert books title to uppercase       ... Mapping conversion ke liye use hota hai .. ak  form se dusre form me convert karna hai to... stream form me
         Stream<String> upperCaseTitle = books.stream()
                 .map(book -> book.title.toUpperCase());
         upperCaseTitle.forEach(System.out::println);

        //3. Sorting: Books by publications date
          Stream<Book> sortedBooks = books.stream()
                  .sorted(Comparator.comparingInt(book ->book.publicationsYear));                  // ak aisi cheez hai jaha ham apna logic define karte hai ... aur jo hamko compare krana hai usko usi form me compare krayenge
        sortedBooks.forEach(System.out::println);
        // 4. Distinct: Remove duplicate title
        Stream<Book> uniqueBooks =  books.stream().distinct();
        uniqueBooks.forEach(System.out::println);

        System.out.println();
        // 5. Limit: Display  only the first 3 books
        System.out.println("DISPLAY FIRST 3 PUBLISHED BOOK BY PUBLICATION YEAR");
          Stream<Book> firstThreeBooks = books.stream()
                  .sorted(Comparator.comparingInt(book ->book.publicationsYear))
                  .limit(3);
        firstThreeBooks.forEach(System.out::println);
        // 6. Skip: Skip the first 2 books
        System.out.println("After skipping two books ");
         Stream<Book> afterSkippingTwo = books.stream()
                 .skip(2);
        afterSkippingTwo.forEach(System.out::println);

    }
//    static Predicate<Book> predicate = new Predicate<Book>() {
//        @Override
//        public boolean test(Book book) {     // this is test case
//            return book.price < 20;
//        }
//    };
}
