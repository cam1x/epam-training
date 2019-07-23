package by.epam.course.oopbasic.payment;


/*
    Класс для представления продукта.
    Возможности:
    1) изменение имени, веса, цены продукта
    2) получение имени, веса, цены продукта
    3) вывод на консоль
 */

public class Product {

    private double price;
    private double weight;
    private String name;

    public Product(){

        name="not defined";
    }

    public Product(String name,double weight,double price){

        setName(name);
        setWeight(weight);
        setPrice(price);
    }

    public void setPrice(double price){

        if(price>0){
            this.price=price;
        }
    }

    public void setWeight(double weight){

        if(weight>0){
            this.weight=weight;
        }
    }

    public void setName(String name){

        if(name!=null && !name.isEmpty()) {
            this.name = name;
        }
    }

    public double getPrice(){

        return price;
    }

    public double getWeight(){

        return weight;
    }

    public String getName(){

        return name;
    }

    public void print(){

        System.out.println(toString());
    }

    @Override
    public String toString(){

        return String.format("%20s %10s %10s",name,Double.toString(weight),Double.toString(price));
    }

    @Override
    public boolean equals(Object obj){

        if(obj == this){
            return true;
        }

        if(obj==null || obj.getClass() != this.getClass()){
            return false;
        }

        Product other=(Product) obj;

        return name.equals(other.name) && weight==other.weight && price==other.price;
    }

    @Override
    public int hashCode(){

        final int prime=31;
        int result=1;

        result=prime*result+((name==null)?0:name.hashCode());
        result=prime*result+Double.hashCode(weight);
        result=prime*result+Double.hashCode(price);

        return result;
    }
}
