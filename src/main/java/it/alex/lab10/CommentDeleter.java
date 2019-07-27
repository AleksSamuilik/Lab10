package it.alex.lab10;

import java.io.*;
import java.util.Scanner;

public class CommentDeleter {

    private String deleteSingleComment(String string) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '"') {
                builder.append(string.charAt(i));
                while (true) {
                    i++;
                    if (string.charAt(i) == '"') {
                        if (string.charAt(i - 1) == '\\') {
                            builder.append(string.charAt(i));
                        } else {
                            builder.append(string.charAt(i));
                            break;
                        }
                    } else {
                        builder.append(string.charAt(i));
                    }
                }
            } else if (i + 1 < string.length() && (string.charAt(i) == '/' && string.charAt(i + 1) == '/')) {
                break;
            } else {
                builder.append(string.charAt(i));
            }
        }
        return builder.toString();
    }

    private String deleteMultiComment(String string) {
        StringBuilder builder1 = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '"') {
                builder1.append(string.charAt(i));
                while (true) {
                    i++;
                    if (string.charAt(i) == '"') {
                        if (string.charAt(i - 1) == '\\') {
                            builder1.append(string.charAt(i));
                        } else {
                            builder1.append(string.charAt(i));
                            break;
                        }
                    } else {
                        builder1.append(string.charAt(i));
                    }
                }
            } else if (string.charAt(i) == '/' && string.charAt(i + 1) == '*') {
                i++;
                while (true) {
                    i++;
                    if (string.charAt(i) == '*') {
                        if (string.charAt(i + 1) == '/') {
                            i++;
                            break;
                        }
                    }
                }
            } else {
                builder1.append(string.charAt(i));
            }
        }
        return builder1.toString();
    }

    public String deleteComment(File file) throws IOException {
        Scanner scanner = new Scanner(file);
        StringBuilder builder = new StringBuilder();
        while (scanner.hasNextLine()) {
            builder.append(deleteSingleComment(scanner.nextLine()));
            builder.append("@@@");
        }
        return deleteMultiComment(builder.toString());
    }
}