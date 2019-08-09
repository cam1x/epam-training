package by.epam.course.string.asobject;

import java.util.Scanner;

/*
    Находит наибольшее число подряд идущих пробелов в строке
 */

public class StringAsObject1 {

    public static int calcLargestNumOfSpaces(String string){
        int numOfSpaces=0;
        int currNum=0;
        int index=0;

        while(true){
            index=string.indexOf(' ',index);

            if(index!=-1){
                while(index<string.length()&& string.charAt(index)==' '){
                    currNum++;
                    index++;
                }

                if(currNum>numOfSpaces){
                    numOfSpaces=currNum;
                }

                currNum=0;
            }else{
                break;
            }
        }

        return numOfSpaces;
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        System.out.println("Введите строку: ");
        String line=in.nextLine();

        int numOfSpaces=calcLargestNumOfSpaces(line);
        System.out.println("Наибольшее число пробелов подряд: "+numOfSpaces);
    }
}
