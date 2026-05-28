import java.nio.file.Files;
import java.nio.file.Path;

public class Validator {

    public static boolean isFileExists(String filePath) {

        return Files.exists(Path.of(filePath));
    }

    public static boolean isValidKey(int key, int alphabetSize) {

        return key >= 0 && key < alphabetSize;
    }
}