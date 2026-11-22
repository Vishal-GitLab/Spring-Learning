package collectionsFramework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Iterating {
    public static void main(String[] args) {
        List<String> users  = new ArrayList<>();
        users.add("alice");
        users.add("Bob");
        users.add("Charlie");
        users.get(0);

        // For each
        System.out.println("USING FOR EACH");
        for (String user: users)
            System.out.println(user);

        // For loop
        System.out.println("Using For loop");
        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i));

            // ITERATOR
            Iterator<String > it = users.iterator();
            while (it.hasNext()) {
               // System.out.println(it.next());
                if (it.next().equals("Bob")) {
                    it.remove();
                }
            }
            for (String user: users)
                System.out.println(user);

        }
    }
}
