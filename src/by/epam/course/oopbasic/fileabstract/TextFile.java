package by.epam.course.oopbasic.fileabstract;


/*
    Класс для представления текстового файла
    Доп возможности:
    1) запись в файл
    2) чтение из файла и вывод на консоль
 */

public class TextFile extends MyFile {

    private String content=new String();

    public TextFile(){

        super();
        super.setExpansion("txt");
    }

    public TextFile(String path,String fileName){

        super(path, fileName,"txt");
        //super.setExpansion("txt");
    }

    @Override
    public void setExpansion(String expansion){
        //Метод ничего не делает
    }

    /*
    Добавляет line к файлу, не переписовая его
     */
    public void addToFile(String line){

        if(isExists()) {
            content += line + "\n";
        }
    }

    /*
    Возвращает содержимое файла
     */
    public String getContent() {

        return content;
    }

    public void printContent(){

        System.out.println(getContent());
    }
}