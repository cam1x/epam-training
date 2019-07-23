package by.epam.course.string;

import java.util.Scanner;

/*
    Подсчитывает, сколько раз среди символов заданной строки
    встречается символ 'a'
 */

public class StringAsObject5 {

    //Регистр не учитывается
    public static int calcNumOfCharacter(String string,char symbolToCalc){

        int num=0;//сколько раз встретился символ
        int index=0;//номер проверяемого символа
        string=string.toLowerCase();

        while(true){
            index=string.indexOf(symbolToCalc,index);
            if(index!=-1){
                num++;
                index++;
            }else{
                break;
            }
        }

        return num;
    }

    public static void main(String[] args){

        Scanner in=new Scanner(System.in);
        System.out.println("Введите строку: ");

        String line=in.nextLine();
        char symbolToCalc='a';
        int num=calcNumOfCharacter(line,symbolToCalc);
        System.out.println("\nВ строке '"+line+"' символ "+symbolToCalc+" встречается "+num+" раз(a).");
    }
}
