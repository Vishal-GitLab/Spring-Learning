package oops.constructor;

public class ConstructorDemo {
    public static void main(String[] args) {
        Car car1 = new Car("kiya", "white",120);
        car1.speed = 100;
        car1.brand = "Defender";
        car1.color = "Black";
        car1.drive();

        Car car2 = new Car("kiya", "white",120);
//        car2.speed =  120;
//        car2.brand  =  "Kia";
//        car2.color = "White";


        Car car3  = new Car("Defender");
        car3.drive();

        System.out.println(car2.getSpeed());
        car2.setSpeed(500);
        System.out.println(car2.getSpeed());
    }
}
