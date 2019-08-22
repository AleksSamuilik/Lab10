package it.alex.lab10;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static it.alex.lab10.TestClazz.UploadedData.fileArrayList;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestClazz {
    @Parameterized.Parameters(name = "{index}:File{0} equals File {1}")
    public static Iterable<Object[]> data() {
        Object[][] data = fileArrayList;
        return Arrays.asList(data);
    }
//                {"D:\\Intelij project\Lab10\\target\\test-classes\\it\\alex\\lab10\\test-1-Input.txt", "D:\Intelij project\Lab10\\target\\test-classes\it\alex\lab10\\test-1-expected.txt"},
//                {"D:\Intelij project\Lab10\\target\\test-classes\it\alex\lab10\\test-2-input.txt", "D:\Intelij project\Lab10\\target\\test-classes\it\alex\lab10\\test-2-expected.txt"}
//        };


    private final File input;
    private final File expected;

    public TestClazz(File input, File expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void mainLoad() {
        System.out.println(input.getName() + expected.getName());
        UploadedData data = new UploadedData();
        File[][] dataArr = data.getResoureceList("it/alex/lab10");
        for (File [] file: dataArr){
            System.out.println(Arrays.toString(file));
        }
    }

    static class  UploadedData {
        static File[][] fileArrayList;
        private static   int index = 0;

        private static boolean isFileNameCorrectFillArray(File name, int count) {
            if (name.getName().toLowerCase().contains("input")) {
                Pattern pattern = Pattern.compile("^([a-z0-9_\\\\.-]+)-" + count + "-input\\.([a-z].+)", Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(name.getName());
                if (matcher.find()) {
                    fileArrayList[index][0] = name;
                    return true;
                }
            } else if (name.getName().toLowerCase().contains("expected")) {
                Pattern pattern = Pattern.compile("^([a-z0-9_\\\\.-]+)-" + count + "-expected\\.([a-z].+)", Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(name.getName());
                if (matcher.find()) {
                    fileArrayList[index][1] = name;
                    return true;
                }
            }
            if (fileArrayList[index][0] != null && fileArrayList[index][1] != null) {
                index++;
            }
            return false;
        }

        public static File[][] getResoureceList(String folder) {

            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            URL url = loader.getResource(folder);
            String path = url.getPath();
            path = path.replaceAll("%20", " ");
            File[] listFile = new File(path).listFiles();
            fileArrayList = new File[listFile.length][2];
            int count = 1;
            while (true) {
                int number = 0;
                for (int i = 0; i < listFile.length; i++) {
                    if (isFileNameCorrectFillArray(listFile[i], count)) {
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

            fileArrayList = Arrays.copyOf(fileArrayList, index);
            return fileArrayList;
        }
    }
}



