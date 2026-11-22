package fuctionalProgramming.streams.terminslOperstions;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOperations {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10,20,30,44,50,55);
        // reduce     -->> ak aisa operation jiski help se jo ak stream me value hai usko ak  final value me la sakte hai
        Stream<Integer> integerStream = numbers.stream();
//        int  sum  = integerStream.reduce(0,(acc,num)->acc + num);  // ak parameter hai identity and ak parameter hai accumulator ,,, jiski help se hame array ke list ka sum mil jayega.... accumulator ak aisi value ka track rkhta h jo har value ko add karta hai
        int  sum  = integerStream.reduce(0, Integer::sum);
        System.out.println("SUM: " + sum);

        // short form
        int total =  numbers.stream()
                .reduce(0,Integer::sum);
        System.out.println("TOTAL: "+ total);
       // collect   .... collect is terminal operation ...  jo stream me result hai usko collect kar sakte hai ... ham collect ko alag form me le sakte hai jaise ki list, set
        List<Integer> evenNumber =  numbers.stream()
                .filter( n ->n % 2 !=0)
                .collect(Collectors.toList());
        System.out.println("EVEN NUMBERS: " + evenNumber);

        // ham isko set me bhi print kra sakte hai
        Set<Integer> evenNumberSet =  numbers.stream()
                .filter( n ->n % 2 ==0)
                .collect(Collectors.toSet());
        System.out.println("EVEN NUMBERS: " + evenNumberSet);


        // find & match
        System.out.println(numbers.stream().findFirst().get());              // first   ak optional return kar dega jiski value null rahega
        System.out.println(numbers.stream().findAny().get());

        boolean has40 = numbers.stream()
                .anyMatch(n -> n ==40);      // anyMatch jisme koi bhi value match krani aur return na  krana ho .. ture and false me answer deta hai..,,,     allMatch  ->>koi ak condition hai jisme sare stream match hone chahiye to ham use karenge ....,,,, noneMatch -->>         return ksrega ture agar koi bhi match nhi huaa to
        System.out.println(has40);
        // iteration
        numbers.stream()
                .forEach(n -> System.out.println(n));
    }
}
