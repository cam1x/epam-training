package by.epam.course.string.asobject;

import java.util.Scanner;

/*
    Из заданной строки получает новую,
    повторив каждый символ дважды
 */

public class StringAsObject6 {

    public static String doubleAllSymbols(String string){
        StringBuilder repeat=new StringBuilder();

        for(int i=0;i<string.length();i++){
            for(int j=0;j<2;j++){
            repeat.append(string.charAt(i));
            }
        }

        return repeat.toString();
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        System.out.println("Введите строку: ");
        String line=in.nextLine();

        String doubleLine=doubleAllSymbols(line);
        System.out.println("\nСтрока, в которой каждый символ продублирован дважды: "+doubleLine);
    }
}
