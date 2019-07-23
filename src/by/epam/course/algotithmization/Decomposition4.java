package by.epam.course.algotithmization;

import java.util.*;

/*
    На плоскости заданы своми координатами n точек.
    Определяет между какими точками самое больщое расстояние
 */

public class Decomposition4 {

    //Возвращает массив из двух элементов: индексы двух точек, между которыми макс расстояние
    public static int[] findPointsGreatestDistance(double[] xCoord,double[] yCoord){

        int arrayOfIndexes[]=new int[2];/*Индексы точек,
         между которыми наибольшее расстояние*/
        double maxDistance=0;
        double currDistance;

        for(int i=0;i<xCoord.length;i++){
            for(int j=i+1;j<xCoord.length;j++){
                currDistance=calculateDistanceBetweenPoints(xCoord[i],yCoord[i],xCoord[j],yCoord[j]);
                if(currDistance>maxDistance){
                    maxDistance=currDistance;
                    arrayOfIndexes[0]=i;
                    arrayOfIndexes[1]=j;
                }
            }
        }

        return arrayOfIndexes;
    }

    public static double calculateDistanceBetweenPoints(double x1,double y1,double x2,double y2){

        return Math.sqrt( (x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
    }

    public static void generateCoordinates(double[] xCoord,double[] yCoord){

        for(int i=0;i<xCoord.length;i++){
            xCoord[i]=Math.random()*40-20;
            xCoord[i] = Math.round( xCoord[i]*100)/100.0d;

            yCoord[i]=Math.random()*40-20;
            yCoord[i] = Math.round(yCoord[i]*100)/100.0d;
        }
    }

    public static void printPoints(double[] xCoordinates,double[] yCoordinates){

        System.out.println();
        for(int i=0;i<xCoordinates.length;i++){
            System.out.print("{"+xCoordinates[i]+","+yCoordinates[i]+"} ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        try {
            Scanner in = new Scanner(System.in);
            System.out.println("Введите кол-во точек: ");

            int numberOfPoints = in.nextInt();

            if (numberOfPoints > 0) {
                double xCoord[] = new double[numberOfPoints];
                double yCoord[] = new double[numberOfPoints];

                generateCoordinates(xCoord, yCoord);
                printPoints(xCoord, yCoord);

                int[] arrOfIndexes = findPointsGreatestDistance(xCoord, yCoord);

                double maxDistance = calculateDistanceBetweenPoints(xCoord[arrOfIndexes[0]], yCoord[arrOfIndexes[0]], xCoord[arrOfIndexes[1]], yCoord[arrOfIndexes[1]]);
                maxDistance = Math.round(maxDistance * 100) / 100.0d;

                System.out.print("\nМаксимальное расстояние = " + maxDistance + " между точками: {" + xCoord[arrOfIndexes[0]] + "," + yCoord[arrOfIndexes[0]] + "}");
                System.out.println(" и {" + xCoord[arrOfIndexes[1]] + "," + yCoord[arrOfIndexes[1]] + "}");

            } else {
                System.out.println("Кол-во точек должно быть положительным!");
            }

        } catch (InputMismatchException ex){
            System.out.println("Ошибка ввода! "+ex.getMessage());
        }
    }
}
