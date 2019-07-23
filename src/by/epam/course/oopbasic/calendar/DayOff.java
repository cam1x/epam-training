package by.epam.course.oopbasic.calendar;

/*
    Класс для представления выходного дня
 */

public class DayOff extends MyDate {

    public DayOff(){

        super();
        super.setDayOff();
    }

    public DayOff(int day, int month, int year){

        super(day, month, year);
        super.setDayOff();
    }
}
