package by.epam.course.classprograming.triangle;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TriangleTest {
    public static void main(String[] args) {
        try {
            Triangle triangle = new Triangle();

            Scanner scanner = new Scanner(System.in);

            System.out.println("\nВведите координаты трех верщин треугольника (x,y)");

            System.out.println("Первая вершина:");
            triangle.setPointA(scanner.nextDouble(), scanner.nextDouble());

            System.out.println("Вторая вершина:");
            triangle.setPointB(scanner.nextDouble(), scanner.nextDouble());

            System.out.println("Третья вершина:");
            triangle.setPointC(scanner.nextDouble(), scanner.nextDouble());

            triangle.print();

            System.out.println("Площадь = " + triangle.getSquare());
            System.out.println("Периметр = " + triangle.getPerimeter());
            System.out.println("Точка пересечения медиан = " + triangle.getCenter());

        } catch (InputMismatchException ex) {
            System.out.println("Ошибка ввода! " + ex.getMessage());
        }
    }
}
