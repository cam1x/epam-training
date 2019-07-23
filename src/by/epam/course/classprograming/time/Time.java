package by.epam.course.classprograming.time;

import java.util.regex.*;

/*
    Класс для представления времени.
    Возможности:
    1) Установка времени с помощью строки/числа часов, мин, сек
    2) Изменение времени на заданное число часов, минут, сек
    3) Вывод времени
 */

public class Time {

    private int hours;
    private int minutes;
    private int seconds;

    public Time() {

    }

    public Time(String time) {
         setTime(time);
    }

    public Time(int hours, int minutes, int seconds) {
        setTime(hours, minutes, seconds);
    }

    //Время установится, если формат и значения времени верны в переданном строковом представлении
    public void setTime(String time){
        if(time!=null && !time.isEmpty()) {
            Pattern timePat = Pattern.compile("[0-9]{2}[.:-][0-9]{2}[.:-][0-9]{2}");
            Matcher timeMat = timePat.matcher(time);

            if (timeMat.find()) {
                int hours = Integer.parseInt(time.substring(0, 2));
                int minutes = Integer.parseInt(time.substring(3, 5));
                int seconds = Integer.parseInt(time.substring(6, 8));
                if (isRightTime(hours, minutes, seconds)) {
                    this.hours = hours;
                    this.minutes = minutes;
                    this.seconds = seconds;
                } else {
                    setZero();
                }

            } else {
                setZero();
            }
        }
    }

    //Время установится, если верны переданные значения часов, минут, секунд
    public void setTime(int hours,int minutes,int seconds){
        if(isRightTime(hours, minutes, seconds)) {
            this.hours = hours;
            this.minutes = minutes;
            this.seconds = seconds;

        }else{
            setZero();
        }
    }

    public void setHours(int hours){
        if(hours>=0 && hours <24){
            this.hours=hours;
        }else{
            setZero();
        }
    }

    public void setMinutes(int minutes){
        if(minutes>=0 && minutes<60){
            this.minutes=minutes;
        }else{
            setZero();
        }
    }

    public void setSeconds(int seconds){
        if(seconds>=0 && seconds<60){
            this.seconds=seconds;
        }else{
            setZero();
        }
    }

    public int getHours(){
        return hours;
    }

    public int getSeconds(){
        return seconds;
    }

    public int getMinutes(){
        return minutes;
    }

    /*
    При выполнениии любой из операция сложения время автоматически переводится в стандартный вид.
    (т.е 15:20 + 68 минут = 16:28)
     */
    public void addHours(int hours){
        if(hours>0) {
            this.hours = (this.hours + hours) % 24;
        }
    }

    public void addMinutes(int minutes){
        if(minutes>0) {
            this.minutes += minutes;
            this.hours = (this.hours + this.minutes / 60) % 24;
            this.minutes %= 60;
        }
    }

    public void addSeconds(int seconds){
        if(seconds>0) {
            this.seconds += seconds;
            this.minutes = (this.minutes + this.seconds / 60);
            this.hours = (this.hours + this.minutes / 60) % 24;
            this.minutes %= 60;
            this.seconds %= 60;
        }
    }

    public void print(){
        System.out.println(toString());
    }

    @Override
    public String toString(){
        return ((hours<=9)?"0"+hours:hours)+":"+((minutes<=9)?"0"+minutes:minutes)+":"+((seconds<=9)?"0"+seconds:seconds);
    }

    //Проверка переданных значений на корректность
    private boolean isRightTime(int hours,int minutes,int seconds){
        return hours>=0 && hours<24 && minutes>=0 && minutes<60 && seconds>=0 && seconds<60;
    }

     //Установить время 00:00:00
    private void setZero(){
        hours=minutes=seconds=0;
    }
}
