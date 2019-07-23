package by.epam.course.classprograming.text;

import java.util.Scanner;
import java.util.regex.*;


/*
 Класс для представления текста.
    Возможности:
    1) устновить предложение
    2) получить предложение
    3) дополнить текст
    4) изменить заголовок текста
    5) вывод на консоль
 */

public class Text {

    private String header;
    private Sentence[] text;

    public Text(){

        header="Header";
        text=new Sentence[1];
        text[0]=new Sentence();
    }

    public Text(String header,String text){

        setText(header, text);
    }

    public void setText(String text){

        if(text!=null && !text.isEmpty()) {
            int numOfSentences = getNumOfSentences(text);
            this.text = new Sentence[numOfSentences];

            for (int i = 0; i < numOfSentences; i++) {
                this.text[i] = new Sentence(getNthSentence(text, i));
            }
        }
    }

    public void setText(String header,String text){

        setHeader(header);
        setText(text);
    }

    public void setHeader(String header){

        if(header!=null && !header.isEmpty()) {
            this.header = header;
        }
    }

    public int getNumOfSentences(){

        return text.length;
    }

    public String getHeader(){

        return header;
    }

    public String getText(){

        String string=new String();

        for(Sentence sentence:text){
            string+=sentence.toString()+" ";
        }

        return string;
    }

    //Добавляет подстроку после предложения с номером position (по индексу position в исходный текст, нумерация с 0)
    public void addText(String text,int position){

        if(position>=0 && position<getNumOfSentences()) {
            int numOfExtraSentences = getNumOfSentences(text);
            Sentence[] extraSentences = new Sentence[numOfExtraSentences];

            for (int i = 0; i < numOfExtraSentences; i++) {
                extraSentences[i] = new Sentence(getNthSentence(text, i));
            }


            Sentence[] newText = new Sentence[getNumOfSentences() + numOfExtraSentences];
            int index = 0;

            for (; index < position; index++) {
                newText[index] = this.text[index];
            }

            for (int j = 0; j < numOfExtraSentences; j++, index++) {
                newText[index] = extraSentences[j];
            }

            for(int i=position;i<getNumOfSentences();i++,index++){
                newText[index]=this.text[i];
            }

            this.text = newText;
        }
    }

    public void print(){

        System.out.println(toString());
    }

    public String readInString(String string){

        Scanner scanner=new Scanner(System.in);

        scanner.useDelimiter("\\n");

        string+=scanner.next();

        return string;
    }

    @Override
    public String toString(){

        String string=new String();
        string+="\t\t\t"+header+"\n";

        for(int i=0;i<getNumOfSentences();i++){
            string+=text[i]+" ";
        }

        return string;
    }

    @Override
    public boolean equals(Object obj){

        if(obj == this){
            return true;
        }

        if(obj==null || obj.getClass() != this.getClass()){
            return false;
        }

        Text other=(Text) obj;

        boolean isEqual=true;

        for(int i=0;i<getNumOfSentences();i++){
            if(!text[i].equals(other.text[i])){
                isEqual=false;
                break;
            }
        }

        return isEqual;
    }

    @Override
    public int hashCode(){

        final int prime=31;
        int result=1;

        for(int i=0;i<getNumOfSentences();i++){
            result=prime*result+text[i].hashCode();
        }

        return result;
    }

    private static int getNumOfSentences(String string){

        int numOfSentences=0;

        string=string.trim();

        Pattern sentence=Pattern.compile("[.!?]+[\"»]?(\\s\\-)?(\\s[A-ZА-Я]|\\r|$)");
        Matcher sentenceMatcher=sentence.matcher(string);

        while(sentenceMatcher.find()){
            String s=sentenceMatcher.group();
            numOfSentences++;
        }

        return numOfSentences;
    }

    //Получить н-ое предложение по индексу в тексте
    private static String getNthSentence(String string,final int NUM){

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
}
