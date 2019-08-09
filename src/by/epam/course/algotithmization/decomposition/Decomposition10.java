package by.epam.course.algotithmization.decomposition;

import java.util.*;

/*
    Дано натуральной число N.
    Формирует массив, элементы которого-цифры N
 */

public class Decomposition10 {

    public static int getNumOfDigits(int num){
        int size=0;

        while(num>0){
            size++;
            num/=10;
        }

        return size;
    }

    public static int getNthDigit(int number, int n) {
        return (int) ((number / Math.pow(10, n - 1)) % 10);
    }

    public static void fillArray(int []array,int num){
        int numOfDigits=getNumOfDigits(num);

        int indexOfDigit;

        for(int i=0;i<array.length;i++){
            indexOfDigit=1+(int)(Math.random()*numOfDigits);
            array[i]=getNthDigit(num,indexOfDigit);
        }
    }

    public static void printArray(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            System.out.println("Введите размер массива:");
            int size = in.nextInt();

            while (size <= 0) {
                System.out.println("Некорректный ввод! Введите натуральное число!");
                size = in.nextInt();
            }

            System.out.println("Введите число, цифрами которого будет заполнен массив:");
            int num = in.nextInt();

            while (num < 0) {
                System.out.println("Некорректный ввод! Введите натуральное число!");
                num = in.nextInt();
            }

            int[] array = new int[size];
            fillArray(array, num);
            printArray(array);

        }catch (InputMismatchException ex){
            System.out.println("Ошибка ввода! "+ex.getMessage());
        }
    }
}
