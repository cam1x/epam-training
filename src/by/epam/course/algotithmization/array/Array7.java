package by.epam.course.algotithmization.array;

import java.util.*;

/*
    Для последовательности находит:
        max(a_1+a_2n,a_2+a_2n-1,...,a_n+a_n+1)
 */

public class Array7 {

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

    public static double getSpecialMax(double[] arr){
        double max=arr[0]+arr[arr.length-1];
        double temp;

        for(int i=0;i<arr.length/2;i++) {
            temp=arr[i]+arr[arr.length-1-i];
            if(temp>max) {
                max = temp;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            System.out.println("Введите количество чисел:");
            int size = in.nextInt();

            try {
                double arr[] = createArray(size);

                fillArrayRandom(arr);

                System.out.println("\nСгенерированная последовательность:");
                printArray(arr);


                System.out.println("\n\nmax = " + getSpecialMax(arr));

            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }

        } catch (InputMismatchException ex){
            System.out.println("Ошибка ввода! "+ex.getMessage());
        }
    }
}