package by.epam.course.basic;

import java.util.*;

/*
Вычисляет значение функии:
    если x<=3 x^2-3x+9
    если x>3 1/(x^3+6)
 */

public class Branch5 {

    public static double calculate(double x){
        double res;

        if(x<=3){
            res=(x-3)*(x-3);
        }else{
            res=1/(Math.pow(x,3)+6);
        }

        return res;
    }

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            System.out.println("Введите x:");
            double x = in.nextDouble();

            System.out.println("y = " + calculate(x));

        }catch (InputMismatchException ex){
            System.out.println("Ошибка ввода! "+ex.getMessage());
        }
    }
}