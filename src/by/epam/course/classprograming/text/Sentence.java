package by.epam.course.classprograming.text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/*
    Класс для представления предложения.
    Возможности:
    1) устновить предложение
    2) получить предложение
    3) вывод на консоль
    P.S.Обьект может "хранить" только одно предложение.
    При попытке инициализации строкой, состоящей более чем из одного предложения,
    обьект будет инициализирован лишь первым предложением.
 */

public class Sentence {
    private Word[] sentence;

    public Sentence() {
        sentence = new Word[1];
        sentence[0] = new Word();
    }

    public Sentence(String string) {
        setSentence(string);
    }

    private static String getFirstSentence(String string) {
        int indexOfStart = 0;
        int indexOfEnd = 0;

        Pattern sentence = Pattern.compile("[.!?]+[\"»]?(\\s\\-)?(\\s[A-ZА-Я]|\\r|$)");
        Matcher sentenceMatcher = sentence.matcher(string);

        if (sentenceMatcher.find()) {
            indexOfEnd = sentenceMatcher.start();
        } else {
            indexOfEnd = string.length() - 1;
        }

        return string.substring(indexOfStart, indexOfEnd + 1);
    }

    private static int getNumOfWords(String string) {
        if (string == null || string.isEmpty()) {
            return 0;
        }
        int numOfWords = 0;

        Pattern wordPat = Pattern.compile("\\b[A-Za-zА-Яа-я0-9]+?\\b[.!?,:;-]*");
        Matcher wordMatch = wordPat.matcher(string);

        while (wordMatch.find()) {
            numOfWords++;
        }

        return numOfWords;
    }

    public void setSentence(String string) {
        if (string != null && !string.isEmpty()) {
            string = getFirstSentence(string);
            sentence = new Word[getNumOfWords(string)];

            int index = 0;

            Pattern wordPat = Pattern.compile("\\b[A-Za-zА-Яа-я0-9]+?\\b[.!?,:;-]*");
            Matcher wordMatch = wordPat.matcher(string);

            while (wordMatch.find()) {
                sentence[index] = new Word(wordMatch.group());
                index++;
            }
        }
    }

    public String getSentences() {
        return toString();
    }

    public String getNthWord(int num) {
        if (num >= 0 && num < sentence.length) {
            return sentence[num].toString();
        } else {
            return " ";
        }
    }

    public int getNumOfWords() {
        return sentence.length;
    }

    public void print() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();

        for (Word word : sentence) {
            string.append(word.toString()).append(" ");
        }

        return string.toString().trim();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Sentence other = (Sentence) obj;

        boolean isEqual = true;

        for (int i = 0; i < getNumOfWords(); i++) {
            if (!sentence[i].equals(other.getWordsArray()[i])) {
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

        for (int i = 0; i < getNumOfWords(); i++) {
            result = prime * result + sentence[i].hashCode();
        }

        return result;
    }

    private Word[] getWordsArray() {
        return sentence;
    }
}
