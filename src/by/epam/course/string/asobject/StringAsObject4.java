package by.epam.course.string.asobject;

/*
    С помощью функция копирования и операции кокатенации
    составляет из слова "информатика" слово "торт"
 */

public class StringAsObject4 {
    public static void main(String[] args) {
        String word1 = "информатика";
        String word2;
        StringBuilder buff = new StringBuilder();

        char[] symbolsOfWord1 = word1.toCharArray();
        char symbolT = symbolsOfWord1[word1.indexOf('т')];
        char symbolO = symbolsOfWord1[word1.indexOf('о')];
        char symbolR = symbolsOfWord1[word1.indexOf('р')];

        word2 = buff.append(symbolT).append(symbolO).append(symbolR).append(symbolT).toString();

        System.out.println(word2);
    }
}
