package by.epam.course.classprograming.account;

import java.util.*;

public class BankAccountTest {

    public static void input(BankAccountArray array){
        try{
            Scanner scanner=new Scanner(System.in);
            BankAccount account;

            System.out.println("\nВведите информацию по шаблону:");
            System.out.println("\nИмя счета Баланс");

            for(int i=0;i<array.getSize();i++) {
                account=array.getBankAccount(i);
                account.setName(scanner.next());
                account.setBalance(scanner.nextDouble());
            }

        }catch (InputMismatchException ex){
            System.out.println("\n Ошибка ввода! "+ex.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            BankAccountArray accounts = new BankAccountArray(2);
            System.out.println("Введите информация для 2-ух счетов");
            input(accounts);
            int choice = 1;
            Scanner scanner = new Scanner(System.in);

            while (choice != 0) {

                System.out.println("Введите 0 для завершения программы");
                System.out.println("Введите 1 для добавления счета");
                System.out.println("Введите 2 для удаления счета");
                System.out.println("Введите 3 для блокировки счета");
                System.out.println("Введите 4 для разблокировки счета");
                System.out.println("Введите 5 для сортировки счетов по имени счета");
                System.out.println("Введите 6 для сортировки счетов по балансу");
                System.out.println("Введите 7 для поиска счета по имени");
                System.out.println("Введите 8 для поиска счета по балансу");
                System.out.println("Введите 9 для поиска счета по имени и балансу одновременно");
                System.out.println("Введите 10 для получения общего баланса");
                System.out.println("Введите 11 для получения общего положительного баланса");
                System.out.println("Введите 12 для получения общего отрицательного баланса");
                System.out.println("Введите 13 для депозита денег на счет");
                System.out.println("Введите 14 для снятия денег со счета");
                System.out.println("Введите 15 для вывода информации о счетах");

                choice = scanner.nextInt();

                switch (choice) {

                    case 1: {
                        System.out.println("\nВведите имя и баланс нового счета");
                        accounts.addBankAccount(scanner.next(), scanner.nextDouble());
                        break;
                    }

                    case 2: {
                        System.out.println("\nВведите имя счета");
                        accounts.deleteBankAccount(scanner.next());
                        break;
                    }

                    case 3: {
                        System.out.println("\nВведите номер счета для блокировки");
                        accounts.block(scanner.nextInt() - 1);
                        break;
                    }

                    case 4: {
                        System.out.println("\nВведите номер счета для блокировки");
                        accounts.unlock(scanner.nextInt() - 1);
                        break;
                    }

                    case 5: {
                        accounts.sortByName();
                        break;
                    }

                    case 6: {
                        accounts.sortByBalance();
                        break;
                    }

                    case 7: {
                        System.out.println("\nВведите имя счета для поиска");
                        BankAccountArray newAcc1 = accounts.find(scanner.next());
                        newAcc1.print();
                        break;
                    }

                    case 8: {
                        System.out.println("\nВведите баланс счета для поиска");
                        BankAccountArray newAcc2 = accounts.find(scanner.nextDouble());
                        newAcc2.print();
                        break;
                    }

                    case 9: {
                        System.out.println("\nВведите имя и баланс счета для поиска");
                        BankAccountArray newAcc3 = accounts.find(scanner.next(), scanner.nextDouble());
                        newAcc3.print();
                        break;
                    }

                    case 10: {
                        System.out.println("\nОбщий баланс = " + accounts.getTotalBalance());
                        break;
                    }

                    case 11: {
                        System.out.println("\nОбщий положительный баланс = " + accounts.getTotalPositiveBalance());
                        break;
                    }

                    case 12: {
                        System.out.println("\nОбщий отрицательный баланс = " + accounts.getTotalNegativeBalance());
                        break;
                    }

                    case 13: {
                        System.out.println("\nВведите сумму и номер счета для депозита (в указанном порядке)");
                        accounts.depositMoney(scanner.nextDouble(), scanner.nextInt()-1);
                        break;
                    }

                    case 14: {
                        System.out.println("\nВведите сумму и номер счета для снятия денег (в указанном порядке)");
                        accounts.withdrawMoney(scanner.nextDouble(), scanner.nextInt()-1);
                        break;
                    }

                    case 15: {
                        System.out.println();
                        accounts.print();
                        break;
                    }
                }
            }

        } catch(InputMismatchException ex){
            System.out.println("\nОшибка ввода! "+ex.getMessage());
        }
    }
}
