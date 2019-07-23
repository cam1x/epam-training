package by.epam.course.classprograming.counter;

import java.util.*;

public class CounterTest {

    public static void main(String[] args){

        try {
            Scanner scanner = new Scanner(System.in);

            DecimalCounter counter = new DecimalCounter();

            int choice = 1;

            while (choice != 0) {
                System.out.println("\nВведите 0 для прекращения работы.");
                System.out.println("Введите 1 для того, чтобы установить значение счетчика.");
                System.out.println("Введите 2 для демонстрации цикла счетчика (10-итераций).");
                System.out.println("Введите 3 для демонстрации обратного цикла счетчика (10-итераций).");
                System.out.println("Введите 4 для увелечения счетчика на произвольное число.");
                System.out.println("Введите 5 для уменьшения счетчика на произвольное число.");
                System.out.println("Введите 6 для вывода на консоль значение счетчика.");

                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                }
                switch (choice) {
                    case 1: {

                        System.out.println("Введите значение:");
                        if (scanner.hasNextInt()) {
                            counter.setCounter(scanner.nextInt());
                        }
                        break;
                    }

                    case 2: {

                        for (int i = 0; i < 10; i++, counter.increase()) {
                            System.out.print(counter.getCounter() + " ");
                        }
                        break;
                    }

                    case 3: {

                        for (int i = 0; i < 10; i++, counter.decrease()) {
                            System.out.print(counter.getCounter() + " ");
                        }
                        break;
                    }

                    case 4: {

                        System.out.println("Введите значение:");
                        if (scanner.hasNextInt()) {
                            counter.increase(scanner.nextInt());
                        }
                        break;
                    }

                    case 5: {

                        System.out.println("Введите значение:");
                        if (scanner.hasNextInt()) {
                            counter.decrease(scanner.nextInt());
                        }
                        break;
                    }

                    case 6: {

                        System.out.println(counter.getCounter());
                        break;
                    }
                }
            }

        } catch (InputMismatchException ex){
            System.out.println("\nОшибка ввода! "+ex.getMessage());
        }
    }
}
