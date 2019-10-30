package it.alex.lab10;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.*;
import java.net.URL;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class DeleterAppTest {

    @Parameterized.Parameters(name = "{index}:File{0} equals File {1}")
    public static Iterable<Object[]> data() {
        String[][] data = getResourcesList();
        return Arrays.asList(data);
    }

    FileRecord fileRecord = new FileRecord();
    CommentDeleter commentDeleter = new CommentDeleter();
    private final String input;
    private final String expected;
    private static File actualFile;


    public DeleterAppTest(String input, String expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void deleterTest() throws IOException {
        File inputFile = new File(input);
        File expectedFile = new File(expected);
        fileRecord.writeFile(commentDeleter.deleteComment(inputFile), actualFile);
        assertEquals(true, FileUtils.contentEquals(expectedFile, actualFile));
    }

    public static String[][] getResourcesList() {
        String folder = "it/alex/lab10";
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        URL url = loader.getResource(folder);
        String path = url.getPath();
        path = path.replaceAll("%20", " ");
        File[] fileList = new File(path).listFiles();
        String[][] list = new String[fileList.length][2];
        Pattern input = Pattern.compile("-input\\.([a-z].+)");
        int index = 0;
        for (int i = 0; i < fileList.length; i++) {
            File inputFile = fileList[i];
            if (inputFile.getName().contains("Test.txt")) {
                actualFile = inputFile;
                continue;
            }
            Matcher matcherInput = input.matcher(fileList[i].getName());
            if (matcherInput.find()) {
                list[index][0] = fileList[i].getPath();
                String fileName = fileList[i].getName().replaceAll("-input\\.([a-z].+)", "");
                Pattern expected = Pattern.compile(fileName + "-expected\\.([a-z].+)");
                int count = 0;
                while (count < fileList.length) {
                    Matcher matcherExpected = expected.matcher(fileList[count].getName());
                    if (matcherExpected.find()) {
                        list[index][1] = fileList[count].getPath();
                        index++;
                        break;
                    } else {
                        count++;
                    }
                }
            }
        }
        list = Arrays.copyOf(list, index);
        return list;
    }
}