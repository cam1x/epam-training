package by.epam.course.classprograming.state;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
    Класс для представления области
    Возможности:
    1) изменения названия и площади области
    2) получение названия и площади
    3) вывод на консоль
    4) добавить город к районы
    5) удалить город из района
    6) добавить район к области
    7) удалить район из области
    8) получение районов области
 */

public class Region {
    private final City center = new City("center");
    private String region;
    private District[] districts;
    private double area = 500;

    public Region() {
        region = "region";
    }

    public Region(String region) {
        setRegion(region);
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        if (area > 0) {
            this.area = area;
        }
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        if (region != null && !region.isEmpty()) {
            this.region = region;
        }
    }

    public String getCenter() {
        return center.toString();
    }

    public void setCenter(String center) {
        if (center != null && !center.isEmpty()) {
            this.center.setCity(center);
        }
    }

    //Добавить город к районы с индексом index внутри данной области
    public void addCity(String city, int index) {
        if (index >= 0 && index < getNumOfDistricts()) {
            Objects.requireNonNull(getNthDistrict(index)).addCity(city);
        }
    }

    //Удалить город из района с индексом index в данной области
    public void deleteCity(String city, int index) {
        if (index >= 0 && index < getNumOfDistricts()) {
            Objects.requireNonNull(getNthDistrict(index)).deleteCity(city);
        }
    }

    //Добавить к данной области район
    public void addDistrict(String district) {
        if (district != null && !district.isEmpty()) {
            Pattern wordPat = Pattern.compile("\\b[a-zA-ZА-Яа-я]+?\\b");
            Matcher wordMatch = wordPat.matcher(district);
            while (wordMatch.find()) {
                addOneDistrict(wordMatch.group());
            }

        }
    }

    //Удалить из данной области район
    public void deleteDistrict(String district) {
        if (district != null && !district.isEmpty()) {
            Pattern wordPat = Pattern.compile("\\b[a-zA-ZА-Яа-я]+?\\b");
            Matcher wordMatch = wordPat.matcher(district);
            while (wordMatch.find()) {
                deleteOneDistrict(wordMatch.group());
            }
        }
    }

    public int getNumOfDistricts() {
        if (districts != null) {
            return districts.length;
        } else {
            return 0;
        }
    }

    //Возвращает список районов области
    public String getDistricts() {
        StringBuilder string = new StringBuilder("");

        if (districts != null) {
            for (District district : districts) {
                string.append(district.toString()).append(" ");
            }
        } else {
            string = new StringBuilder(" ");
        }

        return string.toString();
    }

    public void print() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("");

        string.append(region).append("(-ая) область (обл. центр - ").append(center).append(")");

        if (districts != null) {
            string.append("\n\tРайоны:\n");
            for (District district : districts) {
                string.append("\t").append(district.toString()).append("\n");
            }
        }

        return string.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Region other = (Region) obj;

        boolean isEqual = true;

        for (int i = 0; i < getNumOfDistricts(); i++) {
            if (!districts[i].equals(other.districts[i])) {
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

        for (int i = 0; i < getNumOfDistricts(); i++) {
            result = prime * result + districts[i].hashCode();
        }

        return result;
    }

    private void addOneDistrict(String district) {
        if (districts != null) {
            District[] newDistrict = new District[getNumOfDistricts() + 1];
            if (getNumOfDistricts() >= 0)
                System.arraycopy(districts, 0, newDistrict, 0, getNumOfDistricts());

            newDistrict[getNumOfDistricts()] = new District(district);
            area += newDistrict[getNumOfDistricts()].getArea();
            districts = newDistrict;

        } else {
            districts = new District[1];
            districts[0] = new District(district);
            area += districts[0].getArea();
        }
    }

    private void deleteOneDistrict(String district) {
        district = district.trim();
        if (district.contains(" ")) {
            district = district.substring(0, district.indexOf(" ")).trim();
        }

        int numOfDistricts = getNumOfDistricts();


        for (District district1 : districts) {
            if (district1.getDistrict().equals(district)) {
                numOfDistricts--;
                area -= district1.getArea();
            }
        }

        if (numOfDistricts < getNumOfDistricts()) {
            District[] newDistricts = new District[numOfDistricts];
            for (int i = 0, index = 0; i < getNumOfDistricts(); i++) {
                if (!districts[i].getDistrict().equals(district)) {
                    newDistricts[index] = districts[i];
                    index++;
                }
            }

            districts = newDistricts;
        }
    }

    private District getNthDistrict(int index) {
        if (index >= 0 && index < getNumOfDistricts()) {
            return districts[index];
        } else {
            return null;
        }
    }
}
