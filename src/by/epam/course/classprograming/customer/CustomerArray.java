package by.epam.course.classprograming.customer;

/*
    Коллекция(массив) покупателей.
    Возможности:
    1) удаление/добавление покупателя
    2) сортировка
    3) поиск по номеру кредитной карты
    4) вывод на консоль
 */

public class CustomerArray {

    private Customer[] arrOfCustomers;

    public CustomerArray(int size){
        if(size>0) {
            arrOfCustomers = new Customer[size];
            for (int i = 0; i < size; i++) {
                arrOfCustomers[i] = new Customer();
            }
        }
    }

    public CustomerArray(Customer[] array){
        setArrOfCustomers(array);
    }

    public void setArrOfCustomers(Customer[] array){
        if(array!=null) {
            arrOfCustomers = new Customer[array.length];
            for (int i = 0; i < array.length; i++) {
                arrOfCustomers[i] = array[i];
            }
        }
    }

    public Customer[] getArrOfCustomers(){
        return arrOfCustomers;
    }

    public Customer getCustomer(int index){
        if(index>=0 && index<getSize()){
            return arrOfCustomers[index];
        }else{
            throw new IllegalArgumentException("Индекс выходит за пределы массива!");
        }
    }

    public int getSize(){
        if(arrOfCustomers!=null) {
            return arrOfCustomers.length;
        } else{
            return 0;
        }
    }

    public void print(){
        System.out.println(toString());
    }

    public void addCustomer(Customer customer){
        if(customer!=null) {
            Customer[] newCustomers = new Customer[getSize() + 1];
            for (int i = 0; i < getSize(); i++) {
                newCustomers[i] = arrOfCustomers[i];
            }

            newCustomers[getSize()] = customer;
            arrOfCustomers = newCustomers;
        }
    }

    public void deleteCustomer(Customer customer){
        if(customer==null){
            throw new IllegalArgumentException("Неверный аргумент (null)!");
        }

        int numOfCustomers=getSize();

        for(Customer customer1: arrOfCustomers){
            if(customer1.equals(customer)){
                numOfCustomers--;
            }
        }

        if(numOfCustomers<getSize()){
            Customer[] newCustomers=new Customer[numOfCustomers];

            for(int i=0,index=0;i<getSize();i++){
                if(!arrOfCustomers[i].equals(customer)){
                    newCustomers[index]=arrOfCustomers[i];
                    index++;
                }
            }

            arrOfCustomers=newCustomers;
        }
    }

    public void deleteCustomer(int index){
        if(index>=0 && index<getSize()){
            Customer[] newCustomers=new Customer[getSize()-1];
            for(int i=0,j=0;i<getSize();i++){
                if(i!=index){
                    newCustomers[j]=arrOfCustomers[i];
                    j++;
                }
            }

            arrOfCustomers=newCustomers;
        }
    }

    /*
    Отсортировать покупателей в алфавитном порядке.
     */
    public void sortAlphabet(){
        if(arrOfCustomers==null){
            throw new IllegalArgumentException("Покупатели отсутствуют! (null)");
        }

        String customer1="";
        String customer2="";

        for(int i=0;i<arrOfCustomers.length-1;i++){
            for(int j=0;j<arrOfCustomers.length-i-1;j++){
                customer1+=arrOfCustomers[j].getSurname()+arrOfCustomers[j].getName()+arrOfCustomers[j].getPatronymic();
                customer2+=arrOfCustomers[j+1].getSurname()+arrOfCustomers[j+1].getName()+arrOfCustomers[j+1].getPatronymic();
                if(customer1.compareTo(customer2)>0){

                    swap(j,j+1);
                }
            }
        }
    }

    /*
    Получить покупателей по номеру кредитной карты.
    Если таковые отсутствуют, то возвращается массив, состоящий из одного элемента, в котором значения всех полей установлены по умолчанию.
     */
    public CustomerArray getCustombersByCredit(int startOfMerge,int endOfMerge) {
        if(arrOfCustomers==null){
            throw new IllegalArgumentException("Покупатели отсутствуют! (null)");
        }

        int numOfCustomers=0;

        for(Customer customer: arrOfCustomers){

            if(customer.getCreditCard()>=startOfMerge && customer.getCreditCard()<=endOfMerge){
                numOfCustomers++;
            }
        }

        if(numOfCustomers>0){

            Customer[] customers=new Customer[numOfCustomers];

            int index=0;
            for(Customer customer: arrOfCustomers){
                if(customer.getCreditCard()>=startOfMerge && customer.getCreditCard()<=endOfMerge){
                    customers[index]=customer;
                    index++;
                }
            }

            return new CustomerArray(customers);
        }else{
            Customer[] zeroCustomers=new Customer[1];
            zeroCustomers[0]=new Customer();

            return new CustomerArray(zeroCustomers);
        }
    }

    @Override
    public String toString(){
        if(arrOfCustomers!=null) {
            String res = new String();
            for (Customer customer : arrOfCustomers) {
                res += customer.toString() + "\n";
            }

            return res;

        } else{
            return "Покупатели отсутствуют!";
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

        CustomerArray other=(CustomerArray) obj;

        boolean isEqual=other.getSize()==getSize();

        for(int i=0;isEqual && i<getSize();i++){
            if(!arrOfCustomers[i].equals(other.getArrOfCustomers()[i])){
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
            result=result*prime +arrOfCustomers[i].hashCode();
        }

        return result;
    }

    //Меняет местами два элемента массива покупателей
    private void swap(int index1,int index2){
        if(index1>=0 && index1<arrOfCustomers.length && index2>=0 && index2< arrOfCustomers.length) {
            Customer time = arrOfCustomers[index1];
            arrOfCustomers[index1] = arrOfCustomers[index2];
            arrOfCustomers[index2] = time;
        }
    }
}
