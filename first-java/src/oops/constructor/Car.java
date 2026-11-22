package oops.constructor;

public class Car {
    String brand;
    String color;
    int speed;


//    public Car(String brand) {
//         this.brand =  brand;
//    }
    public Car(String brand , String color, int speed) {      // brand, color  and speed -> this is parameter wala variable
        this.brand =  brand;     // this ka matlab hai ki instance vala variable  na ki parameter wala variable
        this.color =  color;
        this.speed =speed;
    }

    public Car(String brand) {
        this.brand =  brand;
    }


    public void drive() {
        System.out.println(brand+ " is driving at " + "color is " + color + " " + " and speed is "+speed);
    }

    public int getSpeed() {
        return speed; //  us instance ko return karega jo is method ko call kiya hu


    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}



















