package by.epam.course.classprograming.car;

/*
    Класс для представления авто.
    Возможности:
    1) установление состояний полей
    2) получение состояние полей
    3) заправить авто
    4) езда
    5) замена колес
    6) вывод на консоль
 */

public class Car {

    private Engine engine;
    private Wheel[] wheels=new Wheel[4];
    private String mark;
    private double fuel;

    public Car(){

        engine=new Engine();

        for(int i=0;i<wheels.length;i++){
            wheels[i]=new Wheel();
        }

        mark="BMW";
        fuel=20;
    }

    public Car(String mark,double startFuel){

        engine=new Engine();

        for(int i=0;i<wheels.length;i++){
            wheels[i]=new Wheel();
        }

        setMark(mark);
        setFuel(startFuel);
    }

    public Car(String mark,double startFuel, double enginePower, double wheelDiam, String wheelMark){

        setMark(mark);
        setFuel(startFuel);
        setEngine(enginePower);
        setWheels(wheelDiam,wheelMark);
    }

    public void setEngine(double power){

        engine.setPower(power);
    }

    public void setWheels(double diam,String mark){

        for(Wheel wheel:wheels){
            wheel.setDiameter(diam);
            wheel.setMark(mark);
        }
    }

    public void setMark(String mark){

        if(mark!=null && !mark.isEmpty()) {
            this.mark = mark;
        }
    }

    public void setFuel(double fuel){

        if(fuel>=0){
            this.fuel=fuel;
        }
    }

    public double getFuel(){

        return fuel;
    }

    public String getMark(){

        return mark;
    }

    public double getEnginePower(){

        return engine.getPower();
    }

    public String getWheels(){

        String string=new String("Характеристика колес авто:\n");

        for(int i=0;i<wheels.length;i++){
            string+=(i+1)+" колесо: \""+wheels[i].getMark()+"\"  диаметр "+wheels[i].getDiameter()+"\n";
        }

        return string;
    }

    //Заменить все колеса
    public void changeWheel(String mark,double diam){

        for(int i=0;i<wheels.length;i++){
            wheels[i].setDiameter(diam);
            wheels[i].setMark(mark);
        }
    }

    //Заменить колесо под номером position
    public void changeWheel(String mark,double diam, int position){

        if(position>=1 && position<=wheels.length){
            wheels[position-1].setMark(mark);
            wheels[position-1].setDiameter(diam);
        }
    }

    public void refuel(double fuel){

        if(fuel>0){
            this.fuel+=fuel;
            System.out.println("Машина заправлена на "+this.fuel+" л!");
        }
    }

    public void turnOn(){

        engine.turnOn();
        System.out.println("Двигатель заведен!");
    }

    public void turnOff(){

        engine.turnOff();
        System.out.println("Двигатель заглушен!");
    }

    //Возвращает проеханный путь
    public int drive(){

        int path=0;

        if(engine.isWorking){
            while(fuel>0){
                path+=10;
                fuel--;
            }
        }else{
            System.out.println("Машина не заведена!");
        }

        return path;
    }

    public void print(){

        System.out.println(toString());
    }

    @Override
    public String toString(){

        String string=new String();

        string+="\t\t"+getMark()+"\n";
        string+="Мощность двигателя: "+getEnginePower()+"\n";
        string+=getWheels();
        string+="Остаток бензина: "+fuel+"\n";

        return string;
    }
}
