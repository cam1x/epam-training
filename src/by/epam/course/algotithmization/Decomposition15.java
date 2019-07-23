package by.epam.course.algotithmization;

import java.util.*;

/*
    Находит все натуральные n-значные числа,
    цифры в которых образуют возраст. последовательность
 */

public class Decomposition15 {

    public static int getNthDigit(int number, int n) {

        return (int) ((number / Math.pow(10, n - 1)) % 10);
    }

    public static int getNumOfDigits(int num){

        int size=0;

        while(num>0){
            size++;
            num/=10;
        }

        return size;
    }

    //Проверяет образуют ли цифры числа возр. последовательность
    public static boolean isIncSequenceOfDigits(int num){

        boolean isIncSequence=true;
        int numOfDigits=getNumOfDigits(num);

        while(numOfDigits>1){
            if(getNthDigit(num,numOfDigits)>=getNthDigit(num,numOfDigits-1)){
                isIncSequence=false;
                break;
            }
            numOfDigits--;
        }

        return isIncSequence;
    }

    public static void printNumbersWithIncSequence(int n){

        int startNum=(int)Math.pow(10,n-1);
        int endNum=(int)Math.pow(10,n)-1;
        int numOfPrintedInLine=0;

        System.out.println("\n"+n+"-значные числа, цифры которых образуют возрастающую последовательность: ");
        for(int i=startNum;i<=endNum;i++){
            if(isIncSequenceOfDigits(i)){
                System.out.print(i+" ");
                numOfPrintedInLine++;
            }
            if(numOfPrintedInLine>11){
                System.out.println();
                numOfPrintedInLine=0;
            }
        }
    }

    public static void main(String[] args) {

        try {
            Scanner in = new Scanner(System.in);

            System.out.println("Введите некоторое натуральное число (кол-во цифр в числе, определяющее n-значное число):");
            int n = in.nextInt();
            while (n <= 0) {
                System.out.println("Некорректный ввод! Введите натуральное число!");
                n = in.nextInt();
            }

            printNumbersWithIncSequence(n);

        } catch (InputMismatchException ex){
            System.out.println("Ошибка ввода! "+ex.getMessage());
        }
    }
}
