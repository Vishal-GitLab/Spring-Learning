package fuctionalProgramming.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class streamDemo {
    public static void main(String[] args) {
        // Streams --> Assembly line / pipeline
        List<String> items = Arrays.asList("Apple","Banana","Mango");
        for (String fruits : items){
            System.out.println(fruits);
        }
        // using Stream
        Stream<String>  stream =  items.stream();
        stream.forEach(System.out::println);

//        Stream<String> streamNew = items.stream();
//        Stream<String> filteredStream = streamNew.filter(name -> name.startsWith("B"));
//        filteredStream.forEach(System.out::println);

//        Stream<String> streamNew = items.stream();
//        Stream<String> filteredStream = streamNew.filter(name -> name.startsWith("B"));
//        filteredStream.forEach(System.out::println);

        items.stream()
                .filter(name -> name.startsWith("B"))
                .forEach(System.out::println);

        /*
        *USECASES
        * 1. Filtering -->> jaise hmare pass list hai usko filter karna chahte hai
        * 2.Mapping -->>  hmare pass ak trah ka element hai usko ham dusre trah ke element me map krana chahte hai
        * 3. Aggregation -->> hmare pass ak list hai usko aggregate karna chahte hai  .. jaise addition krana chahte hai aur sabko add  karke mutiply by 2 krana chahte hai aur sirf even number ka addition krana chahte hai
        * 4.  Searching -->> ham kisi element ko search karne ke loye use karte hai
        *  5. Iteration -->> agar hamko print karna hai kuch ,, action perform karna hai har kisi element par jo kisi bhi element ka part hai
         */
    }
}










