package fuctionalProgramming.inbuilt;

import java.util.function.Function;

public class functionInterface {
    public static Function<Integer, Integer> addFunction = (a) -> a + 3;                    // rapper class ka use karenge .... rapper class ->> ak class hai ko primitive data type ko cross pond karta hai
    public static Function<Integer, Integer> substractFunction = (a) -> a - 3;

    // channing karne ke liye ...
    public static Function<Integer, Integer> combinedFunction =
            addFunction.andThen(substractFunction);               // andThen() ka use do Functions ko ek ke baad ek (sequence me) execute karne ke liye hota hai.

    public static void main(String[] args) {
        System.out.println(addFunction.apply(10));    // apply() Function Functional Interface ka abstract method hai.
        System.out.println(substractFunction.apply(20));
        System.out.println(substractFunction.apply(10));
    }
}
