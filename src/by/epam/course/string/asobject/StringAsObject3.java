package by.epam.course.string.asobject;

import java.util.Scanner;

/*
    Проверяет является ли заданное слово палиндромом
 */

public class StringAsObject3 {
    public static boolean isPalindrom(String string) {
        StringBuilder copyOfString = new StringBuilder(string);

        StringBuilder reversedString = new StringBuilder(copyOfString);
        reversedString.reverse();

        return copyOfString.toString().equals(reversedString.toString());
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите строку: ");

        String line = in.nextLine();

        if (isPalindrom(line)) {
            System.out.println("Палиндром!");
        } else {
            System.out.println("НЕ палиндром!");
        }
    }
}
