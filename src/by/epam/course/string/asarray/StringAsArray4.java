package by.epam.course.string.asarray;

import java.util.Scanner;

/*
    Находи в строке кол-во чисел
 */

public class StringAsArray4 {

    public static boolean isDigit(char ch){
        return ch>='1'&&ch<='9';
    }

    public static int calcNumOfNumbers(String string){
        int numOfDigits=0;
        boolean prevNumber=false;

        for(int i=0;i<string.length();i++){
            if(isDigit(string.charAt(i))){
                if(prevNumber==false){
                    numOfDigits++;
                }

                prevNumber=true;

            }else{
                prevNumber=false;
            }
        }

        return numOfDigits;
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        System.out.println("Введите строку: ");
        String line=in.nextLine();

        int numOfNumbers=calcNumOfNumbers(line);

        System.out.println("\nЧисло чисел в строке "+line+" = "+numOfNumbers);
    }
}
