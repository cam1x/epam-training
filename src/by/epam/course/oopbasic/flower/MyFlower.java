package by.epam.course.oopbasic.flower;

interface Flower {

    void setColor(String color);
    void setPrice(double price);
    String getName();
    String getColor();
    double getPrice();
}

/*
    Класс для представления цветка
    Возможности:
    1) изменение типа, цвета, цены цветка
    2) получение типа, цвета, цены цветка
    3) вывод на консоль
 */

public class MyFlower implements Flower {

    private double priceForOne;
    private String name="роза";
    private String color="красный";

    public MyFlower(){

        priceForOne=7;
    }

    public MyFlower(String name, String color, double price){

        if(price>0 && isValidString(name) && isValidString(color)){
            this.name=name;
            this.color=color;
            priceForOne=price;
        }
    }

    public void setColor(String color){

        if(isValidString(color)) {
            this.color = color;
        }
    }

    public void setPrice(double price){

        if(price>0){
            priceForOne=price;
        }
    }

    public String getName(){

        return name;
    }

    public String getColor(){

        return color;
    }

    public double getPrice() {

        return priceForOne;
    }

    public void show(){

        System.out.println(toString());
    }

    @Override
    public String toString(){

        return String.format("%15s %15s %10s",name,color,Double.toString(priceForOne));
    }

    @Override
    public boolean equals(Object obj){

        if(obj == this){
            return true;
        }

        if(obj==null || obj.getClass() != this.getClass()){
            return false;
        }

        MyFlower other=(MyFlower) obj;

        return name.equals(other.name) && color.equals(other.color) && priceForOne==other.priceForOne;
    }

    @Override
    public int hashCode(){

        final int prime=31;
        int result=1;

        result=prime*result+((name==null)?0:name.hashCode());
        result=prime*result+((color==null)?0:color.hashCode());
        result=prime*result+Double.hashCode(priceForOne);

        return result;
    }

    protected boolean isValidString(String string){

        return string!=null && !string.isEmpty();
    }

    protected void setName(String name){

        if(isValidString(name)) {
            this.name = name;
        }
    }
}
