package optionalExplained;

import java.util.Optional;

public class functionalOperation {
    public static void main(String[] args) {
        Optional<String> name =  Optional.of("Java");
        Optional<String> nullOptional =  Optional.ofNullable(null);
        // ifPresent()     use -->> ye use hota hai ki optional me value hai ya nahi .. agar hai to kuch karo uske liye hame block of code aur function execute karna hoga agar value hai to
//        name.ifPresent(System.out::println);                // ifPresent as input me consumer leta hai  ,, consemer ka matlab ak parameter lega lekin return kuch bhi nahi karega
        nullOptional.ifPresent(value -> {
            System.out.println(value);
            System.out.println("Hey");       // kuch bhi print nahi hoga kyunki emty hai
        });


        // map()      --->> map ka use cheezo ko transform karne ke liye use kiya jata hai
        Optional<String>  upperCase = name.map(value  -> value.toUpperCase());
        System.out.println(upperCase.orElse("Default value"));

        // filter()
//        Optional<String> temp = name.filter(n->n.startsWith("J"));
//        temp.ifPresent(System.out::println);

        name.filter(n -> n.startsWith("J"))    // short form of filter
                .ifPresent(System.out::println);

        // Combined Operation
        name.filter(n -> n.startsWith("F"))
                .map(String::toUpperCase)
                .ifPresent(System.out::println);
    }
}
























