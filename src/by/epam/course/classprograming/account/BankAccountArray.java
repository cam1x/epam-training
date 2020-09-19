package by.epam.course.classprograming.account;

/*
    Коллекция(массив) счетов.
    Возможности:
    1) (раз)блокировка всех/отдельных счетов
    2) сортировка счетов по различным параметрами
    3) поиск счета
    4) получение общего баланса
    5) получение общего полож/отриц баланса
    6) добавление/удаление счетов
    7) депозит/снятие денег на/со счета(-а)
 */

public class BankAccountArray {
    private BankAccount[] arrOfAccounts;

    public BankAccountArray(int size) {
        if (size > 0) {
            arrOfAccounts = new BankAccount[size];
            for (int i = 0; i < size; i++) {

                arrOfAccounts[i] = new BankAccount();
            }
        }
    }

    public BankAccountArray(BankAccount[] array) {
        setArrOfAccounts(array);
    }

    public int getSize() {
        return arrOfAccounts.length;
    }

    public BankAccount[] getArrOfAccounts() {
        return arrOfAccounts;
    }

    public void setArrOfAccounts(BankAccount[] array) {
        if (array != null) {
            arrOfAccounts = new BankAccount[array.length];
            System.arraycopy(array, 0, arrOfAccounts, 0, array.length);
        }
    }

    public BankAccount getBankAccount(int index) {
        if (index >= 0 && index < getSize()) {
            return arrOfAccounts[index];
        } else {
            throw new IllegalArgumentException("Выход за пределы массива!");
        }
    }

    //Заблокировать все счета
    public void blockAll() {
        for (BankAccount account : arrOfAccounts) {
            account.block();
        }
    }

    //Заблокировать счет с индексом index
    public void block(int index) {
        if (index >= 0 && index < getSize()) {
            arrOfAccounts[index].block();
        }
    }

    //Разблокировать все счета
    public void unlockAll() {
        for (BankAccount account : arrOfAccounts) {
            account.unlock();
        }
    }

    //Разблокировать счет с индексом index
    public void unlock(int index) {
        if (index >= 0 && index < getSize()) {
            arrOfAccounts[index].unlock();
        }
    }

    public double getTotalBalance() {
        double total = 0;
        for (BankAccount account : arrOfAccounts) {
            total += account.getBalance();
        }
        return total;
    }

    public double getTotalNegativeBalance() {
        double total = 0;
        for (BankAccount account : arrOfAccounts) {
            if (account.hasNegativeBalance()) {
                total += account.getBalance();
            }
        }
        return total;
    }

    public double getTotalPositiveBalance() {
        double total = 0;
        for (BankAccount account : arrOfAccounts) {
            if (account.hasPositiveBalance()) {
                total += account.getBalance();
            }
        }
        return total;
    }

    //Сортировка по балансу, если баланс равен, то сортируется по имени счета
    public void sortByBalance() {
        for (int i = 0; i < getSize() - 1; i++) {
            for (int j = 0; j < getSize() - i - 1; j++) {
                if (arrOfAccounts[j].getBalance() > arrOfAccounts[j + 1].getBalance()) {
                    swap(j, j + 1);
                } else {
                    if (arrOfAccounts[j].getBalance() == arrOfAccounts[j + 1].getBalance()) {
                        if (arrOfAccounts[j].getName().compareTo(arrOfAccounts[j + 1].getName()) > 0) {
                            swap(j, j + 1);
                        }
                    }
                }
            }
        }
    }

    //Сортировка по имени счета, если имена счетов совпадают, то сортируется по балансу
    public void sortByName() {
        int time;

        for (int i = 0; i < getSize() - 1; i++) {
            for (int j = 0; j < getSize() - i - 1; j++) {
                time = arrOfAccounts[j].getName().compareTo(arrOfAccounts[j + 1].getName());
                if (time > 0) {
                    swap(j, j + 1);
                } else {
                    if (time == 0) {
                        if (arrOfAccounts[j].getBalance() > arrOfAccounts[j + 1].getBalance()) {
                            swap(j, j + 1);
                        }
                    }
                }
            }
        }
    }


    //Поиск счетов по имени.
    // Если счет не найден, то возвращает массив счетов, состоящий из одного элемента с особой пометкой not defined
    public BankAccountArray find(String name) {
        int num = 0;

        for (BankAccount account : arrOfAccounts) {
            if (account.getName().equals(name)) {
                num++;
            }
        }

        if (num > 0) {
            BankAccount[] newAccounts = new BankAccount[num];

            for (int i = 0, index = 0; i < getSize(); i++) {
                if (arrOfAccounts[i].getName().equals(name)) {
                    newAccounts[index] = arrOfAccounts[i];
                    index++;
                }
            }
            return new BankAccountArray(newAccounts);

        } else {
            return returnZero();
        }
    }

