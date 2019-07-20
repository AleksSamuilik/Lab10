package it.alex.lab10;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileRecord {

    public void writeFile(String allString) throws IOException {
        Scanner readDirectory = new Scanner(System.in);
        System.out.println("Enter the directory of the file to be write: ");
        String directory = readDirectory.nextLine();
        FileWriter writer = new FileWriter(directory);
        String[] array = allString.split("@@@");
        for (String line : array) {
            writer.write(line + "\n");
        }
        writer.close();
    }
}
