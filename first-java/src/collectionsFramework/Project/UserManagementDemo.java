package collectionsFramework.Project;

import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.*;

public class UserManagementDemo {
    public static void main(String[] args) {
//        Set<String> user1Roles =  new HashSet<>(Arrays.asList("ADMIN","USER"));    // Array ak inbuilt class hai ..  asList --->> Array ko list me convert kar rha hai  .. and  HashSet -->>  isse initilize
//        User user1  =  new User(true,"Alice", true);


        List<User> users =  new ArrayList<>();
        users.add(new User(true, "Alice",
                new  HashSet<>(Arrays.asList("ADMIN","USER"))));


        users.add(new User(false, "Bob",
                new  HashSet<>(Arrays.asList("USER"))));


        users.add(new User(true, "Charlie",
                new  HashSet<>(Arrays.asList("MANAGER"))));


        // Inactive user nikalne ke liye Iterator ka use karte h
        // REMove Inactive users

        Iterator<User> iterator =  users.iterator();
        while(iterator.hasNext()){
            if (!iterator.next().isActive())
                iterator.remove();
        }

        // print active users
        System.out.println("ACTIVE USERS");
        for (User user: users)
            System.out.println(user.getName());


        // count users per role
        Map<String,Integer> roleCount  =  new HashMap<>();    // role count ak map hai
          roleCount.get("ifufyes");    // get ak version hai jaha ham default value assign kae sakte hai
        // role count me kya store hoga
        // MANAGER:1       --> PAHLE YE STORE HOGA
        // ADMIN:1          -->> FIR YE STORE HOGA
        for (User user : users) {
            for (String role : user.getRoles()){
                roleCount.put(role, roleCount.getOrDefault(role, 0)+1);    //
            }
        }
        System.out.println("All users");
        for (Map.Entry<String,Integer> entry : roleCount.entrySet()) {
            System.out.println(entry.getKey()+ " : " + entry.getValue());
        }
    }
}



















