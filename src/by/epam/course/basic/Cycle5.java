package by.epam.course.basic;

import java.util.*;

/*
    Находит сумму тех членов ряда, модуль которых больше или равен заданного е.
        Общий член ряда:
            a_n-1/2^n +1/3^n
 */

public class Cycle5 {

    public static double calculate(double eps){

        double sum=0.83;//Первый член ряда (1/2+1/3)

        if(sum<eps) {
            //В ряде не существует членов, модуль котoрых >=eps
            sum=0;
        }
        else {

            int n = 2;//Номер члена ряда
            double part;//Очередной член ряда, который еще не учтен в сумме

            while (true) {
                part = 1.0 / Math.pow(2, n) + 1.0 / Math.pow(3, n);
                if (part >= eps) {
                    sum += part;
                    n++;
                } else {
                    break;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {

        try {
            Scanner in = new Scanner(System.in);
            System.out.println("Input e (e>0):");
            double eps = in.nextDouble();

            double sum = calculate(eps);

            if (sum != 0) {
                System.out.println("sum = " + sum);
            } else {
                System.out.println("There are no members greater or equal than e.");
            }

        } catch(InputMismatchException ex){
            System.out.println("Input error! "+ex.getMessage());
        }
    }
}
