package by.epam.course.oopbasic.flower;

/*
    Класс для представления упаковки.
    Возможности:
    1) изменение цвета упаковки
    2) получение цвета упаковки
    3) вывод на консоль
 */

public class Packaging {

    private String color;

    public Packaging(){
        color="red";
    }

    public Packaging(String color){
        setColor(color);
    }

    public void setColor(String color){
        if(color!=null && !color.isEmpty()) {
            this.color = color;
        }
    }

    public String getColor(){
        return color;
    }

    @Override
    public String toString(){
        return "Цвет упаковки: "+color;
    }

    @Override
    public boolean equals(Object obj){
        if(obj == this){
            return true;
        }

        if(obj==null || obj.getClass() != this.getClass()){
            return false;
        }

        Packaging other=(Packaging)obj;

        return color.equals(other.color);
    }

    @Override
    public int hashCode(){
        final int prime=31;
        int result=1;

        result=prime*result+((color==null)?0:color.hashCode());

        return result;
    }
}
