package fuctionalProgramming.inbuilt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class supplierDemo {     // ye sirf ak value generate karta h bs
    public static void main(String[] args) {
        Supplier<Double> randomNum = () -> Math.random();
        System.out.println(randomNum.get());
    }

}
