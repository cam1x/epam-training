package by.epam.course.oopbasic.present;

/*
    Класс для представления шоколада
 */

public class Chocolate extends MySweet implements Sweet {
    public Chocolate() {
        super();
        super.setName("шоколад");
    }

    public Chocolate(double weight, double price) {
        super("шоколад", weight, price);
    }
}
