package fuctionalProgramming.inbuilt;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class methodReference {
    public static void main(String[] args) {
        // :: -> method reference syntax ka  use karna ,,,, ye ak shorthand notation hota hai jiske through ham method ko refer kar sakte hai
        // step 1, using for loop
        List<String> names  = Arrays.asList("Vishal" ,"Rahul", "Chaurasiya");
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));
        }

        // step 2 .. using enhance loop
        for(String name : names)
            System.out.println(name);


//        names.forEach(new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        });

//        names.forEach((String name) -> {
//            System.out.println(name);
 //       });

//        names.forEach(( name) -> {
//            System.out.println(name);
     //   });

        names.forEach(System.out::println);   // this is  methodReference

    }
}
