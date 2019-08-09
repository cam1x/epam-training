package by.epam.course.algotithmization.decomposition;

import java.util.*;

/*
    Даны натуральные числа K и N.
    Формирует массив, элементами которого являются числа, сумма цифр которых равна K и которые не больше N.
 */

public class Decomposition12 {

    //находит числа сумма цифр, которых =num1 и числа<num2
    public static int[] getNumbersWithSumOfDigits(int num1,int num2){
        int[] arrOfNum=new int[num2];
        int index=0;

        while(num2-->0){
            if(sumOfDigits(num2)==num1){
                arrOfNum[index]=num2;
                index++;
            }
        }

        int[]finalArray=new int[index];

        for(int i=0;i<finalArray.length;i++){
            finalArray[i]=arrOfNum[i];
        }

        return finalArray;
    }

    public static int sumOfDigits(int num){
        int sum=0;

        while(num>0){
            sum+=num%10;
            num/=10;
        }

        return sum;
    }

    //Массив будет заполнен числами, сумма цифр которых равна первому числу и которые не больше второго числа
    public static void fillArray(int[] array, int num1,int num2){
        int[] arrOfNums=getNumbersWithSumOfDigits(num1,num2);
        int randomIndex;

        if(arrOfNums.length>0) {
            for (int i = 0; i < array.length; i++) {
                randomIndex = (int) (Math.random() * arrOfNums.length);
                array[i] = arrOfNums[randomIndex];
            }
        }else{
            System.out.println("\nНе соществует таких цифр!");
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

            System.out.println("Введите два числа, массив будет заполнен числами сумма цифр, которых равна первому числу и которые не больше второго числа:");
            int num1 = in.nextInt();
            while (num1 <= 0) {
                System.out.println("Некорректный ввод! Введите натуральное число!");
                num1 = in.nextInt();
            }

            int num2 = in.nextInt();
            while (num2 <= 0) {
                System.out.println("Некорректный ввод! Введите натуральное число!");
                num2 = in.nextInt();
            }

            int[] array = new int[size];
            fillArray(array, num1, num2);
            printArray(array);

        } catch (InputMismatchException ex){
            System.out.println("Ошибка ввода! "+ex.getMessage());
        }
    }
}
