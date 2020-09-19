package by.epam.course.application.accounting.user;

import by.epam.course.application.accounting.book.Book;
import by.epam.course.application.accounting.book.BookCatalog;

import java.util.List;

/*
    Класс для представления пользователя
    Возможности:
    1) Поиск книги
    2) Поиск всех книг автора
    3) Просмотр каталога
    4) Рекоммендация книги на добавление
    5) Проверка почты на изменения в каталоге
    6) Получение описания книг
 */

public class User {
    protected static BookCatalog catalog = new BookCatalog();
    protected static String adminEmail = " ";//почта администратора
    private String login = "New user";
    private String password;
    private String email = " ";//почта пользователя

    protected User(String login, String password) {
        setLogin(login);
        if (password != null && !password.isEmpty()) {
            this.password = password;
        }
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        if (login != null && !login.isEmpty()) {
            this.login = login;
        }
    }

    public List<Book> findBook(Book book) {
        return catalog.findBook(book);
    }

    public List<Book> findBook(String author) {
        return catalog.findBook(author);
    }

    public boolean isAdmin() {
        return false;
    }

    public void print(int page) {
        catalog.print(page);
    }

    public void print() {
        catalog.print();
    }

    public void checkMail() {
        if (email != null && !email.isEmpty() && !email.equals(" ")) {
            System.out.println(email);
            email = " ";
        } else {
            System.out.println("\nНовых оповещений нет!");
        }
    }

    public void adviceAdmin(String advice) {
        if (advice != null && !advice.isEmpty()) {
            adminEmail += advice;
        }
    }

    public String getDescription(int bookNum) {
        return catalog.getDescription(bookNum);
    }

    public Book getNthBook(int bookNum) {
        return catalog.getNthBook(bookNum);
    }

    @Override
    public String toString() {
        return String.format("%20s %15s %15s", login, encryptPassword(), (isAdmin()) ? "Аdmin" : "User");
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        User other = (User) obj;

        return login.equals(other.login) && isAdmin() == other.isAdmin();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((login == null) ? 0 : login.hashCode());
        result = prime * result + Boolean.hashCode(isAdmin());
        return result;
    }

    protected void addMessage(String message) {
        if (message != null && !message.isEmpty()) {
            email += message;
        }
    }

    protected String getPassword() {
        return password;
    }

    private String encryptPassword() {
        String string = "";
        for (int i = 0; i < password.length(); i++) {
            string += "*";
        }
        return string;
    }
}
