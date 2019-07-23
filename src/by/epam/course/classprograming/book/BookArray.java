package by.epam.course.classprograming.book;

/*
    Коллекция(массив) книг.
    Возможности:
    1) получение списка книг заданного автора
    2) получение списка книг указанного издательста
    3) получение списка книг, впущенных после заданного года
    4) получение книги по индексу
    5) вывод на консоль
    6) добавление/удаление книги
 */

public class BookArray {

    private Book[] arrayOfBooks;

    public BookArray(int size){
        if(size>0) {
            arrayOfBooks = new Book[size];

            for (int i = 0; i < size; i++) {
                arrayOfBooks[i] = new Book();
            }
        }
    }

    public BookArray(Book[] array){
        setArrayOfBooks(array);
    }

    public void setArrayOfBooks(Book[] array){
        if(array!=null) {
            arrayOfBooks = new Book[array.length];

            for (int i = 0; i < array.length; i++) {
                arrayOfBooks[i] = array[i];
            }
        }
    }

    public Book[] getArrayOfBooks(){
        return arrayOfBooks;
    }

    public Book getBook(int index){
        if(index>=0 && index<getSize()){
            return arrayOfBooks[index];
        }else{
            throw new IllegalArgumentException("Выход за пределы массива!");
        }
    }

    public int getSize(){
        if(arrayOfBooks!=null) {
            return arrayOfBooks.length;
        } else{
            return 0;
        }
    }

    public void print(){
        System.out.println(toString());
    }

    public void addBook(Book book){
        if(book!=null) {
            Book[] newBooks = new Book[getSize() + 1];

            for (int i = 0; i < getSize(); i++) {
                newBooks[i] = arrayOfBooks[i];
            }

            newBooks[getSize()] = book;
            arrayOfBooks = newBooks;
        }
    }

    public void deleteBook(Book book){
        if(book==null){
            throw new IllegalArgumentException("Неверный аргумент (null)!");
        }

        int numOfBooks=getSize();

        for(Book book1: arrayOfBooks){
            if(book1.equals(book)){
                numOfBooks--;
            }
        }

        if(numOfBooks<getSize()){
            Book[] newBooks=new Book[numOfBooks];

            for(int i=0,index=0;i<getSize();i++){
                if(!arrayOfBooks[i].equals(book)){
                    newBooks[index]=arrayOfBooks[i];
                    index++;
                }
            }

            arrayOfBooks=newBooks;
        }
    }

    public void deleteBook(int index){
        if(index>=0 && index<getSize()){
            Book[] newBooks=new Book[getSize()-1];

            for(int i=0,j=0;i<getSize();i++){
                if(i!=index){
                    newBooks[j]=arrayOfBooks[i];
                    j++;
                }
            }

            arrayOfBooks=newBooks;
        }
    }

    /*
        Возвращает книги указанного автора.
        Если такие книги отсутствуют, то возвращается массив, состоящий из одного элемента, в котором значения всех полей установлены по умолчанию.
     */
    public BookArray getBooksOfAuthor(String author){
        if(arrayOfBooks==null){
            throw new IllegalArgumentException("Книги отсутствуют! (null)");
        }

        int numOfBooks=0;

        for(Book book:arrayOfBooks){
            if(book.getAuthor().equals(author)){
                numOfBooks++;
            }
        }

        if(numOfBooks>0){

            Book[] books=new Book[numOfBooks];

            for(int i=0,index=0;i<getSize();i++){
                if(arrayOfBooks[i].getAuthor().equals(author)){
                    books[index]=arrayOfBooks[i];
                    index++;
                }
            }
            return new BookArray(books);

        }else{
            Book[] zeroBooks=new Book[1];
            zeroBooks[0]=new Book();
            return new BookArray(zeroBooks);
        }
    }

    /*
        Возвращает книги указанного издательства.
        Если такие книги отсутствуют, то возвращается массив, состоящий из одного элемента, в котором значения всех полей установлены по умолчанию.
     */
    public BookArray getBooksOfPublishing(String publishingHouse){
        if(arrayOfBooks==null){
            throw new IllegalArgumentException("Книги отсутствуют! (null)");
        }

        int numOfBooks=0;

        for(Book book:arrayOfBooks){
            if(book.getPublishingHouse().equals(publishingHouse)){
                numOfBooks++;
            }
        }

        if(numOfBooks>0){

            Book[] books=new Book[numOfBooks];

            for(int i=0,index=0;i<getSize();i++){
                if(arrayOfBooks[i].getPublishingHouse().equals(publishingHouse)){
                    books[index]=arrayOfBooks[i];
                    index++;
                }
            }
            return new BookArray(books);

        }else{
            Book[] zeroBooks=new Book[1];
            zeroBooks[0]=new Book();
            return new BookArray(zeroBooks);
        }
    }

    /*
        Возвращает книги, выпущенные позже заданного года.
        Если такие книги отсутствуют, то возвращается массив, состоящий из одного элемента, в котором значения всех полей установлены по умолчанию.
     */
    public BookArray getBooksFromYear(int year){
        if(arrayOfBooks==null){
            throw new IllegalArgumentException("Книги отсутствуют! (null)");
        }

        int numOfBooks=0;

        for(Book book:arrayOfBooks){
            if(book.getYearOfPublishing()>year){
                numOfBooks++;
            }
        }

        if(numOfBooks>0){

            Book[] books=new Book[numOfBooks];

            for(int i=0,index=0;i<getSize();i++){
                if(arrayOfBooks[i].getYearOfPublishing()>year){
                    books[index]=arrayOfBooks[i];
                    index++;
                }
            }
            return new BookArray(books);

        }else{
            Book[] zeroBooks=new Book[1];
            zeroBooks[0]=new Book();

            return new BookArray(zeroBooks);
        }
    }

    @Override
    public String toString(){
        if(arrayOfBooks!=null) {
            String string = new String();

            for (Book book : arrayOfBooks) {
                string += book.toString() + "\n";
            }
            return string;

        } else{
            return "Книги отсутствуют!";
        }
    }

    @Override
    public boolean equals(Object obj){
        if(obj == this){
            return true;
        }

        if(obj==null || obj.getClass() != this.getClass()){
            return false;
        }

        BookArray other=(BookArray) obj;

        boolean isEqual=other.getSize()==getSize();

        for(int i=0; isEqual && i<getSize();i++){
            if(!arrayOfBooks[i].equals(other.getArrayOfBooks()[i])){
                isEqual=false;
            }
        }

        return isEqual;
    }

    @Override
    public int hashCode(){
        final int prime=31;
        int result=1;

        for(int i=0;i<getSize();i++){
            result=prime*result+arrayOfBooks[i].hashCode();
        }

        return result;
    }
}
