package by.epam.course.algotithmization;

import java.util.*;

/*
    Формирует все магические квадрата n-ого порядка
 */

public class Matrix16 {

    public static void swapTwoArrayElements(int[]array,final int INDEX1,final int INDEX2){

        int time=array[INDEX1];
        array[INDEX1]=array[INDEX2];
        array[INDEX2]=time;
    }

    public static boolean nextPerm(int[] array){
        //Алгоритм Нарайаны
        int i=array.length-1;
        while(--i>=0&&array[i]>array[i+1]){

        }
        if(i==-1){
            return false;
        }

        for(int j=i+1,k=array.length-1;j<k;j++,k--){
            swapTwoArrayElements(array,j,k);
        }

        int j=i+1;
        while(array[j]<array[i]){
            j++;
        }
        swapTwoArrayElements(array,i,j);
        return true;
    }

    public static boolean isMagic(int[] array) {

        boolean isMagic=true;
        final int SIZE=(int)(Math.sqrt(array.length));

        int sum=0;
        int currSum=0;

        for(int i=0;i<SIZE;i++){
            sum+=array[i];
        }

        //Суммы строк
        for(int i=1;i<SIZE && isMagic;i++){
            for(int j=0;j<SIZE;j++){
                currSum+=array[3*i+j];
            }
            isMagic=(currSum==sum);
            currSum=0;
        }

        //Суммы столбцов
        for(int i=0;i<SIZE && isMagic;i++){
            for(int j=0;j<SIZE;j++){
                currSum+=array[i+j*SIZE];
            }
            isMagic=(currSum==sum);
            currSum=0;
        }

        //Главная диагональ
        if (isMagic) {

            for (int i = 0; i < SIZE; i++) {
                currSum += array[i * (SIZE + 1)];
            }
            isMagic = (currSum == sum);
            currSum = 0;
        }

        if(isMagic){
            for (int i = 0; i < SIZE; i++) {
                currSum += array[(SIZE - 1)*(i+1)];
            }
            isMagic = (currSum == sum);
        }

        return isMagic;
    }

    public static void outputArrayAsMatrix(int[]array){

        final int SIZE=(int)Math.sqrt(array.length);
        for(int i=0;i<array.length;i++){
            if(i%SIZE==0) {
                System.out.println();
            }
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    public static void generateMagic(final int SIZE){

        if(SIZE<=0){
            throw new IllegalArgumentException("Порядок должен быть положительным!");
        }

        if(SIZE==2){
            System.out.println("Не существует магических квадратов порядка 2!");
            return;
        }

        int[]array=new int[SIZE*SIZE];

        for(int i=0;i<array.length;i++){
            array[i]=i+1;
        }

        do{
            if(isMagic((array))){
                outputArrayAsMatrix((array));
            }
        }while(nextPerm(array));
    }

    public static void main(String[] args) {

        try {
            Scanner in = new Scanner(System.in);
            System.out.println("Введите порядок магического квадрата: ");

            int n = in.nextInt();

            try {
                generateMagic(n);
            } catch (IllegalArgumentException exception){
                System.out.println(exception.getMessage());
            }

        }catch (InputMismatchException ex){
            System.out.println("Ошибка ввода! "+ex.getMessage());
        }
    }
}