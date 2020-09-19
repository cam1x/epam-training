package by.epam.course.classprograming.customer;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CustomerTest {
    public static void input(CustomerArray customerArray) {
        try {
            Scanner scanner = new Scanner(System.in);

            scanner.useDelimiter(";");
            System.out.println("После ввода каждого поля обязтально используйте разделитель ;");
            System.out.println("Введите по шаблону: ");
            System.out.println("\nФамилия\tИмя\tОтчесто\tАдрес\tНомер кред. карты\tНомер банк. счета");

            Customer customer;

            for (int i = 0; i < customerArray.getSize(); i++) {
                customer = customerArray.getCustomer(i);

                customer.setSurname(scanner.next().trim());
                customer.setName(scanner.next().trim());
                customer.setPatronymic(scanner.next().trim());
                customer.setAddress(scanner.next().trim());

                customer.setCreditCard(Integer.parseInt(scanner.next().trim()));
                customer.setBankAccount(Integer.parseInt(scanner.next().trim()));
            }

        } catch (Exception ex) {
            System.out.println("\nОшибка ввода! " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Количество покупателей:");

            int num = scanner.nextInt();

            if (num > 0) {
                CustomerArray customerArray = new CustomerArray(num);
                input(customerArray);

                System.out.println("\nОтсортировано по алфавиту:");
                customerArray.sortAlphabet();
                customerArray.print();

                System.out.println("\nВведите интревал банковских карт через пробел:");
                CustomerArray customers = customerArray.getCustombersByCredit(scanner.nextInt(), scanner.nextInt());
                customers.print();

            } else {
                System.out.println("Число покупателей должно быть положительным!");
            }

        } catch (InputMismatchException ex) {
            System.out.println("\nОшибка ввода! " + ex.getMessage());
        }
    }
}
