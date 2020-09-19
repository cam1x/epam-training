package by.epam.course.algotithmization.decomposition;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
    Находит НОД 4-ех чисел
 */

public class Decomposition2 {
    public static int greatestCommonDevision(int firstNum, int secondNum) {
        if (secondNum == 0) {
            return Math.abs(firstNum);
        } else {
            return greatestCommonDevision(secondNum, firstNum % secondNum);
        }
    }

    public static int greatestCommonDevision(int firstNum, int secondNum, int thirdNum, int fourthNum) {
        int gcd = greatestCommonDevision(firstNum, secondNum);
        gcd = greatestCommonDevision(gcd, thirdNum);
        gcd = greatestCommonDevision(gcd, fourthNum);
        return gcd;
    }

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            System.out.println("Введите четыре числа: ");
            int num1 = in.nextInt();
            int num2 = in.nextInt();
            int num3 = in.nextInt();
            int num4 = in.nextInt();

            System.out.println("НОД(" + num1 + "," + num2 + "," + num3 + "," + num4 + ") = " + greatestCommonDevision(num1, num2, num3, num4));

        } catch (InputMismatchException ex) {
            System.out.println("Ошибка ввода! " + ex.getMessage());
        }
    }
}
