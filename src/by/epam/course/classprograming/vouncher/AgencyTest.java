package by.epam.course.classprograming.vouncher;

import java.util.*;

public class AgencyTest {

    public static void input(TravelAgency offers){

        try {
            Scanner scanner = new Scanner(System.in);
            TravelVouncher vouncher;

            System.out.println("\nВведите коды из информационное бюллютени для типа, еды и транспорта в указанном порядке, а также кол-во дней и цену");
            for (int i = 0; i < offers.getNumOfVounchers(); i++) {
                vouncher = offers.getVouncher(i);

                vouncher.setType(scanner.nextInt());
                vouncher.setFood(scanner.nextInt());
                vouncher.setTransport(scanner.nextInt());
                vouncher.setNumOfDays(scanner.nextInt());
                vouncher.setCost(scanner.nextDouble());
            }

        } catch (InputMismatchException ex){
            System.out.println("Ошибка ввода! "+ex.getMessage());
        }
    }

    public static void main(String[] args) {

        TravelVouncher.info();

        try {
            Scanner scanner = new Scanner(System.in);

            TravelAgency agency = new TravelAgency(1);
            input(agency);

            int choice = 1;
            int extraChoice;

            while (choice != 0) {
                System.out.println("Введите 0 для выхода из агенства");
                System.out.println("Введите 1, чтобы добавить путевку");
                System.out.println("Введите 2, чтобы удалить путевку");
                System.out.println("Введите 3, чтобы выбрать путевку");
                System.out.println("Введите 4, чтобы найти путевку");
                System.out.println("Введите 5, чтобы отсортировать путевки по цене");
                System.out.println("Введите 6, чтобы отсортировать путевки по типу");
                System.out.println("Введите 7, чтобы отобразить выбранные путевки");
                System.out.println("Введите 8, чтобы отобразить все добавленные предложения");

                choice = scanner.nextInt();

                switch (choice) {
                    case 1: {
                        System.out.println("\nВведите коды из информационное бюллютени для типа, еды и транспорта в указанном порядке, а также кол-во дней и цену");
                        agency.addVouncher(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextDouble());
                        break;
                    }

                    case 2: {
                        System.out.println("\nВведите 1 для удаления путевок дороже указанной цены");
                        System.out.println("Введиет 2 для удаления путевки по ее порядковому номеру");
                        extraChoice = scanner.nextInt();

                        switch (extraChoice) {
                            case 1: {
                                System.out.println("\nВведите цену");
                                agency.deleteVouncher(scanner.nextDouble());
                                break;
                            }

                            case 2: {
                                System.out.println("\nВведите номер путевки");
                                agency.deleteVouncher(scanner.nextInt() - 1);
                                break;
                            }
                        }
                        break;
                    }

                    case 3: {
                        System.out.println("\nВведите номер путевки для выбора");
                        agency.selectVouncher(scanner.nextInt() - 1);
                        break;
                    }

                    case 4: {
                        System.out.println("\nВведите номер путевки");
                        agency.getVouncher(scanner.nextInt() - 1).print();
                        break;
                    }

                    case 5: {
                        agency.sortByPrice();
                        break;
                    }

                    case 6: {
                        agency.sortByType();
                        break;
                    }

                    case 7:{
                        agency.printSelected();
                        break;
                    }

                    case 8: {
                        agency.print();
                        break;
                    }
                }
            }

        }catch (InputMismatchException ex){
            System.out.println(ex.getMessage());
        }
    }
}
