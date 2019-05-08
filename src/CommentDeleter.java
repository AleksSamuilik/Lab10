import java.io.*;
import java.util.Scanner;

public class CommentDeleter {
    //  D:\\Intelij project\\Lab10\\src\\TestJava.java Это я для теста использовал файл.

    public File openFile() {
        System.out.println("Enter the file directory: ");
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

    public String readFileAndDeletesComment(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        StringBuilder builder = new StringBuilder();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            line = line.replaceAll("(?sm)(^(?:\\s*)?((?:/\\*(?:\\*)?).*?(?<=\\*/))|(?://).*?(?<=$))", "");
            builder.append(line);
            builder.append("///");
        }
        return builder.toString();
    }

    public void deletesMultiCommentAndWrite(String result, File file) throws IOException {
        result = result.replaceAll("\\/\\*.*?\\*\\/", "");
        FileWriter writer = new FileWriter(file);
        String[] array = result.split("///");
        for (String line : array) {
            if (line != "\n") {
                writer.write(line + "\n");
            }
        }
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        CommentDeleter commentDeleter = new CommentDeleter();
        File file = commentDeleter.openFile();
        String result = commentDeleter.readFileAndDeletesComment(file);
        commentDeleter.deletesMultiCommentAndWrite(result, file);
    }
}