package by.epam.course.classprograming.counter;

/*
    Реализован цикличный  десятичный счетчик.(т.е. для такого счетчика 4-5=9 9+2=1)
    Возможности:
    1) установить начальное значение счетчика
    2) увеличить значение счетчика на 1/любое нат число
    3) умен. значение счетчика на 1/любое нат число
    4) получить значение счетчика
 */

public class DecimalCounter {

    private int counter;

    public DecimalCounter(){

        counter=0;
    }

    public DecimalCounter(int start){

        setCounter(start);
    }

    public void setCounter(int value){

        if(value>=0) {
            counter = value % 10;
        }
    }

    public int getCounter(){

        return counter;
    }

    //Увеличить на единицу
    public void increase(){

        counter=(counter+1)%10;
    }

    //Увеличить на указанное значение. Реализовано с учетом цикличности счетчика
    public void increase(int value){

        if(value>0) {
            counter = (counter + value) % 10;
        }
    }


    //Уменьшить на единицу
    public void decrease(){

        counter=(counter+9)%10;
    }

    //Уменьшить на указанное значение.
    public void decrease(int value){

        if(value>0) {
            value %= 10;
            counter = (counter + 10 - value) % 10;
        }
    }

    public void print(){

        System.out.println(toString());
    }

    @Override
    public String toString(){

        return "значение счетчика "+counter;
    }
}
