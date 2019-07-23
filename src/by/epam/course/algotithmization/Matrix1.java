package by.epam.course.algotithmization;

import java.util.*;

/*
    Выводит на экран нечетные столбцы матрицы, у которых первый элемент больше последнего
 */

public class Matrix1 {

    public static void printMatrix(int[][] matrix){

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.print("\n");
        }
    }

    public static void printColumns(int[][] matrix){

        boolean arrColumnControl[]=new boolean[matrix[0].length];

        for(int i=0;i<matrix[0].length;i+=2){
            if(matrix[0][i]>matrix[matrix.length-1][i]) {
                arrColumnControl[i]=true;
            }
        }

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(arrColumnControl[j])System.out.print(matrix[i][j]+" ");
            }
            System.out.print("\n");
        }

        System.out.print("\n");
    }

    public static void main(String[] args) {

        try {
            Scanner in = new Scanner(System.in);

            System.out.println("Введите кол-во строк и столбцов матрицы");
            int numOfLines = in.nextInt();
            int numOfColumn = in.nextInt();

            if (numOfLines > 0 && numOfColumn > 0) {
                int arr[][] = new int[numOfLines][numOfColumn];

                System.out.println("Введите элементы матрицы:");
                for (int i = 0; i < numOfLines; i++) {
                    for (int j = 0; j < numOfColumn; j++) {
                        arr[i][j] = in.nextInt();
                    }
                }

                System.out.println("\nВведенная матрица: ");
                printMatrix(arr);

                System.out.println("\nНечетные столбцы,y которых первый элемент > последнего: ");
                printColumns(arr);
            } else {
                System.out.println("Размерность матрицы не может быть <=0");
            }

        } catch (InputMismatchException ex){
            System.out.println("Ошибка ввода! "+ex.getMessage());
        }
    }
}
