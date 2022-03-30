package com.rp.sec01;

import com.github.javafaker.Faker;

public class FakerDemo {

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {

            String NomeFake = Faker.instance().name().fullName();
            System.out.println(NomeFake);
        }
    }
}
