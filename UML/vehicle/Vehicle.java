public class Vehicle {
    private String brand;
    private int speed;

    public void accelerate(int amount) {
        speed += amount;
    }

    public void brake(int amount) {
        speed -= amount;
    }

    public int getSpeed() {
        return speed;
    }
}
