package by.epam.course.string.regex;

import java.io.*;
import java.util.regex.*;
import java.util.Scanner;

/*
Приложение позволяет:

Анализировать узлы XML документа и типизировать их.

P.S Текстовые файлы с входными и выходными данными прилагаются
P.S.S Путь к входному и выходному файлам можно изменить в main()
 */

public class RegEx2 {

    //Запись текста из файла в одну строку
    public static String readInString(String path)throws FileNotFoundException {
        File file=new File(path);
        Scanner scanner=new Scanner(file);

        String string=new String();

        while(scanner.hasNext()){
            string+=scanner.nextLine()+"\r\n";
        }
        scanner.close();

        return string;
    }

    public static void readInFile(String string,String path) throws IOException {
        File file = new File(path);

        if(!file.exists() || file.isDirectory()) {
            // Создание файла
            file.createNewFile();
        }

        // Создание объекта FileWriter
        FileWriter writer = new FileWriter(file,true);

        // Запись содержимого в файл
        writer.write(string);
        writer.flush();
        writer.close();
    }

    //Очистка данных в файле по заданному пути
    public static void cleanFile(String path)throws IOException{
        FileWriter cleaner=new FileWriter(path);
        cleaner.close();
    }

    //Получить закрывающий тег по "названию" тега
    public static String getClosingTag(String tag){
        if (tag == null || tag.isEmpty()) {
            return "";
        }

        Pattern wordPat=Pattern.compile("\\b[a-zA-ZА-Яа-я]+?\\b");
        Matcher wordMatch=wordPat.matcher(tag);

        if(wordMatch.find()){
            return "</"+wordMatch.group()+">";
        }else{
            return " ";
        }
    }

    //Число открывающих тегов в строке
    public static int getNumOfOpeningTags(String string){
        int num=0;
        Pattern openingTagPat= Pattern.compile("<[^/!].+?>");
        Matcher openingTagMathcer=openingTagPat.matcher(string);

        while(openingTagMathcer.find()){
            num++;
        }

        return num;
    }

    //Число закрывающих тегов в строке
    public static int getNumOfClosingTags(String string){
        int num=0;
        Pattern closingTagPat= Pattern.compile("</.+?>");
        Matcher closingTagMathcer=closingTagPat.matcher(string);

        while(closingTagMathcer.find()){
            num++;
        }

        return num;
    }

    //Проверяет равно ли число откр тегов числу закр тегов
    public static boolean isRightNumberOfTags(String document){
        return getNumOfOpeningTags(document)==getNumOfClosingTags(document);
    }

