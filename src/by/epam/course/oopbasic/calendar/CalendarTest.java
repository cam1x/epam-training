package by.epam.course.oopbasic.calendar;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalendarTest {
    public static void main(String[] args) {
        try {
            Calendar calendar = new Calendar();
            Scanner scanner = new Scanner(System.in);

            int choice = 1;

            while (choice != 0) {
                System.out.println("Введите 0 для завершения работы");
                System.out.println("Введите 1 для добавления даты");
                System.out.println("Введите 2 для добавления выходного");
                System.out.println("Введите 3 для добавления праздника");
                System.out.println("Введите 4 для удаления даты");
                System.out.println("Введите 5 для сортировки дат");
                System.out.println("Введите 6 для вывода всех дат");

                choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> {
                        System.out.println("\nВведитe день, месяц, " +
                                "год в указанном порядке (ввод только числами, например 1 1 2009)");
                        calendar.addDate(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
                    }
                    case 2 -> {
                        System.out.println("\nВведитe день, месяц, " +
                                "год в указанном порядке (ввод только числами, например 1 1 2009)");
                        calendar.addDayOff(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
                    }
                    case 3 -> {
                        System.out.println("\nВведитe название праздника, " +
                                "день, месяц, год в указанном порядке (ввод только числами, например 1 1 2009)");
                        calendar.addHoliday(scanner.next(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
                    }
                    case 4 -> {
                        System.out.println("\nВведите номер для удаления");
                        calendar.deleteDate(scanner.nextInt() - 1);
                    }
                    case 5 -> calendar.sort();
                    case 6 -> calendar.print();
                }
            }

        } catch (InputMismatchException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
