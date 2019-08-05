package by.epam.course.application.notebook;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Pattern;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        String inputPath = "input.txt";
        String outputPath = "output.txt";
        Notebook notebook = new Notebook(outputPath);
        notebook.addFromFile(inputPath);

        Scanner scanner=new Scanner(System.in);
        scanner.useDelimiter("(\\s*);(\\s*)");

        System.out.println("\t\t\tВНИМАНИЕ!");
        System.out.println("После ввода каждого поля используйсте разделитель ;\n\n");

        try {
            int choice = 1;
            while (choice != 0) {
                System.out.println("Введите 0, чтобы завершить работу");
                System.out.println("Введите 1, чтобы добавить заметку");
                System.out.println("Введите 2, чтобы удалить заметку");
                System.out.println("Введите 3, чтобы найти заметку по теме");
                System.out.println("Введите 4, чтобы найти заметку по почте");
                System.out.println("Введите 5, чтобы найти заметку по сообщению");
                System.out.println("Введите 6, чтобы найти заметку по подстроке");
                System.out.println("Введите 7, чтобы найти заметку по теме и почте");
                System.out.println("Введите 8, чтобы отсортировать заметки");
                System.out.println("Введите 9, чтобы вывести на консоль все заметки");
                choice = scanner.nextInt();
                switch (choice) {
                    case 1: {
                        System.out.println("\nВведите тему, почту, текст сообщения, используя ; в качестве разделителя");
                        notebook.addNote(new Note(scanner.next(), scanner.next(), scanner.next()));
                        break;
                    }

                    case 2: {
                        System.out.println("\nВведите тему сообщения для удаления");
                        notebook.removeNote(scanner.next());
                        break;
                    }

                    case 3: {
                        System.out.println("\nВведите тему заметки для поиска");
                        List<Note> notes = notebook.findByTopic(scanner.next());
                        for (Note note : notes) {
                            note.print();
                        }
                        break;
                    }

                    case 4: {
                        System.out.println("\nВведите почту для поиска");
                        List<Note> notes = notebook.findByEmail(scanner.next());
                        for (Note note : notes) {
                            note.print();
                        }
                        break;
                    }

                    case 5: {
                        System.out.println("\nВведите сообщение заметки для поиска");
                        List<Note> notes = notebook.findByMessage(scanner.next());
                        for (Note note : notes) {
                            note.print();
                        }
                        break;
                    }

                    case 6: {
                        System.out.println("\nВведите подстроку заметки для поиска");
                        List<Note> notes = notebook.findBySubstring(scanner.next());
                        for (Note note : notes) {
                            note.print();
                        }
                        break;
                    }

                    case 7: {
                        System.out.println("\nВведите тему и почту заметки для поиска");
                        List<Note> notes = notebook.findByTopicAndEmail(scanner.next(), scanner.next());
                        for (Note note : notes) {
                            note.print();
                        }
                        break;
                    }

                    case 8: {
                        notebook.sort();
                        break;
                    }

                    case 9:{
                        notebook.print();
                        break;
                    }
                }
            }
        }catch (InputMismatchException ex){
            System.out.println("Ошибка ввода! Операция невозможна!");
        }
    }
}
