package by.epam.course.algotithmization.sort;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
    Даны две неубывающие последовательности.
    Указывает места, на которые можно вставлять элементы второй последовательности в первую,
    так чтобы новая посл было возрастающей (c учетом сдвига после вставки)
 */

public class Sort7 {
    public static int[] insertIntoArrAnotherArr(int[] arrReceiver, int[] arrSource) {
        int[] arrOfIndexesToInsert = new int[arrSource.length];

        for (int i = 0; i < arrSource.length; i++) {

            arrOfIndexesToInsert[i] = binarySearchOfIndexToInsert(arrReceiver, arrSource[i]) + i;
        }

        return arrOfIndexesToInsert;
    }

    public static int binarySearchOfIndexToInsert(int[] array, final int NUM) {
        int firstIndex = 0;
        int lastIndex = array.length - 1;
        int middleIndex = 0;

        if (NUM <= array[firstIndex]) {
            return firstIndex;
        }

        if (NUM >= array[lastIndex]) {
            return lastIndex + 1;
        }

        while (firstIndex <= lastIndex) {

            middleIndex = (firstIndex + lastIndex) / 2;

            if (NUM >= array[middleIndex] && NUM <= array[middleIndex + 1]) {
                return middleIndex + 1;
            }

            if (array[middleIndex] < NUM) {
                firstIndex = middleIndex;
            } else if (array[middleIndex] > NUM) {
                lastIndex = middleIndex;
            }
        }
        return -1;
    }

    public static int[] generateIntArray(final int SIZE) {
        if (SIZE > 0) {
            int[] arr = new int[SIZE];
            for (int i = 0; i < SIZE; i++) {
                arr[i] = (int) (Math.random() * 101);
            }

            exchangeSort(arr);
            return arr;

        } else {
            throw new IllegalArgumentException("Размер массива должен быть положительным!");
        }
    }

    public static void exchangeSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    swapTwoArrayElements(array, j, j + 1);
                }
            }
        }
    }

    public static void swapTwoArrayElements(int[] array, final int INDEX1, final int INDEX2) {
        int time = array[INDEX1];
        array[INDEX1] = array[INDEX2];
        array[INDEX2] = time;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            try {
                System.out.println("Введите размер первой последовательности: ");
                int size1 = in.nextInt();
                int[] array1 = generateIntArray(size1);

                System.out.println("Введите размер второй последовательности: ");
                int size2 = in.nextInt();
                int[] array2 = generateIntArray(size2);


                System.out.println("Cгенерированные массивы:");
                printArray(array1);
                printArray(array2);

                System.out.println("\nИндексы для вставки элементов массива2 в массив1(с учетом сдвигов после вставки):");
                printArray(insertIntoArrAnotherArr(array1, array2));
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }

        } catch (InputMismatchException ex) {
            System.out.println("Ошибка ввода! " + ex.getMessage());
        }
    }
}
