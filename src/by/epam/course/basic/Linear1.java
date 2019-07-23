package by.epam.course.basic;

import java.util.*;

/*
  Вычисляет значение функции z=((a-3)*b/2)+c
 */

public class Linear1 {

    public static double calculate(double a,double b,double c){
        return (a - 3) * b / 2 + c;
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

            System.out.println("The result of opearation is: z = " + calculate(a,b,c));

        } catch(InputMismatchException ex){

            System.out.println("\nInput error! "+ex.getMessage());
        }
    }
}
