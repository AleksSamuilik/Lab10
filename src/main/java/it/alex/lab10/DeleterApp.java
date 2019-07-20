package it.alex.lab10;

import java.io.File;
import java.io.IOException;

public class DeleterApp {
    public static void main(String[] args) throws IOException {
        FileProvider fileProvider = new CLIFileProvider();
        CommentDeleter deleter = new CommentDeleter();
        FileRecord writer = new FileRecord();
        File file = fileProvider.getFile();
        writer.writeFile(deleter.deleteComment(file));
        //D:\Intelij project\Lab10\src\main\java\it\alex\lab10\InputJavaTest.txt
        //D:\Intelij project\Lab10\src\main\java\it\alex\lab10\Test.txt

    }
}
