package by.epam.course.basic;

import java.util.*;

/*
    Для каждого натурального числа в промежутке от m до n выводит все делители числа, кроме 1 и самого числа
 */

public class Cycle7 {

    public static void printDeviders(int m,int n){

        if(m<=0||n<=0){
           throw new IllegalArgumentException("Введены не натуральные числа!");
        }

        if(m>n) {
            m += (n - (n = m));
        }

        System.out.println("Число\tДелители");
        for(int i=m;i<=n;i++) {
            System.out.print(i+"\t\t");
            for(int j=2;j<=i/2;j++) {
                if(i%j==0) {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        try {
            Scanner in = new Scanner(System.in);

            System.out.println("Введите два натуральных числа m и n:");
            int m = in.nextInt();
            int n = in.nextInt();

            try {
                printDeviders(m, n);
            }catch (IllegalArgumentException exception){
                System.out.println(exception.getMessage());
            }

        } catch (InputMismatchException ex){
            System.out.println("Ошибка ввода! "+ex.getMessage());
        }
    }
}
