package by.epam.course.classprograming.account;

/*
    Класс для представления банковского счета.
    Возможности:
    1) изменение имени, баланса счета
    2) (раз)блокировка счета
    3) депозит на счет
    4) снятие денег со счета
    5) проверка на полож/отриц баланс
    6) вывод информации на консоль
 */

public class BankAccount {

    private double balance;
    private boolean isBlocked;
    private String name="New account";

    public BankAccount(){

    }

    public BankAccount(double balance){

        setBalance(balance);
    }

    public BankAccount(String name,double balance){

        setName(name);
        setBalance(balance);
    }

    public void setBalance(double balance){

        this.balance=balance;
    }

    public void setName(String name){

        if(name!=null && !name.isEmpty()) {
            this.name = name;
        }
    }

    public String getName(){

        return name;
    }

    public double getBalance(){

        return balance;
    }

    public void block(){

        isBlocked=true;
    }

    public void unlock(){

        isBlocked=false;
    }

    //Проверяет положителен ли баланск
    public boolean hasPositiveBalance(){

        return balance>0;
    }

    //Проверяет отрицателен ли баланса
    public boolean hasNegativeBalance(){

        return balance<0;
    }

    //Положить деньги на счет
    public void depositMoney(double money){

        if(!isBlocked){
            balance+=money;
        }else{
            System.out.println("\nСчет заблокирован!");
        }
    }

    //Снять деньги со счета
    public void withdrawMoney(double money){

        if(!isBlocked){
            balance-=money;
        }else{
            System.out.println("\nСчет заблокирован!");
        }
    }

    public void print(){

        System.out.println(toString());
    }

    @Override
    public String toString(){

        return String.format("%15s %10s %15s","'"+name+"'",balance, isBlocked?"заблокирован":"разблокирован");
    }

    @Override
    public boolean equals(Object obj){

        if(obj == this){
            return true;
        }

        if(obj==null || obj.getClass() != this.getClass()){
            return false;
        }

        BankAccount other=(BankAccount) obj;

        return name.equals(other.name) && balance==other.balance && isBlocked==other.isBlocked;
    }

    @Override
    public int hashCode(){

        final int prime=31;
        int result=1;

        result=prime*result+((name==null)?0:name.hashCode());
        result=prime*result+Double.hashCode(balance);
        result=prime*result+Boolean.hashCode(isBlocked);

        return result;
    }
}
