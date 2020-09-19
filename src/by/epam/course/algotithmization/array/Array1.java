package by.epam.course.algotithmization.array;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
   Находит сумму элементов массива, которые кратны введенному числу K
 */

public class Array1 {
    public static int sumOfArr(int[] arr, final int NUM) {
        int sum = 0;

        for (int value : arr) {
            if (value % NUM == 0) {
                sum += value;
            }
        }

        return sum;
    }

    public static void fillArrayRandom(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 101);
        }
    }

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

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            System.out.println("Введите размер массива:");
            int size = in.nextInt();
            System.out.println("Введите число, которое будет использовано для определения кратности:");
            int num = in.nextInt();

            try {
                int[] arr = createArray(size);

                fillArrayRandom(arr);
                printArray(arr);

                int sum = sumOfArr(arr, num);
                System.out.println("\nСумма элементов, кратных " + num + " = " + sum);

            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }

        } catch (InputMismatchException ex) {
            System.out.println("\nОшибка ввода! " + ex.getMessage());
        }
    }
}

