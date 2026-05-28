import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileManager {

    public static String readFile(String filePath) {

        try {

            return Files.readString(
                    Path.of(filePath),
                    StandardCharsets.UTF_8
            );

        } catch (IOException e) {

            System.out.println("Ошибка чтения файла.");
            return "";
        }
    }

    public static void writeFile(String filePath, String text) {

        try {

            Files.writeString(
                    Path.of(filePath),
                    text,
                    StandardCharsets.UTF_8
            );

        } catch (IOException e) {

            System.out.println("Ошибка записи файла.");
        }
    }
}