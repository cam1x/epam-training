package by.epam.course.algotithmization;

import java.util.*;

/*
    Формирует случайную матрицу m*n, сост. из нулей и единиц
    В каждом столбце число единиц равно номеру столбца
 */

public class Matrix14 {

    public static void printMatrix(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            System.out.println("Введите кол-во строк и столбцов матрицы");
            int numOfLines = in.nextInt();
            int numOfColumn = in.nextInt();

            if(numOfColumn>0 && numOfLines>0) {
                int arr[][] = new int[numOfLines][numOfColumn];

                if (numOfColumn <= numOfLines) {

                    int numOf1;//Число единиц, которое должно быть размещено в столбце
                    int indexOfLine;//Индекс строки, генерируемый случайно, в котором должна размещаться одна из 1 столбца

                    for (int i = 0; i < numOfColumn; i++) {
                        numOf1 = i + 1;

                        while (numOf1 != 0) {
                            indexOfLine = (int) (Math.random() * numOfLines);

                            if (arr[indexOfLine][i] == 0) {
                                arr[indexOfLine][i] = 1;
                                numOf1--;
                            }
                        }
                    }

                    System.out.println("\nСгенерированная матрица: ");
                    printMatrix(arr);

                } else {
                    System.out.println("Невозможно построить матрицы, в которой число 1 в столбце равно номеру стобца!");
                }

            } else{
                System.out.println("Размерность матрицы должна быть положительной!");
            }

        } catch (InputMismatchException ex){
            System.out.println("Ошибка ввода! "+ex.getMessage());
        }
    }
}