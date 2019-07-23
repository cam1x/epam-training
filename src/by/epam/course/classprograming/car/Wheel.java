package by.epam.course.classprograming.car;

/*
    Класс для представления двигателя
    Возможности:
    1) изменение состояния полей
    2) получение состояния полей
    P.S. Доступ только внутри пакета
 */

class Wheel {

    private double diameter;
    private String mark;

    Wheel(){

        diameter=25;
        mark="Michelin";
    }

    Wheel(double diam){

        setDiameter(diam);
        mark="Michelin";
    }

    Wheel(double diameter,String mark){

        setDiameter(diameter);
        setMark(mark);
    }

    void setDiameter(double diam){

        if(diam>0){
            diameter=diam;
        }
    }

    void setMark(String mark){

        if(mark!=null && !mark.isEmpty()) {
            this.mark = mark;
        }
    }

    double getDiameter(){

        return diameter;
    }

    String getMark(){

        return mark;
    }

    boolean equals(Wheel other){

        return diameter==other.getDiameter() && mark.equals(other.mark);
    }
}
