package by.epam.course.algotithmization;

import java.util.*;

/*
    Находит наибольший элемент матрицы.
    Заменяет все нечетные элементы на максимальный
 */

public class Matrix15 {

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

    public static int getMax(int[][] matrix){

        int max=matrix[0][0];

        for(int i=0;i<matrix.length;i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
        }

        return max;
    }

    public static void changeAllOdd(int[][] matrix, int number){

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]%2==1 || matrix[i][j]%2==-1){
                    matrix[i][j]=number;
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

            if (numOfColumn > 0 && numOfLines > 0) {
                int arr[][] = new int[numOfLines][numOfColumn];
                fillMatrixRandom(arr);

                System.out.println("\nСгенерированная матрица: ");
                printMatrix(arr);

                System.out.println("\nЗамена всех нечетных на max:");
                int max=getMax(arr);
                changeAllOdd(arr, max);
                printMatrix(arr);

            } else {
                System.out.println("Размерность матрицы должна быть положительной!");
            }

        } catch (InputMismatchException ex){
            System.out.println("Ошибка ввода! "+ex.getMessage());
        }
    }
}