package by.epam.course.classprograming.state;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Класс для представления гос-ва
    Возможности:
    1) изменения названия и площади гос-ва
    2) получение названия и площади
    3) вывод на консоль
    4) добавить город к районы
    5) удалить город из района
    6) добавить район к области
    7) удалить район из области
    8) получение областей гос-ва
    9) добавить область к гос-ву
    10) удалить область из гос-ва
 */

public class State {
    private String state;
    private City capital;
    private Region[] regions;
    private double area = 1000;

    public State() {
        state = "state";
        capital = new City("capital");
    }

    public State(String state, String city) {
        setState(state, city);
    }

    public void setState(String state, String city) {
        if (state != null && !state.isEmpty()) {
            this.state = state;
        }
        this.capital.setCity(city);
    }

    public void setState(String state, String city, double area) {
        setState(state, city);
        setArea(area);
    }

    public void setCenter(String center, int index) {
        if (index >= 0 && index < getNumOfRegions()) {
            regions[index].setCenter(center);
        }
    }

    public String getCenters() {
        StringBuilder string = new StringBuilder();

        if (regions != null) {
            for (Region region : regions) {
                string.append(region.getCenter()).append(" (").append(region.getRegion()).append(")  ");
            }
        } else {
            string = new StringBuilder("Следует добавить области!");
        }

        return string.toString();
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        if (area > 0) {
            this.area = area;
        }
    }

    //Добавить район к области с индексом index в данном государстве
    public void addDistrict(String region, int index) {
        if (index >= 0 && index < getNumOfRegions()) {
            Objects.requireNonNull(getNthRegion(index)).addDistrict(region);
        }
    }

    //Добавить город к последнему району в области с индексом indexOfRegion в гос-ве
    public void addCity(String city, int indexOfRegion) {
        if (indexOfRegion >= 0 && indexOfRegion < getNumOfRegions()) {
            Region region = getNthRegion(indexOfRegion);
            assert region != null;
            if (region.getNumOfDistricts() >= 1) {
                region.addCity(city, region.getNumOfDistricts() - 1);
            }
        }
    }

    //Удалить город из последнего района в области с индексом indexOfRegion в гос-ве
    public void deleteCity(String city, int indexOfRegion) {
        if (indexOfRegion >= 0 && indexOfRegion < getNumOfRegions()) {
            Region region = getNthRegion(indexOfRegion);
            assert region != null;
            if (region.getNumOfDistricts() >= 1) {
                region.deleteCity(city, region.getNumOfDistricts() - 1);
            }
        }
    }

    //Добавить город к району c индексом indexOfDistrict  в области с индексом indexOfRegion в гос-ве
    public void addCity(String city, int indexOfRegion, int indexOfDistrict) {
        if (indexOfRegion >= 0 && indexOfRegion < getNumOfRegions()) {
            Region region = getNthRegion(indexOfRegion);
            if (indexOfDistrict >= 0 && indexOfDistrict < region.getNumOfDistricts()) {
                region.addCity(city, indexOfDistrict);
            }
        }
    }

    //Удалить город из района c индексом indexOfDistrict  в области с индексом indexOfRegion в гос-ве
    public void deleteCity(String city, int indexOfRegion, int indexOfDistrict) {
        if (indexOfRegion >= 0 && indexOfRegion < getNumOfRegions()) {
            Region region = getNthRegion(indexOfRegion);
            if (indexOfDistrict >= 0 && indexOfDistrict < region.getNumOfDistricts()) {
                region.deleteCity(city, indexOfDistrict);
            }
        }
    }

    //Удалить район из области с индексом index
    public void deleteDistrict(String region, int index) {
        if (index >= 0 && index < getNumOfRegions()) {
            Objects.requireNonNull(getNthRegion(index)).deleteDistrict(region);
        }
    }

    //Добавить область
    public void addRegion(String region) {
        if (region != null && !region.isEmpty()) {
            Pattern wordPat = Pattern.compile("\\b[a-zA-ZА-Яа-я]+?\\b");
            Matcher wordMatch = wordPat.matcher(region);
            while (wordMatch.find()) {
                addOneRegion(wordMatch.group());
            }
        }
    }

    //Удалить область
    public void deleteRegion(String region) {
        if (region != null && !region.isEmpty()) {
            Pattern wordPat = Pattern.compile("\\b[a-zA-ZА-Яа-я]+?\\b");
            Matcher wordMatch = wordPat.matcher(region);
            while (wordMatch.find()) {
                deleteOneRegion(wordMatch.group());
            }

        }
    }

    public int getNumOfRegions() {
        if (regions != null) {
            return regions.length;
        } else {
            return 0;
        }
    }

    public void print() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append(state).append(" (столица ").append(capital).append(")\n");

        if (regions != null) {
            string.append("Области:\n");
            for (Region region : regions) {
                string.append(region.toString()).append("\n");
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

        State other = (State) obj;

        boolean isEqual = true;

        for (int i = 0; i < getNumOfRegions(); i++) {
            if (!regions[i].equals(other.regions[i])) {
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

        for (int i = 0; i < getNumOfRegions(); i++) {
            result = prime * result + regions[i].hashCode();
        }

        return result;
    }

    private void addOneRegion(String region) {
        if (regions != null) {
            Region[] newRegion = new Region[getNumOfRegions() + 1];
            if (getNumOfRegions() >= 0) System.arraycopy(regions, 0, newRegion, 0, getNumOfRegions());

            newRegion[getNumOfRegions()] = new Region(region);
            area += newRegion[getNumOfRegions()].getArea();
            regions = newRegion;

        } else {
            regions = new Region[1];
            regions[0] = new Region(region);
            area += regions[0].getArea();
        }
    }

    private void deleteOneRegion(String region) {
        region = region.trim();
        if (region.contains(" ")) {
            region = region.substring(0, region.indexOf(" ")).trim();
        }

        int numOfRegions = getNumOfRegions();

        for (Region region1 : regions) {
            if (region1.getRegion().equals(region)) {
                numOfRegions--;
                area -= region1.getArea();
            }
        }

        if (numOfRegions < getNumOfRegions()) {
            Region[] newRegions = new Region[numOfRegions];
            for (int i = 0, index = 0; i < getNumOfRegions(); i++) {
                if (!regions[i].getRegion().equals(region)) {
                    newRegions[index] = regions[i];
                    index++;
                }
            }

            regions = newRegions;
        }
    }

    private Region getNthRegion(int index) {
        if (index >= 0 && index < getNumOfRegions()) {
            return regions[index];
        } else {
            return null;
        }
    }
}
