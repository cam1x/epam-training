package by.epam.course.oopbasic.present;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

/*
    Класс для представления подарка.
    Возможности:
    1) добавление сладости различными способомами
    2) удаление сладости различными способомами
    3) изменение упаковки
    4) получение числа сладостей того или иного типа
    5) получение общей стоимости/веса
    6) сортировка
    7) вывод на консоль
 */

public class Present {
    private final ArrayList<Sweet> sweets = new ArrayList<Sweet>();
    private final SweetFactory factory = new SweetFactory();
    private final Packaging packaging = new Packaging();

    public Present() {

    }

    public Present(String packagingColor) {
        packaging.setColor(packagingColor);
    }

    public void changePackaging(String color) {
        packaging.setColor(color);
    }

    public void addRandomSweet(int num) {
        while (num-- > 0) {
            Random random = new Random();
            SweetTypes type = SweetTypes.values()[random.nextInt(SweetTypes.values().length)];
            sweets.add(factory.getSweet(type));
        }
    }

    public void addCandy(int num, double weight, double price) {
        while (num-- > 0) {
            sweets.add(factory.getSweet(SweetTypes.CANDY, weight, price));
        }
    }

    public void addChocholate(int num, double weight, double price) {
        while (num-- > 0) {
            sweets.add(factory.getSweet(SweetTypes.CHOCOLATE, weight, price));
        }
    }

    public void addMarmalade(int num, double weight, double price) {
        while (num-- > 0) {
            sweets.add(factory.getSweet(SweetTypes.MARMALADE, weight, price));
        }
    }

    public void removeAllCandy() {
        sweets.removeIf(sweet -> sweet.getName().equals("конфета"));
    }

    public void removeCandy(int num) {
        if (num > 0 && num <= getNumOfCandy()) {
            for (int i = 0; num > 0 && i < sweets.size(); i++) {
                if (sweets.get(i).getName().equals("конфета")) {
                    sweets.remove(i);
                    num--;
                }
            }
        }
    }

    public void removeAllChocolate() {
        sweets.removeIf(sweet -> sweet.getName().equals("шоколад"));
    }

    public void removeChocolate(int num) {
        if (num > 0 && num <= getNumOfChocolade()) {
            for (int i = 0; num > 0 && i < sweets.size(); i++) {
                if (sweets.get(i).getName().equals("шоколад")) {
                    sweets.remove(i);
                    num--;
                }
            }
        }
    }

    public void removeAllMarmalade() {
        sweets.removeIf(sweet -> sweet.getName().equals("мармелад"));
    }

    public void removeMarmalade(int num) {
        if (num > 0 && num <= getNumOfMarmalade()) {
            for (int i = 0; num > 0 && i < sweets.size(); i++) {
                if (sweets.get(i).getName().equals("мармелад")) {
                    sweets.remove(i);
                    num--;
                }
            }
        }
    }

    public int getNumOfCandy() {
        int num = 0;
        for (Sweet sweet : sweets) {
            if (sweet.getName().equals("конфета")) {
                num++;
            }
        }

        return num;
    }

    public int getNumOfChocolade() {
        int num = 0;

        for (Sweet sweet : sweets) {
            if (sweet.getName().equals("шоколад")) {
                num++;
            }
        }

        return num;
    }

    public int getNumOfMarmalade() {
        int num = 0;

        for (Sweet sweet : sweets) {
            if (sweet.getName().equals("мармелад")) {
                num++;
            }
        }

        return num;
    }

    public double getTotalPrice() {
        double price = 0;

        for (Sweet sweet : sweets) {
            price += sweet.getPrice();
        }

        return (double) Math.round(price * 100d) / 100d;
    }

    public double getTotalWeight() {
        double weight = 0;

        for (Sweet sweet : sweets) {
            weight += sweet.getWeight();
        }

        return (double) Math.round(weight * 100d) / 100d;
    }

    public int getNumOfSweets() {
        return sweets.size();
    }

    public void sort() {
        Comparator<Sweet> comparator = Comparator.comparing(Sweet::getPrice);
        comparator.thenComparing(Sweet::getWeight);
        comparator.thenComparing(Sweet::getName);
        sweets.sort(comparator);
    }

    public void show() {
        System.out.println("Вес содержимого: " + getTotalWeight());
        System.out.println("Стоимость подарка без наценки: " + getTotalPrice());
        System.out.println(String.format("%15s %11s %10s", "Тип", "Вес", "Цена"));
        System.out.println(toString());
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();

        for (int i = 0; i < sweets.size(); i++) {
            string.append(i + 1).append(sweets.get(i).toString()).append("\n");
        }

        string.append(packaging.toString());

        return string.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Present other = (Present) obj;

        boolean isEqual = (sweets.size() == other.sweets.size()) && packaging.equals(other.packaging);

        for (int i = 0; isEqual && i < sweets.size(); i++) {
            if (!sweets.get(i).equals(other.sweets.get(i))) {
                isEqual = false;
                break;
            }
        }

        return isEqual;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + packaging.hashCode();
        result = prime * result + sweets.hashCode();

        return result;
    }
}
