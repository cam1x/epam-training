package by.epam.course.algotithmization.matrix;

import java.util.*;

/*
    Формирует матрицу порядка N по правилу:
        A[i,j]=sin( (i^2-j^2)/N) )
    и считает число положительных элементов в ней
 */

public class Matrix7 {

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            System.out.println("Введите порядок матрицы(четный):");
            int numOfLines = in.nextInt();

            if (numOfLines > 0) {
                int numOfPositive = 0;

                System.out.println("\nМатрица, построенная по шаблону:");
                double arr[][] = new double[numOfLines][numOfLines];

                for (int i = 0; i < numOfLines; i++) {
                    for (int j = 0; j < numOfLines; j++) {
                        arr[i][j] = Math.floor(Math.sin((i * i - j * j) / ((double) numOfLines)) * 1000 + .5) / 1000;
                        if (arr[i][j] > 0) {
                            numOfPositive++;
                        }
                        System.out.print(arr[i][j] + "  ");
                    }
                    System.out.print("\n");
                }

                System.out.println("\nЧисло положительных элементов: " + numOfPositive);

            } else {
                System.out.println("Порядок матрицы должен быть положительным");
            }

        } catch (InputMismatchException ex){
            System.out.println("Ошибка ввода! "+ex.getMessage());
        }
    }
}