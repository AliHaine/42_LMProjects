package com.alihaine.avaj;

import java.io.File;

public class FileManager {

    private File scenario;
    private File simulation;

    public FileManager(String scenarioFileName) {
        try {
            scenario = new File(scenarioFileName);
            if (!scenario.exists() || !scenario.canRead() || scenario.isDirectory())
                throw new CustomExceptions("File exception");
        } catch (CustomExceptions e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void scenarioFileSetup() {

    }
}
