package by.epam.course.basic;

import java.util.*;

/*
    Для данных трех точек определяет лежат ли они на одной прямой
 */

public class Branch3 {

    public static boolean isOnOneLine(double xA,double yA, double xB,double yB,double xC,double yC) {
        return (xC - xA) * (yB - yA) == (yC - yA) * (xB - xA);
    }

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            System.out.println("Input A(x,y):");
            double xA = in.nextDouble();
            double yA = in.nextDouble();

            System.out.println("Input B(x,y):");
            double xB = in.nextDouble();
            double yB = in.nextDouble();

            System.out.println("Input C(x,y):");
            double xC = in.nextDouble();
            double yC = in.nextDouble();

            if (isOnOneLine(xA, yA, xB, yB, xC, yC)) {
                System.out.println("The points lie on one straight line.");
            } else {
                System.out.println("Points do not lie on one straight line.");
            }

        } catch (InputMismatchException ex){
            System.out.println("Input error! "+ex.getMessage());
        }
    }
}
