package by.epam.course.basic.cycle;

import java.math.BigInteger;

/*
    Находит произведение квадратов первых двухсот чисел
 */

public class Cycle4 {

    public static void main(String[] args) {
        BigInteger mul=BigInteger.valueOf(1);
        for(int i=1;i<=200;i++) {
            mul=mul.multiply(BigInteger.valueOf(i*i));
        }

        System.out.println("Произведение квадратов первых 200 чисел равнв "+mul);
    }
}
