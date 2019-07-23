package by.epam.course.algotithmization;

import java.util.*;

/*
    Определяет, в каком из данных двух чисел больше цифр.
 */

public class Decomposition11 {

    public static int getNumOfDigits(int num){

        int size=0;

        while(num>0){
            size++;
            num/=10;
        }
        return size;
    }

    //Возвращает число, в котором больше цифр.
    //Если в числах одинаковое число цифр, то возвращает первое число.
    public static int hasMoreDigits(int num1,int num2){

        int hasMoreDigits;
        if(getNumOfDigits(num1)>=getNumOfDigits(num2)){
            hasMoreDigits = num1;
        }else{
            hasMoreDigits = num2;
        }

        return hasMoreDigits;
    }

    public static void main(String[] args) {

        try {
            Scanner in = new Scanner(System.in);

            System.out.println("Введите два числа:");
            int num1 = in.nextInt();
            int num2 = in.nextInt();

            System.out.println("Больше цифр (" + num1 + "," + num2 + ") в " + hasMoreDigits(num1, num2));

        } catch (InputMismatchException ex){
            System.out.println("Ошибка ввода! "+ex.getMessage());
        }
    }
}

