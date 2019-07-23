package by.epam.course.classprograming.train;

import java.util.*;

public class TrainTest {

    public static void input(TrainArray trainArray){

        try {
            Scanner scanner = new Scanner(System.in);
            Train train;

            System.out.println("Введите информацию по шаблону:");
            System.out.println("Путь назначения\tНомер поезда\tВремя отправления(HH:MM)");

            for (int i = 0; i < trainArray.getSize(); i++) {
                train = trainArray.getTrain(i);
                train.setDestination(scanner.next().trim());
                train.setTrainNumber(scanner.nextInt());
                train.setTimeOfAppointment(scanner.next().trim());
            }

        } catch (InputMismatchException ex){
            System.out.println("Ошибка ввода! "+ex.getMessage());
        }
    }

    public static void main(String[] args){

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите число поездов");
            int size = scanner.nextInt();

            if (size > 0) {
                TrainArray trainArray = new TrainArray(size);

                input(trainArray);

                System.out.println("Отсортирован по пунктам назначения:");
                trainArray.sortByDestination();
                trainArray.print();
                System.out.println();

                System.out.println("Отсортирован по номеру поезда:");
                trainArray.sortByNumber();
                trainArray.print();
                System.out.println();

                System.out.println("Введите номер поезда, информацию о котором требуется узнать:");
                trainArray.printInfoByNumber(scanner.nextInt());

            } else {
                System.out.println("Число поездов должно быть положительным!");
            }

        } catch (InputMismatchException ex){
            System.out.println("Ошибка ввода! "+ex.getMessage());
        }
    }
}
