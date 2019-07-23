package by.epam.course.classprograming.airline;

import java.util.regex.*;

/*
    Коллекция(массив) авиалиний.
    Возможности:
    1) нахождение списка рейсов для заданного пункта назнач.
    2) нахождение списка рейсов для заданного дня недели
    3) нахождение списка рейсов для заданного дня недели,
    время вылета для которых больше заданного
    4) добавление/удаление рейса
 */

public class AirlineArray {

    private Airline[] arrayOfAirlines;

    public AirlineArray(int size){

        if(size>0) {
            arrayOfAirlines = new Airline[size];
            for (int i = 0; i < size; i++) {
                arrayOfAirlines[i] = new Airline();
            }
        }
    }

    public AirlineArray(Airline[] array){

        setArrayOfAirlines(array);
    }

    public void setArrayOfAirlines(Airline[] array){

        if(array!=null) {
            arrayOfAirlines = new Airline[array.length];
            for (int i = 0; i < getSize(); i++) {
                arrayOfAirlines[i] = array[i];
            }
        }
    }

    public int getSize(){

        if(arrayOfAirlines!=null) {
            return arrayOfAirlines.length;
        }else{
            return 0;
        }
    }

    public Airline[] getArrayOfAirlines(){

        return arrayOfAirlines;
    }

    public Airline getAirline(int index){

        if(index>=0 && index<getSize()){
            return arrayOfAirlines[index];
        }else{
            throw new IllegalArgumentException("Выход за пределы массива!");
        }
    }

    public void print(){

        System.out.println(toString());
    }

    /*
    Возвращает рейсы в указанный пункт назначений.
    Если такие рейсы отсутствуют, то возвращается массив, состоящий из одного элемента, в котором значения всех полей установлены по умолчанию.
     */
    public AirlineArray getFlightsToDestination(String destination){

        if(arrayOfAirlines==null){
            throw new IllegalArgumentException("Рейсы отсутствуют! (null)");
        }

        int numOfFlights=0;

        for(Airline airline:arrayOfAirlines){
            if(airline.getDestination().equals(destination)){
                numOfFlights++;
            }
        }

        if(numOfFlights>0){
            Airline[] airlinesToDestination=new Airline[numOfFlights];

            for(int i=0,index=0;i<getSize();i++){
                if(arrayOfAirlines[i].getDestination().equals(destination)){
                    airlinesToDestination[index]=arrayOfAirlines[i];
                    index++;
                }
            }
            return new AirlineArray(airlinesToDestination);
        }else{
            return noMathes();
        }
    }

    /*
        Возвращает рейсы в указанный день недели.
        Если такие рейсы отсутствуют, то возвращается массив, состоящий из одного элемента, в котором значения всех полей установлены по умолчанию.
    */
    public AirlineArray getFlightsOnDay(String day){

        if(arrayOfAirlines==null){
            throw new IllegalArgumentException("Рейсы отсутствуют! (null)");
        }

        int numOfFlights=0;
        day=day.toLowerCase();

        for(Airline airline:arrayOfAirlines){
            if(airline.getDays().contains(day)){
                numOfFlights++;
            }
        }

        if(numOfFlights>0){
            Airline[] airlinesOnDay=new Airline[numOfFlights];

            for(int i=0,index=0;i<getSize();i++){
                if(arrayOfAirlines[i].getDays().contains(day)){
                    airlinesOnDay[index]=arrayOfAirlines[i];
                    index++;
                }
            }
            return new AirlineArray(airlinesOnDay);

        }else{
           return noMathes();
        }
    }

