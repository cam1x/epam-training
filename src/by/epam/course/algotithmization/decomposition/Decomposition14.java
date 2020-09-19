package by.epam.course.algotithmization.decomposition;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
    Находит числа Армстронга от 1 до k
 */

public class Decomposition14 {
    //Вычисляет a^b
    public static int power(int a, int b) {
        int result = 1;
        for (int i = 1; i <= b; i++) {
            result *= a;
        }

        return result;
    }

    public static int getNthDigit(int number, int n) {
        return (int) ((number / Math.pow(10, n - 1)) % 10);
    }

    public static int getNumOfDigits(int num) {
        int size = 0;

        while (num > 0) {
            size++;
            num /= 10;
        }

        return size;
    }

    public static boolean isArmstrongNumber(int num) {
        int sum = 0;
        int numOfDigits = getNumOfDigits(num);
        for (int i = 1; i <= numOfDigits; i++) {
            sum += power(getNthDigit(num, i), numOfDigits);
        }

        return sum == num;
    }

    public static void printArmstrongNumbers(final int END_OF_GAP) {
        for (int i = 1; i <= END_OF_GAP; i++) {
            if (isArmstrongNumber(i)) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            System.out.println("Введите некоторое натуральное, до которого будут найден числа Армстронга:");
            int n = in.nextInt();

            while (n <= 0) {
                System.out.println("Некорректный ввод! Введите натуральное число!");
                n = in.nextInt();
            }
            printArmstrongNumbers(n);

        } catch (InputMismatchException ex) {
            System.out.println("Ошибка ввода! " + ex.getMessage());
        }
    }
}
