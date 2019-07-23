package by.epam.course.algotithmization;

import java.util.*;

/*
    Меняет местами наибольший и наименьший элементы последовательности
 */

public class Array4 {

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

    public static void swapMaxMin(double[] arr){
        int indexOfMax=0;
        int indexOfMin=0;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>arr[indexOfMax]){
                indexOfMax=i;
            }
            if(arr[i]<arr[indexOfMin]) {
                indexOfMin=i;
            }
        }

        double buff=arr[indexOfMax];
        arr[indexOfMax]=arr[indexOfMin];
        arr[indexOfMin]=buff;
    }

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            System.out.println("Введите количество чисел:");
            int size = in.nextInt();

            try {
                double arr[] = createArray(size);
                System.out.println("Введите элементы последовательности");
                fillArrayRandom(arr);

                System.out.println("Введенная последовательность:");
                printArray(arr);

                swapMaxMin(arr);

                System.out.println("\nПоследовательность после перемены местами min и max");
                printArray(arr);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }

        } catch (InputMismatchException ex){
            System.out.println("\nОшибка ввода! "+ex.getMessage());
        }
    }
}
