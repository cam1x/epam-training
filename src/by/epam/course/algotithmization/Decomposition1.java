package by.epam.course.algotithmization;

import java.util.*;

/*
    Программа для нахождения НОК и НОД двух чисел
 */

public class Decomposition1 {

    public static int greatestCommonDevision(int firstNum, int secondNum) {

        if(secondNum==0) {
            return Math.abs(firstNum);
        }
        else {
            return greatestCommonDevision(secondNum,firstNum%secondNum);
        }
    }

    public static int leastCommonMultiply(int firstNum,int secondNum){

        return Math.abs(firstNum*secondNum)/greatestCommonDevision(firstNum,secondNum);
    }

    public static void main(String[] args) {

        try {
            Scanner in = new Scanner(System.in);

            System.out.println("Введите два числа: ");
            int num1 = in.nextInt();
            int num2 = in.nextInt();

            System.out.println("НОД(" + num1 + "," + num2 + ") = " + greatestCommonDevision(num1, num2));
            System.out.println("НОК(" + num1 + "," + num2 + ") = " + leastCommonMultiply(num1, num2));

        } catch (InputMismatchException ex){
            System.out.println("Ошибка ввода! "+ex.getMessage());
        }
    }
}
