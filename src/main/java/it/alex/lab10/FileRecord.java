package it.alex.lab10;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileRecord {

    public  void writeFile(String allString, File file) throws IOException {
        FileWriter writer = new FileWriter(file);
        String[] array = allString.split("@@@");
        for (String line : array) {
            writer.write(line + "\n");
        }
        writer.close();
    }
}
