package by.epam.course.oopbasic.fileabstract;

public class FileTest {

    public static void main(String[] args) {
        TextFile file=new TextFile();

        file.setDirectory("F:\\Проекты");
        file.rename("new file");

        file.create();

        file.addToFile("Some words in new file...");

        file.printContent();

        System.out.println("File directory + file name  "+ file);

        file.rename("renamed");

        System.out.println("\nAfter renaming:");
        System.out.println("File directory + file name  "+ file);

        file.delete();
    }
}
