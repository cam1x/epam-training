package by.epam.course.basic.cycle;

import java.util.*;

/*
    Суммирует все числа от 1 до введенного пользователем числа
 */

public class Cycle1 {

    public static int calculate(int num){
        if(num>=1){

            int sum=0;
            for(int i=1;i<=num;i++) {
                sum += i;
            }
            return sum;

        }else{
            throw new IllegalArgumentException("Передано отрицательное число!");
        }
    }

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            System.out.println("Введите целое положительное число:");
            int x = in.nextInt();

            try {
                System.out.println("Сумма чисел от 1 до  " + x + " равна " + calculate(x));
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }

        }catch (InputMismatchException ex){
            System.out.println("Ошибка ввода! "+ex.getMessage());
        }
    }
}