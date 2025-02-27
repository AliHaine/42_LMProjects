package com.alihaine.avaj;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileManager {

    private Scanner scenario;
    private FileWriter simulation;

    public FileManager(String scenarioFileName) {
        try {
            File file = new File(scenarioFileName);
            if (!file.exists() || !file.canRead() || file.isDirectory())
                throw new CustomExceptions("File exception with custom exceptions sys.");
            this.scenario = new Scanner(file);
            this.simulation = new FileWriter("simulation.txt");
        } catch (CustomExceptions | IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public boolean scenarioHasNextLine() {
        return this.scenario.hasNextLine();
    }

    public String getScenarioNextLine() {
        String line = this.scenario.nextLine();
        System.out.println(line);
        return line;
    }

    public void writeSimulationLine(String line) {
        try {
            this.simulation.write(line);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void closeFiles() {
        this.scenario.close();
        try {
            this.simulation.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
