package by.epam.course.algotithmization.array;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
    Считает число отрицательных, положительных и нулевых элментов в массиве
 */

public class Array3 {
    public static void fillArrayRandom(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Math.random() * 101 - 51;
            arr[i] = (double) Math.round(arr[i] * 100d) / 100d;
        }
    }

    public static double[] createArray(int size) {
        if (size > 0) {
            return new double[size];
        } else {
            throw new IllegalArgumentException("Размер массива не может быть отрицательным!");
        }
    }

    public static void printArray(double[] arr) {
        for (double el : arr) {
            System.out.print(el + " ");
        }
    }

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            System.out.println("Введите размер массива:");
            int size = in.nextInt();

            try {
                int positive = 0;
                int negative = 0;
                int zero = 0;
                double[] arr = createArray(size);
                fillArrayRandom(arr);
                System.out.println("\nСгенерированный массив: ");
                printArray(arr);

                for (int i = 0; i < size; i++) {
                    if (arr[i] > 0) {
                        positive++;
                    } else {
                        if (arr[i] < 0) {
                            negative++;
                        } else {
                            zero++;
                        }
                    }
                }

                System.out.println("\nЧисло положительных элементов: " + positive);
                System.out.println("Число отрицательных элементов: " + negative);
                System.out.println("Число нулевых элементов: " + zero);

            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }

        } catch (InputMismatchException ex) {
            System.out.println("Ошибка ввода! " + ex.getMessage());
        }
    }
}
