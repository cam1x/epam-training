package by.epam.course.string.asobject;

import java.util.Scanner;

/*
    Находит самое длинное слово в строке и выводит на экран
 */

public class StringAsObject8 {

    public static String findTheLargestWord(String string){
        //Удаление лищних пробелов из строки и формирование массива слов
        String [] word = removeExtraSpaces(string).split(" ");
        String maxlethWord = "";
        for(int i = 0; i < word.length; i++){
            if(word[i].length() >= maxlethWord.length()){
                maxlethWord = word[i];
            }
        }

        return maxlethWord;
    }

    public static String removeExtraSpaces(String string){
        String buff=new String();
        boolean prevSpace=true;

        int lastIndex=string.length()-1;
        while(string.charAt(lastIndex)==' '){
            lastIndex--;
        }

        for(int i=0;i<=lastIndex;i++){
            if(string.charAt(i)==' '){
                if(!prevSpace){
                    buff+=string.charAt(i);
                }
                prevSpace=true;
            }
            else{
                buff+=string.charAt(i);
                prevSpace=false;
            }
        }

        return buff;
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        System.out.println("Введите строку: ");
        String line=in.nextLine();

        String largestWord=findTheLargestWord(line);

        System.out.println("\nСамое длинное слово строки: "+largestWord);
    }
}
