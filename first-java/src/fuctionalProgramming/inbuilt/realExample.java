package fuctionalProgramming.inbuilt;

import javax.swing.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class realExample {
    public static void main(String[] args) {
        // <tittle>  costs $ <price>
        BiFunction<String, Double, String> formatter = (tittle, price) -> tittle + "cost $" + price;
        System.out.println(formatter.apply("Java Basics", 599.49));
        System.out.println(formatter.apply("Python Basics", 59.49));

        System.out.println();

        // hamko jab return nahi karna ho sirf print karna ho to BiConsumer ka use karenge
        BiConsumer<String, Double> formatterConsumer = (tittle, price) -> System.out.println(tittle + "cost $" + price);
        formatterConsumer.accept("Java Basics", 599.49);
         formatterConsumer.accept("Python Basics", 59.49);

         // agar hamko janna ho ki kisi product  ke liy expencive hai ya nhi  to ham isExpensive ka use  karenge
        Predicate<Double> isExpensive  = price -> price > 500;
        System.out.println(isExpensive.test(900.3));
    }
}
