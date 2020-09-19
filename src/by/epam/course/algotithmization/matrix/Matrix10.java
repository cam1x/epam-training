package by.epam.course.algotithmization.matrix;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
    Находит положительные элементы главной диагонали
 */

public class Matrix10 {
    public static void printMatrix(double[][] matrix) {
        for (double[] doubles : matrix) {
            for (double aDouble : doubles) {
                System.out.print(aDouble + " ");
            }
            System.out.print("\n");
        }
    }

    public static void fillMatrixRandom(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = Math.random() * 101 - 51;
                matrix[i][j] = (double) Math.round(matrix[i][j] * 100d) / 100d;
            }
        }
    }

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            System.out.println("Введите порядок матрицы");
            int numOfLines = in.nextInt();

            if (numOfLines > 0) {

                double[][] arr = new double[numOfLines][numOfLines];
                fillMatrixRandom(arr);

                System.out.println("\nСгенерированная матрица: ");
                printMatrix(arr);

                System.out.println("\nПоложительные элементы главной диагонали:");
                for (int i = 0; i < numOfLines; i++) {
                    if (arr[i][i] > 0) {
                        System.out.print(arr[i][i] + "  ");
                    }
                }

            } else {
                System.out.println("Порядок матрицы должен быть полодительным!");
            }

        } catch (InputMismatchException ex) {
            System.out.println("Ошибка ввода! " + ex.getMessage());
        }
    }
}