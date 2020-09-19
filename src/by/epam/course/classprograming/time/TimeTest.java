package by.epam.course.classprograming.time;

import java.util.InputMismatchException;
import java.util.Scanner;


public class TimeTest {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            Time time = new Time();

            int choice = 1;

            while (choice != 0) {
                System.out.println("\nВведите 0 для прекращения работы.");
                System.out.println("Введите 1 для того, чтобы установить время при помощи строки.");
                System.out.println("Введите 2 для того, чтобы установить время при помощи ввода часов, минут, секунд.");
                System.out.println("Введите 3, чтобы установить часы.");
                System.out.println("Введите 4, чтобы установить минуты.");
                System.out.println("Введите 5, чтобы установить секунды");
                System.out.println("Введите 6, чтобы прибавить часы.");
                System.out.println("Введите 7, чтобы прибавить минуты.");
                System.out.println("Введите 8, чтобы прибавить секунды.");
                System.out.println("Введите 9, чтобы вывести время.");


                choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> {
                        System.out.println("\nВведите время (HH:MM::SS):");
                        time.setTime(scanner.next());
                    }
                    case 2 -> {
                        System.out.println("\nВведите часы, минуты, секунды в указанном порядке через пробел:");
                        time.setTime(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
                    }
                    case 3 -> {
                        System.out.println("\nВведите часы:");
                        time.setHours(scanner.nextInt());
                    }
                    case 4 -> {
                        System.out.println("\nВведите минуты:");
                        time.setMinutes(scanner.nextInt());
                    }
                    case 5 -> {
                        System.out.println("\nВведите секунды:");
                        time.setSeconds(scanner.nextInt());
                    }
                    case 6 -> {
                        System.out.println("\nВведите часы:");
                        time.addHours(scanner.nextInt());
                    }
                    case 7 -> {
                        System.out.println("\nВведите минуты:");
                        time.addMinutes(scanner.nextInt());
                    }
                    case 8 -> {
                        System.out.println("\nВведите секунды:");
                        time.addSeconds(scanner.nextInt());
                    }
                    case 9 -> System.out.println(time);
                }
            }

        } catch (InputMismatchException ex) {
            System.out.println("Ошибка ввода! " + ex.getMessage());
        }
    }
}
