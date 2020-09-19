package by.epam.course.application.accounting.book;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
    Класс для представления эл. книги
    Доп возможности:
    1) добавление адреса размещения книги
    (допускается только полный адрес)
    2) получение адреса сайта
 */

public class ElectronicBook extends Book {
    private String resource = "http://elib.bsu.by/";

    public ElectronicBook(String author, String name, int pages) {
        super(author, name, pages);
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        Pattern urlPattern = Pattern.compile("^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]");
        Matcher urlMatcher = urlPattern.matcher(resource);
        if (urlMatcher.find()) {
            this.resource = resource;
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\t" + resource;
    }
}
