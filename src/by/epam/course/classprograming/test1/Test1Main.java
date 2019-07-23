package by.epam.course.classprograming.test1;

import java.util.*;

public class Test1Main {

    public static void main(String[] args){
        try {
            Test1 object = new Test1();
            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите значения переменных: ");

            object.setVar1(scanner.nextDouble());
            object.setVar2(scanner.nextDouble());

            System.out.println("\nВведенные данные:");
            object.printVars();

            System.out.println("\nCумма = " + object.sumVars());
            System.out.println("\nMax = " + object.returnMax());

        } catch (InputMismatchException ex){
            System.out.println("Ошибка ввода! "+ex.getMessage());
        }

    }
}
