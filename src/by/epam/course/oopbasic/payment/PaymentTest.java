package by.epam.course.oopbasic.payment;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PaymentTest {
    public static void main(String[] args) {
        try {
            Payment payment = new Payment();

            Scanner scanner = new Scanner(System.in);

            int choice = 1;
            int extraChoice;

            while (choice != 0) {
                System.out.println("Введите 0 для завершения работы");
                System.out.println("Введите 1 для добавления товара");
                System.out.println("Введите 2 для удаления товара");
                System.out.println("Введите 3 для изменения товара по номеру");
                System.out.println("Введите 4 для сортировки товаров по цене");
                System.out.println("Введите 5 для сортировки товаров по весу");
                System.out.println("Введите 6 для сортировки товаров по названию");
                System.out.println("Введите 7 для получения общей суммы");
                System.out.println("Введите 8 для получения общего веса");
                System.out.println("Введите 9 для получения информации по всем товарам");

                choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> {
                        System.out.println("\nВведите название товара, его вес и цену в указанном порядке");
                        payment.addProduct(scanner.next(), scanner.nextDouble(), scanner.nextDouble());
                    }
                    case 2 -> {
                        System.out.println("\nВведите 1 для удаления товара по номеру");
                        System.out.println("Введите 2 для удаления товара по названию, весу и цене");
                        extraChoice = scanner.nextInt();

                        switch (extraChoice) {
                            case 1 -> {
                                System.out.println("\nВведите номер товара");
                                payment.deleteProduct(scanner.nextInt() - 1);
                            }
                            case 2 -> {
                                System.out.println("\nВведите название товара, его вес и цену в указанном порядке");
                                payment.deleteProduct(scanner.next(), scanner.nextDouble(), scanner.nextDouble());
                            }
                        }
                    }
                    case 3 -> {
                        System.out.println("\nВведите номер товара для изменения, " +
                                "а также название, вес и цену, на которые следует изменить");
                        payment.setProduct(scanner.nextInt() - 1, scanner.next(), scanner.nextDouble(), scanner.nextDouble());
                    }
                    case 4 -> payment.sortByPrice();
                    case 5 -> payment.sortByWeight();
                    case 6 -> payment.sortByName();
                    case 7 -> System.out.println("\nОбщая сумма = " + payment.getTotalPrice());
                    case 8 -> System.out.println("\nОбщий вес = " + payment.getTotalWeight());
                    case 9 -> payment.print();
                }

            }

        } catch (InputMismatchException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
