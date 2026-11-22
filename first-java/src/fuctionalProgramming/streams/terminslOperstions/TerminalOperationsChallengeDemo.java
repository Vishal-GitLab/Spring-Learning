package fuctionalProgramming.streams.terminslOperstions;

import fuctionalProgramming.streams.intermidiate.Book;
import jdk.jfr.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TerminalOperationsChallengeDemo {
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

        // total cost of all books in the bookstore
        Double bookCost =  books.stream()
                .mapToDouble(book -> book.price)
                        .reduce(0, Double::sum);
        System.out.println(bookCost);


        // Collecting books into a list of titles
        List<String> bookTitles = books.stream()
                .map(book -> book.title)
                .collect(Collectors.toList());
        System.out.println(bookTitles);


        // Grouping books by category

      Map<String, List<Book>> byCategory = books.stream()
//                .collect(Collectors.groupingBy(bookStringFunction));
              .collect(Collectors.groupingBy(Book::getCategory));

        byCategory.forEach((category,bookList)->{
          bookList.forEach(System.out::println);
      });

    }
   static Function<Book,String> bookStringFunction =  new Function<Book, String>() {  // static ka use iliye kiye hai ki directly call kar sakw
        @Override
        public String apply(Book book) {
            return book.getCategory();

        }
    };
}
