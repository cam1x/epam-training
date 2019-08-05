package by.epam.course.application.accounting.book;

/*
    Класс для представления книги.
    Возможности:
    1) изменение имени, автора, числа страниц, описания книги
    2) получение имени, автора, числа страниц, описания книги
 */

public class Book {

    private String name;
    private String author;
    private int pages;
    private String description;

    public Book(String author,String name,int pages){
        setPages(pages);
        setName(name);
        setAuthor(author);
        description=author+"\t"+name+" ("+pages+" pages)\n";
    }

    public void setName(String name){
        if(name!=null && !name.isEmpty()){
            this.name=name;
        }
    }

    public void setAuthor(String author){
        if(author!=null && !author.isEmpty()){
            this.author=author;
        }
    }

    public void setPages(int pages){
        if(pages>0){
            this.pages=pages;
        }
    }

    public void addDescription(String description) {
        if(description!=null && !description.isEmpty()) {
            this.description += description+"\n";
        }
    }

    public void changeDescription(String description){
        if(description!=null && !description.isEmpty()) {
            this.description = author+"\t"+name+" ("+pages+" pages)\n";
            this.description+=description;
        }
    }

    public String getName(){
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString(){
        return String.format("%15s %15s %10s",author,name,Integer.toString(pages));
    }

    @Override
    public boolean equals(Object obj){
        if(obj == this){
            return true;
        }

        if(obj==null || !(obj instanceof Book)){
            return false;
        }

        Book other=(Book) obj;

        return name.equals(other.name) && author.equals(other.author) && pages==other.pages;
    }

    @Override
    public int hashCode(){
        final int prime=31;
        int result=1;
        result=prime*result+((name==null)?0:name.hashCode());
        result=prime*result+((author==null)?0:author.hashCode());
        result=prime*result+pages;
        return result;
    }
}
