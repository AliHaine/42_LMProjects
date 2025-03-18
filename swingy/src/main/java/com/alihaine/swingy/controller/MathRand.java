package com.alihaine.swingy.controller;

import java.util.Random;

public class MathRand {


    private static final Random random = new Random();

    public static int getRandom(int bound) {
        return random.nextInt(bound);
    }

    public static boolean getBoolRand() {
        return random.nextBoolean();
    }
}
