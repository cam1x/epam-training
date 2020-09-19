package by.epam.course.classprograming.student;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentTest {
    public static void input(StudentArray studentArray) {
        try {
            Student student;
            Scanner scanner = new Scanner(System.in);

            System.out.println("\nВведите информацию по шаблону:");
            System.out.println("Имя\t\tИнициалы\t\tНомер группы\t\tОценка1 Оценка2 Оценка3 Оценка4 Оценка5");
            for (int i = 0; i < studentArray.getSize(); i++) {
                student = studentArray.getStudent(i);
                student.setSurname(scanner.next().trim());
                student.setInitials(scanner.next().trim());
                student.setGroupNumber(scanner.nextInt());

                for (int j = 0; j < 5; j++) {
                    student.setMarks(scanner.nextInt(), j);
                }
            }

        } catch (InputMismatchException ex) {
            System.out.println("Ошибка ввода! " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите число студентов: ");
            int numOfStudents = scanner.nextInt();

            if (numOfStudents > 0) {
                StudentArray studentArray = new StudentArray(numOfStudents);

                input(studentArray);

                System.out.println("\nОтличники:");
                StudentArray honorPupils = studentArray.getHonorPupil();
                honorPupils.print();

            } else {
                System.out.println("\nЧисло студентов должно быть положительным!");
            }

        } catch (InputMismatchException ex) {
            System.out.println("Ошибка ввода! " + ex.getMessage());
        }
    }
}