    //Поиск счетов по балансу.
    // Если счет не найден, то возвращает массив счетов, состоящий из одного элемента с особой пометкой not defined
    public BankAccountArray find(double balance) {
        int num = 0;

        for (BankAccount account : arrOfAccounts) {
            if (account.getBalance() == balance) {
                num++;
            }
        }

        if (num > 0) {
            BankAccount[] newAccounts = new BankAccount[num];
            for (int i = 0, index = 0; i < getSize(); i++) {
                if (arrOfAccounts[i].getBalance() == balance) {
                    newAccounts[index] = arrOfAccounts[i];
                    index++;
                }
            }
            return new BankAccountArray(newAccounts);

        } else {
            return returnZero();
        }
    }

    //Поиск счетов по имени и балансу одновременно.
    // Если счет не найден, то возвращает массив счетов, состоящий из одного элемента с особой пометкой not defined
    public BankAccountArray find(String name, double balance) {
        int num = 0;

        for (BankAccount account : arrOfAccounts) {
            if (account.getName().equals(name) && account.getBalance() == balance) {
                num++;
            }
        }

        if (num > 0) {
            BankAccount[] newAccounts = new BankAccount[num];
            for (int i = 0, index = 0; i < getSize(); i++) {
                if (arrOfAccounts[i].getName().equals(name) && arrOfAccounts[i].getBalance() == balance) {
                    newAccounts[index] = arrOfAccounts[i];
                    index++;
                }
            }
            return new BankAccountArray(newAccounts);

        } else {
            return returnZero();
        }
    }

    //Добавить счет
    public void addBankAccount(String name, double deposit) {
        BankAccount[] newAccounts = new BankAccount[getSize() + 1];

        if (getSize() >= 0) System.arraycopy(arrOfAccounts, 0, newAccounts, 0, getSize());

        newAccounts[getSize()] = new BankAccount(name, deposit);
        arrOfAccounts = newAccounts;
    }

    //Удалить счет
    public void deleteBankAccount(String name) {
        int numOfAccounts = getSize();

        for (BankAccount account : arrOfAccounts) {
            if (account.getName().equals(name)) {
                numOfAccounts--;
            }
        }

        if (numOfAccounts < getSize()) {
            BankAccount[] newAccounts = new BankAccount[numOfAccounts];
            for (int i = 0, index = 0; i < getSize(); i++) {
                if (!arrOfAccounts[i].getName().equals(name)) {
                    newAccounts[index] = arrOfAccounts[i];
                    index++;
                }
            }

            arrOfAccounts = newAccounts;
        }

    }

    //Вывод денег со счета с индексом index
    public void withdrawMoney(double money, int indexOfAccount) {
        if (indexOfAccount >= 0 && indexOfAccount < getSize()) {
            arrOfAccounts[indexOfAccount].withdrawMoney(money);
        }
    }

    //Депозит на счет с индексом index
    public void depositMoney(double money, int indexOfAccount) {
        if (indexOfAccount >= 0 && indexOfAccount < getSize()) {
            arrOfAccounts[indexOfAccount].depositMoney(money);
        }
    }

    public void print() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (BankAccount account : arrOfAccounts) {
            string.append(account.toString()).append("\n");
        }
        return string.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        BankAccountArray other = (BankAccountArray) obj;
        boolean isEqual = true;

        for (int i = 0; i < getSize(); i++) {
            if (!arrOfAccounts[i].equals(other.arrOfAccounts[i])) {
                isEqual = false;
                break;
            }
        }

        return isEqual;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        for (int i = 0; i < getSize(); i++) {
            result = prime * result + arrOfAccounts[i].hashCode();
        }

        return result;
    }

    private void swap(int index1, int index2) {
        if (index1 >= 0 && index1 < getSize() && index2 >= 0 && index2 < getSize()) {
            BankAccount time = arrOfAccounts[index1];
            arrOfAccounts[index1] = arrOfAccounts[index2];
            arrOfAccounts[index2] = time;
        }
    }

    //Возвращает массив счетов, состоящий из одного элемента с особой пометкой not defined
    private BankAccountArray returnZero() {
        BankAccount[] zeroAccounts = new BankAccount[1];
        zeroAccounts[0] = new BankAccount();
        zeroAccounts[0].setName("not defined");
        return new BankAccountArray(zeroAccounts);
    }
}
