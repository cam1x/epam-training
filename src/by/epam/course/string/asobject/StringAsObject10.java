package by.epam.course.string.asobject;

import java.util.Scanner;

/*
    Считает число предложения в строке, путем
    подсчета . ! ?
 */

public class StringAsObject10 {
    public static int calcNumOfSentences(String string) {
        return calcNumOfCharacter(string, '.') +
                calcNumOfCharacter(string, '!') + calcNumOfCharacter(string, '?');
    }

    //Регистр не учитывается
    public static int calcNumOfCharacter(String string, char symbolToCalc) {
        int num = 0;//сколько раз встретился символ
        int index = 0;//номер проверяемого символа
        string = string.toLowerCase();

        while (true) {
            index = string.indexOf(symbolToCalc, index);

            if (index != -1) {
                num++;
                index++;
            } else {
                break;
            }
        }

        return num;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите строку: ");
        String line = in.nextLine();

        int numOfSentences = calcNumOfSentences(line);
        System.out.println("\nЧисло предложений " + numOfSentences);
    }
}
