package collectionsFramework;

import java.util.ArrayList;
import java.util.List;
class CarNew {
    String brand;
    CarNew(String brand) {
        this.brand  = brand;
    }
}
public class genericsDemo {
    public static void main(String[] args) {
        List<String> users  = new ArrayList<>();
        users.add("alice");
        users.add("Bob");
        users.add("Charlie");
//        users.add(1);
        users.add("Alice");

        for (Object user : users) {
            System.out.println(user);
        }
        System.out.println("Element using index " + users.get(1));

        //Lis of object
        CarNew car1 = new CarNew("Toyota");
        CarNew car2  = new CarNew("ford");
        List<CarNew>  carList = new ArrayList<>();  // it is a generics
        carList.add(car1);
        carList.add(car2);

        System.out.println("All Cars");
        for (CarNew car : carList) {
            System.out.println(car.brand);
        }
    }
}
