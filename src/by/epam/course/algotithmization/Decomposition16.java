package by.epam.course.algotithmization;

import java.util.*;

/*
    Определяет сумму n-значных чисел,
    содержащих только нечетные цифры.
    Определяет также сколько четных цифр в сумме
 */

public class Decomposition16 {

    public static int getNthDigit(long number, int n) {

        return (int) ((number / Math.pow(10, n - 1)) % 10);
    }

    public static int getNumOfDigits(long num){

        int size=0;

        while(num>0){
            size++;
            num/=10;
        }

        return size;
    }

    public static boolean hasOnlyOddDigits(int num){

        int numOfDigits=getNumOfDigits(num);
        boolean onlyOdd=true;

        while(numOfDigits>0){
            if(getNthDigit(num,numOfDigits)%2==0){
                onlyOdd=false;
                break;
            }
            numOfDigits--;
        }

        return onlyOdd;
    }

    public static long sumOfNumWithOddDigits(int n){

        int startNum=(int)Math.pow(10,n-1);
        int endNum=(int)Math.pow(10,n)-1;
        long sum=0;

        for(int i=startNum;i<=endNum;i++){
            if(hasOnlyOddDigits(i)){
                sum+=i;
            }
        }

        return sum;
    }

    public static int calcNumOfEven(long num){

        int numOfDigits=getNumOfDigits(num);
        int numOfEven=0;

        while(numOfDigits>0){
            if(getNthDigit(num,numOfDigits)%2==0){
                numOfEven++;
            }
            numOfDigits--;
        }

        return numOfEven;
    }

    public static void main(String[] args) {

        try {
            Scanner in = new Scanner(System.in);

            System.out.println("Введите некоторое натуральное число (кол-во цифр в числе, определяющее n-значное число):");
            int n = in.nextInt();

            while (n <= 0) {
                System.out.println("Некорректный ввод! Введите натуральное число!");
                n = in.nextInt();
            }

            long sum = sumOfNumWithOddDigits(n);

            System.out.println("\nCумма = " + sum + " . Число четных чисел в сумме = " + calcNumOfEven(sum));

        } catch (InputMismatchException ex){
            System.out.println("Ошибка ввода! "+ex.getMessage());
        }
    }
}
