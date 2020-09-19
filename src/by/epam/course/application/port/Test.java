package by.epam.course.application.port;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Port port = new Port(10000, 6000);

        Scanner scanner = new Scanner(System.in);
        int choice = 1;
        try {
            while (choice != 0) {
                System.out.println("Введите 0, чтобы выйти из программы");
                System.out.println("Введите 1, чтобы добавить в порт корабль");
                choice = scanner.nextInt();

                switch (choice) {
                    case 0 -> System.out.println("Завершение программы...");
                    case 1 -> {
                        System.out.println("Введите максимально допустимое число контейнеров и " +
                                "текущее число контейнеров на корабле");
                        port.addShip(new Ship(scanner.nextInt(), scanner.nextInt()));
                    }
                    default -> System.out.println("Недопустимая оперция!");
                }
            }
        } catch (InputMismatchException ex) {
            System.out.println("Ошибка ввода!");
            ex.printStackTrace();
        }
    }
}