    /*
    Алгоритм анализа XML-документа:
    1) сравнивается число открывающих и закрывающих тегов во всем документе. Если не равно, то анализ окончен
    2) находится очередной открывающий тег в документе
    3) поиск закрывающиего тего, соответствующего найденному тегу. Если закр. тег не найден, то анализ окончен
    4) в содержимом узла, ограниченном найденными откр и закр тегами, сравнивается число открывающих и закрывающих тегов.Если не равно, то анализ окончен.
    5) вывод полученных данных (узел, откр и закр теги, содержимое тега) в документ, путь которого передан в функцию
    6) если рассмотренный открывающи тег не был последним, то выполнить 2)-5), в противном случае анализ окончен.
     */
    public static void analyzeXML(String document,String outputPath)throws IOException {
        Pattern openingTagPat = Pattern.compile("<[^/!].+?>");
        Matcher openingTagMatсher = openingTagPat.matcher(document);

        String openingTag;
        String closingTag;
        String bodyOfTag;

        int startOfOpening;
        int endOfClosing;
        int numOfNode = 1;

        cleanFile(outputPath);

        //Проверка на равенство числа открывающихся и закрывающихся тегов во всем документе
        if(getNumOfOpeningTags(document)==getNumOfClosingTags(document)) {

            while (openingTagMatсher.find()) {
                //Очередной найденный открывающий тег и соответствуюший ему закрывающий тег
                openingTag = openingTagMatсher.group();
                closingTag = getClosingTag(openingTag);

                startOfOpening = document.indexOf(openingTag);
                endOfClosing = document.indexOf(closingTag);

                //Закрывающий тег не найден в строке
                if (endOfClosing != -1) {
                    endOfClosing += closingTag.length();

                    readInFile("\t\tУзел №" + numOfNode + ": \n", outputPath);
                    readInFile(document.substring(startOfOpening, endOfClosing), outputPath);

                    //Получение индекса первого элмента содержимого тега
                    startOfOpening += openingTag.length();
                    while (document.charAt(startOfOpening) == ' ' || document.charAt(startOfOpening) == '\r' || document.charAt(startOfOpening) == '\n') {
                        startOfOpening++;
                    }

                    //Получение индекса последнего элмента содержимого тега
                    endOfClosing -= closingTag.length() + 1;
                    while (document.charAt(endOfClosing) == ' ' || document.charAt(endOfClosing) == '\r' || document.charAt(endOfClosing) == '\n') {
                        endOfClosing--;
                    }

                    bodyOfTag = document.substring(startOfOpening, endOfClosing + 1);

                    //Проверка на равенство числа открывающихся и закрывающихся тегов в содержимом тега
                    if(isRightNumberOfTags(bodyOfTag)) {
                        readInFile("\nОткрывающий тег: " + openingTag, outputPath);

                        if (bodyOfTag.isEmpty()) {
                            readInFile("\nТег без тела.", outputPath);
                        } else {
                            readInFile("\nСодержимое тега:" + bodyOfTag, outputPath);
                        }

                        readInFile("\nЗакрывающий тег: " + closingTag+"\n\n", outputPath);
                        numOfNode++;

                    }else{
                        cleanFile(outputPath);
                        readInFile("Ошибка! Нарушена вложенность тегов!",outputPath);
                        break;
                    }

                }else{
                    cleanFile(outputPath);
                    readInFile("Ошибка! Не найден закрывающий тег "+closingTag+" !",outputPath);
                    break;
                }
            }
        }else{
            cleanFile(outputPath);
            readInFile("Ошибка! Количество открывающих тегов не равна количетсву закрывающих тегов!",outputPath);
        }
    }

    public static void main(String[] args){
        String line=new String();
        Scanner scanner=new Scanner(System.in);

        String inputPath= "F:\\Проекты\\Java\\java_online\\src\\by\\epam\\course\\string\\regex\\reg2_text";
        String outputPath="F:\\Проекты\\Java\\java_online\\src\\by\\epam\\course\\string\\regex\\ResultOfReg2.txt";

        try {
            cleanFile(outputPath);
        } catch (IOException ex){
            System.out.println("Неверный путь выходного файла!"+ex.getMessage());
        }

        int choice=1;

        while (choice!=0){
            System.out.println("Введите 0 для выхода из меню.");
            System.out.println("Введите 1 для чтения XML-документа из текстового файла.");
            System.out.println("Введите 2 для анализа XML-документа и автоматической выгрузки результатов в текстовый файл.");
            System.out.println("Введите 3 для вывода результата анализа в консоль.");
            System.out.println();

            choice=scanner.nextInt();
            switch (choice){
                case 1:{
                    try {
                        line = readInString(inputPath);
                    } catch (FileNotFoundException ex){
                        System.out.println("Неверный путь входного файла!"+ex.getMessage());
                    }
                    break;
                }

                case 2: {
                    try {
                        analyzeXML(line, outputPath);
                    } catch (IOException ex){
                        System.out.println("Неверный путь выходного файла!"+ex.getMessage());
                    }
                    break;
                }

                case 3:{
                    try {
                        System.out.println(readInString(outputPath));
                    } catch (FileNotFoundException ex){
                        System.out.println("Неверный путь выходного файла!"+ex.getMessage());
                    }
                    break;
                }
            }
        }
    }
}
