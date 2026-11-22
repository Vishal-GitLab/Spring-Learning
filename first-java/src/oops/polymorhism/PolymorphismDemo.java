package oops.polymorhism;

public class PolymorphismDemo {
    public static void main(String[] args) {
        Car c1  =  new Car("Toyota",200,5);
        c1.displayInfo();

      Bike b1  =  new Bike("Yamaha", 120, true);
        b1.displayInfo();

        c1.start();
        b1.start();

        Vehicle v1  =  new Vehicle("VehicleBrand",202);
        v1.start();
          // Method Overriding (Runtime polymorphism)
        Vehicle v2  =  new Car("Toyota",200,5);    // ham new operator se car class ko access kar skate ... vehicle ko access karte time ye dekha ki car kke object ko access karna hai
        v1.start();

        Vehicle v3  = new  Bike("Yamaha", 120, true);
        v3.start();


        // method overloading
        b1.start("Hello");

    }
}
