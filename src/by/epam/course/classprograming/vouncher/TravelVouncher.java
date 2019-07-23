package by.epam.course.classprograming.vouncher;

/*
    Класс для представления тур. путевки
    Возможности:
    1) изменение кол-ва дней,цены, питания, транспорта, типа
    2) получение кол-ва дней,цены, питания, транспорта, типа
    3) выбор/отмена путевки
    4) вывод на консоль
 */

public class TravelVouncher {

    private int numOfDays;
    private double cost;
    private String food;
    private String transport;
    private String type;
    private boolean isSelected;

    public TravelVouncher(){
        transport="без транспорта";
        type="смешанный тип";
        food="без питания";
    }

    public TravelVouncher(int typeChoise,int foodChoice,int transportChoice,int numOfDays,double cost){
        setNumOfDays(numOfDays);
        setCost(cost);
        setFood(foodChoice);
        setTransport(transportChoice);
        setType(typeChoise);
    }

    public void setNumOfDays(int days){
        if(days>0){
            this.numOfDays=days;
        }
    }

    public void setCost(double cost){
        if(cost>0){
            this.cost=cost;
        }
    }

    public void setFood(int choice){
        switch (choice){
            case 1:{
                food="все включено";
                break;
            }

            case 2:{
                food="завтрак";
                break;
            }

            case 3:{
                food="завтрак + ужин";
                break;
            }

            case 4:{
                food="завтрак + обед + ужин";
                break;
            }

            default:{
                food="без питания";
            }
        }
    }

    public void setTransport(int choice){
        switch (choice){
            case 1:{
                transport="самолет";
                break;
            }

            case 2:{
                transport="поезд";
                break;
            }

            case 3:{
                transport="автобус";
                break;
            }

            case 4:{
                transport="микроавтобус";
                break;
            }

            default:{
                transport="без транспорта";
            }
        }
    }

    public void setType(int choice){
        switch (choice){
            case 1:{
                type="отдых";
                break;
            }

            case 2:{
                type="экскурсии";
                break;
            }

            case 3:{
                type="лечение";
                break;
            }

            case 4:{
                type="шопинг";
                break;
            }

            case 5:{
                type="круиз";
                break;
            }

            default:{
                type="смешанный тип";
            }
        }
    }

    public int getNumOfDays(){
        return numOfDays;
    }

    public double getCost(){
        return cost;
    }

    public String getFood(){
        return food;
    }

    public String getTransport(){
        return transport;
    }

    public String getType(){
        return type;
    }

    public boolean isSelected(){
        return isSelected;
    }

    public void select(){
        isSelected=true;
    }

    public void deselect(){
        isSelected=false;
    }

    public void print(){
        System.out.println(toString());
    }

    @Override
    public String toString(){
        return String.format("%15s %20s %20s %5s %7s %10s",type,food,transport,Integer.toString(numOfDays),Double.toString(cost),isSelected? "выбрана":"");
    }

    @Override
    public boolean equals(Object obj){
        if(obj == this){
            return true;
        }

        if(obj==null || obj.getClass() != this.getClass()){
            return false;
        }

        TravelVouncher other=(TravelVouncher) obj;

        return type.equals(other.type) && numOfDays==other.numOfDays && cost==other.cost
                && transport.equals(other.transport) && food.equals(other.food);
    }

    @Override
    public int hashCode(){
        final int prime=31;
        int result=1;

        result=prime*result+numOfDays;
        result=prime*result+Double.hashCode(cost);
        result=prime*result+((food==null)?0:food.hashCode());
        result=prime*result+((transport==null)?0:transport.hashCode());
        result=prime*result+((type==null)?0:type.hashCode());

        return result;
    }

    public static void info(){
        System.out.println("*******************************ИНФОРМАЦИЯ********************************");
        System.out.println("\n\t\tПитание");
        System.out.println("1 - все включено");
        System.out.println("2 - завтрак");
        System.out.println("3 - завтрак + ужин");
        System.out.println("4 - завтрак + обед + ужин");
        System.out.println("другой выбор - без питания");

        System.out.println("\n\t\tТранспорт");
        System.out.println("1 - самолет");
        System.out.println("2 - поезд");
        System.out.println("3 - автобус");
        System.out.println("4 - микроавтобус");
        System.out.println("другой выбор - без транспорта");

        System.out.println("\n\t\tТип путевки");
        System.out.println("1 - отдых");
        System.out.println("2 - экскурсии");
        System.out.println("3 - лечение");
        System.out.println("4 - шопинг");
        System.out.println("5 - круиз");
        System.out.println("другой выбор - смешанный тип");

        System.out.println("\n***************************************************************************");
    }
}
