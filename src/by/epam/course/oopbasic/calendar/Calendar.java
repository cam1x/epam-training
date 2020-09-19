package by.epam.course.oopbasic.calendar;

import java.util.ArrayList;
import java.util.Comparator;

/*
    Класс для представления календаря
    Возможности:
    1) добавить дату в календарь
    2) добавить выходной/праздник в календарь
    3) удалить дату из календаря
    4) сортировка календаря
    5) вывод на консоль
 */

public class Calendar {
    private final ArrayList<MyDate> dates = new ArrayList<MyDate>();

    public Calendar() {

    }

    public void addDate(int day, int month, int year) {
        dates.add(new MyDate(day, month, year));
    }

    public void addHoliday(String name, int day, int month, int year) {
        dates.add(new Holiday(name, day, month, year));
    }

    public void addDayOff(int day, int month, int year) {
        dates.add(new DayOff(day, month, year));
    }

    public void deleteDate(int index) {
        if (index >= 0 && index < dates.size()) {
            dates.remove(index);
        }
    }

    public void getDate(int index) {
        if (index >= 0 && index < dates.size()) {
            dates.get(index);
        }
    }

    public void sort() {
        dates.sort(new Comparator<MyDate>() {

            @Override
            public int compare(MyDate p1, MyDate p2) {
                return p1.compareTo(p2);
            }
        });
    }

    public void print() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();

        for (int i = 0; i < dates.size(); i++) {
            string.append(i + 1).append("  ").append(dates.get(i).toString()).append("\n");
        }

        return string.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Calendar other = (Calendar) obj;

        boolean isEqual = (dates.size() == other.dates.size());

        for (int i = 0; isEqual && i < dates.size(); i++) {
            if (!dates.get(i).equals(other.dates.get(i))) {
                isEqual = false;
                break;
            }
        }

        return isEqual;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        for (MyDate date : dates) {
            result = prime * result + date.hashCode();
        }

        return result;
    }
}
