package by.epam.course.algotithmization.decomposition;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
    Вычисляет площадь четырехугольника, один из углов которого прямой.
 */

public class Decomposition9 {
    public static double calcSquareOfRightTriangle(double cathetus1, double cathetus2) {
        double square;

        if (cathetus1 > 0 && cathetus2 > 0) {
            square = (cathetus1 * cathetus2) / 2;
        } else {
            square = -1;
        }

        return square;
    }

    public static double calcSquareOfTriangle(double side1, double side2, double side3) {
        double square;

        boolean triangleExist = isTriangleExist(side1, side2, side3);
        if (side1 > 0 && side2 > 0 && side3 > 0 && triangleExist) {
            double p = (side1 + side2 + side3) / 2;
            square = Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
        } else {
            square = -1;
        }

        return square;
    }

    public static boolean isTriangleExist(double side1, double side2, double side3) {
        boolean triangleExist = (side1 < side2 + side3) && (side2 < side1 + side3) && (side3 < side1 + side2);
        return triangleExist || side1 == side2 && side2 == side3;
    }

    public static double calcSquareOfQuadWithRightAngle(double side1, double side2, double side3, double side4) {
        double square;
        double squareOfPart1 = calcSquareOfRightTriangle(side1, side2);
        double squareOfPart2 = calcSquareOfTriangle(Math.sqrt(side1 * side1 + side2 * side2), side3, side4);

        boolean quadExist = squareOfPart1 > 0 && squareOfPart2 > 0;

        if (side1 > 0 && side2 > 0 && side3 > 0 && side4 > 0 && quadExist) {
            square = squareOfPart1 + squareOfPart2;
        } else {
            square = -1;
        }

        return square;
    }

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            System.out.println("Введите две стороны, между которыми прямой угол:");
            double side1 = in.nextDouble();
            double side2 = in.nextDouble();

            System.out.println("Введите две оставшиеся стороны:");
            double side3 = in.nextDouble();
            double side4 = in.nextDouble();

            double square = calcSquareOfQuadWithRightAngle(side1, side2, side3, side4);

            if (square > 0) {
                System.out.println("S = " + square);
            } else {
                System.out.println("Не существует четырехугольника с введенными сторонами!");
            }

        } catch (InputMismatchException ex) {
            System.out.println("Ошибка ввода! " + ex.getMessage());
        }
    }
}
