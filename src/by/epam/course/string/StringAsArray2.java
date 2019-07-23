package by.epam.course.string;

import java.util.Scanner;

/*
    Заменяет в строке все вхождения 'word' на 'letter'
 */

public class StringAsArray2 {

    //Проверяет совпадают ли слово в массиве, начинающееся с индекса START_INDEX, c word
    //Если указан слишком маленький стартовый индекс-вовзрашает false. Без учета регистра
    public static boolean isTheSameWord(String string,final int START_INDEX, String word){

        boolean isTheSame;
        if(START_INDEX+word.length()>string.length()){
            isTheSame =false;
        }else{
            isTheSame=true;
            for(int i=START_INDEX,index=0;i<START_INDEX+word.length();i++,index++){
                if(toLowerCase(string.charAt(i))!=toLowerCase(word.charAt(index))){
                    isTheSame=false;
                    break;
                }
            }
        }
        return isTheSame;
    }

    public static char toLowerCase(char ch){

        if(ch>='A'&&ch<='Z'){
            ch-='A'-'a';
        }
        return ch;
    }

    public static String changeWord(String string,String wordOld, String wordNew) {

        String resString=new String();

        for(int i=0;i<string.length();i++){
            if(isTheSameWord(string,i,wordOld)){
               resString+=wordNew;
               i+=wordOld.length()-1;
            }else{
                resString+=string.charAt(i);
            }
        }
        return resString;
    }

    public static void main(String[] args){

        Scanner in=new Scanner(System.in);
        System.out.println("Введите строку: ");
        String line=in.nextLine();

        String wordOld="word";
        String wordNew="letter";

        String resString=changeWord(line,wordOld,wordNew);
        System.out.println("\nСтрока после замены "+wordOld+" на "+wordNew+":");
        System.out.println(resString);
    }
}
