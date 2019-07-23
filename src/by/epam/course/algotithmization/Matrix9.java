package by.epam.course.algotithmization;

import java.util.*;

/*
      Считает сумму элементов в каждом столбце.
      Определяет какой столбец имеет наибольшую сумму
 */

public class Matrix9 {

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
                matrix[i][j]=Math.random()*101;
                matrix[i][j]=(double)Math.round(matrix[i][j]*100d)/100d;
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

                System.out.println("\nСгенерированная матрица: ");
                printMatrix(arr);

                double maxSum = 0;
                double currSum = 0;
                double sumOfColumn[] = new double[numOfColumn];

                for (int i = 0; i < numOfColumn; i++) {
                    for (int j = 0; j < numOfLines; j++) {
                        currSum += arr[j][i];
                    }

                    if (currSum > maxSum) {
                        maxSum = currSum;
                    }

                    sumOfColumn[i] = currSum;
                    currSum = 0;
                }

                System.out.println("\nМаксимальную сумму = " + maxSum + " имеют столбцы:");
                for (int i = 0; i < numOfColumn; i++) {
                    if (sumOfColumn[i] == maxSum) {
                        System.out.print((i+1) + " ");
                    }
                }
            }else{
                System.out.println("Размерность матрицы должна быть положительна");
            }

        } catch (InputMismatchException ex){
            System.out.println("Ошибка ввода! "+ex.getMessage());
        }
    }
}