package by.epam.course.algotithmization.sort;

/*
    Сортировка выбором
 */

public class Sort3 {

    public static void sortByChoise(int[] array){
        /*Если массив отсортирован по возрастанию
        for(int i=0;i<array.length/2;i++){

            swapTwoArrayElements(array,i,array.length-1-i);
        }*/
         //Если массив заранее не отсортирован по возрастанию
        for(int i=0;i<array.length;i++){
            int maxInd = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] > array[maxInd]) {
                    maxInd = j;
                }
            }
           swapTwoArrayElements(array,i,maxInd);
        }
    }

    public static void swapTwoArrayElements(int[]array,final int INDEX1,final int INDEX2){
        int time=array[INDEX1];
        array[INDEX1]=array[INDEX2];
        array[INDEX2]=time;
    }

    public static void printArray(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr1[]={1,2,10,15,20,21,28,100,110,114};

        sortByChoise(arr1);

        printArray(arr1);
    }
}
