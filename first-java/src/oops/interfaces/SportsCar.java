package oops.interfaces;

public class SportsCar implements CarControls {
    @Override
    public void turnRight() {
        System.out.println("SPORTS RIGHT");
    }

    @Override
    public void turnLeft() {
        System.out.println("SPORTS LEFT");
    }

    @Override
    public void applyBreaks() {
        System.out.println("SPORTS Break");
    }
}
