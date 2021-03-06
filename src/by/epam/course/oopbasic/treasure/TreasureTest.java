package by.epam.course.oopbasic.treasure;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TreasureTest {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            TreasureSet treasure = new TreasureSet();

            String inputPath = "F:\\Проекты\\Java\\java_online\\src\\by\\epam\\course\\oopbasic\\treasure\\Treasures";

            int choice = 1;
            int extraChoice;

            while (choice != 0) {
                System.out.println("Введите 0 для выхода");
                System.out.println("Введите 1 для добавления сокровища");
                System.out.println("Введите 2 для удаления сокровища");
                System.out.println("Введите 3 для сортировки сокровища");
                System.out.println("Введите 4 для выбора сокровища");
                System.out.println("Введите 5 для отображения выбранных сокровищ");
                System.out.println("Введите 6 для отображения всех хранящихся сокровищ");

                choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> {
                        System.out.println("\nВведите 1 для чтения из файла");
                        System.out.println("Введите 2 для ввода информации вручную");

                        extraChoice = scanner.nextInt();

                        switch (extraChoice) {
                            case 1 -> treasure.addTreasure(inputPath);
                            case 2 -> {
                                System.out.println("\n Введите имя сокровища, вес, цену в указаннои порядке");
                                treasure.addTreasure(scanner.next(), scanner.nextDouble(), scanner.nextDouble());
                            }
                        }
                    }
                    case 2 -> {
                        System.out.println("\nВведите 1 для удаления по номеру");
                        System.out.println("Введите 2 для удаления по имени, весу, цене");

                        extraChoice = scanner.nextInt();

                        switch (extraChoice) {
                            case 1 -> {
                                System.out.println("\nВведите номер для удаления");
                                treasure.deleteTreasure(scanner.nextInt() - 1);
                            }
                            case 2 -> {
                                System.out.println("\n Введите имя сокровища, вес, цену в указаннои порядке для удаления");
                                treasure.deleteTreasure(scanner.next(), scanner.nextDouble(), scanner.nextDouble());
                            }
                        }
                    }
                    case 3 -> treasure.sortTreasures();
                    case 4 -> {
                        System.out.println("\nВведите 1 для выбора по номеру");
                        System.out.println("Введите 2 для выбора самого дорого");
                        System.out.println("Введите 3 для выбора на заданную сумму");

                        extraChoice = scanner.nextInt();

                        switch (extraChoice) {
                            case 1 -> {
                                System.out.println("\nВведите номер сокровища");
                                treasure.selectTreasure(scanner.nextInt() - 1);
                            }
                            case 2 -> treasure.selectTheMostExpensive();
                            case 3 -> {
                                System.out.println("\nВведите сумму");
                                TreasureSet selected = treasure.getTreasures(scanner.nextDouble());
                                selected.print();
                            }
                        }
                    }
                    case 5 -> {
                        TreasureSet selected = treasure.getSelected();
                        selected.print();
                    }
                    case 6 -> treasure.print();
                }
            }

        } catch (InputMismatchException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
