package by.epam.course.algotithmization.array;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
    Находит в массиве целых чисел наиболее часто встречаемое число.
    Если таких чисел несколько, то определяет наименьшее из них
 */

public class Array9 {
    public static int[] createArray(int size) {
        if (size > 0) {
            return new int[size];
        } else {
            throw new IllegalArgumentException("Размер массива не может быть отрицательным!");
        }
    }

    public static void printArray(int[] arr) {
        for (int el : arr) {
            System.out.print(el + " ");
        }
    }

    public static void sort(int[] arr) {
        int temp;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /*
        Алгоритм:
        1) сортируем массив
        2) в отсортиванном массиве находим наибольшую платаформу
        (платформа-одинаковые числа следующий друг за другом.
        Например в массиве 1 1 1 2 2 3 три платформы, наибольшая-1 1 1)
        3) в массиве находим первую платформу максимальной длины и возвращаем число,
        входящее в эту платформу. (т.к. массив отсортирован это число будет min среди наиболее часто встречаемых)
     */
    public static int getMostCommon(int[] arr) {
        sort(arr);

        int lenOfPlatform = 1;
        int res = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - lenOfPlatform]) {
                lenOfPlatform++;
            }
        }

        for (int i = lenOfPlatform - 1; i < arr.length; i++) {
            if (arr[i] == arr[i - lenOfPlatform + 1]) {
                res = arr[i];
                break;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            System.out.println("Введите размер массива:");
            int size = in.nextInt();

            try {
                int[] arr = createArray(size);
                System.out.println("Введите элементы массива:");
                for (int i = 0; i < size; i++) {
                    arr[i] = in.nextInt();
                }

                System.out.println("\nВведенный массив:");
                printArray(arr);

                System.out.println("\n\nМинимальный наиболее часто встречаемый элемент: " + getMostCommon(arr));

            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }

        } catch (InputMismatchException ex) {
            System.out.println("Ошибка ввода! " + ex.getMessage());
        }
    }
}
