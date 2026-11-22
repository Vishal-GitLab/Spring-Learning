package oops.polymorhism;

public class Car extends Vehicle {
    private int doors;

    public Car(String brand, int speed, int doors){
        super(brand, speed);       //super ka matlab upar value pass karna ,,,,,, parante class ke onstructoer ko call kar rha hai
        // agar parant class me private hai to usko access krne ke liye super ka use karte h
        this.doors =  doors;
    }


    public void start() {
        System.out.println("Starting Car");;
    }
    @Override
    public void displayInfo() {
   super.displayInfo();
        System.out.println("Brand: " + getBrand()  + ", Speed"+ getSpeed()  + " Km/hr "+doors+" ");
    }


}
