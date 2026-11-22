package collectionsFramework;

import java.util.ArrayList;
import java.util.List;
         class Car {
             String brand;
             Car(String brand) {
                 this.brand  = brand;
             }
         }
public class listDemo {
    public static void main(String[] args) {
        List<String> users  = new ArrayList<>();
        users.add("alice");
        users.add("Bob");
        users.add("Charlie");

//        for (Object user : users) {
//            System.out.println(user);
//        }
        System.out.println("Element using index " + users.get(1));

        //Lis of object
        Car car1 = new Car("Toyota");
        Car car2  = new Car("ford");
        List<Car>  carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);

        System.out.println("All Cars");
        for (Car car : carList) {
            System.out.println(car.brand);
        }
    }
}
