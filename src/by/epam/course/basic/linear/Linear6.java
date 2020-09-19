package by.epam.course.basic.linear;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
    Возвращает true, если точка принадлежит области, и false-в противном случае
 */

public class Linear6 {
    public static boolean isInShape(double x, double y) {
        boolean inSpace = false;

        if (x >= -2 && x <= 2 && y >= 0 && y <= 4 || x >= -4 && x <= 4 && y >= -3 && y <= 0) {
            inSpace = true;
        }

        if (inSpace && Math.pow(x, 2) / Math.pow(0.25, 2) + Math.pow(y + 1, 2) / Math.pow(0.5, 2) <= 1) {
            inSpace = false;
        }

        return inSpace;
    }

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            System.out.println("Input coordinates of a point (x,y):");
            double x = in.nextDouble();
            double y = in.nextDouble();

            System.out.println(isInShape(x, y));

        } catch (InputMismatchException ex) {
            System.out.println("Input error! " + ex.getMessage());
        }
    }
}