package oops.inheritance;

public class Bike extends Vehicle {
    private boolean hashCarrier;
    public Bike(String brand, int speed, boolean hashCarrier) {
        super(brand, speed);
        this.hashCarrier = hashCarrier;
    }

    public boolean isHashCarrier() {
        return hashCarrier;
    }

    public void setHashCarrier(boolean hashCarrier) {
        this.hashCarrier = hashCarrier;
    }
}
