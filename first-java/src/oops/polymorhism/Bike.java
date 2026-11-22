package oops.polymorhism;

public class Bike extends Vehicle {
    private boolean hashCarrier;
    public Bike(String brand, int speed, boolean hashCarrier) {
        super(brand, speed);
        this.hashCarrier = hashCarrier;
    }


    @Override          // bina iske bhi ho jayega lekin agar override kar denge to koi bhi hmara code aasani se read kar lega
    public void start() {    // one without parameter
        System.out.println("Starting Bike");;
    }

    public void start(String greet) {      // one with parameter
        System.out.println("Starting Bike" + greet );;
    }
    public boolean isHashCarrier() {
        return hashCarrier;
    }

    public void setHashCarrier(boolean hashCarrier) {
        this.hashCarrier = hashCarrier;
    }
}
