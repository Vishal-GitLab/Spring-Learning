package oops.encapsulation;
 class Car {
     private String brand;
     private String color;
     private int speed;


     public Car(String brand, String color, int speed) {      // brand, color  and speed -> this is parameter wala variable
         this.brand = brand;     // this ka matlab hai ki instance vala variable  na ki parameter wala variable
         this.color = color;
         this.speed = speed;
     }

     public void drive() {
         System.out.println(brand + " is driving at " + "color is " + color + " " + " and speed is " + speed);
     }

     public int getSpeed() {
         return speed;
     }

     public void setSpeed(int speed) {
         if (speed < 0)
             speed = 0;
         this.speed = speed;
     }
 }
     public class encapsulationDemo {
         public static void main(String[] args) {
             Car car1 = new Car("Toyota", "red", 100);    //  agar set ko hta denge tab ab speed ki vallue ak bar hi set hoti h jab  objact create hota h  , uske bad koi nahi set kar sakta hai
             car1.setSpeed(-200);
             car1.drive();

             Car car2 =  new Car("kiya","white",200);
             car2.drive();
         }
     }














