package by.epam.course.classprograming.test2;

/*
   Test2, содержащий 2 переменные. Реализованы конструкторы, set- get- методы
    Возможности:
    1) вывод на экран
    2) изменение переменных
    3) нахождение суммы значений
    4) нахождение наибольшего значения
 */

public class Test2 {
    private double firstVar;
    private double secondVar;

    public Test2() {
        firstVar = 0;
        secondVar = 0;
    }

    public Test2(double value1, double value2) {
        firstVar = value1;
        secondVar = value2;
    }

    public void printVars() {
        System.out.println(toString());
    }

    public double getVar1() {
        return firstVar;
    }

    public void setVar1(double value) {
        firstVar = value;
    }

    public double getVar2() {
        return secondVar;
    }

    public void setVar2(double value) {
        secondVar = value;
    }

    @Override
    public String toString() {
        return "Var1 = " + firstVar + ", var2 = " + secondVar;
    }
}
