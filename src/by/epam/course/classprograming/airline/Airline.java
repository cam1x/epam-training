package by.epam.course.classprograming.airline;

import java.util.regex.*;

/*
    Класс для представления самолета
    Возможности:
    1) изменить значение каждого поля
    2) получить значение каждого поля
    3) вывод на консоль
 */

public class Airline {

    private String destination;
    private int flightNumber;
    private Plane planeType;
    private String timeOfAppointment;
    private int[] days=new int[7];//бинарный массив, где 1 в i-ой позиции означает, что рейс запланирован (i+1) день

    public Airline(){
        destination="not defined";
        planeType=Plane.PASSENGER;
        timeOfAppointment="00:00";
    }

    public Airline(String destination,int flightNumber,Plane planeType,String timeOfAppointment,String days){
        setDestination(destination);
        setFlightNumber(flightNumber);
        setPlaneType(planeType);
        setTimeOfAppointment(timeOfAppointment);
        setDays(days);
    }

    //Время установится только, если в переданной строке верен формат и значение времени
    public void setTimeOfAppointment(String timeOfAppointment){
       if(isCorrectTime(timeOfAppointment) && timeOfAppointment!=null){
           this.timeOfAppointment=timeOfAppointment;
       }else{
           this.timeOfAppointment="00:00";
       }
    }

    //Установить 1 в бинарный массив, если найден соотв. день недели
    public void setDays(String days){
        if(days!=null && !days.isEmpty()) {
            days = days.toLowerCase();

            if (days.contains("понедельник") || days.contains("monday")) {
                this.days[0] = 1;
            }
            if (days.contains("вторник") || days.contains("tuesday")) {
                this.days[1] = 1;
            }
            if (days.contains("среда") || days.contains("wednesday")) {
                this.days[2] = 1;
            }
            if (days.contains("четверг") || days.contains("thursday")) {
                this.days[3] = 1;
            }
            if (days.contains("пятница") || days.contains("friday")) {
                this.days[4] = 1;
            }
            if (days.contains("суббота") || days.contains("saturday")) {
                this.days[5] = 1;
            }
            if (days.contains("воскресенье") || days.contains("sunday")) {
                this.days[6] = 1;
            }
        }
    }

    public void setDestination(String destination){
        if(destination!=null && !destination.isEmpty()) {
            this.destination = destination;
        }
    }

    public void setFlightNumber(int flightNumber){
        if(flightNumber>0) {
            this.flightNumber = flightNumber;
        }
    }

    public void setPlaneType(Plane planeType){
        this.planeType=planeType;
    }

    public int getFlightNumber(){
        return flightNumber;
    }

    public String getDestination(){
        return destination;
    }

    public String getTimeOfAppointment(){
        return timeOfAppointment;
    }

    public String getDays(){
        String string=new String();

        if(days[0]==1){
            string+="понедельник ";
        }

        if(days[1]==1){
            string+="вторник ";
        }

        if(days[2]==1){
            string+="среда ";
        }

        if(days[3]==1){
            string+="четверг ";
        }

        if(days[4]==1){
            string+="пятница ";
        }

        if(days[5]==1){
            string+="суббота ";
        }

        if(days[6]==1){
            string+="воскресенье";
        }

        return string;
    }

    public Plane getPlaneType(){
        return planeType;
    }

    public void print(){
        System.out.println(toString());
    }

    @Override
    public String toString(){
        return String.format("%15s %10s %10s %15s %35s",destination, Integer.toString(flightNumber),
                planeType.toString(), timeOfAppointment, getDays());
    }

    @Override
    public boolean equals(Object obj){
        if(obj == this){
            return true;
        }

        if(obj==null || obj.getClass() != this.getClass()){
            return false;
        }

        Airline other=(Airline) obj;
        return destination.equals(other.destination) && getDays().equals(other.getDays()) &&
                planeType.toString().equals(other.planeType.toString()) &&
                timeOfAppointment.equals(other.timeOfAppointment);
    }

    @Override
    public int hashCode(){
        final int prime=31;
        int result=1;

        result=prime*result+((destination==null)?0:destination.hashCode());
        result=prime*result+flightNumber;
        result=prime*result+planeType.hashCode();
        result=prime*result+((timeOfAppointment==null)?0:timeOfAppointment.hashCode());
        result=prime*result+((getDays()==null)?0:getDays().hashCode());

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
}
