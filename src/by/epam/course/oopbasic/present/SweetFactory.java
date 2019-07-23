package by.epam.course.oopbasic.present;

/*
    Фабрика по производству сладостей
 */

public class SweetFactory {

    public Sweet getSweet(SweetTypes type){

        Sweet toReturn=null;
        switch (type){
            case CANDY:{
                toReturn=new Candy();
                break;
            }

            case CHOCOLATE:{
                toReturn=new Chocolate();
                break;
            }

            case MARMALADE:{
                toReturn=new Marmalade();
                break;
            }
        }
        return toReturn;
    }

    public Sweet getSweet(SweetTypes type,double weight, double price){

        Sweet toReturn=getSweet(type);

        if(toReturn!=null){
            toReturn.setWeight(weight);
            toReturn.setPrice(price);
        }

        return toReturn;
    }
}
