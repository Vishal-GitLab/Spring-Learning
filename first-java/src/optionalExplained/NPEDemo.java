package optionalExplained;

import java.util.Optional;

public class NPEDemo {
    public static void main(String[] args) {
//        String name = null;
//        System.out.println(name.length());     // null exception error
        String name = "Java";
        if (name != null)
            System.out.println(name.length());
        else
        System.out.println("No name value");

        // Optional
        Optional<String> optionalString = Optional.of("Vishal");
        System.out.println(optionalString);

        Optional<String> empty = Optional.empty();
        System.out.println(empty);

        // creating null value
        Optional<String>  mayBe  = Optional.ofNullable(null);    // agar ofNullable hai to null likh denge to handle kar lega....,,, agar optional.of me null likh denge to crash ho jayega
        System.out.println(mayBe);

        // Checking value
        System.out.println(optionalString.isPresent());
        System.out.println(mayBe.isPresent());

        System.out.println(optionalString.isEmpty());
        System.out.println(mayBe.isEmpty());

        // rertive karne ke liye get()  ka use karte hai
        System.out.println(optionalString.get());    // agr sure hai ki value hai tabhi ham get use karenge nhi to nhi
//        System.out.println(mayBe.get());       // agar ham mayBe par get use karenge to error aa jayegi

        // safe trike se value retrive karna

        // orElse("default value ")      -->> agar optional me value hai to return kar dega agar optional me value nahi hai to jo ham default value provide kar rhe hai usko provide kar denge

        System.out.println(optionalString.orElse("default"));
        System.out.println(mayBe.orElse("default"));
        String temp =  mayBe.orElse("default");

        // orElseGet()    --->> ye default value ke bajay ak supplier leta hai ...    use case-->.supplier ka matlab method execute karta hai ya to lamda value return karta hai agar usme optional value hai ya empty hai to
        String result = mayBe.orElseGet(()->{
            System.out.println("Generating default value");
            return "default";
        });
            //oeElseThrow() -->> ak aisi cheez hai agar value present hai to return kar denge agar valur present nahi hai to exception throw ka istemal kar sakte hai
       String newResult = optionalString.orElseThrow(
               () -> new RuntimeException("Not found")
       );
        System.out.println(newResult);
    }
}






