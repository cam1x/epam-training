package by.epam.course.basic;

import java.util.*;

/*
    Определяет цифры, входящие в запись как первого так и второго числа
 */

public class Cycle8 {

    public static void printTheSameDigits(int num1,int num2){
        int digits[];
        digits=new int[10];/*Массив цифр.
            Если в ячейке с индексом idx установлен 0,
        значит, цифра idx не входит ни в одно число
            Если в ячейке с индексом idx установлена 1,
        значит, одна из цирф имеет в своем представлении цифру idx.
            Если в ячейке с индексом idx установлена 2,
        значит, цирфа idx-общая цирфа
        */

        int time;
        time=num1;

        int idx;
        while (time!=0) {
            idx=time%10;
            if(digits[idx]==0) {
                digits[idx] = 1;
            }
            time/=10;
        }

        time=num2;
        boolean hasTheSameNumbers=false;
        while (time!=0) {
            idx=time%10;
            if(digits[idx]==1){
                digits[idx]=2;
                hasTheSameNumbers=true;
            }
            time/=10;
        }

        if(hasTheSameNumbers) {
            System.out.println("Цифры, которые имеют оба числа:");
            for (int i = 0; i < 10; i++) {
                if (digits[i] == 2) System.out.print(i + " ");
            }
        }
        else {
            System.out.println("Общих цифр нет.");
        }
    }

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            System.out.println("Введите два числа:");
            int num1 = in.nextInt();
            int num2 = in.nextInt();

            printTheSameDigits(num1, num2);

        }catch (InputMismatchException ex){
            System.out.println("Ошибка ввода! "+ex.getMessage());
        }
    }
}
