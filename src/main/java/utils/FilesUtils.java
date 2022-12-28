package utils;

import entities.Comment;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static utils.Utils.GSON;

public class FilesUtils {

    private FilesUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static void saveTextFile(String filePath, String text) {
        FileWriter file = null;
        try {
            file = new FileWriter(filePath);
            file.write(text);
        } catch (IOException e) {
            System.out.println("Error save file!");
        }

        if (file != null) {
            try {
                file.close();
            } catch (IOException e) {
                System.out.println("Error close file!");
            }
        }

    }

    public static void saveCommentsToFile(String fileName, List<Comment> comments) {
        saveTextFile(fileName, GSON.toJson(comments));
    }

}
