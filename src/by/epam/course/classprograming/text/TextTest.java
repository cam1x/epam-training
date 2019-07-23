package by.epam.course.classprograming.text;

public class TextTest {

    public static void main(String[] args){
        Text text=new Text("Новый текст","Этот текст лишен какого либо-смысла. Единственная цель-продемонстрировать работоспособность класса. Последнее предложение?");
        text.print();

        System.out.println("\n");
        text.setHeader("Измененный текст");
        text.addText("Магия склейки! Данная подстрока добавлена после 2-го предложения.",2);
        text.print();
    }
}
