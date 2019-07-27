package it.alex.lab10;

import java.io.*;

public class DeleterApp {
    public static void main(String[] args) throws IOException {
        FileProvider fileProvider = new CLIFileProvider();
        CommentDeleter deleter = new CommentDeleter();
        FileRecord writer = new FileRecord();
        File inputFile = fileProvider.getFile("read");
        File outputFile = fileProvider.getFile("write");
        writer.writeFile(deleter.deleteComment(inputFile),outputFile);

        //D:\Intelij project\Lab10\src\main\java\it\alex\lab10\InputJavaTest.txt
        //D:\Intelij project\Lab10\src\main\java\it\alex\lab10\InputMyTest.txt

        //D:\Intelij project\Lab10\src\main\java\it\alex\lab10\OutputJavaTest.txt
        //D:\Intelij project\Lab10\src\main\java\it\alex\lab10\OutputMyTest.txt

    }
}
