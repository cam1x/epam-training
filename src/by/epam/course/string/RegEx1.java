package by.epam.course.string;

import java.io.*;
import java.util.regex.*;
import java.util.Scanner;

/*
Приложение позволяет:
1) Считать текст из файла в строку
2) Отсортировать абзацы по кол-у предложений в них
3) Отсортировать слова в каждом предложении по длине
4) Отсортировать слова в преложении по числу вхождений введенного символа ( в случае равенства вхождений - по алфавиту)
5) Записать результат в выходной файл

P.S Текстовые файлы с входными и выходными данными прилагаются
P.S.S Путь к входному и выходному файлам можно изменить в main()
 */

public class RegEx1 {
    //Запись текста из файла в одну строку
    public static String readInString(String path)throws FileNotFoundException{

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

        // Создание файла
        file.createNewFile();

        // Создание объекта FileWriter
        FileWriter writer = new FileWriter(file);

        // Запись содержимого в файл
        writer.write(string);
        writer.flush();
        writer.close();
    }

    //Возвращает число абазей
    public static int getNumOfBasics(String string){

        int numOfBasics=0;

        Pattern basic=Pattern.compile("\\r\\n$",Pattern.MULTILINE);
        Matcher basicMathcer=basic.matcher(string);

        while (basicMathcer.find()){
            numOfBasics++;
        }

        return numOfBasics;
    }

    //Получить н-ый абзац по индексу
    public static String getNthBasic(String string,final int NUM){

        int indexOfStart=0;
        int indexOfEnd=0;

        if(NUM>getNumOfBasics(string)||string ==" "||NUM<0){
            return "";
        }else {
            if(NUM==0){
                indexOfStart=0;
            }else {
                int num = NUM;
                while (num != 0) {
                    indexOfStart = string.indexOf("\r\n\r\n", indexOfStart + 1);
                    num--;
                }
                while (string.charAt(indexOfStart) == '\r' || string.charAt(indexOfStart) == '\n') {
                    indexOfStart++;
                }
            }

            indexOfEnd = string.indexOf("\r\n\r\n", indexOfStart + 1);

            if(indexOfEnd!=-1) {
                while (string.charAt(indexOfEnd) == '\r' || string.charAt(indexOfEnd) == '\n') {
                    indexOfEnd--;
                }
            }else{
                indexOfEnd=string.length()-1;
            }

            return string.substring(indexOfStart, indexOfEnd + 1);
        }
    }

    //Сортирует абзацы по числу предложений
    public static String sortBasics(String string){

        int numOfBasics=getNumOfBasics(string);

        StringBuilder buffString=new StringBuilder(string);

        String basic1;
        String basic2;
        int index;

        for(int i=0;i<numOfBasics-1;i++){
            for(int j=0;j<numOfBasics-i-1;j++){

                basic1=getNthBasic(buffString.toString(),j);
                basic2=getNthBasic(buffString.toString(),j+1);

                if(getNumOfSentences(basic1)>getNumOfSentences(basic2)){
                    index=buffString.indexOf(basic1);
                    buffString.replace(index,index+basic1.length(),basic2);

                    index=buffString.lastIndexOf(basic2);
                    buffString.replace(index,index+basic2.length(),basic1);
                }
            }
        }

        return buffString.toString();
    }

    //Считает кол-во предложений в тексте
    public static int getNumOfSentences(String string){

        int numOfSentences=0;

        string=string.trim();

        Pattern sentence=Pattern.compile("[.!?]+[\"»]?(\\s\\-)?(\\s[A-ZА-Я]|\\r|$)");
        Matcher sentenceMatcher=sentence.matcher(string);

        while(sentenceMatcher.find()){
            numOfSentences++;
        }

        return numOfSentences;
    }

