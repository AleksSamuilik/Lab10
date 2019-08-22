//package it.alex.lab10;
//
//import org.junit.Ignore;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.Parameterized;
//
//import java.io.*;
//import java.net.URL;
//import java.util.*;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//import static org.junit.Assert.*;
//
//@RunWith(Parameterized.class)
//public class DeleterAppTest {
//    private final File input;
//    private final File expected;
//    FileRecord fileRecord = new FileRecord();
//    CommentDeleter commentDeleter = new CommentDeleter();
//    private static ArrayList<File> fileArrayList = new ArrayList<>();
//
//
//    public static List<ArrayList<File>> data() {
//        File[] listFiles = getResourceFolderFiles("it/alex/lab10");
//        fillingTestFiles(listFiles);
//        return Arrays.asList(fileArrayList);
//    }
//
//
//    private static File[] getResourceFolderFiles(String folder) {
//        ClassLoader loader = Thread.currentThread().getContextClassLoader();
//        URL url = loader.getResource(folder);
//        String path = url.getPath();
//        path = path.replaceAll("%20", " ");
//        return new File(path).listFiles();
//    }
//
//    private static void fillingTestFiles(File[] files) {
//        int count = 1;
//        while (true) {
//            int number = 0;
//            for (int i = 0; i < files.length; i++) {
//                if (isFileNameCorrect(files[i], count)) {
//                    number++;
//                }
//                if (number == 2) {
//                    count++;
//                    break;
//                }
//            }
//            if (number != 2) {
//                break;
//            }
//        }
//    }
//
//    private static boolean isFileNameCorrect(File name, int count) {
//        if (name.getName().toLowerCase().contains("input")) {
//            Pattern pattern = Pattern.compile("^([a-z0-9_\\\\.-]+)-" + count + "-input\\.([a-z].+)", Pattern.CASE_INSENSITIVE);
//            Matcher matcher = pattern.matcher(name.getName());
//            if (matcher.find()) {
//                fileArrayList.add(name);
//                return true;
//            }
//        } else if (name.getName().toLowerCase().contains("expected")) {
//            Pattern pattern = Pattern.compile("^([a-z0-9_\\\\.-]+)-" + count + "-expected\\.([a-z].+)", Pattern.CASE_INSENSITIVE);
//            Matcher matcher = pattern.matcher(name.getName());
//            if (matcher.find()) {
//                fileArrayList.add(name);
//                return true;
//            }
//        }
//        return false;
//    }
//
//    private File findTestFile(File[] files) {
//        for (int i = 0; i < files.length; i++) {
//            if (files[i].getName().toLowerCase().contains("test.txt")) {
//                return files[i];
//            }
//        }
//        return null;
//    }
//
//    public DeleterAppTest(File input, File expected) {
//        this.input = input;
//        this.expected = expected;
//
//    }
//
//    @Test
//    public void automaticTest() throws IOException {
////
////        File actualFile = findTestFile(listFiles);
////        Iterator<File> iterator = fileArrayList.iterator();
////        while (iterator.hasNext()) {
////            Scanner scannerExpected = new Scanner(iterator.next());
////            fileRecord.writeFile(commentDeleter.deleteComment(iterator.next()), actualFile);
////            Scanner scannerActual = new Scanner(actualFile);
////            while (scannerActual.hasNextLine()) {
////                String expected = scannerExpected.nextLine();
////                String actual = scannerActual.nextLine();
////                assertEquals(expected, actual);
////            }
////
////        }
//        Scanner scannerExpected = new Scanner(expected);
//        File actualFile = findTestFile(getResourceFolderFiles("it/alex/lab10"));
//        fileRecord.writeFile(commentDeleter.deleteComment(input), actualFile);
//        Scanner scannerActual = new Scanner(actualFile);
//        while (scannerActual.hasNextLine()) {
//            String expected = scannerExpected.nextLine();
//            String actual = scannerActual.nextLine();
//            assertEquals(expected, actual);
//        }
//    }
//
//
//    @Ignore
//    @Test
//    public void deleteCommentTest1() throws IOException {
//        File inputFile = new File("D:\\Intelij project\\Lab10\\src\\main\\java\\it\\alex\\lab10\\InputMyTest.txt");
//        File actualFile = new File("D:\\Intelij project\\Lab10\\src\\main\\java\\it\\alex\\lab10\\OutputMyTest.txt");
//        File expectedFile = new File("D:\\Intelij project\\Lab10\\src\\main\\java\\it\\alex\\lab10\\InputMyTest.txt");
//
//        fileRecord.writeFile(commentDeleter.deleteComment(inputFile), actualFile);
//        Scanner scannerExpected = new Scanner(expectedFile);
//        Scanner scannerActual = new Scanner(actualFile);
//
//        while (scannerActual.hasNextLine()) {
//            String expected = scannerExpected.nextLine();
//            String actual = scannerActual.nextLine();
//            assertEquals(expected, actual);
//        }
//    }
//
//    @Ignore
//    @Test
//    public void deleteCommentTest2() throws IOException {
//        File inputFile = new File("D:\\Intelij project\\Lab10\\src\\main\\java\\it\\alex\\lab10\\InputMyTest.txt");
//        File actualFile = new File("D:\\Intelij project\\Lab10\\src\\main\\java\\it\\alex\\lab10\\OutputMyTest.txt");
//        File expectedFile = new File("D:\\Intelij project\\Lab10\\src\\main\\java\\it\\alex\\lab10\\InputMyTest.txt");
//
//        fileRecord.writeFile(commentDeleter.deleteComment(inputFile), actualFile);
//        Scanner scannerExpected = new Scanner(expectedFile);
//        Scanner scannerActual = new Scanner(actualFile);
//
//        while (scannerActual.hasNextLine()) {
//            String expected = scannerExpected.nextLine();
//            String actual = scannerActual.nextLine();
//            assertEquals(expected, actual);
//        }
//    }
//}


