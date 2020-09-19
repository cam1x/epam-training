package by.epam.course.basic.linear;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
    Вычисляет значения выражения по формуле:
       ( (sinx + cosx)/(cosx-siny) ) * tg(x*y);
 */

public class Linear3 {
    public static double calculate(double x, double y) {
        if ((x * y) != Math.PI) {
            double result = (Math.sin(x) + Math.cos(y)) / (Math.cos(x) - Math.sin(y));
            result *= Math.tan(x * y);
            return result;
        } else {
            throw new IllegalArgumentException("Result is undifined (x*y=pi/2)!");
        }
    }

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            System.out.println("Input x:");
            double x = in.nextDouble();
            System.out.println("Input y:");
            double y = in.nextDouble();

            try {
                System.out.println("Result is " + calculate(x, y));
            } catch (InputMismatchException exception) {
                System.out.println(exception.getMessage());
            }

        } catch (InputMismatchException ex) {
            System.out.println("Input error! " + ex.getMessage());
        }
    }
}
