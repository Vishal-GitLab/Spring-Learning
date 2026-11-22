package oops.interfaces;

public class ElectricCar implements CarControls {
    @Override
    public void turnRight() {
        System.out.println("ELECTRIC RIGHT");
    }

    @Override
    public void turnLeft() {
        System.out.println("ELECTRIC LEFT");
    }

    @Override
    public void applyBreaks() {
        System.out.println("ELECTRIC BREAK");
    }
}
