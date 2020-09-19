package by.epam.course.application.accounting.user;

import by.epam.course.application.accounting.book.Book;
import by.epam.course.application.accounting.book.ElectronicBook;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class AccountingBooks {

    private static UserFactory factory = new UserFactory();
    private final String defaultPath = "F:\\Проекты\\Java\\java_online\\src\\by\\epam\\course\\application\\accounting\\user\\Users.txt";
    private final List<User> users = new ArrayList<User>();
    private final File file;//выходной файл для логов пользователей

    public AccountingBooks() {
        file = new File(defaultPath);
        createFile();
    }

    public AccountingBooks(String pathToFile) {
        if (pathToFile != null && !pathToFile.isEmpty()) {
            file = new File(pathToFile);
        } else {
            file = new File(defaultPath);
        }
        createFile();
    }

    //Решгистрация пользователя
    public void addUser(String login, String password) {
        if (isValidLogin(login)) {
            User toAdd = factory.getUser(password, login);
            users.add(toAdd);
            addToFile(toAdd.toString() + "\n");
        }
    }

    //Авторизация уже зарегестрированного пользователя
    public boolean login(String login, String password) {
        if (!isValidLogin(login)) {
            int index = 0;
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getLogin().equals(login)) {
                    index = i;
                    break;
                }
            }
            if (password.equals(users.get(index).getPassword())) {
                users.add(users.size(), users.get(index));
                users.remove(index);
                return true;
            } else {
                System.out.println("Введен неверный пароль!");
                return false;
            }
        } else {
            System.out.println("Пользователь " + login + " не найден!");
            return false;
        }
    }

    public void removeUser(User user) {
        users.remove(user);
        writeToFile();
    }

    public void menu() {
        int choice = 1;
        Scanner scanner = new Scanner(System.in);
        try {
            while (choice != 0) {
                System.out.println("Введите 0, чтобы выйти из приложения");
                System.out.println("Введите 1, чтобы залогиниться");
                System.out.println("Введите 2, чтобы зарегистрироваться в каталоге");
                choice = scanner.nextInt();

                if (choice == 1 || choice == 2) {
                    boolean isLogged = false;

                    while (!isLogged) {
                        switch (choice) {
                            case 1 -> {
                                System.out.println("\nВведите логин и пароль:");
                                isLogged = login(scanner.next(), scanner.next());
                            }
                            case 2 -> {
                                System.out.println("\nВведите логин и пароль:");
                                addUser(scanner.next(), scanner.next());
                                isLogged = true;
                            }
                        }

                    }

                    if (users.get(users.size() - 1).isAdmin()) {
                        adminMenu();
                    } else {
                        deffoltUserMenu();
                    }
                }
            }
        } catch (InputMismatchException ex) {
            System.out.println("Ошибка ввода! Операция невозможна!");
            menu();
        }
    }

    //Панель обычного пользователя
    private void deffoltUserMenu() {
        int choice = 1;
        Scanner scanner = new Scanner(System.in);
        try {
            while (choice != 0) {
                System.out.println("Введите 0, чтобы выйти");
                System.out.println("Введите 3, чтобы получить список книг текущей страницы");
                System.out.println("Введите 4, чтобы получить список книг на определенной странице");
                System.out.println("Введите 5, чтобы найти книгу");
                System.out.println("Введите 6, чтобы найти все книги автора");
                System.out.println("Введите 7, чтобы проверить почту");
                System.out.println("Введите 8, чтобы порекомендовать книгу");
                System.out.println("Введите 9, чтобы получить описание книги");
                choice = scanner.nextInt();
                switch (choice) {
                    case 3 -> users.get(users.size() - 1).print();
                    case 4 -> {
                        System.out.println("\nВведите номер страницы:");
                        users.get(users.size() - 1).print(scanner.nextInt());
                    }
                    case 5 -> {
                        System.out.println("\nВведите автора, название книги, число страниц (через пробел)");
                        users.get(users.size() - 1).findBook(new Book(scanner.next(), scanner.next(), scanner.nextInt()));
                    }
                    case 6 -> {
                        System.out.println("\nВведите автора");
                        users.get(users.size() - 1).findBook(scanner.next());
                    }
                    case 7 -> {
                        users.get(users.size() - 1).checkMail();
                    }
                    case 8 -> {
                        System.out.println("\nВведите автора, название книги, число страниц (через пробел)");
                        users.get(users.size() - 1).adviceAdmin(scanner.next() + " " + scanner.next() + " " + scanner.nextInt());
                    }
                    case 9 -> {
                        System.out.println("\nВведите порядковый номер книги на текущей странице");
                        users.get(users.size() - 1).getDescription(scanner.nextInt());
                    }
                }
            }
        } catch (InputMismatchException ex) {
            System.out.println("Ошибка ввода! Операция невозможна!");
            deffoltUserMenu();
        }
    }

    //Админ панель
    private void adminMenu() {
        int choice = 1;
        Scanner scanner = new Scanner(System.in);
        try {
            while (choice != 0) {
                System.out.println("Введите 0, чтобы выйти");
                System.out.println("Введите 3, чтобы получить список книг текущей страницы");
                System.out.println("Введите 4, чтобы получить список книг на определенной странице");
                System.out.println("Введите 5, чтобы найти книгу");
                System.out.println("Введите 6, чтобы найти все книги автора");
                System.out.println("Введите 7, чтобы получить описание книги");
                System.out.println("Введите 8, чтобы добавить книгу");
                System.out.println("Введите 9, чтобы добавить электронную книгу");
                System.out.println("Введите 10, чтобы удалить книгу");
                System.out.println("Введите 11, чтобы ответить на рекоммендации пользователей");
                System.out.println("Введите 12, чтобы изменить пароль от админ панели");
                System.out.println("Введите 13, чтобы изменить описание");
                choice = scanner.nextInt();
                switch (choice) {
                    case 3: {
                        users.get(users.size() - 1).print();
                        break;
                    }

                    case 4: {
                        System.out.println("\nВведите номер страницы:");
                        users.get(users.size() - 1).print(scanner.nextInt());
                        break;
                    }

                    case 5: {
                        System.out.println("\nВведите автора, название книги, число страниц (через пробел)");
                        users.get(users.size() - 1).findBook(new Book(scanner.next(), scanner.next(), scanner.nextInt()));
                        break;
                    }

                    case 6: {
                        System.out.println("\nВведите автора");
                        users.get(users.size() - 1).findBook(scanner.next());
                        break;
                    }

                    case 7: {
                        System.out.println("\nВведите порядковый номер книги на текущей странице");
                        users.get(users.size() - 1).getDescription(scanner.nextInt());
                        break;
                    }

                    case 8: {
                        System.out.println("\nВведите автора, название книги, число страниц (через пробел)");
                        Book book = new Book(scanner.next(), scanner.next(), scanner.nextInt());
                        ((Administrator) users.get(users.size() - 1)).addBook(book);
                        messageAllUsers(book.toString() + "\t\tДобавлена в каталог\n");
                        break;
                    }

                    case 9: {
                        System.out.println("\nВведите автора, название книги, число страниц, полный адрес сайта (через пробел)");
                        ElectronicBook ebook = new ElectronicBook(scanner.next(), scanner.next(), scanner.nextInt());
                        ebook.setResource(scanner.next());
                        ((Administrator) users.get(users.size() - 1)).addBook(ebook);
                        messageAllUsers(ebook.toString() + "\t\tДобавлена в каталог\n");
                        break;
                    }

                    case 10: {
                        System.out.println("\nВведите автора, название книги, число страниц (через пробел)");
                        ((Administrator) users.get(users.size() - 1)).removeAll(new Book(scanner.next(), scanner.next(), scanner.nextInt()));
                        break;
                    }

                    case 11: {
                        users.get(users.size() - 1).checkMail();
                        break;
                    }

                    case 12: {
                        System.out.println("\nВведите старый пароль, а псоле новый(через пробел)");
                        ((Administrator) users.get(users.size() - 1)).changePassword(scanner.next(), scanner.next());
                        break;
                    }

                    case 13: {
                        System.out.println("\nВведите порядковый номер книги на текущей странице и описание");
                        int num = scanner.nextInt();
                        ((Administrator) users.get(users.size() - 1)).setDescription(num, scanner.next());
                        Book book = users.get(users.size() - 1).getNthBook(num);
                        if (book != null) {
                            messageAllUsers(book.toString() + "\t\tИзменено описание\n");
                        }
                        break;
                    }
                }
            }
        } catch (InputMismatchException ex) {
            System.out.println("Ошибка ввода! Операция невозможна!");
            adminMenu();
        }
    }

    //Оповестить всех пользователей
    private void messageAllUsers(String string) {
        for (User user : users) {
            if (!user.isAdmin()) {
                user.addMessage(string);
            }
        }
    }

    //Проверка на существования пользователя в системе
    private boolean isValidLogin(String login) {
        boolean isInvalid = true;
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                isInvalid = false;
                break;
            }
        }
        return isInvalid;
    }

    //Дозапись в конец файла
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

    //Перезапись всех пользователей
    private void writeToFile() {
        try {
            FileWriter writer = new FileWriter(file);
            for (User user : users) {
                writer.write(user.toString() + "\n");
            }
            writer.flush();
            writer.close();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //Создание файла по пути, если он отсутствует
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
