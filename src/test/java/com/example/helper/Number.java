package com.example.helper;

import java.util.Random;

/**
 * Created by internship on 16.09.2016.
 */
public class Number {
    public static int generateRandomNumber() {
        Random rand = new Random();
        int value = rand.nextInt(20) + 1;
        return value;
    }
}
