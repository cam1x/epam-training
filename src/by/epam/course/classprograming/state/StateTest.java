package by.epam.course.classprograming.state;

import java.util.*;

public class StateTest {

    public static void main(String[] args) {

        try {
            State state = new State("Беларусь", "Минск");
            Scanner scanner = new Scanner(System.in);

            int choice = 1;

            while (choice != 0) {

                System.out.println("Введите 0 для завершения работы");
                System.out.println("Введите 1, чтобы добавить область");
                System.out.println("Введите 2, чтобы удалить область");
                System.out.println("Введите 3, чтобы добавить район");
                System.out.println("Введите 4, чтобы удалить район");
                System.out.println("Введите 5, чтобы добавить город");
                System.out.println("Введите 6, чтобы удалить город");
                System.out.println("Введите 7, чтобы получить список областных центров");
                System.out.println("Введите 8, чтобы узнать площадь гос-ва");
                System.out.println("Введите 9, чтобы установить площаль гос-ва");
                System.out.println("Введите 10, чтобы вывести информацию о гос-ве");

                choice = scanner.nextInt();

                switch (choice) {

                    case 1: {
                        System.out.println("\nВведите область и областной центр");
                        state.addRegion(scanner.next());
                        state.setCenter(scanner.next(),state.getNumOfRegions()-1);
                        break;
                    }

                    case 2: {
                        System.out.println("\nВведите область");
                        state.deleteRegion(scanner.next());
                        break;
                    }

                    case 3: {
                        System.out.println("\nВведите район и номер области, к которому его следует добавить");
                        state.addDistrict(scanner.next(), scanner.nextInt() - 1);
                        break;
                    }

                    case 4: {
                        System.out.println("\nВведите район и номер области, из которого его следует удалить");
                        state.deleteDistrict(scanner.next(), scanner.nextInt() - 1);
                        break;
                    }

                    case 5: {
                        System.out.println("\nВведите город, а также номер области и номер района внутри области, в которых нужно добавить город");
                        state.addCity(scanner.next(), scanner.nextInt() - 1, scanner.nextInt() - 1);
                        break;
                    }

                    case 6: {
                        System.out.println("\nВведите город, а также номер области и номер района внутри области, из которого следует удалить город");
                        state.deleteCity(scanner.next(), (scanner.nextInt() - 1), (scanner.nextInt() - 1));
                        break;
                    }

                    case 7: {
                        System.out.println("\nСписок областных центров:");
                        System.out.println(state.getCenteres()+"\n");
                        break;
                    }

                    case 8: {
                        System.out.println("\nПлощадь гос-ва = " + state.getArea());
                        break;
                    }

                    case 9: {
                        System.out.println("\nВведите площадь гос-ва: ");
                        state.setArea(scanner.nextDouble());
                        break;
                    }

                    case 10: {
                        state.print();
                        break;
                    }
                }
            }

        }catch(InputMismatchException ex){
            System.out.println("\nОшибка ввода!");
        }
    }
}
