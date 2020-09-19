package by.epam.course.classprograming.text;

/*
    Класс для представления слова.
    Возможности:
    1) устновить слово
    2) получить слово
    3) вывод на консоль
 */

public class Word {
    private String word;

    public Word() {
        word = "Word";
    }

    public Word(String word) {
        setWord(word);
    }

    public String getWord() {
        return word;
    }

    //Если передана строка, состоящая более чем из одного слова, то поле будет инициализировано первым словом
    public void setWord(String word) {
        if (word != null && !word.isEmpty()) {
            if (word.contains(" ")) {
                this.word = word.substring(0, word.indexOf(" ")).trim();
            } else {
                this.word = word.trim();
            }
        }
    }

    public int getLength() {
        return word.length();
    }

    public void print() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return word;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Word other = (Word) obj;

        return this.word.equals(other.getWord());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + ((word == null) ? 0 : word.hashCode());

        return result;
    }
}
