package lib.listeners;

import lib.core.ConfigManager;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class AllureEnvironmentWriter {

    public static void createEnvironmentFile() {
        try {
            String resultsDirectory = System.getProperty("allure.results.directory", "build/allure-results");
            Path environmentFile = Path.of(resultsDirectory, "environment.properties");

            Files.createDirectories(environmentFile.getParent());

            Properties props = new Properties();
            props.setProperty("Platform", ConfigManager.getPlatform());
            props.setProperty("Device Name", ConfigManager.getDeviceName());
            props.setProperty("Platform Version", ConfigManager.getPlatformVersion());

            try (BufferedWriter writer = Files.newBufferedWriter(environmentFile, StandardCharsets.UTF_8)) {
                props.store(writer, "Allure Environment Properties");
            }

            System.out.println("Allure environment file written to: " + environmentFile.toAbsolutePath());

        } catch (IOException e) {
            System.err.println("Failed to write Allure environment file: " + e.getMessage());
        }
    }
}
