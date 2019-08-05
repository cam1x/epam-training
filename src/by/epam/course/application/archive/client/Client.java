package by.epam.course.application.archive.client;

import java.io.*;
import java.net.Socket;
import java.util.*;

public class Client {

    private static void write(BufferedWriter writer, String request){
        try {
            writer.write(request);
            writer.newLine();
            writer.flush();
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    //Меню запросов на сервер
    public static void menu(BufferedReader reader, BufferedWriter writer){
        Scanner scanner = new Scanner(System.in);
        String request;

        System.out.println("Введите логин и пароль для авторизации: ");
        request = 1 + ";" + scanner.next() + ";" + scanner.next();
        write(writer, request);

        try {
            int choice = 1;
            while (choice != 0) {

                do {
                    System.out.println(reader.readLine());
                }while (reader.ready());

                System.out.println("1-Авторизация");
                System.out.println("2-Просмотр архива");
                System.out.println("3-Поиск архивов факультета");
                System.out.println("4-Поиск архивов по курсу");
                System.out.println("5-Поиск архивов по году зачисления");
                System.out.println("--------------------АДМИН МЕНЮ-----------------");
                System.out.println("6-Добавить дело");
                System.out.println("7-Удалить дело");
                System.out.println("8-Удалить дела отчисленных и выпущенных студентов");
                System.out.println("9-Выбрать дело");
                System.out.println("10-Отсортировать дела");
                System.out.println("11-Изменить факультет");
                System.out.println("12-Увеличить курс студента");
                System.out.println("13-Изменить курс");
                System.out.println("14-Изменить пароль админ панели");
                choice = scanner.nextInt();
                switch (choice) {
                    case 1: {
                        System.out.println("Введите логин и пароль для авторизации: ");
                        request = 1 + ";" + scanner.next() + ";" + scanner.next();
                        write(writer, request);
                        break;
                    }

                    case 2: {
                        request = 2 + ";";
                        write(writer, request);
                        break;
                    }

                    case 3: {
                        System.out.println("Введите название факультета");
                        request = 3 + ";" + scanner.next();
                        write(writer, request);
                        break;
                    }

                    case 4: {
                        System.out.println("Введите курс для поиска");
                        request = 4 + ";" + scanner.nextInt();
                        write(writer, request);
                        break;
                    }

                    case 5: {
                        System.out.println("Введите год поступления");
                        request = 5 + ";" + scanner.nextInt();
                        write(writer, request);
                        break;
                    }

                    case 6: {
                        System.out.println("Введите имя студента, факультет, курс и год зачисдения");
                        request = 6 + ";" + scanner.next() + ";" + scanner.next() + ";" + scanner.nextInt() + ";" + scanner.nextInt();
                        write(writer, request);
                        break;
                    }

                    case 7: {
                        System.out.println("Введите номер дела для удаления");
                        request = 7 + ";" + scanner.nextInt();
                        write(writer, request);
                        break;
                    }

                    case 8: {
                        request = 8 + ";";
                        write(writer, request);
                        break;
                    }

                    case 9: {
                        System.out.println("Введите номер дела для выбора");
                        request = 8 + ";" + scanner.nextInt();
                        write(writer, request);
                        break;
                    }

                    case 10: {
                        request = 10 + ";";
                        write(writer, request);
                        break;
                    }

                    case 11: {
                        System.out.println("Введите новое название факультета");
                        request = 11 + ";" + scanner.next();
                        write(writer, request);
                        break;
                    }

                    case 12: {
                        request = 12 + ";";
                        write(writer, request);
                        break;
                    }

                    case 13: {
                        System.out.println("Введите номер курса");
                        request = 13 + ";" + scanner.nextInt();
                        write(writer, request);
                        break;
                    }

                    case 14:{
                        System.out.println("Введите старый, а затем через пробел новый пароль");
                        request=14+";"+scanner.next()+";"+scanner.next();
                        write(writer,request);
                        break;
                    }
                }
            }
        }catch (InputMismatchException e){
            throw new RuntimeException(e);
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        try(
                Socket socket=new Socket("127.0.0.1",8000);
                BufferedWriter writer=
                        new BufferedWriter(
                                new OutputStreamWriter(
                                        socket.getOutputStream()));
                BufferedReader reader=
                        new BufferedReader(
                                new InputStreamReader(
                                        socket.getInputStream()));
             ){
                while(socket.isConnected()) {
                    menu(reader, writer);
                }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
