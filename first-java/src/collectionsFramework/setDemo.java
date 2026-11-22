package collectionsFramework;

import java.util.HashSet;
import java.util.Set;

public class setDemo {
    public static void main(String[] args) {
        Set<String> roles = new HashSet<>();
        roles.add("ADMIN");
        roles.add("USER");
        roles.add("MANAGER");

        // agar ham kisi prakar ka duplicate  karna chahte ha to add nahi hoga
        for (String role : roles ){
            System.out.println("ROLE: " + role);
        }
    }
}
