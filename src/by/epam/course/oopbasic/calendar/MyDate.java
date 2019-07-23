package by.epam.course.oopbasic.calendar;

/*
    Класс для представления даты(дня)
    Возможности:
    1) установить дату
    2) получить дату
    3) проверка на выходной день
    4) получить день недели по дате
    5) позволяет сравнивать две даты (раньшь/позже)
 */

public class MyDate {

   private int year;
   private int month;
   private int day;
   private String dayOfWeek;
   private boolean isDayOff;//является ли данный день выходным

   public MyDate(){

       day=18;
       month=7;
       year=2019;
       setDayOfWeek();
   }

   public MyDate(int day, int month, int year){

      setDate(day, month, year);
   }

   public void setDate(int day,int month,int year){

       setDay(day);
       setMonth(month);
       setYear(year);
       setDayOfWeek();
   }

   public void setYear(int year){

       if(year>=1900 && year<=2100){
           this.year=year;
           setDayOfWeek();
       }
   }

   public void setMonth(int month){

       if(month>=1 && month<=12){
           this.month=month;
           setDayOfWeek();
       }
   }

   public void setDay(int day) {

       if(day>=1 && day<=31) {
           this.day = day;
           setDayOfWeek();
       }
    }

    public int getDay() {

        return day;
    }

    public int getYear(){

       return year;
    }

    public int getMonth(){

       return month;
    }

    public String getDayOfWeek(){

       return getDayOfWeek();
    }

    public boolean isDayOff(){

       return isDayOff;
    }

    public boolean isWorkingDay(){

       return !isDayOff;
    }

    public boolean after(MyDate myDate){

       return year> myDate.year || (year== myDate.year && month> myDate.month)
               || (year== myDate.year && month== myDate.month && day> myDate.day);
    }

    public boolean before(MyDate myDate){

        return year< myDate.year || (year== myDate.year && month< myDate.month)
                || (year== myDate.year && month== myDate.month && day< myDate.day);
    }

    public int compareTo(MyDate myDate){

       if(this.after(myDate)){
           return 1;
       }

       if(this.before(myDate)){
           return -1;
       }

       return 0;
    }

    public void print(){

       System.out.println(toString());
    }

    @Override
    public String toString(){

        return (day<10?"0":"")+day+"."+(month<10?"0":"")+month+"."+year+ "   "+dayOfWeek+ "   "+ (isDayOff?"вых.":"раб.");
    }

    @Override
    public boolean equals(Object obj){

        if(obj == this){
            return true;
        }

        if(obj==null || obj.getClass() != this.getClass()){
            return false;
        }

        MyDate myDate=(MyDate) obj;

        return year==myDate.year && month==myDate.month && day== myDate.day;
    }

    @Override
    public int hashCode(){

        final int prime=31;
        int result=1;

        result=prime*result+year;
        result=prime*result+month;
        result=prime*result+day;

        return result;
    }

    /*
    Сделать данный день выходным(используется классом выходного дня, иной класс не может сделать день рабочим/нерабочим)
     */
    protected void setDayOff(){

       isDayOff=true;
    }

    /*
    Получения дня недели по дате.
    Реализовано без использоания посторонних классов
     */
    private void setDayOfWeek(){

        int a=(14-month)/12;
        int y=year-a;
        int m =month+12*a-2;
        int num= (day+ (31*m)/12 +y+ y/4 -y/100+y/400) %7;

        switch (num){
            case 0:{
                dayOfWeek="ВС";
                break;
            }

            case 1:{
                dayOfWeek="ПН";
                break;
            }

            case 2:{
                dayOfWeek="ВТ";
                break;
            }

            case 3:{
                dayOfWeek="СР";
                break;
            }

            case 4:{
                dayOfWeek="ЧТ";
                break;
            }

            case 5:{
                dayOfWeek="ПТ";
                break;
            }

            case 6:{
                dayOfWeek="СБ";
                break;
            }
        }

        isDayOff=(dayOfWeek.equals("СБ") || dayOfWeek.equals("ВС"));
    }
}
