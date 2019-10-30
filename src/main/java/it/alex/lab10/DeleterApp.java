package it.alex.lab10;

import java.io.*;

public class DeleterApp {
    public static void main(String[] args) throws IOException {
        FileProvider fileProvider = new CLIFileProvider();
        CommentDeleter deleter = new CommentDeleter();
        FileRecord writer = new FileRecord();
        File inputFile = fileProvider.getFile("read");
        File outputFile = fileProvider.getFile("write");
        writer.writeFile(deleter.deleteComment(inputFile), outputFile);
    }
}