    /*
        Возвращает рейсы в указанный день недели после заданного времени.
        Если такие рейсы отсутствуют или неверно указано время (недопустимый формат или значение),
        то возвращается массив, состоящий из одного элемента, в котором значения всех полей установлены по умолчанию.
    */
    public AirlineArray getFlightsOnDay(String day,String time){

        if(arrayOfAirlines==null){
            throw new IllegalArgumentException("Рейсы отсутствуют! (null)");
        }

        if(isCorrectTime(time)) {
            int numOfFlights = 0;
            day = day.toLowerCase();

            boolean isLater;

            for (Airline airline : arrayOfAirlines) {
                isLater=time.compareTo(airline.getTimeOfAppointment())<0;
                if (isLater && airline.getDays().contains(day)) {
                    numOfFlights++;
                }
            }

            if (numOfFlights > 0) {
                Airline[] airlinesOnDay = new Airline[numOfFlights];

                for (int i = 0,index=0; i < getSize(); i++) {
                    isLater=time.compareTo(arrayOfAirlines[i].getTimeOfAppointment())<0;
                    if (isLater&&arrayOfAirlines[i].getDays().contains(day)) {
                        airlinesOnDay[index] = arrayOfAirlines[i];
                        index++;
                    }
                }
                return new AirlineArray(airlinesOnDay);

            } else {
                return noMathes();
            }

        } else{
            return noMathes();
        }
    }

    public void addAirline(Airline airline){

        if(airline!=null) {
            Airline[] newAirlines = new Airline[getSize() + 1];

            for (int i = 0; i < getSize(); i++) {
                newAirlines[i] = arrayOfAirlines[i];
            }

            newAirlines[getSize()] = airline;
            arrayOfAirlines = newAirlines;
        }
    }

    public void deleteAirline(Airline airline){

        if(airline==null){
            throw new IllegalArgumentException("Неверный аргумент (null)!");
        }

        int numOfAirlines=getSize();

        for(Airline airline1: arrayOfAirlines){

            if(airline1.equals(airline)){

                numOfAirlines--;
            }
        }

        if(numOfAirlines<getSize()){
            Airline[] newAirlines=new Airline[numOfAirlines];
            for(int i=0,index=0;i<getSize();i++){
                if(!arrayOfAirlines[i].equals(airline)){
                    newAirlines[index]=arrayOfAirlines[i];
                    index++;
                }
            }
            arrayOfAirlines=newAirlines;
        }
    }

    public void deleteAirline(int index){

        if(index>=0 && index<getSize()){
            Airline[] newAirlines=new Airline[getSize()-1];
            for(int i=0,j=0;i<getSize();i++){
                if(i!=index){
                    newAirlines[j]=arrayOfAirlines[i];
                    j++;
                }
            }
            arrayOfAirlines=newAirlines;
        }
    }

    @Override
    public String toString(){

        if(arrayOfAirlines!=null) {
            String string = new String();

            for (Airline airline : arrayOfAirlines) {
                string += airline.toString() + "\n";
            }

            return string;

        } else{
            return "Рейсы отсутствуют!";
        }
    }

    @Override
    public boolean equals(Object obj){

        if(obj == this){
            return true;
        }

        if(obj==null || obj.getClass() != this.getClass()){
            return false;
        }

        AirlineArray other=(AirlineArray) obj;

        boolean isEqual=(other.getSize()==getSize());

        for(int i=0;isEqual && i<getSize();i++){
            if(!arrayOfAirlines[i].equals(other.getArrayOfAirlines()[i])){
                isEqual=false;
            }
        }

        return isEqual;
    }

    @Override
    public int hashCode(){

        final int prime=31;
        int result=1;

        for(int i=0;i<getSize();i++){
            result=prime*result+arrayOfAirlines[i].hashCode();
        }

        return result;
    }

    //Проверка на корректность хранящегося в строке времени: формат и допустимость значений.
    private boolean isCorrectTime(String time){

        Pattern timePat= Pattern.compile("[0-9]{2}[.:-][0-9]{2}");
        Matcher timeMat=timePat.matcher(time);

        if(timeMat.find()){
            int hours=Integer.parseInt(time.substring(0,2));
            int mins=Integer.parseInt(time.substring(3,5));
            return hours>=0 && hours<24 && mins>=0 && mins<60;
        }else{
            return false;
        }
    }

    //Возвращает массив, состоящий из одного элемента, в котором значения всех полей установлены по умолчанию.
    private AirlineArray noMathes(){

        Airline[] zeroAirlines=new Airline[1];
        zeroAirlines[0]=new Airline();

        return new AirlineArray(zeroAirlines);
    }
}
