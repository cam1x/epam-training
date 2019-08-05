package by.epam.course.application.archive.user;

/*
    Класс для авторизации пользователей
    В случае введения верного пароля, авторизируется как админ
    В противном случае - как обычный пользовватель
    Пароль может быть изменен только авторизированным админом
 */

public class UserFactory {

    private static String password="12344321";

    public User getUser(String parole, String login){
        if(password.equals(parole)){
            return new Administrator(login,parole);
        }else{
            return new User(login,parole);
        }
    }

    public static void changePassword(String oldPassword,String newPassword){
        if(oldPassword.equals(password) && newPassword!=null && !newPassword.isEmpty()){
            password=newPassword;
        }
    }
}
