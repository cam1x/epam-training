package by.epam.course.oopbasic.flower;

/*
    Фабрика по производству цветов
 */

public class FlowerFactory {

    public Flower getFlower(FlowerTypes type){
        Flower toReturn=null;
        switch (type){
            case ROSE:{
                toReturn=new Rose();
                break;
            }

            case LILY:{
                toReturn=new Lily();
                break;
            }

            case TULIP:{
                toReturn=new Tulip();
                break;
            }
        }

        return toReturn;
    }

    public Flower getFlower(FlowerTypes type,String color, double price){
        Flower toReturn=getFlower(type);

        if(toReturn!=null){
            toReturn.setColor(color);
            toReturn.setPrice(price);
        }

        return toReturn;
    }
}
