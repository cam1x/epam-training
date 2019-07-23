package by.epam.course.classprograming.triangle;

/*
    Класс для представления треугольника.
    Возомжности:
    1) Задать точки треугольника
    2) Получить точки треугольника
    3) Вычисление площади
    4) Вычисление периметра
    5) Получить центр треугольника
    6) Вывод на консоль
 */

public class Triangle {

    private Point pointA=new Point();
    private Point pointB=new Point();
    private Point pointC=new Point();

    public Triangle(){

    }

    public Triangle(Point p1,Point p2,Point p3){

        pointA.setPoint(p1);
        pointB.setPoint(p2);
        pointC.setPoint(p3);
    }

    public void setPointA(double x, double y){

        pointA.setX(x);
        pointA.setY(y);
    }

    public void setPointB(double x, double y){

        pointB.setX(x);
        pointB.setY(y);
    }

    public void setPointC(double x, double y){

        pointC.setX(x);
        pointC.setY(y);
    }

    public Point getPointA(){

        return pointA;
    }

    public Point getPointB(){

        return pointB;
    }

    public Point getPointC(){

        return pointC;
    }

    public double getSquare(){

        double square=((pointA.getX()-pointC.getX())*(pointB.getY()-pointC.getY())-(pointA.getY()-pointC.getY())*(pointB.getX()-pointC.getX()))/2;

        return Math.abs(square);
    }

    //Возвращает центр треугольника (точка пересечения медиан)
    public Point getCenter(){

        Point center=new Point();
        center.setX((pointA.getX()+pointB.getX()+pointC.getX())/3);
        center.setY((pointA.getY()+pointB.getY()+pointC.getY())/3);

        return center;
    }

    public double getPerimeter(){

        double side1=Math.sqrt(Math.pow(pointA.getX()-pointB.getX(),2) + Math.pow((pointA.getX()-pointB.getY()),2));
        double side2=Math.sqrt(Math.pow(pointB.getX()-pointC.getX(),2) + Math.pow((pointB.getY()-pointC.getY()),2));
        double side3=Math.sqrt(Math.pow(pointC.getX()-pointA.getX(),2) + Math.pow((pointC.getY()-pointA.getY()),2));

        return side1+side2+side3;
    }

    public void print(){

        System.out.println(toString());
    }

    @Override
    public String toString(){

        return "Triangle ( "+pointA.toString()+", "+pointB.toString()+", "+pointC.toString()+" );";
    }

    @Override
    public boolean equals(Object obj){

        if(obj == this){
            return true;
        }

        if(obj==null || obj.getClass() != this.getClass()){
            return false;
        }

        Triangle other=(Triangle) obj;

        return pointA.equals(other.pointA) && pointB.equals(other.pointB) && pointC.equals(other.pointC);
    }

    @Override
    public int hashCode(){

        final int prime=31;
        int result=1;
        result=prime*result+pointA.hashCode();
        result=prime*result+pointB.hashCode();
        result=prime*result+pointC.hashCode();
        return result;
    }
}
