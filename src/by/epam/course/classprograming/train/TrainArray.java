package by.epam.course.classprograming.train;

/*
    Класс для представления коллекции(массива) поездов
    Возможности:
    1) добавить/удалить поезд
    2) сортировка по пункту назначению/номеру
    3) получить поезд по номеру
    4) вывод на консоль
 */

public class TrainArray {

    private Train[] arrOfTrains;

    public TrainArray(int size){
        if(size>0) {
            arrOfTrains = new Train[size];
            for (int i = 0; i < size; i++) {

                arrOfTrains[i] = new Train();
            }

        }else{
            throw new IllegalArgumentException("Размер массива должен быть положительным!");
        }
    }

    public TrainArray(Train[] array){
        setArrOfTrains(array);
    }

    public void setArrOfTrains(Train[] array){
        if(array!=null) {
            arrOfTrains = new Train[array.length];
            for (int i = 0; i < array.length; i++) {
                arrOfTrains[i] = array[i];
            }
        }
    }

    public int getSize(){
        if(arrOfTrains!=null) {
            return arrOfTrains.length;
        } else{
            return 0;
        }
    }

    public Train[] getArrOfTrains(){
        return arrOfTrains;
    }

    public Train getTrain(int index){
        if(index>=0 && index<getSize()){
            return arrOfTrains[index];
        }else{
            throw new IllegalArgumentException("Переданный индекс выходит за пределы массива!");
        }
    }

    //Сортировка поиздов по номеру поезда
    public void sortByNumber(){
        for(int i=0;i<arrOfTrains.length-1;i++){
            for(int j=0;j<arrOfTrains.length-i-1;j++){
                if(arrOfTrains[j].getTrainNumber()>arrOfTrains[j+1].getTrainNumber()){
                    swap(j,j+1);
                }
            }
        }
    }

    //Сортировка поездов по пункту назначения
    public void sortByDestination(){
        int stringCompare;

        for(int i=0;i<arrOfTrains.length-1;i++){
            for(int j=0;j<arrOfTrains.length-i-1;j++){
                stringCompare=arrOfTrains[j].getDestination().compareTo(arrOfTrains[j+1].getDestination());

                if(stringCompare>0){
                    swap(j,j+1);
                }else{
                    if(stringCompare==0){
                        if(isEarlier(j,j+1)){
                            swap(j,j+1);
                        }
                    }
                }
            }
        }
    }

    public void print(){
        System.out.println(toString());
    }

    //Получить информацию по номеру поезда
    public void printInfoByNumber(int number){
        for(int i=0;i<arrOfTrains.length;i++){
            if(arrOfTrains[i].getTrainNumber()==number){
                arrOfTrains[i].print();
            }
        }
    }

    public void addTrain(Train train){
        if(train!=null) {
            Train[] newTrains = new Train[getSize() + 1];

            for (int i = 0; i < getSize(); i++) {
                newTrains[i] = arrOfTrains[i];
            }

            newTrains[getSize()] = train;
            arrOfTrains = newTrains;
        }
    }

    public void deleteTrain(Train train){
        if(train==null){
            throw new IllegalArgumentException("Неверный аргумента (null)!");
        }

        int numOfTrains=getSize();

        for(Train train1: arrOfTrains){
            if(train.equals(train)){
                numOfTrains--;
            }
        }

        if(numOfTrains<getSize()){
            Train[] newTrains=new Train[numOfTrains];
            for(int i=0,index=0;i<getSize();i++){
                if(!arrOfTrains[i].equals(train)){
                    newTrains[index]=arrOfTrains[i];
                    index++;
                }
            }

            arrOfTrains=newTrains;
        }
    }

    public void deleteTrain(int index){
        if(index>=0 && index<getSize()){
            Train[] newTrains=new Train[getSize()-1];

            for(int i=0,j=0;i<getSize();i++){
                if(i!=index){
                    newTrains[j]=arrOfTrains[i];
                    j++;
                }
            }

            arrOfTrains=newTrains;
        }
    }

    @Override
    public String toString(){
        if(arrOfTrains!=null) {
            String string = new String();
            for (Train train : arrOfTrains) {
                string += train.toString() + "\n";
            }
            return string;
        }
        else{
            return "Поезда отсутствуют! ";
        }
    }

    @Override
    public boolean equals(Object obj){
        if(obj == this){
            return true;
        }

        if(obj==null || obj.getClass() != this.getClass()){
            return false;
        }

        TrainArray other=(TrainArray) obj;

        boolean isEqual=other.getSize()==getSize();

        for(int i=0;isEqual && i<getSize();i++){
            if(!arrOfTrains[i].equals(other.arrOfTrains[i])){
                isEqual=false;
            }
        }

        return isEqual;
    }

    @Override
    public int hashCode(){
        final int prime=31;
        int result=1;

        for(int i=0;i<getSize();i++){
            result=result*prime +arrOfTrains[i].hashCode();
        }

        return result;
    }

    //Перестановка двух поездов в массиве поездов
    private void swap(int index1,int index2){
        if(index1>=0 && index1<arrOfTrains.length && index2>=0 && index2<arrOfTrains.length) {
            Train temp;
            temp = arrOfTrains[index1];
            arrOfTrains[index1] = arrOfTrains[index2];
            arrOfTrains[index2] = temp;
        }
    }

    //Проверка раньше ли отправляется поезда с index1, чем поезд с index2
    private boolean isEarlier(int index1,int index2){
        if(index1>0 && index1<arrOfTrains.length && index2>0 && index2<arrOfTrains.length) {
            return arrOfTrains[index1].getTimeOfAppointment().compareTo(arrOfTrains[index2].getTimeOfAppointment()) > 0;
        }else{
            return false;
        }
    }
}
