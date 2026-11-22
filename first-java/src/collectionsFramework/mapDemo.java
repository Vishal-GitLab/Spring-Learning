package collectionsFramework;

import java.util.HashMap;
import java.util.Map;

public class mapDemo {
    public static  void main(String[] args){


        // hamko bnana padega ki map ke andae kis type ka data type store karna padega
        Map<Integer,String>  userMap = new HashMap<>();
        userMap.put(1, "Alice");
        userMap.put(2,"Bob");
        userMap.put(3,"Charlie");

        System.out.println("User with id 2: "  + userMap.get(2));

        System.out.println("All Users");
        for (Map.Entry<Integer,String> entry: userMap.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }
}
