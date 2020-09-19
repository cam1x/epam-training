package by.epam.course.basic.cycle;

/*
    Выводит на экран соответствие между символами и их числ обозначениями
 */

public class Cycle6 {
    public static void main(String[] args) {
        System.out.println(String.format("%12s %13s", "Число", "Соотв. символ"));

        for (int i = 33; i < 256; i++) {
            System.out.println(String.format("%10s %10s", i, (char) i));
        }
    }
}
