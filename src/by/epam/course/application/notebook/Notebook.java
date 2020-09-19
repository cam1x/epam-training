package by.epam.course.application.notebook;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
    Класс для представления блокнота
    Возможности:
    1) Добавление/удаление записки
    2) Загрузить содержимое из текстового файла
    3) Автоматическая "выгрузка" результатов в выходной файл
    4) Поиск заметки по различным параметрам
    5) Сортировка заметок
    6) Вывод на консоль
    P.S. Поиск заметок реализован с использованием
         регулярных выражений.
 */

public class Notebook {
    private final String defaultInputPath = "F:\\Проекты\\Java\\java_online\\src\\by\\epam\\course\\application\\notebook\\input.txt";
    private final String defaultOutputPath = "F:\\Проекты\\Java\\java_online\\src\\by\\epam\\course\\application\\notebook\\output.txt";

    private final List<Note> notes = new ArrayList<Note>();
    private File outputFile = new File(defaultOutputPath);
    private String afterOperation = "";/*Содержит рез-ты всех операций.
    Хранится для корректной перезаписи выхожного файла после удаления заметки*/

    public Notebook(String outputPath) {
        outputFile = new File(outputPath);
        createFile(outputFile);
    }

    public Notebook() {
        createFile(outputFile);
    }

    public void addNote(Note note) {
        if (note != null) {
            notes.add(note);
            addToFile(note.toString() + "\n\n");
        }
    }

    //Добавление заметок из входного файла
    public void addFromFile(String inputPath) {
        try {
            File inputFile = new File(inputPath);
            Scanner scanner = new Scanner(inputFile);
            try {
                scanner.useDelimiter("(\\s*);(\\s*)");
                while (scanner.hasNext()) {
                    addNote(new Note(scanner.next(), scanner.next(), scanner.next()));
                }
            } catch (InputMismatchException ex) {
                System.out.println("Ошибка ввода! У заметки отсутствует тема/почта/сообщение!");
            }
        } catch (IOException ex) {
            System.out.println("Ошибка! Файл не найден!");
        }
    }

    public void removeNote(Note note) {
        notes.remove(note);
        writeToFile();
    }

    //Удаление заметок по теме
    public void removeNote(String topic) {
        for (int i = 0; i < notes.size(); i++) {
            if (notes.get(i).getTopic().equals(topic)) {
                notes.remove(notes.get(i));
            }
        }
        writeToFile();
    }

    public void sort() {
        Comparator<Note> comparator = Comparator.comparing(Note::getTopic);
        comparator.thenComparing(Note::getMessage);
        notes.sort(comparator);
        afterOperation += "\n\tОтсортировано\n";
        addToFile("\n\tОтсортировано\n");
        for (Note note : notes) {
            afterOperation += note.toString() + "\n";
            addToFile(note.toString() + "\n");
        }
    }

    //Находит заметки, тема которых совпадает с topic
    public List<Note> findByTopic(String topic) {
        topic = topic.trim();
        List<Note> founded = new ArrayList<>();
        if (!topic.isEmpty()) {
            Pattern pattern = Pattern.compile("^\\Q" + topic + "\\E$");
            Matcher matcher;
            for (Note note : notes) {
                matcher = pattern.matcher(note.getTopic());
                if (matcher.find()) {
                    founded.add(note);
                }
            }
        }
        afterOperation += "\n\tРезультаты поиска по теме " + topic;
        addToFile("\n\tРезультаты поиска по теме " + topic);
        addResult(founded);
        return founded;
    }

    //Находит заметки, почта которых совпадает с email
    public List<Note> findByEmail(String email) {
        email = email.trim();
        List<Note> founded = new ArrayList<>();
        if (!email.isEmpty()) {
            Pattern pattern = Pattern.compile("^\\Q" + email + "\\E$");
            Matcher matcher;
            for (Note note : notes) {
                matcher = pattern.matcher(note.getEmail());
                if (matcher.find()) {
                    founded.add(note);
                }
            }
        }
        afterOperation += "\n\tРезультаты поиска по почте " + email;
        addToFile("\n\tРезультаты поиска по почте " + email);
        addResult(founded);
        return founded;
    }

