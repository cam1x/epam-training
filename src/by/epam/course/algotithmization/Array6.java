package by.epam.course.algotithmization;

import java.util.*;

/*
    Суммирует элементы последовательности, порядковые номера которых являются простыми числами
 */

public class Array6 {

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

    public static double sumOfPrimeIndeсces(double arr[]) {
        double sum=0;

        for (int i=0;i<arr.length;i++) {
            if(isPrime(i)) {
                sum += arr[i];
            }
        }

        return sum;
    }

    public static boolean isPrime(final int NUM) {
        boolean prime;

        if(NUM<=1) {
            prime = false;
        }
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

                System.out.println("\n\nСумма чисел, индекс которых - простое число = " + sumOfPrimeIndeсces(arr));

            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }

        } catch (InputMismatchException ex){
            System.out.println("Ошибка ввода! "+ex.getMessage());
        }
    }
}
