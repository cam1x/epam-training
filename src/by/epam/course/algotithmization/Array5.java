package by.epam.course.algotithmization;

import java.util.*;

/*
    Выводит на печать лишь те числа, для которых верно a_i>i
 */

public class Array5 {

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

                System.out.println("\n\nВывод только тех элементов, для которых выполнено a_i>i:");
                for (int i = 0; i < size; i++) {
                    if (arr[i] > i) {
                        System.out.print(arr[i] + " ");
                    }
                }

            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }

        } catch (InputMismatchException ex){
            System.out.println("Ошибка ввода! "+ex.getMessage());
        }
    }
}

