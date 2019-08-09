package by.epam.course.algotithmization.matrix;

import java.util.*;

/*
    Формирует матрицу по шаблону:
    1 1 1 ... 1 1 1
    2 2 2 ... 2 2 0
    3 3 3 ... 3 0 0
    ...............
    n 0 0 ... 0 0 0
 */

public class Matrix5 {

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            System.out.println("Введите порядок матрицы(четный):");
            int numOfLines = in.nextInt();

            if (numOfLines > 0) {

                if (numOfLines % 2 == 1) {
                    System.out.println("\nВведено нечетное число, размер будет увеличен до четного!");
                    numOfLines++;
                }

                System.out.println("\nМатрица, построенная по шаблону:");
                int arr[][] = new int[numOfLines][numOfLines];
                for (int i = 0; i < numOfLines; i++) {
                    for (int j = 0; j < numOfLines; j++) {
                        if (j < numOfLines - i) {
                            arr[i][j] = 1 + i;
                        } else {
                            arr[i][j] = 0;
                        }

                        System.out.print(arr[i][j] + " ");
                    }
                    System.out.print("\n");
                }
            } else {
                System.out.println("Порядок матрицы должен быть положительным");
            }

        } catch (InputMismatchException ex){
            System.out.println("Ошибка ввода! "+ex.getMessage());
        }
    }
}