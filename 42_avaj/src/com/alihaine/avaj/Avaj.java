package com.alihaine.avaj;

public class Avaj {

    public static FileManager fileManager;

    public static void main(String[] argv) {
        if (argv.length != 1) {
            System.out.println("No arguments given");
            return;
        }
        fileManager = new FileManager(argv[0]);
        try {
            new Simulation();
        } catch (CustomExceptions e) {
            System.out.println(e);
        }
        fileManager.closeFiles();
    }
}
