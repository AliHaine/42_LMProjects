package com.alihaine.avaj;

import java.io.File;

public class Avaj {

    private static FileManager fileManager;

    public static void main(String[] argv) {
        if (argv.length != 1) {
            System.out.println("No arguments given");
            return;
        }
        fileManager = new FileManager(argv[0]);
    }
}
