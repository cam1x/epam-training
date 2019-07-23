package by.epam.course.oopbasic.treasure;

/*
    Класс для представления сокровища.
    Возможности:
    1) изменение имени, веса, цены сокровища
    2) получение имени, веса, цены сокровища
    3) выбор сокровища
    4) вывод на консоль
 */

public class Treasure {

    private String name="not defined";
    private double price;
    private double weight;
    private boolean isSelected;

    public Treasure(){

    }

    public Treasure(String name,double weight,double price){
        setName(name);
        setWeight(weight);
        setPrice(price);
    }

    public void setName(String name){
        if(name!=null && !name.isEmpty()) {
            this.name = name;
        }
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

    public void select(){
        isSelected=true;
    }

    public void unselect(){
        isSelected=false;
    }

    public double getPrice(){
        return price;
    }

    public double getWeight(){
        return weight;
    }

    public boolean isSelected(){
        return isSelected;
    }

    public String getName(){
        return name;
    }

    public void print(){
        System.out.println(toString());
    }

    @Override
    public String toString(){
        return String.format("%15s %10s %10s %10s",name,Double.toString(weight),Double.toString(price),(isSelected)?"выбрана":"");
    }

    @Override
    public boolean equals(Object obj){
        if(obj == this){
            return true;
        }

        if(obj==null || obj.getClass() != this.getClass()){
            return false;
        }

        Treasure other=(Treasure) obj;

        return price==other.price && weight==other.weight;
    }

    @Override
    public int hashCode(){
        final int prime=31;
        int result=1;

        result=prime*result+Double.hashCode(price);
        result=prime*result+Double.hashCode(weight);

        return result;
    }
}

