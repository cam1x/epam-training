package by.epam.course.algotithmization;

import java.util.*;

/*
    Объединяет два одномерных массива в один, включая второй массив между k-м и (k+1)-м элементами первого
 */

public class Sort1 {

    public static int[] combineTwoArrays(int[] arr1,int[]arr2,final int BORDER){

        if(BORDER<0 || BORDER>arr2.length) {
            throw new IllegalArgumentException("Введенное число больше размера первого массива!");
        }

        int resArray[]=new int[arr1.length+arr2.length];
        int index=0;

        for(;index<BORDER;index++){
            resArray[index]=arr1[index];
        }

        for(int j=0;j<arr2.length;j++,index++){
            resArray[index]=arr2[j];
        }

        for(int j=BORDER;j<arr1.length;j++,index++){
            resArray[index]=arr1[j];
        }

        return resArray;
    }

    public static int[] generateIntArray(final int SIZE) {

        if(SIZE>0) {
            int[] arr = new int[SIZE];
            for (int i = 0; i < SIZE; i++) {
                arr[i] = (int) (Math.random() * 101);
            }

            return arr;
        }else{
            throw new IllegalArgumentException("Размер массива должен быть положительным!");
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
            try {
                System.out.println("Введите размер первого массива: ");
                int sizeOfFirstArray = in.nextInt();
                int arr1[] = generateIntArray(sizeOfFirstArray);

                System.out.println("Введите размер второго массива: ");
                int sizeOfSecondArray = in.nextInt();
                int arr2[] = generateIntArray(sizeOfSecondArray);


                System.out.println("Введите некоторое натуральное число (<размер первого массива):");
                int num = in.nextInt();

                System.out.println("Введенные массивы:");
                printArray(arr1);
                printArray(arr2);

                int resArray[] = combineTwoArrays(arr1, arr2, num);
                System.out.println("\nРезультат склеивания:");
                printArray(resArray);

            } catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }

        } catch (InputMismatchException ex){
            System.out.println("Ошибка ввода! "+ex.getMessage());
        }
    }
}