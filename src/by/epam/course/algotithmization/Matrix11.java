package by.epam.course.algotithmization;

import java.util.Scanner;

/*
    Заполняет матрицу 10х20 случайными числами от 0 до 15.
    Выводит на экран полученную матрицу и номера строк,
    в которых число 5 встречается 3 и более раз
 */

public class Matrix11 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int numOfLines=10;
        int numOfColumn=20;

        int arr[][]=new int[numOfLines][numOfColumn];

        int timesOf5=0;//Число 5 в текущей строке
        boolean arrTimeOf5[]=new boolean[numOfLines];
        boolean containLineWithEnough5=false;/*В матрице есть как миниму одна строка,
        удовлетворяющая условию*/

        System.out.println("\nCгенерированная матрица: ");
        for(int i=0;i<numOfLines;i++){
            for(int j=0;j<numOfColumn;j++){
                arr[i][j]=(int)( Math.random() * 16 );
                System.out.print(arr[i][j]+"  ");
                if(arr[i][j]==5){
                    timesOf5++;
                }
            }

            if(timesOf5>=3){
                arrTimeOf5[i]=true;
                containLineWithEnough5=true;
            }

            timesOf5=0;
            System.out.print("\n");
        }

        if(containLineWithEnough5){

            System.out.println("\n\nНомера строк, в которых 5 встречается 3 или более раз:");
            for(int i=0;i<numOfLines;i++){
                if(arrTimeOf5[i]) {
                    System.out.print((i+1)+" ");
                }
            }
        } else{
            System.out.println("В матрице нет строки, в которой 5 встречается 3 или более раз.");
        }
    }
}
