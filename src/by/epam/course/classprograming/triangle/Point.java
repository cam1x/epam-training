package by.epam.course.classprograming.triangle;

/*
    Класс для представления точки.
    Возможности:
    1) Установить кооридинаты точки
    2) Получить координаты точки
    3) Вывод на консоль
 */

public class Point {
    private double x;
    private double y;

    public Point() {

    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setPoint(Point p) {
        x = p.x;
        y = p.y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "{" + Math.round(x * 100) / 100.0d + "," + (Math.round(y * 100) / 100.0d) + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Point other = (Point) obj;

        return x == other.x && y == other.y;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Double.hashCode(x);
        result = prime * result + Double.hashCode(y);

        return result;
    }
}
