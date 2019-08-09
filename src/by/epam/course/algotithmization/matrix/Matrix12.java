package by.epam.course.algotithmization.matrix;

import java.util.*;

/*
    Сортирует строки матрицы по возрастанию и убыванию значений
 */

public class Matrix12 {

    public static void printMatrix(double[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.print("\n");
        }
    }

    public static void fillMatrixRandom(double[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[i].length;j++){
                matrix[i][j]=Math.random()*101-51;
                matrix[i][j]=(double)Math.round(matrix[i][j]*100d)/100d;
            }
        }
    }

    public static void sortAscending(double[][] matrix){
        double temp;

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length-1;j++){
                for(int k=0;k<matrix[0].length-j-1;k++){
                    if(matrix[i][k]>matrix[i][k+1]){
                        temp=matrix[i][k];
                        matrix[i][k]=matrix[i][k+1];
                        matrix[i][k+1]=temp;
                    }
                }
            }
        }
    }

    public static void sortDescending(double[][] matrix){
        double temp;

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length-1;j++){
                for(int k=0;k<matrix[0].length-j-1;k++){
                    if(matrix[i][k]<matrix[i][k+1]){
                        temp=matrix[i][k];
                        matrix[i][k]=matrix[i][k+1];
                        matrix[i][k+1]=temp;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            System.out.println("Введите кол-во строк и столбцов матрицы");
            int numOfLines = in.nextInt();
            int numOfColumn = in.nextInt();

            if(numOfColumn>0 && numOfLines>0) {
                double arr[][] = new double[numOfLines][numOfColumn];

                fillMatrixRandom(arr);
                System.out.println("\nCгенерированная матрица: ");
                printMatrix(arr);

                sortAscending(arr);
                System.out.println("\nСтроки отсортированы по возрастанию: ");
                printMatrix(arr);

                sortDescending(arr);
                System.out.println("\nСтроки отсортированы по убыванию: ");
                printMatrix(arr);

            }else{
                System.out.println("Размерность матрицы должна быть полоджительна!");
            }

        } catch (InputMismatchException ex){
            System.out.println("Ошибка ввода! "+ex.getMessage());
        }
    }
}