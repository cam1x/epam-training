package by.epam.course.oopbasic.flower;

/*
    Класс для представлении лилии
 */

public class Lily extends MyFlower implements Flower {

    public Lily(){
        super();
        super.setName("лилия");
    }

    public Lily(String color,double price){
        super("лилия",color,price);
    }

}
