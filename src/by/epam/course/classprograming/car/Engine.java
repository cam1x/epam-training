package by.epam.course.classprograming.car;

/*
    Класс для представления двигателя
    Возможности:
    1) изменение состояния полей
    2) получение состояния полей
    P.S. Доступ только внутри пакета
 */

class Engine {
    public boolean isWorking;
    private double power;

    Engine() {
        power = 50;
    }

    Engine(double power) {
        setPower(power);
    }

    double getPower() {
        return power;
    }

    void setPower(double power) {
        if (power > 0) {
            this.power = power;
        }
    }

    void turnOn() {
        isWorking = true;
    }

    void turnOff() {
        isWorking = false;
    }
}
