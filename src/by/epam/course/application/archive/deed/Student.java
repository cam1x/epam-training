package by.epam.course.application.archive.deed;

/*
    Класс для представления студента
    Возможности:
    1) Получить/установить имя, факультет, курс, год зачисления
    2) Увеличение курса
    3) Вывод на консоль
    P.S. Хранит статус студента (выпущен, зачислен, отчислен)
 */

public class Student {
    public static final int TRAINING_PERIOD = 4;

    private String name = "My name";
    private String faculty = "FAMCS";
    private int course = 1;
    private int yearOfEnrolling = 2019;
    private StudentStatus status = StudentStatus.ENROLLED;

    public Student() {

    }

    public Student(String name, String faculty, int course, int yearOfEnrolling) {
        setName(name);
        setFaculty(faculty);
        setCourse(course);
        setYearOfEnrolling(yearOfEnrolling);
    }

    public StudentStatus getStatus() {
        return status;
    }

    protected void setStatus(StudentStatus status) {
        if (status != null) {
            this.status = status;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        if (faculty != null && !faculty.isEmpty()) {
            this.faculty = faculty;
        }
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        if (course >= 1 && course <= TRAINING_PERIOD) {
            this.course = course;
        }
    }

    public int getYearOfEnrolling() {
        return yearOfEnrolling;
    }

    public void setYearOfEnrolling(int year) {
        if (year > 1900 && year < 2100) {
            yearOfEnrolling = year;
        }
    }

    public boolean incCourse() {
        if (course <= TRAINING_PERIOD - 1) {
            course++;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return String.format("%15s %15s %7s %9s %10s", name, faculty, course, yearOfEnrolling, status.toString());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Student other = (Student) obj;

        return name.equals(other.name) && faculty.equals(other.faculty) && course == other.course &&
                yearOfEnrolling == other.yearOfEnrolling && status.equals(other.status);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((faculty == null) ? 0 : faculty.hashCode());
        result = prime * result + course;
        result = prime * result + yearOfEnrolling;
        result = prime * result + status.hashCode();

        return result;
    }
}
