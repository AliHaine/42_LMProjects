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
            if (!this.scenario.hasNextLine())
                throw new CustomExceptions("File exception with custom exceptions file is empty");
            this.simulation = new FileWriter("simulation.txt");
        } catch (CustomExceptions | IOException e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(2);
        }
    }

    public boolean scenarioHasNextLine() {
        return this.scenario.hasNextLine();
    }

    public String getScenarioNextLine() {
        return this.scenario.nextLine();
    }

    public void writeSimulationLine(String line) {
        try {
            this.simulation.write(line + '\n');
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
