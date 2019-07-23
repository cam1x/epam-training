package by.epam.course.classprograming.book;

import java.util.*;

public class BookTest {

    public static void input(BookArray bookArray){
        try{
            Scanner scanner=new Scanner(System.in);

            Book book;
            System.out.println("\nВведите информацию по шаблону (разделитель обязателен):");
            System.out.println("Допустимые типы переплетов: "+ Arrays.toString(Binding.values()));
            System.out.println("\nНазвание книги;\tАвтор;\tИздательстов;\tГод издательства;\tЧисло страниц;\tЦена;\tТип переплета;");

            scanner.useDelimiter(";");
            for(int i=0;i<bookArray.getSize();i++) {
                book=bookArray.getBook(i);

                book.setName(scanner.next().trim());
                book.setAuthor(scanner.next().trim());
                book.setPublishingHouse(scanner.next().trim());
                book.setYearOfPublishing(Integer.parseInt(scanner.next().trim()));
                book.setNumberOfPages(Integer.parseInt(scanner.next().trim()));
                book.setPrice(Integer.parseInt(scanner.next().trim()));
                book.setBindingType(Binding.valueOf(scanner.next().trim().toUpperCase()));
            }

        }catch(Exception ex){
            System.out.println("\nОшибка ввода! "+ex.getMessage());
        }
    }

    public static void main(String[] args){
        try{
            Scanner scanner=new Scanner(System.in);

            scanner.useDelimiter(";");
            System.out.println("Внимание! После каждого ввода необходимо ставить ;");
            System.out.println("Введите число книг:");

            int num=scanner.nextInt();

            if(num>0) {
                BookArray bookArray = new BookArray(num);

                input(bookArray);

                System.out.println("\nВведите автора для поиска книг:");
                BookArray bookOfAuthor = bookArray.getBooksOfAuthor(scanner.next().trim());
                bookOfAuthor.print();

                System.out.println("\nВведите назввание издательства для поиска книг:");
                BookArray bookOfPublishing = bookArray.getBooksOfPublishing(scanner.next().trim());
                bookOfPublishing.print();

                System.out.println("\nВведите год, для поиск книг");
                BookArray bookFromYear = bookArray.getBooksFromYear(Integer.parseInt(scanner.next().trim()));
                bookFromYear.print();
            }

        }catch(Exception ex){

            System.out.println("Ошибка ввода! Ввод произведен не по шаблону или же пропущена ;");
        }
    }
}
