package by.epam.course.string;

import java.util.Scanner;

/*
    Удаляет в строке все лишние пробелы и крайние пробелы
 */

public class StringAsArray5 {

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
        String editedLine=removeExtraSpaces(line);

        System.out.println("\nСтрока после удаления лишних пробелов:");
        System.out.println(editedLine+";");
    }
}
