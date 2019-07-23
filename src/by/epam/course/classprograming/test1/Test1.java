package by.epam.course.classprograming.test1;

/*
    Test1, содержащий 2 переменные. Возможности:
    1) вывод на экран
    2) изменение переменных
    3) нахождение суммы значений
    4) нахождение наибольшего значения
 */

public class Test1 {

    private double firstVar;
    private double secondVar;

    public Test1(){
         firstVar=0;
         secondVar=0;
    }

    public Test1(double value1, double value2){
        firstVar=value1;
        secondVar=value2;
    }

    public void printVars(){
        System.out.println(toString());
    }

    public void setVar1(double value){
        firstVar=value;
    }

    public void setVar2(double value){
        secondVar=value;
    }

    public double getVar1(){
        return firstVar;
    }

    public double getVar2(){
        return secondVar;
    }

    public double sumVars(){
        return firstVar+secondVar;
    }

    public double returnMax(){
        return firstVar>secondVar? firstVar:secondVar;
    }

    @Override
    public String toString(){
        return "Var1 = "+firstVar+", var2 = "+secondVar;
    }
}
