package by.epam.course.algotithmization;

import java.util.*;

/*
    Формирует матрицу по шаблону
    1 2 3 ... n
    n n-1 n-2...1
    1 2 3 ... n
    n n-1 n-2...1
    .............
    n n-1 n-2...1
 */

public class Matrix4 {

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
                        if (i % 2 == 0) {
                            arr[i][j] = 1 + j;
                        } else {
                            arr[i][j] = numOfLines - j;
                        }
                        System.out.print(arr[i][j] + " ");
                    }
                    System.out.print("\n");
                }
            } else {
                System.out.println("Порядок матрицы должен быть положительным!");
            }

        } catch (InputMismatchException ex){
            System.out.println("Ошибка ввода! "+ex.getMessage());
        }
    }
}