    //Получить н-ое предложение по индексу в тексте
    public static String getNthSentence(String string,final int NUM){

        int indexOfStart=0;
        int indexOfEnd=0;

        if(NUM>=getNumOfSentences(string)||string.isEmpty()||NUM<0) {
            return "";
        }else{
            Pattern sentence=Pattern.compile("[.!?]+[\"»]?(\\s\\-)?(\\s[A-ZА-Я]|\\r|$)");
            Matcher sentenceMatcher=sentence.matcher(string);
            if(NUM==0){
                indexOfStart=0;
            }else {
                int num = NUM;
                while (num != 0 && sentenceMatcher.find()) {
                    indexOfStart = sentenceMatcher.start();
                    num--;
                }

                boolean wrongSymbol=string.charAt(indexOfStart)=='.'||string.charAt(indexOfStart)=='\r'||string.charAt(indexOfStart)=='\n'
                        || string.charAt(indexOfStart)=='!'|| string.charAt(indexOfStart)=='?' || string.charAt(indexOfStart)==';';

                while(indexOfStart<string.length()&& wrongSymbol) {
                    indexOfStart++;
                    wrongSymbol=string.charAt(indexOfStart)=='.'||string.charAt(indexOfStart)=='\r'||string.charAt(indexOfStart)=='\n'
                            || string.charAt(indexOfStart)=='!'|| string.charAt(indexOfStart)=='?' || string.charAt(indexOfStart)==';';
                }
            }

            if(sentenceMatcher.find()){
                indexOfEnd=sentenceMatcher.start();
            }else{
                indexOfEnd=string.length()-1;
            }
        }

        return string.substring(indexOfStart,indexOfEnd+1);
    }

    public static int getNumOfWords(String string){

      if (string == null || string.isEmpty()) {
          return 0;
      }

      int numOfWords=0;

      Pattern wordPat=Pattern.compile("\\b[a-zA-ZА-Яа-я]+?\\b");
      Matcher wordMatch=wordPat.matcher(string);

      while(wordMatch.find()){
          numOfWords++;
      }

      return numOfWords;
    }

    //Получить н-ое слово по индексу в предложении
    public static String getNthWord(String string,final int NUM){

        if (string == null || string.isEmpty()) {
            return "";
        }

        int num=NUM+1;

        Pattern wordPat=Pattern.compile("\\b[a-zA-ZА-Яа-я]+?\\b");
        Matcher wordMatch=wordPat.matcher(string);

        while(num!=0 && wordMatch.find()){
            num--;
        }

        return wordMatch.group();
    }

    //Сортировка слов в каждом предложении по длине
    public static String sortSentences(String string){

        int numOfSentences=getNumOfSentences(string);
        int numOfWords;
        String sentence;
        String word1;
        String word2;
        int index;

        StringBuilder buffSentence;
        String buffString=new String(string);

        for(int i=0;i<numOfSentences;i++){
            sentence=getNthSentence(string,i);
            numOfWords=getNumOfWords(sentence);
            buffSentence=new StringBuilder(sentence);

            for(int j=0;j<numOfWords-1;j++){
                for(int k=0;k<numOfWords-j-1;k++){
                    word1=getNthWord(buffSentence.toString(),k);
                    word2=getNthWord(buffSentence.toString(),k+1);
                    if(word1.length()>word2.length()){
                        buffSentence=swapWordsInStringBuilder(buffSentence,k,k+1);
                    }
                }
            }
            buffString=buffString.replace(sentence,buffSentence);
        }

        return buffString;
    }

    //Сортировка слов в каждом предложении по длине
    public static String sortSentences(String string,char symbol){

        int numOfSentences=getNumOfSentences(string);
        int numOfWords;
        String sentence;
        String word1;
        String word2;
        int index;

        StringBuilder buffSentence;
        String buffString=new String(string);

        for(int i=0;i<numOfSentences;i++){
            sentence=getNthSentence(string,i);
            numOfWords=getNumOfWords(sentence);
            buffSentence=new StringBuilder(sentence);

            for(int j=0;j<numOfWords-1;j++){
                for(int k=0;k<numOfWords-j-1;k++){
                    word1=getNthWord(buffSentence.toString(),k);
                    word2=getNthWord(buffSentence.toString(),k+1);

                    if(countNumOfSymbols(word1,symbol) > countNumOfSymbols(word2,symbol)){
                        buffSentence=swapWordsInStringBuilder(buffSentence,k,k+1);
                    }else{
                        if(countNumOfSymbols(word1,symbol) == countNumOfSymbols(word2,symbol)){
                            if(word1.compareTo(word2)>0){
                                buffSentence=swapWordsInStringBuilder(buffSentence,k,k+1);
                            }
                        }
                    }
                }
            }

            buffString=buffString.replace(sentence,buffSentence);
        }

        return buffString;
    }

