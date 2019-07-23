package by.epam.course.classprograming.car;

/*
    Класс для представления двигателя
    Возможности:
    1) изменение состояния полей
    2) получение состояния полей
    P.S. Доступ только внутри пакета
 */

class Engine {

    private double power;
    public boolean isWorking;

    Engine(){
        power=50;
    }

    Engine(double power){
        setPower(power);
    }

    void setPower(double power){
        if(power>0){
            this.power=power;
        }
    }

    double getPower(){
        return power;
    }

    void turnOn(){
        isWorking=true;
    }

    void turnOff(){
        isWorking=false;
    }
}
