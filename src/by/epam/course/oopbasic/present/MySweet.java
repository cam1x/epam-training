package by.epam.course.oopbasic.present;

interface Sweet {

    void setWeight(double weight);
    void setPrice(double price);
    double getWeight();
    String getName();
    double getPrice();
}

/*
    Класс для представления сладостей
    Возможности:
    1) изменение имени, веса, цены сладости
    2) получение имени, веса, цены сладости
    3) вывод на консоль
 */

public class MySweet implements Sweet {

    private String name="Красная шапочка";
    private double weight;
    private double price;

    public MySweet(){

        weight=500;
        price=15.89;
    }

    public MySweet(String name, double weight, double price){

        if(price>0 && weight>0 && isValidString(name)){
            this.name=name;
            this.weight=weight;
            this.price=price;
        }
    }

    public void setWeight(double weight){

        if(weight>0){
            this.weight=weight;
        }
    }

    public void setPrice(double price){

        if(price>0){
            this.price=price;
        }
    }

    public double getWeight(){

        return weight;
    }

    public String getName(){

        return name;
    }

    public double getPrice(){

        return price;
    }

    @Override
    public String toString(){

        return String.format("%15s %10s %10s",name,Double.toString(weight),Double.toString(price));
    }

    @Override
    public boolean equals(Object obj){

            if(obj == this){
                return true;
            }

            if(obj==null || obj.getClass() != this.getClass()){
                return false;
            }

            MySweet other=(MySweet)obj;

            return name.equals(other.name) && (price==other.price) && (weight==other.weight);
    }

    @Override
    public int hashCode(){

        final int prime=31;
        int result=1;
        result=prime*result+((name==null)?0:name.hashCode());
        result=prime*result+Double.hashCode(price);
        result=prime*result+Double.hashCode(weight);
        return result;
    }

    protected void setName(String name){

        if(isValidString(name)) {
            this.name = name;
        }
    }

    protected boolean isValidString(String string){

        return string!=null && !string.isEmpty();
    }
}

