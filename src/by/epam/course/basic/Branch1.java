package by.epam.course.basic;

import java.util.*;

/*
    Определяет существует ли треугольник по двум углам.
    Если треугольник существует, то проверяется является ли он прямоугольным
 */

public class Branch1 {

    public static String analizeTriangle(double ang1, double ang2){
        String string;

        if (ang1 + ang2 < 180) {
            if (ang1 == 90 || ang2 == 90 || ang1 + ang2 == 90) {
                string="Right triangle";
            }
            else {
                string="A triangle with given angles exists";
            }
        }
        else {
            string="A triangle with given angles does NOT exist.";
        }

        return string;
    }

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            System.out.println("Input the first angle:");
            double ang1 = in.nextDouble();

            System.out.println("Input the second angle:");
            double ang2 = in.nextDouble();

            System.out.println(analizeTriangle(ang1, ang2));

        }catch(InputMismatchException ex){
            System.out.println("Input error! "+ex.getMessage());
        }
    }
}