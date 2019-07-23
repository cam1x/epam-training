package by.epam.course.string;

import java.util.Scanner;

/*
    В строке после каждого символа 'a' вставляет символ 'b'
 */

public class StringAsObject2 {

    //Добавляет после каждого символа inputAfter cимвол symbolToInput
    public static String addSymbol(String string,char inputAfter, char symbolToInput){

        String newCharSeq=new String();
        newCharSeq+=inputAfter;
        newCharSeq+=symbolToInput;

        String oldSeq=new String();
        oldSeq+=inputAfter;

        return string.replace(oldSeq,newCharSeq);
    }

    public static void main(String[] args){

        Scanner in=new Scanner(System.in);
        System.out.println("Введите строку: ");
        String line=in.nextLine();

        char oldSymbol='a';
        char newSymbol='b';

        String changedLine=addSymbol(line,oldSymbol,newSymbol);

        System.out.println("После каждого символа" + oldSymbol+" добавлен "+newSymbol);
        System.out.println(changedLine);
    }
}
