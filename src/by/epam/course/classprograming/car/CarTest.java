package by.epam.course.classprograming.car;

public class CarTest {
    public static void main(String[] args) {
        Car car = new Car();
        car.print();

        car.turnOn();
        System.out.println("Машина проехала " + car.drive() + " км.");

        System.out.println("Остаток бензина: " + car.getFuel());
        car.refuel(100);

        car.changeWheel("Pirelli", 20, 2);

        System.out.println();
        car.print();
    }
}
