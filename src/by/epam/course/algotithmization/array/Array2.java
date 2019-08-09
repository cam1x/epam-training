package by.epam.course.algotithmization.array;

import java.util.*;

/*
    Заменяет все члены последовательности, которые больше данного Z, этим числом.
    Считает число замен
 */

public class Array2 {

    public static int changeArr(double[] arr,final double NUM){
        int changes=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >NUM) {
                arr[i] = NUM;
                changes++;
            }
        }

        return changes;
    }

    public static void fillArrayRandom(double [] arr){
        for(int i=0;i<arr.length;i++){
            arr[i]=Math.random()*101-51;
            arr[i]=(double)Math.round(arr[i]*100d)/100d;
        }
    }

    public static double[] createArray(int size){
        if(size>0){
            return new double[size];
        }else{
            throw new IllegalArgumentException("Размер массива не может быть отрицательным!");
        }
    }

    public static void printArray(double[] arr){
        for(double el:arr){
            System.out.print(el+" ");
        }
    }

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            System.out.println("Введите количество элементов в последовательности:");
            int size = in.nextInt();
            System.out.println("Введите число, которым будут заменены все элементы, большие чем это число:");
            double num = in.nextDouble();

            try {
                double arr[] = createArray(size);

                fillArrayRandom(arr);
                System.out.println("\nСгенирированная последовательность:");
                printArray(arr);

                int changes = changeArr(arr, num);

                System.out.println("\n\nИзмененная последовательность:");
                printArray(arr);

                System.out.println("\n\nЧисло замен = " + changes);

            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }

        } catch (InputMismatchException ex){
            System.out.println("Ошибка ввода! "+ex.getMessage());
        }
    }
}


