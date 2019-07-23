package by.epam.course.oopbasic.flower;

/*
    Класс для представления розы
 */

public class Rose extends MyFlower implements Flower {

    public Rose(){

        super();
        super.setName("роза");
    }

    public Rose(String color,double price){

        super("роза",color,price);
    }

}
