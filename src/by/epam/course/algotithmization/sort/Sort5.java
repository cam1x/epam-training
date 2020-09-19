package by.epam.course.algotithmization.sort;

/*
    Сортиовка вставками с использованием двоичного поиска
 */

public class Sort5 {
    public static int binarySearchOfIndexToInsert(int[] array, final int END_OF_GAP, final int NUM) {
        int firstIndex = 0;
        int lastIndex = END_OF_GAP;
        int middleIndex;

        if (NUM <= array[firstIndex]) {
            return firstIndex;
        }

        if (NUM >= array[lastIndex]) {
            return lastIndex + 1;
        }

        while (firstIndex <= lastIndex) {

            middleIndex = (firstIndex + lastIndex) / 2;

            if (NUM >= array[middleIndex] && NUM <= array[middleIndex + 1]) {
                return middleIndex + 1;
            }

            if (array[middleIndex] < NUM) {
                firstIndex = middleIndex;
            } else if (array[middleIndex] > NUM) {
                lastIndex = middleIndex;
            }
        }
        return -1;
    }

    public static void insertSort(int[] array) {
        int lastIndexOfSorted = 0;

        while (lastIndexOfSorted < array.length && array[lastIndexOfSorted] < array[lastIndexOfSorted + 1]) {
            lastIndexOfSorted++;
        }

        for (int i = lastIndexOfSorted + 1; i < array.length; i++) {
            int insertIndex = binarySearchOfIndexToInsert(array, lastIndexOfSorted, array[i]);
            int insertValue = array[i];
            if (i - insertIndex >= 0)
                System.arraycopy(array, insertIndex, array, insertIndex + 1, i - insertIndex);
            array[insertIndex] = insertValue;
            lastIndexOfSorted++;
        }
    }

    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 41, 18, 112, 18, 19, 3, 2, 1, 189, -1, -19};

        insertSort(arr1);
        printArray(arr1);
    }
}
