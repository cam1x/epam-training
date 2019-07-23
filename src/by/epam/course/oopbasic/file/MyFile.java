package by.epam.course.oopbasic.file;

import java.io.*;

/*
    Класс для представления файла
    Возможности:
    1) изменение директории, имени, расширения файла
    2) получение директории, имени, расширения файла
    3) проверка существует ли данный файл
    4) создание файла
    5) удалание файла
    6) переименование файла
    7) вывод на консоль
 */

public class MyFile {

    private Directory directory;
    private String fileName;
    private String expansion;
    private File file;

    public MyFile(){
        this.directory =new Directory();
        fileName="file";
        expansion="exe";
        file=new File(directory.getDirectory(),fileName+"."+expansion);
    }

    public MyFile(String path,String fileName){
        setDirectory(path);
        setFileName(fileName);
        expansion="exe";
        file=new File(directory.getDirectory(),fileName+"."+expansion);
    }

    public MyFile(String path,String fileName,String expansion){
        setDirectory(path);
        setFileName(fileName);
        setExpansion(expansion);
        file=new File(directory.getDirectory(),fileName+"."+expansion);
    }

    public void setExpansion(String expansion){
        if(expansion!=null && !expansion.isEmpty()) {
            this.expansion = expansion;
            file = new File(directory.getDirectory(), fileName + "." + expansion);
        }
    }

    public void setFileName(String fileName){
        if(fileName!=null && !fileName.isEmpty()) {
            this.fileName = fileName;
            file = new File(directory.getDirectory(), fileName + "." + expansion);
        }
    }

    public void setDirectory(String path){
        if(path!=null && !path.isEmpty()) {
            directory.setDirectory(path);
            file = new File(directory.getDirectory(), fileName + "." + expansion);
        }
    }

    public File getFile(){
        return file;
    }

    public String getFileName(){
        return fileName;
    }

    public String getExpansion(){
        return expansion;
    }

    public String getDirectory(){
        return directory.toString();
    }

    public boolean isExists(){
        return file.isFile();
    }

    public boolean create(){
        if(!isExists()){
            if(!directory.isExists()){
                directory.create();
            }
            try {
                return file.createNewFile();
            } catch(IOException ex){
                return false;
            }

        }else{
            return false;
        }
    }

    public boolean delete(){
        if(isExists()){
            return file.delete();
        }else{
            return false;
        }
    }

    public boolean rename(String name){
        File newFile=new File(directory.getDirectory(),name+"."+expansion);

        boolean isRenamed=false;

        if(isExists() && !newFile.exists()){
            isRenamed=file.renameTo(newFile);
        }

        if(isRenamed){
            setFileName(name);
        }

        return isRenamed;
    }

    public void print(){
        System.out.println(toString());
    }

    @Override
    public String toString(){
        return directory.toString()+"//"+fileName+"."+expansion;
    }

    @Override
    public boolean equals(Object obj){
        if(obj == this){
            return true;
        }

        if(obj==null || obj.getClass() != this.getClass()){
            return false;
        }

        MyFile other=(MyFile) obj;

        return directory.equals(other.directory) && fileName.equals(other.fileName)
                && expansion.equals(other.expansion);
    }

    @Override
    public int hashCode(){
        final int prime=31;
        int result=1;

        result=prime*result+((fileName==null)?0:fileName.hashCode());
        result=prime*result+((expansion==null)?0:expansion.hashCode());
        result=prime*result+directory.hashCode();

        return result;
    }

}
