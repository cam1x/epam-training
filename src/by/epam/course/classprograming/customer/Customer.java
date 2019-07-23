package by.epam.course.classprograming.customer;

/*
    Класс покупатель.
    Возможности:
    1) Изменение всех полей класса
    2) Получение всех полей класса через get-
    P.S.По умолчанию id-пользователя - его порядковый номер.
    При желании id-пользователя может быть изменено на произвольное допустимое значение.
 */

public class Customer {

    private static int idCounter;

    private int id;
    private String surname;
    private String name;
    private String patronymic;
    private String adress;
    private int creditCard;
    private int bankAccount;

    public Customer(){

        surname=name=patronymic=adress="not defined";
        id=++idCounter;
    }

    public Customer(int id,String surname,String name,String patronymic,String adress,int creditCard,int bankAccount){

        setId(id);
        setSurname(surname);
        setName(name);
        setPatronymic(patronymic);
        setAdress(adress);
        setCreditCard(creditCard);
        setBankAccount(bankAccount);
    }

    public Customer(String surname,String name,String patronymic,String adress,int creditCard,int bankAccount){

        setSurname(surname);
        setName(name);
        setPatronymic(patronymic);
        setAdress(adress);
        setCreditCard(creditCard);
        setBankAccount(bankAccount);
    }

    public void copyCustomer(Customer customer){

        setSurname(customer.surname);
        setName(customer.name);
        setPatronymic(customer.patronymic);
        setAdress(customer.adress);
        setCreditCard(customer.creditCard);
        setBankAccount(customer.bankAccount);
    }

    public int getId(){

        return id;
    }

    public String getSurname(){

        return surname;
    }

    public String getName(){

        return name;
    }

    public String getPatronymic(){

        return patronymic;
    }

    public String getAdress(){

        return adress;
    }

    public int getCreditCard(){

        return creditCard;
    }

    public int getBankAccount(){

        return bankAccount;
    }

    public void setId(int id){

        if(id>0) {
            this.id = id;
        }
    }

    public void setSurname(String surname){

        if(surname!=null && !surname.isEmpty()) {
            this.surname = surname;
        }
    }

    public void setName(String name){

        if(name!=null && !name.isEmpty()) {
            this.name = name;
        }
    }

    public void setPatronymic(String patronymic){

        if(patronymic!=null && !patronymic.isEmpty()) {
            this.patronymic = patronymic;
        }
    }

    public void setAdress(String adress){

        if(adress!=null && !adress.isEmpty()) {
            this.adress = adress;
        }
    }

    public void setCreditCard(int creditCard){

        if(creditCard>0) {
            this.creditCard = creditCard;
        }
    }

    public void setBankAccount(int bankAccount){

        if(bankAccount>0) {
            this.bankAccount = bankAccount;
        }
    }

    @Override
    public String toString(){

        String string = String.format("%5s %15s %15s %15s %15s %10s %10s", Integer.toString(id), surname, name, patronymic, adress,
                Integer.toString(creditCard), Integer.toString(bankAccount));
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

        Customer customer=(Customer) obj;

        boolean isTheSamePerson= name.equals(customer.name) && surname.equals(customer.surname) && patronymic.equals(customer.patronymic);
        return isTheSamePerson && adress.equals(customer.adress);
    }

    @Override
    public int hashCode(){

        final int prime=31;
        int result=1;

        result=prime*result+((name==null)?0:name.hashCode());
        result=prime*result+((surname==null)?0:surname.hashCode());
        result=prime*result+((patronymic==null)?0:patronymic.hashCode());
        result=prime*result+((adress==null)?0:adress.hashCode());
        result=prime*result+creditCard;
        result=prime*result+bankAccount;

        return result;
    }
}
