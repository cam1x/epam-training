package by.epam.course.application.accounting.user;

import by.epam.course.application.accounting.book.Book;
import java.util.*;

/*
    Класс для представления администратора
    Доп возможности:
    1) Модернизация каталога
    (добавление/удаление/изменение описания)
    2) Добавление рекомендованных книг
    3) Изменение пароля к админ панели
 */

public class Administrator extends User {

    protected Administrator(String login,String password){
        super(login,password);
    }

    public void changePassword(String oldPassword,String newPassword){
        UserFactory.changePassword(oldPassword, newPassword);
    }

    public void addBook(Book book){
        catalog.addBook(book);
    }

    public void addBook(String author,String name,int pages){
        catalog.addBook(author, name, pages);
    }

    public void addElectronicBook(String author,String name,int pages,String resourse){
        catalog.addElectronicBook(author, name, pages, resourse);
    }

    public void removeBook(Book book){
        catalog.removeBook(book);
    }

    public void removeAll(Book book){
        catalog.removeAll(book);
    }

    public void setDescription(int bookNum,String description){
        catalog.setDescription(bookNum, description);
    }

    @Override
    public void checkMail(){
        if(adminEmail!=null && !adminEmail.isEmpty() && !adminEmail.equals(" ")){
            Scanner scanner=new Scanner(adminEmail);
            try{
                addBook(scanner.next(),scanner.next(),scanner.nextInt());
                System.out.println("Предложенные пользователями книги добавлены в каталог");
                adminEmail=" ";
            }catch (InputMismatchException ex){
                System.out.println("На почте содержался спам!");
            }
        }
    }

    @Override
    public boolean isAdmin(){
        return true;
    }
}
