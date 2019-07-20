package it.alex.lab10;

import java.io.File;
import java.util.Scanner;

public class CLIFileProvider implements FileProvider{

    @Override
    public File getFile(String whatForFile ) {
            System.out.println("Enter the file directory to "+whatForFile+": ");
            Scanner scanner = new Scanner(System.in);

            while (scanner.hasNextLine()) {
                try {
                    return new File(scanner.nextLine());
                } catch (Exception e) {
                    System.out.println("Sorry. Try again. Error: " + e);
                }
            }
            return null;
        }
    }