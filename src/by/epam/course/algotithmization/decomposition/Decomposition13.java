package by.epam.course.algotithmization.decomposition;

import java.util.*;

/*
    Находит все пары близнецов из отрезка [n,2n], где n-натур число >2
 */

public class Decomposition13 {

    public static boolean isPrime(final int NUM) {
        boolean prime;
        if(NUM<=1) prime=false;
        else {
            prime = true;
            int i = 2;
            while (i*i<=NUM) {
                if (NUM % i != 0) {
                    i++;
                } else {
                    prime = false;
                    break;
                }
            }
        }

        return prime;
    }

    public static boolean isTwinNumbers(int num1,int num2){
        return isPrime(num1)&&isPrime(num2)&&Math.abs(num1-num2)==2;
    }

    public static void printTwinNumbers(int startNumber,int endNumber){
        if(startNumber<endNumber) {
            for (int i = startNumber; i <= endNumber - 2; i++) {
                if (isTwinNumbers(i, i + 2)) {
                    System.out.print("{" + i + "," + (i + 2) + "} ");
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            System.out.println("Введите некоторое натуральное, которое больше 2:");
            int n = in.nextInt();
            while (n <= 2) {
                System.out.println("Некорректный ввод! Введите натуральное число, которое больше 2!");
                n = in.nextInt();
            }

            printTwinNumbers(n, 2 * n);

        } catch (InputMismatchException ex){
            System.out.println("Ошибка ввода! "+ex.getMessage());
        }
    }
}
