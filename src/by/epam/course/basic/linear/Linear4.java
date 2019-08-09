package by.epam.course.basic.linear;

import java.util.*;

/*
    Меняет местами дробную и целую части числа вида nnn.ddd
 */

public class Linear4 {

    public static double reverse(double number){
        double reversed=(int)number/1000.0 + (number-(int)number) * 1000;
        return (double)Math.round(reversed*1000d)/1000d;
    }

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            System.out.println("Input number:");
            double num = in.nextDouble();

            System.out.println("Reversed number = " + reverse(num));

        }catch (InputMismatchException ex){
            System.out.println("\nInput error!"+ex.getMessage());
        }
    }
}
