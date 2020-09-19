package by.epam.course.oopbasic.present;

/*
    Класс для представления мармелада
 */

public class Marmalade extends MySweet implements Sweet {
    public Marmalade() {
        super();
        super.setName("мармелад");
    }

    public Marmalade(double weight, double price) {
        super("мармелад", weight, price);
    }
}
