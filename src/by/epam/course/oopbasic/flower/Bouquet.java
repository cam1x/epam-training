package by.epam.course.oopbasic.flower;

import java.util.*;

/*
    Класс для представления букета(коллекции цветов)
    Возможности:
    1) добавление того или иного вида цветка
    2) удаление того или иного вида цветка
    3) сортировка букета
    4) получение общей стоимость
    5) получение числа цветков того или иного типа
    6) вывод на консоль
    7) изменение упаковки
 */

public class Bouquet {

    private ArrayList<Flower> flowers=new ArrayList<Flower>();
    private FlowerFactory factory=new FlowerFactory();
    private Packaging packaging=new Packaging();

    public Bouquet(){

    }

    public Bouquet(String packagingColor){

        packaging.setColor(packagingColor);
    }

    public void changePackaging(String color){

        packaging.setColor(color);
    }

    public void addRandomFlower(int num){

        while(num-->0) {
            Random random = new Random();
            FlowerTypes type = FlowerTypes.values()[random.nextInt(FlowerTypes.values().length)];
            flowers.add(factory.getFlower(type));
        }
    }

    public void addRose(int num,String color,double price){

        while(num-->0){
            flowers.add(factory.getFlower(FlowerTypes.ROSE,color,price));
        }
    }

    public void addLily(int num,String color,double price){

        while(num-->0){
            flowers.add(factory.getFlower(FlowerTypes.LILY,color,price));
        }
    }

    public void addTulip(int num,String color,double price){

        while(num-->0){
            flowers.add(factory.getFlower(FlowerTypes.TULIP,color,price));
        }
    }

    public void removeAllRoses(){

        for(Flower flower:flowers){
            if(flower.getName().equals("роза")){
                flowers.remove(flower);
            }
        }
    }

    public void removeRoses(int num){

        if(num>0 && num <=getNumOfRoses()){
            for(int i=0;num>0 && i<flowers.size();i++){
                if(flowers.get(i).getName().equals("роза")){
                    flowers.remove(i);
                    num--;
                }
            }
        }
    }

    public void removeAllLily(){

        for(Flower flower:flowers){
            if(flower.getName().equals("лилия")){
                flowers.remove(flower);
            }
        }
    }

    public void removeLily(int num) {

        if (num > 0 && num <= getNumOfLily()) {
            for (int i = 0; num > 0 && i < flowers.size(); i++) {
                if (flowers.get(i).getName().equals("лилия")) {
                    flowers.remove(i);
                    num--;
                }
            }
        }
    }

    public void removeAllTulip(){

        for(Flower flower: flowers){
            if(flower.getName().equals("тюльпан")){
                flowers.remove(flower);
            }
        }
    }

    public void removeTulip(int num) {

        if (num > 0 && num <= getNumOfTulip()) {
            for (int i = 0; num > 0 && i < flowers.size(); i++) {
                if (flowers.get(i).getName().equals("тюльпан")) {
                    flowers.remove(i);
                    num--;
                }
            }
        }
    }

    public int getNumOfRoses(){

        int num=0;

        for(Flower flower:flowers){
            if(flower.getName().equals("роза")){
                num++;
            }
        }

        return num;
    }

    public int getNumOfLily(){

        int num=0;

        for(Flower flower:flowers){
            if(flower.getName().equals("лилия")){
                num++;
            }
        }

        return num;
    }

    public int getNumOfTulip(){

        int num=0;

        for(Flower flower:flowers){
            if(flower.getName().equals("тюльпан")){
                num++;
            }
        }

        return num;
    }

    public double getTotalPrice(){

        double price=0;

        for(Flower flower:flowers){
            price+=flower.getPrice();
        }

        return (double)Math.round(price*100d)/100d;
    }

    public int getNumOfFlowers(){

        return flowers.size();
    }

    public void sort(){

        Comparator<Flower> comparator=Comparator.comparing(Flower::getPrice);
        comparator.thenComparing(Flower::getName);
        comparator.thenComparing(Flower::getColor);

        flowers.sort(comparator);
    }

    public void show(){

        System.out.println("Стоимость букета: "+getTotalPrice());
        System.out.println(String.format("%15s %16s %10s","Тип","Цвет","Цена"));
        System.out.println(toString());
    }

    @Override
    public String toString(){

        String string=new String();

        for(int i=0;i<flowers.size();i++){
            string+=(i+1)+flowers.get(i).toString()+"\n";
        }

        string+=packaging.toString();

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

        Bouquet other=(Bouquet) obj;

        boolean isEqual=(flowers.size()==other.flowers.size()) && packaging.equals(other.packaging);

        for(int i=0;isEqual && i<flowers.size();i++){
            if(!flowers.get(i).equals(other.flowers.get(i))){
                isEqual=false;
            }
        }

        return isEqual;
    }

    @Override
    public int hashCode(){

        final int prime=31;
        int result=1;

        result=prime*result+packaging.hashCode();
        result=prime*result+flowers.hashCode();

        return result;
    }
}
