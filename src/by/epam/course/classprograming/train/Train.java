package by.epam.course.classprograming.train;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
    Класс Train. Возможности:
    1) изменения пункта назначения, номера поезда, времени отпр.
    2) получение информации о поезде
 */

public class Train {
    private String destination;
    private int trainNumber;
    private String timeOfAppointment;

    public Train() {
        destination = "not defined";
        timeOfAppointment = "00:00:00";
    }

    public Train(String destination, int trainNumber, String timeOfAppointment) {
        setDestination(destination);
        setTrainNumber(trainNumber);
        setTimeOfAppointment(timeOfAppointment);
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        if (destination != null && !destination.isEmpty()) {
            this.destination = destination;
        }
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(int trainNumber) {
        if (trainNumber > 0) {
            this.trainNumber = trainNumber;
        }
    }

    public String getTimeOfAppointment() {
        return timeOfAppointment;
    }

    //Время установится только, если в переданной строке верен формат и значение времени
    public void setTimeOfAppointment(String timeOfAppointment) {
        if (timeOfAppointment != null && !timeOfAppointment.isEmpty()) {
            if (isCorrectTime(timeOfAppointment)) {
                this.timeOfAppointment = timeOfAppointment;
            } else {
                this.timeOfAppointment = "00:00";
            }
        }
    }

    public void print() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return String.format("%15s %5s %8s", destination, trainNumber, timeOfAppointment);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Train other = (Train) obj;

        return destination.equals(other.destination) && trainNumber == other.trainNumber &&
                timeOfAppointment.equals(other.timeOfAppointment);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + ((destination == null) ? 0 : destination.hashCode());
        result = prime * result + ((timeOfAppointment == null) ? 0 : timeOfAppointment.hashCode());
        result = prime * result + trainNumber;

        return result;
    }

    private boolean isCorrectTime(String time) {
        Pattern timePat = Pattern.compile("[0-9]{2}[.:-][0-9]{2}");
        Matcher timeMat = timePat.matcher(time);

        if (timeMat.find()) {
            int hours = Integer.parseInt(time.substring(0, 2));
            int mins = Integer.parseInt(time.substring(3, 5));
            return hours >= 0 && hours < 24 && mins >= 0 && mins < 60;
        } else {
            return false;
        }
    }
}
