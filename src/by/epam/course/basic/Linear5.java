package by.epam.course.basic;

import java.util.*;

/*
    Представляет длительность времени, указанного в секундах, в часах, минутах и секундах.
    Форма представления: HHч MMмин SSc
 */

public class Linear5 {

    public static String normalizeTime(int seconds){
        int hours=seconds/3600;
        int minutes=(seconds-hours*3600)/60;
        int sec=seconds-hours*3600-minutes*60;

        return hours+"ч "+minutes+"мин "+sec+"с";
    }

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);

            System.out.println("Input time is seconds:");
            int sec = in.nextInt();

            System.out.println(normalizeTime(sec));

        } catch(InputMismatchException ex){
            System.out.println("Input error! "+ex.getMessage());
        }
    }
}