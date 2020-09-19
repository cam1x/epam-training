package by.epam.course.string.asobject;

import java.util.Scanner;

/*
    Удаляет из заданной строки повторяющиеся символы
    и все пробелы
 */

public class StringAsObject7 {
    //Удаляет все повторяющиеся символы и пробелы
    public static String removeDuplicates(String string) {
        StringBuilder noDupeplicates = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            String si = string.substring(i, i + 1);
            if (!si.equals(" ") && noDupeplicates.indexOf(si) == -1) {
                noDupeplicates.append(si);
            }
        }

        return noDupeplicates.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String line = in.nextLine();

        String noDuplicates = removeDuplicates(line);
        System.out.println("\nСтрока, в которой удалены повторяющиеся символы: " + noDuplicates);
    }
}
