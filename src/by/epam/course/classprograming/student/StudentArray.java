package by.epam.course.classprograming.student;

/*
    Коллекция(массив) студентов.
    Возможности:
    1) Получение отличников
    2) Вывод информации о студентах
    3) Добавление/удаление студента
 */

public class StudentArray {

    private Student[] arrayOfStudents;

    public StudentArray(int size){
        if(size>0) {
            arrayOfStudents = new Student[size];
            for (int i = 0; i < size; i++) {
                arrayOfStudents[i] = new Student();
            }
        }
    }

    public StudentArray(Student[] arr){
        setArrayOfStudents(arr);
    }

    public void setArrayOfStudents(Student[] arr){
        if(arr!=null) {
            arrayOfStudents = new Student[arr.length];
            for (int i = 0; i < arr.length; i++) {
                arrayOfStudents[i] = arr[i];
            }
        }
    }

    public Student getStudent(int index){
        if(index>=0 && index<getSize()){
            return arrayOfStudents[index];
        }else{
            throw new IllegalArgumentException("Переданный индекс выходит за пределы массива!");
        }
    }

    public Student[] getArrayOfStudents(){
        return arrayOfStudents;
    }

    public int getSize(){
        if(arrayOfStudents!=null) {
            return arrayOfStudents.length;
        }else{
            return 0;
        }
    }

    //Возвращает число отличников в массиве студентов
    public int getNumOfHonorPupils(){
        if(arrayOfStudents==null){
            throw new IllegalArgumentException("Студенты отсутствуют! (null)");
        }

        int numOfHonor=0;

        for(Student student:arrayOfStudents){
            if(student.isHonorPupil()){
                numOfHonor++;
            }
        }

        return numOfHonor;
    }

    /*
    Возвращает отличников.
    Если таковые отсутствуют, то возвращается массив, состоящий из одного элемента, в котором значения всех полей установлены по умолчанию.
     */
    public StudentArray getHonorPupil(){
        int numOfHonor=getNumOfHonorPupils();

        if(numOfHonor>0){
            Student[] arrayOfHonor=new Student[numOfHonor];

            for(int i=0,index=0;i<arrayOfStudents.length;i++){
                if(arrayOfStudents[i].isHonorPupil()){
                    arrayOfHonor[index]=arrayOfStudents[i];
                    index++;
                }
            }
            return new StudentArray(arrayOfHonor);

        }else{
            Student[] zeroHonor=new Student[1];
            zeroHonor[0]=new Student();

            return new StudentArray(zeroHonor);
        }
    }

    public void addStudent(Student student){
        if(student!=null) {
            Student[] newStudents = new Student[getSize() + 1];

            for (int i = 0; i < getSize(); i++) {
                newStudents[i] = arrayOfStudents[i];
            }

            newStudents[getSize()] = student;
            arrayOfStudents = newStudents;
        }
    }

    public void deleteStudent(Student student){
        if(student==null){
            throw new IllegalArgumentException("Неверный аргумента (null)!");
        }

        int numOfStudents=getSize();

        for(Student student1: arrayOfStudents){
            if(student1.equals(student)){
                numOfStudents--;
            }
        }

        if(numOfStudents<getSize()){
            Student[] newStudents=new Student[numOfStudents];
            for(int i=0,index=0;i<getSize();i++){
                if(!arrayOfStudents[i].equals(student)){
                    newStudents[index]=arrayOfStudents[i];
                    index++;
                }
            }
            arrayOfStudents=newStudents;
        }
    }

    public void deleteStudent(int index){
        if(index>=0 && index<getSize()){
            Student[] newStudents=new Student[getSize()-1];
            for(int i=0,j=0;i<getSize();i++){
                if(i!=index){
                    newStudents[j]=arrayOfStudents[i];
                    j++;
                }
            }
            arrayOfStudents=newStudents;
        }
    }

    public void print(){
        System.out.println(toString());
    }

    @Override
    public String toString(){
        if(arrayOfStudents!=null) {
            String string = new String();
            for (Student student : arrayOfStudents) {
                string += student.toString() + "\n";
            }
            return string;

        }else{
            return "Студенты отсутствуют!";
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

        StudentArray other=(StudentArray) obj;

        boolean isEqual=other.getSize()==getSize();

        for(int i=0;isEqual && i<getSize();i++){
            if(!arrayOfStudents[i].equals(other.arrayOfStudents[i])){
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
            result=result*prime +arrayOfStudents[i].hashCode();
        }

        return result;
    }
}
