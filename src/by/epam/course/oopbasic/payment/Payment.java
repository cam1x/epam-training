package by.epam.course.oopbasic.payment;

import java.util.*;

/*
    Класс для представления платежа(коллекция продуктов)
    Возможности:
    1) добавление/удаление продукта
    2) сортировка продуктов по различным параметрам
    3) получение общей цены/веса
    4) печать чека на консоль
 */

public class Payment {

    private ArrayList<Product> products=new ArrayList<Product>();

    public Payment(){

    }

    public Payment(int num){

        for(int i=0;i<num;i++){
            products.add(new Product());
        }
    }

    public void addProduct(String name,double weight,double price){

        products.add(new Product(name,weight,price));
    }

    public void setProduct(int index,String name,double weight,double price){

        if(index>=0 && price <products.size()) {
            products.set(index, new Product(name, weight, price));
        }
    }

    public void deleteProduct(int index){

        if(index>=0 && index<products.size()){
            products.remove(index);
        }
    }

    public void deleteProduct(String name,double weight,double price){

        products.remove(new Product(name,weight,price));
    }

    public void sortByPrice(){

        Comparator<Product> comparator=Comparator.comparing(Product::getPrice);
        comparator=comparator.thenComparing(Product::getName);
        comparator=comparator.thenComparing(Product::getWeight);
        products.sort(comparator);
    }

    public void sortByWeight(){

        Comparator<Product> comparator=Comparator.comparing(Product::getWeight);
        comparator=comparator.thenComparing(Product::getPrice);
        comparator=comparator.thenComparing(Product::getName);
        products.sort(comparator);
    }

    public void sortByName(){

        products.sort(new Comparator<Product>(){

            @Override
            public int compare(Product p1,Product p2){

                return p1.getName().compareTo(p2.getName());
            }
        });
    }

    public double getTotalPrice(){

        double price=0;

        for(Product product:products){
            price+=product.getPrice();
        }

        return (double)Math.round(price*100d)/100d;
    }

    public double getTotalWeight(){

        double weight=0;

        for(Product product:products){
            weight+=product.getWeight();
        }

        return (double)Math.round(weight*100d)/100d;
    }

    public void print(){

        System.out.println("\n Общая сумма = "+getTotalPrice());
        System.out.println(" Общий вес = "+getTotalWeight()+"\n");
        System.out.println(toString());
    }

    @Override
    public String toString(){

        String string=new String();

        for(int i=0;i<products.size();i++){
            string+=(i+1)+products.get(i).toString()+"\n";
        }

        return string;
    }

    @Override
    public boolean equals(Object obj){

        if(obj == this){
            return true;
        }

        if(obj==null || obj.getClass() != this.getClass()){
            return false;
        }

        Payment other=(Payment) obj;

        boolean isEqual=true;

        for(int i=0;i<products.size();i++){
            if(!products.get(i).equals(other.products.get(i))){
                isEqual=false;
                break;
            }
        }

        return isEqual;
    }

    @Override
    public int hashCode(){

        final int prime=31;
        int result=1;

        for(Product product:products){
            result=prime*result+product.hashCode();
        }

        return result;
    }
}
