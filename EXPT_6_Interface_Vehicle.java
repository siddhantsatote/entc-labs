interface Vehicle {
    int MAX_SPEED = 200;  // public static final
    void start();
    void stop();
    void displayInfo();
}

class Car implements Vehicle {
    String model;
    int speed;

    Car(String m, int s) {
        model = m;
        speed = s;
    }

    public void start() {
        System.out.println(model + " car started.");
    }

    public void stop() {
        System.out.println(model + " car stopped.");
    }

    public void displayInfo() {
        System.out.println("Car: " + model + " | Speed: " + speed + " km/h");
    }
}

class Bike implements Vehicle {
    String brand;
    int speed;

    Bike(String b, int s) {
        brand = b;
        speed = s;
    }

    public void start() {
        System.out.println(brand + " bike started.");
    }

    public void stop() {
        System.out.println(brand + " bike stopped.");
    }

    public void displayInfo() {
        System.out.println("Bike: " + brand + " | Speed: " + speed + " km/h");
    }
}

public class InterfaceDemo {
    public static void main(String[] args) {
        Vehicle car = new Car("Toyota Camry", 180);
        Vehicle bike = new Bike("Royal Enfield", 140);

        car.displayInfo();
        car.start();
        car.stop();

        bike.displayInfo();
        bike.start();
        bike.stop();
    }
}
