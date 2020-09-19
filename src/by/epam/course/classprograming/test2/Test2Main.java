package by.epam.course.classprograming.test2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test2Main {
    public static void main(String[] args) {
        try {
            Test2 object = new Test2();
            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите значения переменных: ");

            object.setVar1(scanner.nextDouble());
            object.setVar2(scanner.nextDouble());

            System.out.println("\nВведенные данные:");

            System.out.println("Var1 = " + object.getVar1() + ", var2 = " + object.getVar2());

        } catch (InputMismatchException ex) {
            System.out.println("Ошибка ввода! " + ex.getMessage());
        }
    }
}
