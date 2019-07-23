package by.epam.course.oopbasic.file;

import java.io.File;
import java.util.*;

/*
    Класс для представления директории
    Возможности:
    1) изменение директории
    2) добавление папки к директории
    3) удаление папки из директории
    4) замена одной папки на другую
    5) проверка существует ли данная директория
    6) создание данной директории
    7) вывод на консоль
 */

public class Directory {

    private String diskName="C";
    private ArrayList<String> folders=new ArrayList<String>();
    private File directory;

    public Directory(){

        folders.add("Program files");
    }

    public Directory(String path){

        setDirectory(path);
    }

    public void setDirectory(String path){

        if(path!=null && !path.isEmpty()) {
            int index = path.indexOf(":\\");

            if (index != -1) {
                diskName = path.substring(0, index).trim();
                path = path.substring(index + 2);
            }

            folders.clear();
            Scanner scanner = new Scanner(path);
            scanner.useDelimiter("\\\\");

            while (scanner.hasNext()) {
                folders.add(scanner.next());
            }
        }
    }

    public void setDiskName(String disk){

        if(disk!=null && !disk.isEmpty()) {
            this.diskName = disk;
        }
    }

    public void addFolder(String folder){

        if(folder!=null && !folder.isEmpty()) {
            folders.add(folder);
        }
    }

    /*
    Заменить в пути папку oldFolder на newFolder
     */
    public void changeFolder(String oldFolder, String newFolder){

        if(oldFolder!=null && newFolder!=null && !oldFolder.isEmpty() && !newFolder.isEmpty()) {
            int index = folders.indexOf(oldFolder);
            if (index != -1) {
                folders.set(index, newFolder);
            }
        }
    }

    /*
    Очистить путь
     */
    public void deleteAllFolders(){

        folders.clear();
    }

    /*
    Удалить из пути папку name
     */
    public void deleteFolder(String name){

        folders.remove(name);
    }

    /*
    Получить File директории, созданный по указанному пути
     */
    public File getDirectory(){
        directory=new File(toString());
        return directory;
    }

    /*
    Существует ли директория
     */
    public boolean isExists(){
        directory=new File(toString());
        return directory.isDirectory();
    }

    /*
    Если директория не сущетсвует, то она создается
    Возвращает true, если была создана директория
     */
    public boolean create(){

        if(!isExists()){
           return directory.mkdirs();
        }else{
            return false;
        }
    }

    /*
    Вывести путь
     */
    public void print(){
        System.out.println(toString());
    }

    @Override
    public String toString(){

        String string=new String();

        string+=diskName+":";

        for(int i=0;i<folders.size();i++){
            string+="//"+folders.get(i);
        }

        return string;
    }

    @Override
    public boolean equals(Object obj){

        if(obj == this){
            return true;
        }

        if(obj==null || obj.getClass() != this.getClass()){
            return false;
        }

        Directory other=(Directory)obj;

        return diskName.equals(other.diskName) && folders.equals(other.folders);
    }

    @Override
    public int hashCode(){

        final int prime=31;
        int result=1;

        result=prime*result+((diskName==null)?0:diskName.hashCode());
        result=prime*result+folders.hashCode();

        return result;
    }
}
