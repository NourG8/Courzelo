package com.example.corzello.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PythonScriptRunner {

    public boolean runPythonScript() {
        try {
            String scriptPath ="D:\\PI PROJECT\\Corzello\\src\\main\\java\\com\\example\\corzello\\flask_integration\\flask_scraping.py";
            // Build the command to run the Python script
            ProcessBuilder pb = new ProcessBuilder("python", scriptPath);

            // Start the process
            Process process = pb.start();

            // Read output from Python script
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Wait for the process to finish
            process.waitFor();

            // Check the exit value of the process
            int exitValue = process.exitValue();
            if (exitValue == 0) {
                System.out.println("Python script executed successfully.");
                return true; // Return true for success
            } else {
                System.out.println("Python script failed with exit code: " + exitValue);
                return false; // Return false for error
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return false; // Return false for error
        }
    }
}
