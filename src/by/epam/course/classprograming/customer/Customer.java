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
    private String address;
    private int creditCard;
    private int bankAccount;

    public Customer() {
        surname = name = patronymic = address = "not defined";
        id = ++idCounter;
    }

    public Customer(int id, String surname, String name, String patronymic,
                    String address, int creditCard, int bankAccount) {
        setId(id);
        setSurname(surname);
        setName(name);
        setPatronymic(patronymic);
        setAddress(address);
        setCreditCard(creditCard);
        setBankAccount(bankAccount);
    }

    public Customer(String surname, String name, String patronymic, String address, int creditCard, int bankAccount) {
        setSurname(surname);
        setName(name);
        setPatronymic(patronymic);
        setAddress(address);
        setCreditCard(creditCard);
        setBankAccount(bankAccount);
    }

    public void copyCustomer(Customer customer) {
        setSurname(customer.surname);
        setName(customer.name);
        setPatronymic(customer.patronymic);
        setAddress(customer.address);
        setCreditCard(customer.creditCard);
        setBankAccount(customer.bankAccount);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        }
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (surname != null && !surname.isEmpty()) {
            this.surname = surname;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        if (patronymic != null && !patronymic.isEmpty()) {
            this.patronymic = patronymic;
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address != null && !address.isEmpty()) {
            this.address = address;
        }
    }

    public int getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(int creditCard) {
        if (creditCard > 0) {
            this.creditCard = creditCard;
        }
    }

    public int getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(int bankAccount) {
        if (bankAccount > 0) {
            this.bankAccount = bankAccount;
        }
    }

    @Override
    public String toString() {
        return String.format("%5s %15s %15s %15s %15s %10s %10s", id, surname, name, patronymic, address,
                creditCard, bankAccount);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Customer customer = (Customer) obj;

        boolean isTheSamePerson = name.equals(customer.name) && surname.equals(customer.surname) && patronymic.equals(customer.patronymic);
        return isTheSamePerson && address.equals(customer.address);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((surname == null) ? 0 : surname.hashCode());
        result = prime * result + ((patronymic == null) ? 0 : patronymic.hashCode());
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        result = prime * result + creditCard;
        result = prime * result + bankAccount;

        return result;
    }
}
