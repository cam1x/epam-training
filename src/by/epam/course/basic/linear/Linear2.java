package by.epam.course.basic.linear;

import java.util.*;

/*
Вычисляет выражения по формуле:
(b+sqrt(b^2+4*a*c))/(2*a) - a^3*c+ b^-2
 */

public class Linear2 {

    public static double calculate(double a,double b,double c){
        double time=b*b+4*a*c;

        if(time>=0 && a!=0 && b!=0){
            return (b + Math.sqrt(time)) / (2 * a) - Math.pow(a, 3) * c + Math.pow(b,-2);
        }else{
            if(time<0){
                throw new IllegalArgumentException("Discriminant less than zero");
            }else{
                throw new IllegalArgumentException("Division by zero!");
            }
        }

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

            try {
                System.out.println("Result is: " + calculate(a, b, c));
            } catch(IllegalArgumentException exception){
                System.out.println(exception.getMessage());
            }

        } catch(InputMismatchException ex){
            System.out.println("\nInput error! "+ex.getMessage());
        }
    }
}