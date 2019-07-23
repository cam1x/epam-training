package by.epam.course.oopbasic.flower;

/*
    Класс для представления тюльпана
 */

public class Tulip extends MyFlower implements Flower {

    public Tulip(){
        super();
        super.setName("тюльпан");
    }

    public Tulip(String color,double price){
        super("тюльпан",color,price);
    }
}
