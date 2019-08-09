package by.epam.course.algotithmization.sort;

/*
    Из двух неубывающих последовательностей образовать новую неубывающую последовательность
 */

public class Sort2 {

    public static int[] combineTwoSequences(int[] arr1,int[] arr2){
        int[] combinedArray=new int[arr1.length+arr2.length];

        int indexOfArray1=0;
        int indexOfArray2=0;

        if(arr1[0]>arr2[0]){
            combinedArray[0]=arr2[0];
            indexOfArray2++;
        }else{
            combinedArray[0]=arr1[0];
            indexOfArray1++;
        }

        boolean isIllegalIndexes;
        int i=1;

        while(i<combinedArray.length){

            isIllegalIndexes=indexOfArray1<arr1.length &&indexOfArray2<arr2.length;

            if(isIllegalIndexes) {
                if (arr1[indexOfArray1] < arr2[indexOfArray2]) {
                    combinedArray[i] = arr1[indexOfArray1];
                    indexOfArray1++;
                }else{
                    combinedArray[i] = arr2[indexOfArray2];
                    indexOfArray2++;
                }
            }else{
                break;
            }
            i++;
        }

        while(indexOfArray1<arr1.length){
            combinedArray[i]=arr1[indexOfArray1];
            indexOfArray1++;
            i++;
        }

        while(indexOfArray2<arr2.length){
            combinedArray[i]=arr2[indexOfArray2];
            indexOfArray2++;
            i++;
        }

        return combinedArray;
    }

    public static void printArray(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr1[]={1,3,5,7,8,10,15,21};
        int arr2[]={2,3,4,5,11,14,15,22,29};

       printArray(combineTwoSequences(arr1,arr2));
    }
}

