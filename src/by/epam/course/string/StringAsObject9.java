package by.epam.course.string;

import java.util.Scanner;

/*
    Считает число строчных и прописных букв в строке
 */

public class StringAsObject9 {

    public static boolean isLowerCase(char ch){

        return ch>='a'&&ch<='z';
    }

    public static boolean isUpperCase(char ch){

        return ch>='A'&&ch<='Z';
    }

    public static int calcNumOfLowerCase(String string){

        int num=0;
        for(int i=0;i<string.length();i++){
            if(isLowerCase(string.charAt(i))){
                num++;
            }
        }

        return num;
    }

    public static int calcNumOfUpperCase(String string){

        int num=0;
        for(int i=0;i<string.length();i++){
            if(isUpperCase(string.charAt(i))){
                num++;
            }
        }

        return num;
    }

    public static void main(String[] args){

        Scanner in=new Scanner(System.in);
        System.out.println("Введите строку: ");
        String line=in.nextLine();

        int numOfLower=calcNumOfLowerCase(line);
        int numOfUpper=calcNumOfUpperCase(line);

        System.out.println("\nЧисло строчных букв: "+numOfLower);
        System.out.println("\nЧисло прописных букв: "+numOfUpper);
    }
}
