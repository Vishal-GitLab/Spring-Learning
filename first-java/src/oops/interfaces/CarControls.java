package oops.interfaces;

public interface CarControls {
    void turnRight();
    void turnLeft();
    void applyBreaks();

    default void accelerate() {

    }
}
