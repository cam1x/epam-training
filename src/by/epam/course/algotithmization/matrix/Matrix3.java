package by.epam.course.algotithmization.matrix;

import java.util.*;

/*
    Выводит k-ую строку и p-й столбец
 */

public class Matrix3 {

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

    public static void printLineAndColumn(int[][] matrix,int outLine,int outColumn){
        if(outColumn>matrix[0].length || outLine>matrix.length || outColumn<=0 || outLine<=0) {
            throw new IllegalArgumentException("Неверный номер столбца/строки!");
        }

        System.out.println("\nCтрока: ");
        for(int i=0;i<matrix[0].length;i++){
            System.out.print(matrix[outLine-1][i]+" ");
        }

        System.out.println("\n\nСтолбец:");
        for(int i=0;i<matrix.length;i++){
            System.out.println(matrix[i][outColumn-1]);
        }

        System.out.print("\n");
    }

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            System.out.println("Введите кол-во строк и столбцов матрицы");
            int numOfLines = in.nextInt();
            int numOfColumn = in.nextInt();

            int arr[][] = new int[numOfLines][numOfColumn];

            if (numOfColumn > 0 && numOfLines > 0) {
                fillMatrixRandom(arr);

                System.out.println("\nСгенерированная матрица: ");
                printMatrix(arr);

                System.out.println("Введите номер строки и столбца, которые требуется вывести:");
                int outLine = in.nextInt();
                int outColumn = in.nextInt();

                try {
                    printLineAndColumn(arr, outLine, outColumn);
                } catch (IllegalArgumentException exception) {
                    System.out.println(exception.getMessage());
                }
            }

        } catch (InputMismatchException ex){
            System.out.println("Ошибка ввода! "+ex.getMessage());
        }
    }
}