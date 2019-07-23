package by.epam.course.classprograming.state;

import java.util.regex.*;

/*
    Класс для представления района
    Возможности:
    1) изменения названия и площади района
    2) получение названия и площади
    3) вывод на консоль
    4) добавления города к району
    5) удаление города из района
    6) получение городов района
 */

public class District {

    private String district;
    private City[] citiesOfDistrict;
    private double area=200;

    public District(){
        district="district";
    }

    public District(String district){
        setDistrict(district);
    }

    public void setDistrict(String district){
        if(district!=null && !district.isEmpty()) {
            this.district = district;
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

    public String getDistrict(){
        return district;
    }

    //Добавляет город к данному району
    public void addCity(String city){
        if (city != null && !city.isEmpty()) {
            Pattern wordPat = Pattern.compile("\\b[a-zA-ZА-Яа-я]+?\\b");
            Matcher wordMatch = wordPat.matcher(city);
            while (wordMatch.find()) {
                addOneCity(wordMatch.group());
            }

        }
    }

    //Удаляет город из данного района
    public void deleteCity(String city){

        if (city != null && !city.isEmpty()) {
            Pattern wordPat = Pattern.compile("\\b[a-zA-ZА-Яа-я]+?\\b");
            Matcher wordMatch = wordPat.matcher(city);
            while (wordMatch.find()) {

                deleteOneCity(wordMatch.group());
            }
        }
    }

    public int getNumOfCities(){
        if(citiesOfDistrict!=null){
            return citiesOfDistrict.length;
        }else{
            return 0;
        }
    }

    //Возвращает список городов данного района
    public String getCities(){
        String string=new String();

        if(citiesOfDistrict!=null){
            for(City city:citiesOfDistrict){
                string+=city.toString()+" ";
            }
        }else{
            string=" ";
        }

        return string;
    }

    public void print(){
        System.out.println(toString());
    }

    @Override
    public String toString(){
        String string=new String();

        string+=district+"(-ий) район.";

        if(citiesOfDistrict!=null){
            string+="\n\t\tГорода: ";
            for(City city:citiesOfDistrict){
                string+=city.toString()+" ";
            }
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

        District other=(District) obj;

        boolean isEqual=true;

        for(int i=0;i<getNumOfCities();i++){
            if(!citiesOfDistrict[i].equals(other.citiesOfDistrict[i])){
                isEqual=false;
                break;
            }
        }

        return isEqual;
    }

    @Override
    public int hashCode(){
        final int prime=31;
        int result=1;

        for(int i=0;i<getNumOfCities();i++){
            result=prime*result+citiesOfDistrict[i].hashCode();
        }

        return result;
    }

    private void addOneCity(String city){
        if(citiesOfDistrict!=null){
            City[] newCities=new City[getNumOfCities()+1];
            for(int i=0;i<getNumOfCities();i++){
                newCities[i]=citiesOfDistrict[i];
            }

            newCities[getNumOfCities()]=new City(city);
            area+=newCities[getNumOfCities()].getArea();
            citiesOfDistrict=newCities;
        }else{
            citiesOfDistrict=new City[1];
            citiesOfDistrict[0]=new City(city);
            area+=citiesOfDistrict[0].getArea();
        }

    }

    private void deleteOneCity(String city){
        city=city.trim();
        if(city.contains(" ")){
            city=city.substring(0,city.indexOf(" ")).trim();
        }

        int numOfCities=getNumOfCities();

        for(City cities:citiesOfDistrict){
            if(cities.getCity().equals(city)){
                numOfCities--;
                area-=cities.getArea();
            }
        }

        if(numOfCities<getNumOfCities()) {
            City[] newCities = new City[numOfCities];
            for (int i = 0, index = 0; i < getNumOfCities(); i++) {
                if (!citiesOfDistrict[i].getCity().equals(city)) {
                    newCities[index] = citiesOfDistrict[i];
                    index++;
                }
            }

            citiesOfDistrict = newCities;
        }
    }
}
