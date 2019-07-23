package by.epam.course.algotithmization;

import java.util.*;

/*
    Сжимает массив, выбрасывая из него каждый второй элемент.
    Осободившиеся элементы заполняются нулями и помещаются в конец массива.
 */

public class Array10 {

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

    public static void compressArray(int[] arr){
        int size=arr.length;

        for(int i=1;i<=size/2;i++){
            arr[i]=0;
            for(int j=i;j<size-1;j++){
                //swap без использования буфера
                arr[j+1] += (arr[j] - (arr[j] = arr[j+1]));
            }
        }
    }

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            System.out.println("Введите размер массива:");
            int size = in.nextInt();

            try {
                int arr[] = createArray(size);
                fillArrayRandom(arr);

                System.out.println("\nСгенерированный массив:");
                printArray(arr);

                compressArray(arr);
                System.out.println("\nСжатый массив(удален каждый второй элемент):");
                printArray(arr);

            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }

        } catch (InputMismatchException ex){
            System.out.println("Ошибка ввода! "+ex.getMessage());
        }
    }
}
