package by.epam.course.algotithmization.decomposition;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
    Проверяет являются ли три числа взимно простыми в совокупности
 */

public class Decomposition6 {
    public static boolean isMutuallySimple(int num1, int num2, int num3) {
        return greatestCommonDevision(num1, num2, num3) == 1;
    }

    public static int greatestCommonDevision(int firstNum, int secondNum) {
        if (secondNum == 0) {
            return Math.abs(firstNum);
        } else {
            return greatestCommonDevision(secondNum, firstNum % secondNum);
        }
    }

    public static int greatestCommonDevision(int firstNum, int secondNum, int thirdNum) {
        int gcd = greatestCommonDevision(firstNum, secondNum);
        gcd = greatestCommonDevision(gcd, thirdNum);
        return gcd;
    }

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("Введите три числа:");
            int num1 = in.nextInt();
            int num2 = in.nextInt();
            int num3 = in.nextInt();

            if (isMutuallySimple(num1, num2, num3)) {
                System.out.println("Числа " + num1 + "," + num2 + "," + num3 + " в совокупности взаимно простые.");
            } else {
                System.out.println("Числа " + num1 + "," + num2 + "," + num3 + " НЕ являются взаимно простыми.");
            }

        } catch (InputMismatchException ex) {
            System.out.println("Ошибка ввода! " + ex.getMessage());
        }
    }
}
