package fuctionalProgramming.inbuilt;

import java.util.function.BiFunction;
import java.util.function.Function;

public class biFunction {

    //  static is liye defined kar rhe hai ki bas aasani se call kar saku
//    public static BiFunction<Integer, Integer,Integer>  addFunction = (a,b) -> a + b;      // ak integer -- parameter h,, dursa integer bhi parameter hai,,,,   teesra integer return type hai
    public static BiFunction<Integer, Integer,Integer>  addFunction = Integer :: sum;
    public static BiFunction<Integer, Integer,Integer>  subsTractFunction = (a,b) -> a - b;

    public static void main(String[] args) {
        System.out.println(addFunction.apply(10,30));
        System.out.println(subsTractFunction.apply(10,5));

        Function<Integer, Integer> multipleBy2 = x  -> x * 2;
        BiFunction<Integer,Integer,Integer> combinedFunction =  addFunction.andThen(multipleBy2);
        System.out.println(combinedFunction.apply(2,5));      // pahle add karega fir multiply karega
    }
}
