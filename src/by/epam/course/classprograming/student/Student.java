package by.epam.course.classprograming.student;

/*
        Класс Student.
     Возможности:
     1) изменение фамилии, инициалов студента
     2) изменение номера групыы и оценок
     3) проверка на отличника
     4) получение информации о студенте
 */

public class Student {

    private String surname;
    private String initials;
    private int groupNumber;
    private int[] marks=new int[5];

    public Student(){
        surname="not defined";
        initials="not defined";
    }

    public Student(String surname,String initials,int group){
        setSurname(surname);
        setInitials(initials);
        setGroupNumber(group);
    }

    //Позволяет изменить отметки по всем предметам
    public void setMarks(int mark1,int mark2,int mark3,int mark4,int mark5){
        if(mark1>0 && mark2>0 && mark3>0 && mark4>0 && mark5>0) {
            marks[0] = mark1;
            marks[1] = mark2;
            marks[2] = mark3;
            marks[3] = mark4;
            marks[4] = mark5;
        }
    }

    //Позволяет изменить отметку по отдельному предмету, зная номер предмета в табиле успеваемости
    public void setMarks(int mark, int subjectNumber){
        if(subjectNumber>=0 && subjectNumber<marks.length && mark>0){
            marks[subjectNumber]=mark;
        }
    }

    public void setSurname(String surname){
        if(surname!=null && !surname.isEmpty()) {
            this.surname = surname;
        }
    }

    public void setInitials(String initials){
        if(initials!=null && !initials.isEmpty()) {
            this.initials = initials;
        }
    }

    public void setGroupNumber(int group){
        if(group>0) {
            groupNumber = group;
        }
    }

    public String getSurname(){
        return surname;
    }

    public String getInitials(){
        return initials;
    }

    public int getGroupNumber(){
        return groupNumber;
    }

    //Получить все отметки
    public int[] getMarks(){
        return marks;
    }

    //Получить отметка по отдельному предмету
    public int getMark(int index){
        if(index>=0 && index<marks.length){
            return marks[index];
        }else{
            return 0;
        }
    }

    //Проверяет является ли ученик отличником
    public boolean isHonorPupil(){
        int numOfPupils=0;
        boolean isHonorPupil=true;

        for(int i=0;i<marks.length;i++){
            if(marks[i]<9){
                isHonorPupil=false;
                break;
            }
        }

       return isHonorPupil;
    }

    public void print(){
        System.out.println(toString());
    }

    @Override
    public String toString(){
        return String.format("%15s %7s %7s %5s %5s %5s %5s %5s",surname,initials,Integer.toString(groupNumber),
                Integer.toString(marks[0]),Integer.toString(marks[1]),Integer.toString(marks[2]),
                Integer.toString(marks[3]),Integer.toString(marks[4]));
    }

    @Override
    public boolean equals(Object obj){
        if(obj == this){
            return true;
        }

        if(obj==null || obj.getClass() != this.getClass()){
            return false;
        }

        Student other=(Student) obj;

        boolean theSameMarks= getMarks().equals(other.getMarks());

        return  theSameMarks && surname.equals(other.surname) &&
                initials.equals(other.initials) && groupNumber==other.groupNumber;

    }

    @Override
    public int hashCode(){
        final int prime=31;
        int result=1;

        result=prime*result+((surname==null)?0:surname.hashCode());
        result=prime*result+((initials==null)?0:initials.hashCode());
        result=prime*result+groupNumber;
        result=prime*result+getMarks().hashCode();

        return result;
    }
}
