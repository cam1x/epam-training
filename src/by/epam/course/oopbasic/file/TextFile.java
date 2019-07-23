package by.epam.course.oopbasic.file;

import java.io.*;

/*
    Класс для представления текстового файла
    Доп возможности:
    1) запись в файл
    2) чтение из файла и вывод на консоль
 */

public class TextFile extends MyFile {

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

        try {
            FileWriter writer = new FileWriter(getFile(), true);
            writer.write("\n"+line);
            writer.flush();
            writer.close();

        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    /*
    Возвращает содержимое файла
     */
    public String getContent() {

      StringBuilder sb=new StringBuilder();
      try(BufferedReader br =new BufferedReader(new InputStreamReader(new FileInputStream(toString()),"UTF-8"))) {

          String currentLine;

          while((currentLine=br.readLine())!=null){

              sb.append(currentLine);
              sb.append("\n");
          }
      }catch (IOException ex){

      }

      return sb.toString();
    }

    public void printContent(){

        System.out.println(getContent());
    }
}
