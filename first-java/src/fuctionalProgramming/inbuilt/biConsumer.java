package fuctionalProgramming.inbuilt;

import java.util.function.BiConsumer;

public class biConsumer {
    public static void main(String[] args) {
        BiConsumer<Integer,Integer> addConsumer = (a,b) -> System.out.println("Addition two number: "+ (a+b));
        addConsumer.accept(4,5);
    }
}
