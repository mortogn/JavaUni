package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileUtil {
    public static String readFile(String path) {
        try {
            String content = Files.readString(Path.of(path));
            return content;
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return "";
        }
    }

    public static void writeFile(String path, String content) {
        try {
            Files.writeString(Path.of(path), content);
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }
}
