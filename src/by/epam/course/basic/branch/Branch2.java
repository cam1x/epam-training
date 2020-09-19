package by.epam.course.basic.branch;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
    Для чисел a,b,c,d находит max( min(a,b), min(c,d) )
 */

public class Branch2 {
    public static double getMaxOfMins(double a, double b, double c, double d) {
        double minAB = Math.min(a, b);
        double minCD = Math.min(c, d);
        return Math.max(minAB, minCD);
    }

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            System.out.println("Input a:");
            double a = in.nextDouble();

            System.out.println("Input b:");
            double b = in.nextDouble();

            System.out.println("Input c:");
            double c = in.nextDouble();

            System.out.println("Input d:");
            double d = in.nextDouble();

            System.out.println("max(min(a,b),min(c,d))=" + getMaxOfMins(a, b, c, d));

        } catch (InputMismatchException ex) {
            System.out.println("Input error! " + ex.getMessage());
        }
    }
}
