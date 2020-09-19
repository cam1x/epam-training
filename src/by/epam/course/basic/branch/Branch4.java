package by.epam.course.basic.branch;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
    Заданы размеры A,B прямоугольного отверствия и размеры x,y,z кирпича.
    Определяет, пройдет ли кирпич через отверстие.
 */

public class Branch4 {
    public static boolean isFit(double a, double b, double x, double y, double z) {
        if (a <= 0 || b <= 0 || x <= 0 || y <= 0 || z <= 0) {
            throw new IllegalArgumentException("Рамзеры не могут отрицательными!");
        }

        return (x <= a && y <= b) || (x <= b && y <= a) || (x <= a && z <= b) || (z <= a && x <= b) ||
                (y <= a && z <= b) || (z <= b && y <= a);
    }

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            System.out.println("Введите размеры прямоугольного отверстия (A,B):");
            double a = in.nextDouble();
            double b = in.nextDouble();

            System.out.println("Введите размеры кирпича (x,y,z):");
            double x = in.nextDouble();
            double y = in.nextDouble();
            double z = in.nextDouble();

            try {
                if (isFit(a, b, x, y, z)) {
                    System.out.println("Кирпич пройдет.");
                } else {
                    System.out.println("Кирпич НЕ пройдет.");
                }

            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }

        } catch (InputMismatchException ex) {
            System.out.println("Ошибка ввода! " + ex.getMessage());
        }
    }
}