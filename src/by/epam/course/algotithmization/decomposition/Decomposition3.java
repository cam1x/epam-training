package by.epam.course.algotithmization.decomposition;

import java.util.*;

/*
    Вычисляет площадь правильного шестиугольника, используя метод для вычисления площади правильного треуг
 */

public class Decomposition3 {

    private static double calculateSquareOfRegularTriangle(double sideLength){
        if (sideLength>0) {
            return (sideLength * sideLength * Math.sqrt(3)) / 4;
        }else{
            throw new IllegalArgumentException("Длина стороны должна быть положительной!");
        }
    }

    private static double calculateSquareOfRightHexagon(double sideLength){
        if(sideLength>0) {
            return 6 * calculateSquareOfRegularTriangle(sideLength);
        }else{
            throw new IllegalArgumentException("Длина стороны должна быть положительной!");
        }
    }

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            System.out.println("Введите длину стороны правильного шестиугольника: ");
            double sideLength = in.nextDouble();

            try {
                double squareOfHexagon = calculateSquareOfRightHexagon(sideLength);
                System.out.println("Площадь правильного шестиугольника = " + squareOfHexagon);
            } catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }

        } catch (InputMismatchException ex){
            System.out.println("Ошибка ввода! "+ex.getMessage());
        }
    }
}
