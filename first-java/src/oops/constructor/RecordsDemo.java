package oops.constructor;

  record Bike(String brand, int speed) {

  }
public class RecordsDemo {
    public static void main(String[] args) {
        Bike bike = new Bike("Thar",230);
        System.out.println("Brand: " + bike.brand());
        System.out.println("Speed: " + bike.speed());
    }
}
