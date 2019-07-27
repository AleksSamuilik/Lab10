package it.alex.lab10;

import org.junit.Test;

import java.io.*;
import java.util.Scanner;

import static org.junit.Assert.*;


public class DeleterAppTest {
    FileRecord fileRecord = new FileRecord();
    CommentDeleter commentDeleter = new CommentDeleter();

    @Test
    public void deleteCommentTest1() throws IOException {
        File inputFile = new File("D:\\Intelij project\\Lab10\\src\\main\\java\\it\\alex\\lab10\\InputJavaTest.txt");
        File actualFile = new File("D:\\Intelij project\\Lab10\\src\\main\\java\\it\\alex\\lab10\\Test.txt");
        File expectedFile = new File("D:\\Intelij project\\Lab10\\src\\main\\java\\it\\alex\\lab10\\OutputJavaTest.txt");

        fileRecord.writeFile(commentDeleter.deleteComment(inputFile), actualFile);
        Scanner scannerExpected = new Scanner(expectedFile);
        Scanner scannerActual = new Scanner(actualFile);

        while (scannerActual.hasNextLine()) {
            String expected = scannerExpected.nextLine();
            String actual = scannerActual.nextLine();
            assertEquals(expected, actual);
        }
    }

    @Test
    public void deleteCommentTest2() throws IOException {
        File inputFile = new File("D:\\Intelij project\\Lab10\\src\\main\\java\\it\\alex\\lab10\\InputMyTest.txt");
        File actualFile = new File("D:\\Intelij project\\Lab10\\src\\main\\java\\it\\alex\\lab10\\OutputMyTest.txt");
        File expectedFile = new File("D:\\Intelij project\\Lab10\\src\\main\\java\\it\\alex\\lab10\\InputMyTest.txt");

        fileRecord.writeFile(commentDeleter.deleteComment(inputFile), actualFile);
        Scanner scannerExpected = new Scanner(expectedFile);
        Scanner scannerActual = new Scanner(actualFile);

        while (scannerActual.hasNextLine()) {
            String expected = scannerExpected.nextLine();
            String actual = scannerActual.nextLine();
            assertEquals(expected, actual);
        }
    }
}
