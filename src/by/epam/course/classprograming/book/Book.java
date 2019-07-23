package by.epam.course.classprograming.book;

/*
    Класс для представления книги.
    Возможности:
    1) изменить значение каждого поля
    2) получить значение каждого поля
    3) вывод на консоль
 */

public class Book {

    private static int idCounter;

    private int id;
    private String name;
    private String publishingHouse;
    private String author;
    private int yearOfPublishing;
    private int numberOfPages;
    private double price;
    private Binding bindingType;

    public Book(){

        name=publishingHouse=author="not defined";
        id=++idCounter;
        bindingType=Binding.HARDCOVER;
    }

    public Book(String name,String publishingHouse,String author,int yearOfPublishing,int numberOfPages,int price,Binding bindingType) {

        setName(name);
        setPublishingHouse(publishingHouse);
        setAuthor(author);
        setYearOfPublishing(yearOfPublishing);
        setNumberOfPages(numberOfPages);
        setPrice(price);
        setBindingType(bindingType);
    }

    public Book(int id,String name,String publishingHouse,String author,int yearOfPublishing,int numberOfPages,int price,Binding bindingType){

        this(name,publishingHouse,author,yearOfPublishing,numberOfPages,price,bindingType);
        setId(id);
    }

    public void setId(int id){

        if(id>0) {
            this.id = id;
        }
    }

    public void setName(String name){

        if(name!=null && !name.isEmpty()) {
            this.name = name;
        }
    }

    public void setPublishingHouse(String publishingHouse){

        if(publishingHouse!=null && !publishingHouse.isEmpty()) {
            this.publishingHouse = publishingHouse;
        }
    }

    public void setAuthor(String author){

        if(author!=null && !author.isEmpty()) {
            this.author = author;
        }
    }

    public void setYearOfPublishing(int yearOfPublishing){

        if(yearOfPublishing>0) {
            this.yearOfPublishing = yearOfPublishing;
        }
    }

    public void setNumberOfPages(int numberOfPages){

        if(numberOfPages>0) {
            this.numberOfPages = numberOfPages;
        }
    }

    public void setPrice(double price){

        if(price>0) {
            this.price = price;
        }
    }

    public void setBindingType(Binding bindingType){

        this.bindingType=bindingType;
    }

    public String getName(){

        return name;
    }

    public String getPublishingHouse(){

        return publishingHouse;
    }

    public String getAuthor(){

        return author;
    }

    public int getId(){

        return id;
    }

    public int getYearOfPublishing(){

        return yearOfPublishing;
    }

    public int getNumberOfPages(){

        return numberOfPages;
    }

    public double getPrice(){

        return price;
    }

    public Binding getBindingType(){

        return bindingType;
    }

    public void print(){

        System.out.println(toString());
    }

    @Override
    public String toString(){

        return String.format("%5s %10s %10s %15s %6s %5s %4s %5s",Integer.toString(id),name,
                author,publishingHouse,Integer.toString(yearOfPublishing),
                Integer.toString(numberOfPages),Double.toString(price),bindingType.toString());
    }

    @Override
    public boolean equals(Object obj){

        if(obj == this){
            return true;
        }

        if(obj==null || obj.getClass() != this.getClass()){
            return false;
        }

        Book other=(Book)obj;
        return name.equals(other.name) && publishingHouse.equals(other.publishingHouse) && author.equals(other.author)&&
                yearOfPublishing==other.yearOfPublishing && numberOfPages==other.numberOfPages
                && price==other.price && bindingType.equals(other.bindingType);
    }

    @Override
    public int hashCode(){

        final int prime=31;
        int result=1;

        result=prime*result+((name==null)?0:name.hashCode());
        result=prime*result+((publishingHouse==null)?0:publishingHouse.hashCode());
        result=prime*result+yearOfPublishing;
        result=prime*result+numberOfPages;
        result=prime*result+Double.hashCode(price);
        result=prime*result+bindingType.hashCode();

        return result;
    }
}
