package by.epam.course.algotithmization;

import java.util.*;

/*
        Из заданного числа вычли сумму его цифр.
        Из результата вновь вычли сумму его цифр и т.д.
        Вычисляет сколько таких действий надо произвести, чтобы получить 0
 */

public class Decomposition17 {

    public static int sumOfDigits(int num){
        int sum=0;
        while(num>0){
            sum+=num%10;
            num/=10;
        }

        return sum;
    }

    //Вычисляет сколько раз из числа надо вычесть сумму его цифр, чтобы число стало равным 0
    public static int calcTimesToBecomeZero(int num){
        int times=0;

        while(num>0){
            num-=sumOfDigits(num);
            times++;
        }

        return times;
    }

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            System.out.println("Введите некоторое натуральное число:");
            int num = in.nextInt();
            while (num <= 0) {
                System.out.println("Некорректный ввод! Введите натуральное число!");
                num = in.nextInt();
            }

            System.out.println("\nДля того, чтобы число обратилось в 0, из него необходимо вычесть сумму его цифр " + calcTimesToBecomeZero(num) + " раз.");

        } catch (InputMismatchException ex){
            System.out.println("Ошибка ввода! "+ex.getMessage());
        }
    }
}
