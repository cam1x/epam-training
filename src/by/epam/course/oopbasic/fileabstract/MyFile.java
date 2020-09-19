package by.epam.course.oopbasic.fileabstract;

/*
    Класс для представления файла
    Возможности:
    1) изменение директории, имени, расширения файла
    2) получение директории, имени, расширения файла
    3) проверка существует ли данный файл
    4) создание файла
    5) удаление файла
    6) переименование файла
    7) вывод на консоль
 */

public class MyFile {
    private Directory directory;
    private String fileName;
    private String expansion;
    private boolean isExists = false;

    public MyFile() {
        this.directory = new Directory();
        fileName = "file";
        expansion = "exe";
    }

    public MyFile(String path, String fileName) {
        setDirectory(path);
        rename(fileName);
        expansion = "exe";
    }

    public MyFile(String path, String fileName, String expansion) {
        setDirectory(path);
        rename(fileName);
        setExpansion(expansion);
    }

    public void rename(String fileName) {
        if (fileName != null && !fileName.isEmpty()) {
            this.fileName = fileName;
        }
    }

    public String getFileName() {
        return fileName;
    }

    public String getExpansion() {
        return expansion;
    }

    public void setExpansion(String expansion) {
        if (expansion != null && !expansion.isEmpty()) {
            this.expansion = expansion;
        }
    }

    public String getDirectory() {
        return directory.toString();
    }

    public void setDirectory(String path) {
        if (path != null && !path.isEmpty()) {
            directory.setDirectory(path);
        }
    }

    public boolean isExists() {
        return isExists;
    }

    public void delete() {
        isExists = false;
    }

    public void create() {
        isExists = true;
    }

    public void print() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return directory.toString() + "//" + fileName + "." + expansion + "\t" + ((isExists) ?
                "существует" : "не существует");
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        MyFile other = (MyFile) obj;

        return directory.equals(other.directory) && fileName.equals(other.fileName)
                && expansion.equals(other.expansion);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
        result = prime * result + ((expansion == null) ? 0 : expansion.hashCode());
        result = prime * result + directory.hashCode();

        return result;
    }
}