    //Получить индекс первого символо слова с индексом NUM
    public static int getIndexOfWord(String string,final int NUM){
        int indexOfStart=0;

        if(NUM>=getNumOfWords(string) || NUM<0 || string.isEmpty()){
            return -1;
        }
        else{
            Pattern wordPat=Pattern.compile("\\b[a-zA-ZА-Яа-я]+?\\b");
            Matcher wordMatch=wordPat.matcher(string);
            int num=NUM+1;

            while(num!=0 && wordMatch.find()){
                indexOfStart=wordMatch.start();
                num--;
            }
        }

        return indexOfStart;
    }

    //Поменять местами два слова по их индексам
    public static StringBuilder swapWordsInStringBuilder(StringBuilder buffSentence,int index1,int index2){
        int index;
        String word1=getNthWord(buffSentence.toString(),index1);
        String word2=getNthWord(buffSentence.toString(),index2);

        index=getIndexOfWord(buffSentence.toString(),index1);
        if(word1.length()==1 && index+word1.length()+1<buffSentence.length()){
            char buff=buffSentence.charAt(index+1);

            buffSentence.replace(index,index+1+word1.length(),word2);
            buffSentence.insert(index+word2.length(),buff);
        }else {
            buffSentence.replace(index, index + word1.length(), word2);
        }

        index=getIndexOfWord(buffSentence.toString(),index2);
        if(word2.length()==1&& index+word2.length()+1<buffSentence.length()){
            char buff=buffSentence.charAt(index+1);
            buffSentence.replace(index,index+1+word2.length(),word1);
            buffSentence.insert(index+word1.length(),buff);
        }else {
            buffSentence.replace(index, index + word2.length(), word1);
        }

        return buffSentence;
    }

    //Считает сколько раз символ встречается в слове
    public static int countNumOfSymbols(String string,char symbol){

        int num=0;
        for(int i=0;i<string.length();i++){
            if(string.charAt(i)==symbol){
                num++;
            }
        }

        return num;
    }

    public static void main(String[] args){

        String line=new String();
        Scanner scanner=new Scanner(System.in);

        String inputPath= "reg1_text";
        String outputPath="ResultOfReg1.txt";

        int choice=1;

        while (choice!=0){
            System.out.println("Введите 0 для выхода из меню.");
            System.out.println("Введите 1 для чтения текста из текстового файла.");
            System.out.println("Введите 2 для вывода текста.");
            System.out.println("Введите 3 для сортировки абзацев.");
            System.out.println("Введите 4 для сортировки слов в предложениях по длине.");
            System.out.println("Введите 5 для сортировки слов в предложениях по числу вхождений введенного символа.");
            System.out.println("Введите 6 для записи измененного текста в файл.");
            System.out.println();

            choice=scanner.nextInt();
            switch (choice){
                case 1:{
                    try {
                        line = readInString(inputPath);
                    }catch (FileNotFoundException ex){
                        System.out.println("Неверный путь входного файла!"+ex.getMessage());
                    }
                    break;
                }

                case 2:{
                    System.out.println(line+"\n");
                    break;
                }

                case 3:{
                    line=sortBasics(line);
                    break;
                }

                case 4:{
                    line=sortSentences(line);
                    break;
                }

                case 5:{
                    System.out.println("\nВведите символ:");
                    char symbol=scanner.next().charAt(0);
                    line=sortSentences(line,symbol);
                    break;
                }

                case 6:{
                    try {
                        readInFile(line, outputPath);
                    } catch (IOException ex){
                        System.out.println("Неверный путь выходного файла!"+ex.getMessage());
                    }
                    break;
                }
            }
        }
    }
}
