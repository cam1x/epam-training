package by.epam.course.application.archive.deed;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
    Класс для представления архива дел
    Возможности:
    1) Добавление дела
    2) Удаление дел по различным параметрам
    3) Сортировка дел
    4) Поиск дед
    5) Изменение активного дела (активное дело-последнее)
    6) Выбор дела (=присваение статуса активного)
    7) Вывод на консоль
 */

public class Archive {
    private final List<Deed> archive = new ArrayList<Deed>();

    public void addDeed(Deed deed) {
        archive.add(deed);
    }

    public void addDeed(String name, String faculty, int course, int yearOfEnrolling) {
        archive.add(new Deed(name, faculty, course, yearOfEnrolling));
    }

    public void removeDeed(Deed deed) {
        archive.remove(deed);
    }

    public void removeDeed(int numOfDeed) {
        Deed deed;
        for (int i = 0; i < archive.size(); i++) {
            deed = archive.get(i);
            if (deed.getNumOfDeed() == numOfDeed) {
                archive.remove(deed);
            }
        }
    }

    //Удаление отчисленных и окончивших универ студентов
    public void removeIfNotEnrolled() {
        Deed deed;
        for (int i = 0; i < archive.size(); i++) {
            deed = archive.get(i);
            if (deed.getStatus() != StudentStatus.ENROLLED) {
                archive.remove(deed);
            }
        }
    }

    public boolean chooseDeed(int numOfDeed) {
        int id = -1;
        for (int i = 0; i < archive.size(); i++) {
            if (archive.get(i).getNumOfDeed() == numOfDeed) {
                id = i;
                break;
            }
        }
        if (id != -1) {
            archive.add(archive.size(), archive.get(id));
            archive.remove(id);
            return true;
        } else {
            return false;
        }
    }

    public void changeFaculty(String faculty) {
        if (archive.size() > 0) {
            archive.get(archive.size() - 1).changeFaculty(faculty);
        }
    }

    public void setCharacteristic(String characteristic) {
        if (archive.size() > 0) {
            archive.get(archive.size() - 1).setCharacteristic(characteristic);
        }
    }

    public boolean incCourse() {
        if (archive.size() > 0) {
            return archive.get(archive.size() - 1).incCourse();
        } else {
            return false;
        }
    }

    public void changeCourse(int course) {
        if (archive.size() > 0) {
            archive.get(archive.size() - 1).changeCourse(course);
        }
    }

    public void sort() {
        Comparator<Deed> comparator = Comparator.comparing(Deed::getStatus);
        comparator.thenComparing(Deed::getFaculty);
        comparator.thenComparing(Deed::getCourse);
        comparator.thenComparing(Deed::getYearOfEnrolling);
        comparator.thenComparing(Deed::getName);
        archive.sort(comparator);
    }

    public List<Deed> findDeedByFaculty(String faculty) {
        List<Deed> founded = new ArrayList<>();
        if (faculty != null && !faculty.isEmpty() && archive.size() > 0) {
            for (Deed deed : archive) {
                if (deed.getFaculty().equals(faculty)) {
                    founded.add(deed);
                }
            }
        }
        return founded;
    }

    public List<Deed> findDeedByCourse(int course) {
        List<Deed> founded = new ArrayList<>();
        if (archive.size() > 0) {
            for (Deed deed : archive) {
                if (deed.getCourse() == course) {
                    founded.add(deed);
                }
            }
        }
        return founded;
    }

    //Поиск дел студентов по году зачисления
    public List<Deed> findDeedByYear(int year) {
        List<Deed> founded = new ArrayList<>();
        if (archive.size() > 0) {
            for (Deed deed : archive) {
                if (deed.getYearOfEnrolling() == year) {
                    founded.add(deed);
                }
            }
        }
        return founded;
    }

    //Получить дело по индексу в архиве
    public Deed get(int n) {
        if (n >= 0 && n < archive.size()) {
            return archive.get(n);
        } else {
            return null;
        }
    }

    //Возвращает число дел в архиве
    public int size() {
        return archive.size();
    }

    public void print() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        if (archive.size() > 0) {
            StringBuilder string = new StringBuilder();
            for (Deed deed : archive) {
                string.append(deed.toString()).append("\n");
            }
            return string.toString();
        } else {
            return "Архив пуст!";
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Archive other = (Archive) obj;

        boolean isEqual = archive.size() == other.archive.size();

        for (int i = 0; isEqual && i < archive.size(); i++) {
            if (!archive.get(i).equals(other.archive.get(i))) {
                isEqual = false;
                break;
            }
        }

        return isEqual;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + archive.hashCode();

        return result;
    }
}