    //Находит заметки, сообщение которых совпадает с message
    public List<Note> findByMessage(String message) {
        message = message.trim();
        List<Note> founded = new ArrayList<>();
        if (!message.isEmpty()) {
            Pattern pattern = Pattern.compile("^\\Q" + message + "\\E$");
            Matcher matcher;
            for (Note note : notes) {
                matcher = pattern.matcher(note.getMessage());
                if (matcher.find()) {
                    founded.add(note);
                }
            }
        }
        afterOperation += "\n\tРезультаты поиска по сообщению " + message;
        addToFile("\n\tРезультаты поиска по собщению " + message);
        addResult(founded);
        return founded;
    }

    //Находит заметки, тема и почта которых совпадает с topic и email соотв
    public List<Note> findByTopicAndEmail(String topic, String email) {
        topic = topic.trim();
        email = email.trim();
        List<Note> founded = new ArrayList<>();
        if (!topic.isEmpty()) {
            Pattern pattern = Pattern.compile("^\\Q" + topic + "\n" + email + "\\E$");
            Matcher matcher;
            for (Note note : notes) {
                matcher = pattern.matcher(note.getTopic() + "\n" + note.getEmail());
                if (matcher.find()) {
                    founded.add(note);
                }
            }
        }
        afterOperation += "\n\tРезультаты поиска по теме " + topic + " и почте " + email;
        addToFile("\n\tРезультаты поиска по теме " + topic + " и почте " + email);
        addResult(founded);
        return founded;
    }

    //Находит заметки, текст сообщения которых содержит substring
    public List<Note> findBySubstring(String substring) {
        List<Note> founded = new ArrayList<>();
        if (substring != null && !substring.isEmpty()) {
            Pattern pattern = Pattern.compile("\\Q" + substring + "\\E");
            Matcher matcher;
            for (Note note : notes) {
                matcher = pattern.matcher(note.getMessage());
                if (matcher.find()) {
                    founded.add(note);
                }
            }
        }
        afterOperation += "\n\tРезультаты поиска по подстроке " + substring;
        addToFile("\n\tРезультаты поиска по подстроке " + substring);
        addResult(founded);
        return founded;
    }

    public void print() {
        if (notes.size() > 0) {
            for (Note note : notes) {
                System.out.println(note);
            }
        }
    }

    @Override
    public String toString() {
        if (notes.size() > 0) {
            StringBuilder string = new StringBuilder();
            for (Note note : notes) {
                string.append(note.toString()).append("\n");
            }
            return string.toString();
        } else {
            return "No notes found!";
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Notebook other = (Notebook) obj;

        boolean isEqual = (notes.size() == other.notes.size());

        for (int i = 0; isEqual && i < notes.size(); i++) {
            if (!notes.get(i).equals(other.notes.get(i))) {
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
        result = prime * result + notes.hashCode();
        return result;
    }

    //Дозаписывает часть каталога в конец файл
    private void addToFile(String content) {
        try {
            FileWriter writer = new FileWriter(outputFile, true);
            writer.write(content);
            writer.flush();
            writer.close();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //Перезапись всего каталога в файл
    private void writeToFile() {
        if (notes.size() > 0) {
            try {
                FileWriter writer = new FileWriter(outputFile);
                for (Note note : notes) {
                    writer.write(note.toString() + "\n");
                }
                writer.write(afterOperation);
                writer.flush();
                writer.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    //Создает файл по ук. пути, если он отсутствует
    private boolean createFile(File file) {
        if (!file.exists()) {
            try {
                return file.createNewFile();
            } catch (IOException ex) {
                return false;
            }
        } else {
            cleanFile();
            return false;
        }
    }

    //Очистка данных в файле по заданному пути
    private void cleanFile() {
        try {
            FileWriter cleaner = new FileWriter(outputFile);
            cleaner.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void addResult(List<Note> founded) {
        if (founded.size() > 0) {
            afterOperation += "\n";
            addToFile("\n");
            for (Note note : founded) {
                afterOperation += note.toString() + "\n";
                addToFile(note.toString() + "\n");
            }
        } else {
            afterOperation += "\nНе найдено\n";
            addToFile("\nНе найдено\n");
        }
    }
}
