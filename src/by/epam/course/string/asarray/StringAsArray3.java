package by.epam.course.string.asarray;

import java.util.Scanner;

/*
    Находит в строке кол-во цифр
 */

public class StringAsArray3 {
    public static boolean isDigit(char ch) {
        return ch >= '1' && ch <= '9';
    }

    public static int calcNumOfDigits(String string) {
        int numOfDigits = 0;

        for (int i = 0; i < string.length(); i++) {
            if (isDigit(string.charAt(i))) {
                numOfDigits++;
            }
        }

        return numOfDigits;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String line = in.nextLine();

        int numOfDigits = calcNumOfDigits(line);

        System.out.println("\nЧисло цифр в строке " + line + " = " + numOfDigits);
    }
}
