package oops.interfaces;

public class InterfaceDemo {
    public static void main(String[] args) {

        CarControls myCar1 = new ElectricCar();
        myCar1.turnLeft();

        CarControls myCar2 = new SportsCar();
        myCar2.turnLeft();
    }
}
