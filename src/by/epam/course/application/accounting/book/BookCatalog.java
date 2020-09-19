package by.epam.course.application.accounting.book;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*
       Класс для представления каталога книг
       Возможности:
       1) добавление книги в каталог
       2) удаление книги из каталога
       3) поиск книги
       4) поиск всех книг автора
       5) вывод на консоль текущей/любой страницы каталога
       6) изменение/получения книги на странице каталога
       7) дублирование каталога в текстовый файл, по указанному пути
       (если по пути отсутствует файл, то он будет создан автоматически)
 */

public class BookCatalog {
    private static int page = 1;//общее число страниц
    private static int currPage = 1;//текущая страница
    private final String defaultPath = "F:\\Проекты\\Java\\java_online\\src\\by\\epam\\course\\application\\accounting\\book\\Catalog.txt";
    private final Map<Integer, List<Book>> catalog = new HashMap<Integer, List<Book>>();
    private final File file;//выходной файл

    public BookCatalog() {
        file = new File(defaultPath);
        createFile();
    }

    public BookCatalog(String pathToFile) {
        if (pathToFile != null && !pathToFile.isEmpty()) {
            file = new File(pathToFile);
        } else {
            file = new File(defaultPath);
        }
        createFile();
    }

    public void addBook(Book book) {
        if (book != null) {
            if (!catalog.containsKey(page)) {
                catalog.put(page, new ArrayList<Book>());
                catalog.get(page).add(book);
            } else {
                if (catalog.get(page).size() > 9) {
                    page++;
                    catalog.put(page, new ArrayList<Book>());
                }
                catalog.get(page).add(book);
            }
            currPage = page;
            addToFile(book.toString() + "\n");
        }
    }

    public void addBook(String author, String name, int pages) {
        addBook(new Book(author, name, pages));
    }

    public void addElectronicBook(String author, String name, int pages, String resourse) {
        ElectronicBook eBook = new ElectronicBook(author, name, pages);
        eBook.setResource(resourse);
        addBook(eBook);
    }

    //Удаление не больше, чем одного экз переданной книги
    public void removeBook(Book book) {
        int removePage = -1;
        for (Integer i : catalog.keySet()) {
            if (catalog.get(i).contains(book)) {
                removePage = i;
                break;
            }
        }
        if (removePage != -1) {
            currPage = removePage;
            catalog.get(removePage).remove(book);
            while (catalog.containsKey(removePage + 1)) {
                catalog.get(removePage).add(catalog.get(removePage + 1).get(0));
                catalog.get(removePage + 1).remove(0);
                removePage++;
            }
            writeToFile();
        }
    }

    //Удаление всех книг в каталоге, соввпавших с переданной
    public void removeAll(Book book) {
        for (Integer i : catalog.keySet()) {
            while (catalog.get(i).contains(book)) {
                removeBook(book);
            }
        }
    }

    //Поиск книг автора в каталоге
    public List<Book> findBook(String author) {
        List<Book> authorsBooks = new ArrayList<Book>();
        if (catalog.size() > 0) {
            for (Integer i : catalog.keySet()) {
                for (Book book : catalog.get(i)) {
                    if (book.getAuthor().equals(author)) {
                        authorsBooks.add(book);
                    }
                }
            }
        }
        return authorsBooks;
    }

    //Поиск книг в каталоге
    public List<Book> findBook(Book findingBook) {
        List<Book> books = new ArrayList<Book>();
        if (catalog.size() > 0) {
            for (Integer i : catalog.keySet()) {
                for (Book book : catalog.get(i)) {
                    if (book.equals(findingBook)) {
                        books.add(book);
                    }
                }
            }
        }
        return books;
    }

    //Изменить описание n-ой книги на текущей стр каталога
    public void setDescription(int bookNum, String description) {
        if (catalog.size() > 0 && bookNum > 0 && bookNum <= catalog.get(currPage).size()) {
            catalog.get(currPage).get(bookNum - 1).addDescription(description);
        }
    }

    //Получить описание n-ой книги на текущей стр каталога
    public String getDescription(int bookNum) {
        if (catalog.size() > 0 && bookNum > 0 && bookNum <= catalog.get(currPage).size()) {
            return catalog.get(currPage).get(bookNum - 1).getDescription();
        } else {
            return "Wrong book number!";
        }
    }

    //Получить n-ую книгу на текущей стр каталога
    public Book getNthBook(int bookNum) {
        if (catalog.size() > 0 && bookNum > 0 && bookNum <= catalog.get(currPage).size()) {
            return catalog.get(currPage).get(bookNum - 1);
        } else {
            return null;
        }
    }

    //Печать указанной стр каталога
    public void print(int page) {
        if (catalog.containsKey(page)) {
            System.out.println("--------------------------" + page + "---------------------------");
            for (int i = 0; i < catalog.get(page).size(); i++) {
                System.out.println((i + 1) + "\t\t" + catalog.get(page).get(i).toString());
            }
            System.out.println("--------------------------" + page + "---------------------------");
        }
    }

    //Печать текущей стр каталога
    public void print() {
        print(currPage);
    }

    //Дозаписывает часть каталога в конец файл
    private void addToFile(String content) {
        try {
            FileWriter writer = new FileWriter(file, true);
            writer.write(content);
            writer.flush();
            writer.close();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //Перезапись всего каталога в файл
    private void writeToFile() {
        try {
            FileWriter writer = new FileWriter(file);
            for (Integer i : catalog.keySet()) {
                for (Book book : catalog.get(i)) {
                    writer.write(book.toString() + "\n");
                }
            }
            writer.flush();
            writer.close();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //Создает файл по ук. пути, если он отсутствует
    private boolean createFile() {
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
            FileWriter cleaner = new FileWriter(file);
            cleaner.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
