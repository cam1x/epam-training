package by.epam.course.oopbasic.flower;

public class BouquetTest {

    public static void main(String[] args) {
       Bouquet bouquet=new Bouquet();

       bouquet.addRandomFlower(3);//Добавляем 3 цветка случайного типа
        bouquet.addLily(2,"бордовый",9.46);//Добавляем 2 бордовые лилии
        bouquet.addTulip(3,"фиолетовый",11.15);//Добавляем 3 фиолетовых тюльпана
        bouquet.addRose(4,"красный",7.99);//Добавляем 4 красные розы
        bouquet.removeRoses(3);//Удаляем 3 розы из букета
        bouquet.sort();//Сортируем букет

        bouquet.changePackaging("желтый");//Выбираем желтую упаковку
        bouquet.show();//Показываем готовый букет
    }
}
