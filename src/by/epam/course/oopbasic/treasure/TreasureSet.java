package by.epam.course.oopbasic.treasure;

/*
Набор сокровищ.
Функционал:
1) добавления сокровища тем или иным образом
2) удаление сокровища из набора
3) выбор сокровища тем или иным образом
4) вывод информации о сокровищах
5) получение самого дорого сокровищ и сокровищ на указанную сумму
6) сортировка сокровищ
 */

import java.io.File;
import java.util.*;

public class TreasureSet {

    private ArrayList<Treasure> treasures=new ArrayList<Treasure>();

    public TreasureSet(){

    }

    public int getSize(){
        return treasures.size();
    }

    public double getTotalPrice(){
        double total=0;

        for(Treasure treasure:treasures){
            total+=treasure.getPrice();
        }

        return (double)Math.round(total*100d)/100d;
    }

    public double getTotalWeight(){
        double total=0;

        for(Treasure treasure:treasures){
            total+=treasure.getWeight();
        }

        return (double)Math.round(total*100d)/100d;
    }

    //Получить самое дорогое сокровище
    public Treasure getTheMostExpensive(){
        if(!treasures.isEmpty()) {
            Treasure theMostExp = treasures.get(0);
            for (Treasure treasure : treasures) {
                if (treasure.getPrice() > theMostExp.getPrice()) {
                    theMostExp = treasure;
                }
            }
            return theMostExp;

        }else{
            return new Treasure("not found",0,0);
        }
    }

    //Получить список выбранных сокровищ
    public TreasureSet getSelected(){
        TreasureSet selected=new TreasureSet();

        for(Treasure treasure:treasures){
            if(treasure.isSelected()){
                selected.addTreasure(treasure);
            }
        }

        return selected;
    }

    //Получить список сокровищ на указанную сумму, отмечая их как выбранным и в исходной коллекции сокровищ
    public TreasureSet getTreasures(double sum){
        TreasureSet selected=new TreasureSet();
        TreasureSet sortedCopy=this;
        sortedCopy.sortTreasures();

        int index=getSize()-1;
        Treasure currTreasure;

        while(sum>0 && index>0){
            currTreasure=treasures.get(index);
            if(currTreasure.getPrice()<=sum){
                selected.addTreasure(currTreasure);
                currTreasure.select();
                sum-=currTreasure.getPrice();
            }
            index--;
        }

        return selected;
    }

    //Сортирует сокровища по цене, если цена одинаковая, то по весу, если вес одинаков, то по названию
    public void sortTreasures(){
        Comparator<Treasure> comparator=Comparator.comparing(Treasure::getPrice);
        comparator=comparator.thenComparing(Treasure::getWeight);
        comparator=comparator.thenComparing(Treasure::getName);
        treasures.sort(comparator);
    }

    //Добавляет сокровища с текстового файла с путем path.
    public void addTreasure(String path){
        try {
            File file = new File(path);
            Scanner fileScan = new Scanner(file);
            Scanner stringScan;

            String currLine;

            while(fileScan.hasNextLine() &&(currLine=fileScan.nextLine())!=null){
                stringScan=new Scanner(currLine);
                stringScan.useDelimiter(";");
                treasures.add(new Treasure(stringScan.next().trim(),Double.parseDouble(stringScan.next().trim()),Double.parseDouble(stringScan.next().trim())));
                stringScan.close();
            }
            fileScan.close();

        } catch(Exception ex){
            System.out.println("\n"+ex.getMessage());
        }
    }

    public void addTreasure(String name,double weight,double price){
        treasures.add(new Treasure(name,weight,price));
    }

    public void addTreasure(Treasure treasure){
        treasures.add(treasure);
    }

    public void deleteTreasure(int index){
        if(index>=0 && index<treasures.size()){
            treasures.remove(index);
        }
    }

    public void deleteTreasure(String name,double weight,double price){
        treasures.remove(new Treasure(name,weight,price));
    }

    public boolean isEmpty(){
        return treasures.isEmpty();
    }

    // Выбрать сокровище по индексу
    public void selectTreasure(int index){
        if(index>=0 && index<treasures.size()){
            treasures.get(index).select();
        }
    }

    //Выбрать самое дорогое сокровище
    public void selectTheMostExpensive(){
        getTheMostExpensive().select();
    }

    public void print(){
        System.out.println(toString());
        System.out.println("\nИтого: стоимость "+getTotalPrice()+", вес "+getTotalWeight()+"\n");
    }

    @Override
    public String toString(){
        String string=new String();

        for(int i=0;i<treasures.size();i++){
            string+=(i+1)+treasures.get(i).toString()+"\n";
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

        TreasureSet other=(TreasureSet) obj;

        boolean isEqual=(getSize()==other.getSize());

        for(int i=0;isEqual && i<getSize();i++){
            if(!treasures.get(i).equals(other.treasures.get(i))){
                isEqual=false;
            }
        }

        return isEqual;
    }

    @Override
    public int hashCode(){
        final int prime=31;
        int result=1;

        for(Treasure treasure:treasures){
            result=prime*result+treasure.hashCode();
        }

        return result;
    }
}
