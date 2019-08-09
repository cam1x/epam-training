package by.epam.course.algotithmization.sort;

import java.util.*;

/*
    Приводит дроби к общему знаменателю
 */

public class Sort8 {

    public static void generateFractions(int[] arrayOfNumeretor, int[] arrayOfDenominator){
        for(int i=0;i<arrayOfDenominator.length;i++){
            arrayOfNumeretor[i]=(int)(Math.random()*11);
            arrayOfDenominator[i]=(int)(1+Math.random()*25);
        }
    }

    public static void printFractions(int[] arrayOfNumeretor, int[] arrayOfDenominator){
        for(int i=0;i<arrayOfDenominator.length;i++){
            System.out.print(arrayOfNumeretor[i]+"/"+arrayOfDenominator[i]+" ");
        }
    }

    public static void toCommonDenominator(int[] arrayOfNumeretor, int[] arrayOfDenominator){
        int commonDenominator=leastCommonMultiply(arrayOfDenominator);
        for(int i=0;i<arrayOfNumeretor.length;i++){
            arrayOfNumeretor[i]*=commonDenominator/arrayOfDenominator[i];
            arrayOfDenominator[i]=commonDenominator;
        }
        exchangeSort(arrayOfNumeretor);
    }

    public static void exchangeSort(int[] array){
        for(int i=0;i<array.length-1;i++){
            for(int j=0;j<array.length-1-i;j++){
                if(array[j]>array[j+1]){
                    swapTwoArrayElements(array,j,j+1);
                }
            }
        }
    }

    public static void swapTwoArrayElements(int[]array,final int INDEX1,final int INDEX2){
        int time=array[INDEX1];
        array[INDEX1]=array[INDEX2];
        array[INDEX2]=time;
    }

    public static int leastCommonMultiply(int[]array){
        int nok=array[0];
        for(int i=1;i<array.length;i++){
            nok=(nok*array[i])/greatesrCommonDevision(nok,array[i]);
        }
        return nok;
    }

    public static int greatesrCommonDevision(int firstNum, int secondNum) {
        if(secondNum==0) {
            return Math.abs(firstNum);
        }
        else {
            return greatesrCommonDevision(secondNum,firstNum%secondNum);
        }
    }

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            System.out.println("Количество дробей:");
            int numOfFractions = in.nextInt();

            if(numOfFractions>0) {
                int[] arrayOfNumeretor = new int[numOfFractions];
                int[] arrayOfDenominator = new int[numOfFractions];

                generateFractions(arrayOfNumeretor, arrayOfDenominator);
                System.out.println(numOfFractions + " сгенерированных дробей: ");
                printFractions(arrayOfNumeretor, arrayOfDenominator);

                toCommonDenominator(arrayOfNumeretor, arrayOfDenominator);
                System.out.println("\n\nДроби приведены к общему знаменателю и отсортированы:");
                printFractions(arrayOfNumeretor, arrayOfDenominator);

            } else{
                System.out.println("Число дробей должно быть положительным!");
            }

        } catch (InputMismatchException ex){
            System.out.println("Ошибка ввода! "+ex.getMessage());
        }
    }
}
