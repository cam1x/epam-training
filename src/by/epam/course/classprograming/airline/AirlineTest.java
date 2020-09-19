package by.epam.course.classprograming.airline;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AirlineTest {
    public static void input(AirlineArray airlineArray) {
        try {
            Scanner scanner = new Scanner(System.in);
            scanner.useDelimiter(";");

            Airline airline;

            System.out.println("\nВведите информацию по шаблону. Ввод разделителя ; обязателен!");
            System.out.println("\nПоддерживаемые типы самолетов: " + Arrays.toString(Plane.values()));
            System.out.println("\nПункт назначения;\tНомер рейса;\tТип самолета;\tВремя вылета;\tДни недели;");

            for (int i = 0; i < airlineArray.getSize(); i++) {
                airline = airlineArray.getAirline(i);

                airline.setDestination(scanner.next().trim());
                airline.setFlightNumber(Integer.parseInt(scanner.next().trim()));
                airline.setPlaneType(Plane.valueOf(scanner.next().trim().toUpperCase()));
                airline.setTimeOfAppointment(scanner.next().trim());
                airline.setDays(scanner.next().trim());
            }

        } catch (Exception ex) {
            System.out.println("\nОшибка ввода! " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите число авиалиний: ");

            int num = scanner.nextInt();
            if (num > 0) {
                AirlineArray airlineArray = new AirlineArray(num);

                input(airlineArray);

                System.out.println("\nВведите пункт назначения для поиска рейсов");
                AirlineArray flightsToDestination = airlineArray.getFlightsToDestination(scanner.next().trim());
                flightsToDestination.print();

                System.out.println("\nВведите день недели для поиска рейсов");
                AirlineArray flightsOnDay = airlineArray.getFlightsOnDay(scanner.next().trim());
                flightsOnDay.print();

                System.out.println("\nВведите день недели и время для поиска рейсов в заданный день после заданного времени");
                AirlineArray flightsOnDayFromTime = airlineArray.getFlightsOnDay(scanner.next().trim(), scanner.next().trim());
                flightsOnDayFromTime.print();

            } else {
                System.out.println("Число авиалиний должно быть положительным!");
            }

        } catch (InputMismatchException ex) {

            System.out.println("\nОшибка ввода!");
        }
    }
}
