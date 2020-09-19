package by.epam.course.algotithmization.decomposition;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
    Вычисляет сумы трех последовательно расположенных элементов массива с номерами от k до m
 */

public class Decomposition8 {
    /*START-порядковый номер эл-та. Индекс этого эл-та START-1
      При передаче недопустимого индекс возвращает -1
    */
    public static int sumOfThreeElements(int[] array, final int START) {
        int sum = -1;

        try {
            sum = array[START - 1] + array[START] + array[START + 1];
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("\nНедопустимый индекс!");
        }

        return sum;
    }

    /*
        Находит сумму всех "троек", начиная от START-1 до END-1
        START и END номера эл-тов, а не их индексы.
        В случае передаче таковых индексов, что тройки не существую, возвращает 0.
     */
    public static int sumElements(int[] array, final int START, final int END) {
        if (START > END) {
            throw new IllegalArgumentException("Начальный индекс не может быть больше конечного!");
        }

        if (END > array.length) {
            throw new IllegalArgumentException("Номер последнего эл-та суммирования выходит за пределы массива!");
        }

        int sum = 0;

        for (int i = START; i <= END - 2; i++) {

            sum += sumOfThreeElements(array, i);
        }

        return sum;
    }

    public static void fillArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 41 - 20);
        }
    }

    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("Введите размер массива:");

            int size = in.nextInt();

            if (size > 0) {

                int[] array = new int[size];
                fillArray(array);
                System.out.println("\nCгенерированный массив:");
                printArray(array);

                System.out.println("\nВведите номер, с которого начать " +
                        "суммирование в массиве, и номер на котором закончить:");
                int start = in.nextInt();
                int end = in.nextInt();

                try {
                    System.out.println("\nСумма = " + sumElements(array, start, end));
                } catch (IllegalArgumentException ex) {
                    System.out.println(ex.getMessage());
                }

            } else {
                System.out.println("Размер массива должен быть положительным!");
            }

        } catch (InputMismatchException ex) {
            System.out.println("Ошибка ввода! " + ex.getMessage());
        }
    }
}
