package by.epam.course.oopbasic.calendar;

/*
    Класс для представления праздника
 */

public class Holiday extends MyDate {

    private String holidayName;

    public Holiday(String name,int day,int month,int year){
        super(day, month, year);
        holidayName=name;
    }

    public void setHolidayName(String name){
        this.holidayName=name;
    }

    public String getHolidayName(){
        return holidayName;
    }

    @Override
    public String toString(){
        return super.toString()+"   праздник";
    }
}
