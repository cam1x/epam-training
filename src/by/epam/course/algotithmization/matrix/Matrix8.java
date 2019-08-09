package by.epam.course.algotithmization.matrix;

import java.util.*;

/*
    Меняет местами два столбца матрицы
 */

public class Matrix8 {

    public static void printMatrix(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.print("\n");
        }
    }

    public static void fillMatrixRandom(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[i].length;j++){
                matrix[i][j]=(int)(Math.random()*101-51);
            }
        }
    }

    public static void swapColumns(int[][] matrix,int col1,int col2){
        if(col1>matrix[0].length || col2>matrix[0].length || col1<=0 ||col2<=0) {
            throw new IllegalArgumentException("Введены неверные номера столбцов!");
        }

        int buff;

        for(int i=0;i<matrix.length;i++){
            buff=matrix[i][col1-1];
            matrix[i][col1-1]=matrix[i][col2-1];
            matrix[i][col2-1]=buff;
        }
    }

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            System.out.println("Введите кол-во строк и столбцов матрицы");
            int numOfLines = in.nextInt();
            int numOfColumn = in.nextInt();

            if (numOfLines > 0 && numOfColumn > 0) {
                int arr[][] = new int[numOfLines][numOfColumn];
                fillMatrixRandom(arr);

                System.out.println("\nСгенерированная матрица: ");
                printMatrix(arr);

                System.out.println("Введите номера столбцов, которые необходимо поменять:");
                int col1 = in.nextInt();
                int col2 = in.nextInt();

                try {
                    swapColumns(arr, col1, col2);

                    System.out.println("\nМатрица после перестановки столбцов:");
                    printMatrix(arr);
                } catch (IllegalArgumentException exception){
                    System.out.println(exception.getMessage());
                }

            } else {
                System.out.println("Размерность матрицы должна быть положительна");
            }

        } catch (InputMismatchException ex){
            System.out.println("Ошибка ввода! "+ex.getMessage());
        }
    }
}