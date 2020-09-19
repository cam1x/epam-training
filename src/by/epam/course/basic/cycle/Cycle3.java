package by.epam.course.basic.cycle;

/*
Находит сумму квадратов перывх ста чисел
 */

public class Cycle3 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i * i;
        }

        System.out.println("Сумма квадратов первых 100 чисел равна " + sum);
    }
}