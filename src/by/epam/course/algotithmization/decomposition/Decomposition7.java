package by.epam.course.algotithmization.decomposition;

/*
    Вычисляет сумму факториалов всех нечетных чисел от 1 до 9
 */

public class Decomposition7 {
    public static int calculateFactorial(int n) {
        if (n == 0) {
            return 1;
        }

        return n * calculateFactorial(n - 1);
    }

    public static int calculateSumOfFactorialForOdd(int startOfMerge, int endOfMerge) {
        int sum = 0;

        if (startOfMerge % 2 == 0) {
            startOfMerge++;
        }

        for (int i = startOfMerge; i <= endOfMerge; i += 2) {
            sum += calculateFactorial(i);
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println("Сумма факториалов от 1 до 9 = " + calculateSumOfFactorialForOdd(1, 9));
    }
}
