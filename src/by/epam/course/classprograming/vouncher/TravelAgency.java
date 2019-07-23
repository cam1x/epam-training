package by.epam.course.classprograming.vouncher;

/*
    Коллекция(массив) путевок
    Возможности:
    1) добавление/удаление путевки
    2) поиск путевки
    3) выбор/отмена путевки
    4) сортировка путевок по различным полям
    5) вывод на консоль
 */

public class TravelAgency {

    private TravelVouncher[] offers;

    public TravelAgency(int number){
        if(number>0) {
            offers = new TravelVouncher[number];
            for (int i = 0; i < number; i++) {
                offers[i] = new TravelVouncher();
            }
        }
    }

    public TravelAgency(TravelVouncher[] array){
        setOffers(array);
    }

    public void setOffers(TravelVouncher[] array){
        if(array!=null) {
            offers = new TravelVouncher[array.length];
            for (int i = 0; i < array.length; i++) {
                offers[i] = array[i];
            }
        }
    }

    public int getNumOfVounchers(){
        return offers.length;
    }

    public TravelVouncher[] getOffers(){
        return offers;
    }

    public TravelVouncher getVouncher(int index){
        if(index>=0 && index<getNumOfVounchers()){
            return offers[index];
        }else{
            throw new IllegalArgumentException("Выход за пределы массива!");
        }
    }


    public void addVouncher(int typeChoise,int foodChoice,int transportChoice,int numOfDays,double cost){
        TravelVouncher[] newVounchers=new TravelVouncher[getNumOfVounchers()+1];
        for(int i=0;i<getNumOfVounchers();i++){
            newVounchers[i]=offers[i];
        }

        newVounchers[getNumOfVounchers()]=new TravelVouncher(typeChoise,foodChoice,transportChoice,numOfDays,cost);
        offers=newVounchers;
    }

    public void deleteVouncher(double cost){
        int numOfVounchers=getNumOfVounchers();

        for(TravelVouncher vouncher: offers){
            if(vouncher.getCost()>cost){
                numOfVounchers--;
            }
        }

        if(numOfVounchers<getNumOfVounchers()){
            TravelVouncher[] newVounchers=new TravelVouncher[numOfVounchers];
            for(int i=0,index=0;i<getNumOfVounchers();i++){
                if(offers[i].getCost()<=cost){
                    newVounchers[index]=offers[i];
                    index++;
                }
            }

            offers=newVounchers;
        }
    }

    public void deleteVouncher(int index){
        if(index>=0 && index<getNumOfVounchers()){
            int numOfVounchers=getNumOfVounchers()-1;
                TravelVouncher[] vounchers = new TravelVouncher[numOfVounchers];
                for(int i=0,j=0;i<getNumOfVounchers();i++){
                    if(i!=index){
                        vounchers[j]=offers[i];
                        j++;
                    }
                }

            offers=vounchers;
        }
    }

    public void selectVouncher(int index){
        if(index>=0 && index<getNumOfVounchers()){
            offers[index].select();
        }
    }

    public void deselectVouncher(int index){
        if(index>=0 && index<getNumOfVounchers()){
            offers[index].deselect();
        }
    }

    //Сортирует путевки по цене. Если цены одинаковы, то сортирует по кол-ву дней
    public void sortByPrice(){
        for(int i=0;i<getNumOfVounchers()-1;i++){
            for(int j=0;j<getNumOfVounchers()-i-1;j++){
                if(offers[j].getCost()>offers[j+1].getCost()){
                    swap(j,j+1);
                }else{
                    if(offers[j+1].getCost()==offers[j].getCost()){
                        if(offers[j].getNumOfDays()>offers[j+1].getNumOfDays()){
                            swap(j,j+1);
                        }
                    }
                }
            }
        }
    }

    //Сортирует по типу путевки. Если тип одинаковый, то сортирует по цене
    public void sortByType(){
        int time;

        for(int i=0;i<getNumOfVounchers()-1;i++){
            for(int j=0;j<getNumOfVounchers()-i-1;j++){
                time=offers[j].getType().compareTo(offers[j+1].getType());
                if(time>0){
                    swap(j,j+1);
                }else{
                    if(time==0){
                        if(offers[j].getCost()>offers[j+1].getCost()){
                            swap(j,j+1);
                        }
                    }
                }
            }
        }
    }

    public void printSelected(){
        int num=0;

        for(int i=0;i<getNumOfVounchers();i++){
            if(offers[i].isSelected()){
                System.out.println((i+1)+offers[i].toString());
                num++;
            }
        }

        if(num>0) {
            System.out.println("Итого выбрано " + num + " путевок");
        }else{
            System.out.println("\nНи одна путевка не выбрана!");
        }
    }

    public void print(){
        System.out.println(toString());
    }

    @Override
    public String toString(){
        String string= new String();

        for(int i=0;i<getNumOfVounchers();i++){
            string+=(i+1)+offers[i].toString()+"\n";
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

        TravelAgency other=(TravelAgency) obj;

        boolean isEqual=getNumOfVounchers()==other.getNumOfVounchers();

        for(int i=0;isEqual && i<getNumOfVounchers();i++){
            if(!offers[i].equals(other.getOffers()[i])){
                isEqual=false;
            }
        }

        return isEqual;
    }

    @Override
    public int hashCode(){
        final int prime=31;
        int result=1;

        for(TravelVouncher vouncher:offers){
            result=prime*result+vouncher.hashCode();
        }

        return result;
    }

    private void swap(int index1,int index2){

        if(index1>=0 && index1<getNumOfVounchers() && index2>=0 && index2<getNumOfVounchers()){
            TravelVouncher time=offers[index1];
            offers[index1]=offers[index2];
            offers[index2]=time;
        }
    }
}
