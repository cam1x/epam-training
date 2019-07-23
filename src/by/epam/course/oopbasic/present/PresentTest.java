package by.epam.course.oopbasic.present;

public class PresentTest {

    public static void main(String[] args) {
        Present present=new Present("желтый");//Создаем пустой подарок в желтой упаковке

        present.addRandomSweet(3);//Добавляем 3 упаковки случайных сладостей
        present.addChocholate(2,100, 5);//Добавляем 2 плитки шоколада по 100г, стоимостью 5р за штуку
        present.addCandy(3,70,7);//Добавляем 3 упаковки конфет по 70г, стоимостью 7р за упаковку
        present.addMarmalade(2,75,2.99);//Добавляем 2 упаковки мармелада по 75, стоимостью 2.99 за упаковку
        present.removeCandy(2);//Удаляем 2 упаковки конфет

        present.sort();
        present.show();

    }
}
