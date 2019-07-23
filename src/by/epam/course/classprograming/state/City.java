package by.epam.course.classprograming.state;

/*
    Класс для представления города
    Возможности:
    1) изменения названия и площади города
    2) получение названия и площади
    3) вывод на консоль
 */

public class City {

    private String city;
    private double area=50;

    public City(){
        city="city";
    }

    public City(String city){
        setCity(city);
    }

    public void setCity(String city){
        if(city!=null && !city.isEmpty()) {
            this.city = city.trim();
        }
    }

    public void setArea(double area){
        if(area>0){
            this.area=area;
        }
    }

    public double getArea(){
        return area;
    }

    public String getCity(){
        return city;
    }

    public void print(){
        System.out.println(toString());
    }

    @Override
    public String toString(){
        return city;
    }

    @Override
    public boolean equals(Object obj){
        if(obj == this){
            return true;
        }

        if(obj==null || obj.getClass() != this.getClass()){
            return false;
        }

        City other=(City) obj;

        return city.equals(other.city);
    }

    @Override
    public int hashCode(){
        final int prime=31;
        int result=1;

        result=prime*result+((city==null)?0:city.hashCode());
        return result;
    }
}
