package by.epam.course.algotithmization.array;

import java.util.*;

/*
    Из исходной последовательности образует новую последовательность, удаляя элементы, равные минимальному
 */

public class Array8 {

    public static void fillArrayRandom(int [] arr){
        for(int i=0;i<arr.length;i++){
            arr[i]=(int)(Math.random()*101-51);
        }
    }

    public static int[] createArray(int size){
        if(size>0){
            return new int[size];
        }else{
            throw new IllegalArgumentException("Размер массива не может быть отрицательным!");
        }
    }

    public static void printArray(int[] arr){
        for(int el:arr){
            System.out.print(el+" ");
        }
    }

    public static int minOfArray(int[] arr) {
        int min=arr[0];

        for(int i=0;i<arr.length;i++){
            if(arr[i]<min) {
                min = arr[i];
            }
        }

        return min;
    }

    public static int[] deleteElementFromArr(int[] arr,final int NUM) {
        int size=arr.length;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==NUM) {
                size--;
            }
        }

        int newArr[]=new int[size];
        int i=0;
        int j=0;
        while(i<size && j<arr.length) {
            if(arr[j]!=NUM) {
                newArr[i]=arr[j];
                i++;
            }
            j++;
        }

        return newArr;
    }

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            System.out.println("Введите количество чисел:");
            int size = in.nextInt();

            try {
                int arr[] = createArray(size);
                fillArrayRandom(arr);

                System.out.println("\nСгенерированная последовательность:");
                printArray(arr);

                System.out.println("\n\nПоследовательность без элементов, равных минимальному:");
                int[] arrWithoutMin = deleteElementFromArr(arr, minOfArray(arr));
                printArray(arrWithoutMin);

            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }

        } catch (InputMismatchException ex){
            System.out.println("\nОшибка ввода! "+ex.getMessage());
        }
    }
}