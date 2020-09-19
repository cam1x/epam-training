package by.epam.course.algotithmization.sort;

/*
    Сортировка обменами с подсчетом числа перестановок
 */

public class Sort4 {
    public static int exchangeSort(int[] array) {
        int numberOfExchanges = 0;

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    swapTwoArrayElements(array, j, j + 1);
                    numberOfExchanges++;
                }
            }
        }

        return numberOfExchanges;
    }

    public static void swapTwoArrayElements(int[] array, final int INDEX1, final int INDEX2) {
        int time = array[INDEX1];
        array[INDEX1] = array[INDEX2];
        array[INDEX2] = time;
    }

    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr1 = {114, 110, 15, 7, 5, 1};
        System.out.println("Число перестановок: " + exchangeSort(arr1));
        printArray(arr1);
    }
}