package it.alex.lab10;

import org.junit.Ignore;
import org.junit.Test;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;


public class DeleterAppTest {
    FileRecord fileRecord = new FileRecord();
    CommentDeleter commentDeleter = new CommentDeleter();
    private ArrayList<File> fileArrayList = new ArrayList<>();

    private File[] getResourceFolderFiles(String folder) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        URL url = loader.getResource(folder);
        String path = url.getPath();
        path = path.replaceAll("%20", " ");
        return new File(path).listFiles();
    }

    private void fillinTestFiles(File[] files) {
        int count = 1;
        while (true) {
            int number = 0;
            for (int i = 0; i < files.length; i++) {
                if (isFileNameCorrect(files[i], count)) {
                    number++;
                }
                if (number == 2) {
                    count++;
                    break;
                }
            }
            if (number != 2) {
                break;
            }
        }
    }

    private boolean isFileNameCorrect(File name, int count) {
        if (name.getName().toLowerCase().contains("input")) {
            Pattern pattern = Pattern.compile("^([a-z0-9_\\\\.-]+)-" + count + "-input\\.([a-z].+)", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(name.getName());
            if (matcher.find()) {
                fileArrayList.add(name);
                return true;
            }
        } else if (name.getName().toLowerCase().contains("expected")) {
            Pattern pattern = Pattern.compile("^([a-z0-9_\\\\.-]+)-" + count + "-expected\\.([a-z].+)", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(name.getName());
            if (matcher.find()) {
                fileArrayList.add(name);
                return true;
            }
        }
        return false;
    }

    private File findTestFile(File[] files) {
        for (int i = 0; i < files.length; i++) {
            if (files[i].getName().toLowerCase().contains("test.txt")) {
                return files[i];
            }
        }
        return null;
    }


    @Test
    public void automaticTest() throws IOException {
        File[] listFiles = getResourceFolderFiles("it/alex/lab10");
        fillinTestFiles(listFiles);
        File actualFile = findTestFile(listFiles);
        Iterator<File> iterator = fileArrayList.iterator();
        while (iterator.hasNext()) {
            Scanner scannerExpected = new Scanner(iterator.next());
            fileRecord.writeFile(commentDeleter.deleteComment(iterator.next()), actualFile);
            Scanner scannerActual = new Scanner(actualFile);
            while (scannerActual.hasNextLine()) {
                String expected = scannerExpected.nextLine();
                String actual = scannerActual.nextLine();
                assertEquals(expected, actual);
            }

        }
    }
}