package fuctionalProgramming.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class firstStreamDemo {
    public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

    // ITERATION 1 List: even  number from "numbers" list
    List<Integer> evenNumber1 = new ArrayList<>();
            for (int num : numbers) {
        if (num % 2 == 0)
            evenNumber1.add(num);
    }
            System.out.println("Even numbers without stream: " + evenNumber1);

    // ITERATION 2 -- USING STREAM
    Stream<Integer> integerStream1 = numbers.stream();
    Stream<Integer> integerStream2 = integerStream1.filter(p2);
    List<Integer> evenNumber2 = integerStream2.toList();
            System.out.println("Even number with stream 2: " + evenNumber2);

    // ITERATION 3
    List<Integer> eveNumbers3 = numbers.stream()      // ye hamara sourece hai    ........ ye ak steram return kar rha hai
            .filter(num -> num % 2 == 0)       // ye hamara intermidiate operation...... ye stream par filter karke dusri stream return kar rha h   aur isme predicate ka use kar rhe hai
            .toList();                        // ye hamari terminal operation hai  .... aur isme collect kar rhe hai
            System.out.println("Even number with stream 3: " + eveNumbers3);


}
static Predicate<Integer> p = new Predicate<Integer>() {
    @Override
    public boolean test(Integer integer) {
        int remainder  = integer % 2;
        if (remainder == 0)
            return  true;
        return false;
    }
};
static Predicate<Integer> p2 = (integer) -> integer  % 2 == 0;
}
