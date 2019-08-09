package by.epam.course.algotithmization.matrix;

import java.util.*;
/*
    Выводит на экран элементы матрицы, стоящие на диагонали
 */

public class Matrix2 {

    public static void printMatrix(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.print("\n");
        }
    }

    public static void printDiag(int[][] matrix){
        System.out.println("\nГлавная диагональ:");
        for(int i=0;i<matrix.length;i++){
            System.out.print(matrix[i][i]+" ");
        }

        System.out.println("\nПобочная диагональ:");
        for(int i=0;i<matrix.length;i++){
            System.out.print(matrix[i][matrix.length-1-i]+" ");
        }

        System.out.print("\n");
    }

    public static void fillMatrixRandom(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[i].length;j++){
                matrix[i][j]=(int)(Math.random()*101-51);
            }
        }
    }

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            System.out.println("Введите порядок матрицы");
            int numOfLines = in.nextInt();

            if (numOfLines > 0) {
                int arr[][] = new int[numOfLines][numOfLines];
                fillMatrixRandom(arr);

                System.out.println("\nCгенерированная матрица: ");
                printMatrix(arr);

                printDiag(arr);
            } else {
                System.out.println("\nРазмерность матрицы должна быть положительной");
            }

        } catch (InputMismatchException ex){
            System.out.println("Ошибка ввода! "+ex.getMessage());
        }
    }
}