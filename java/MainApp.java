import java.util.Scanner;

public class MainApp {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            printMenu();

            String choice = scanner.nextLine();

            switch (choice) {

                case "1":
                    System.out.println("Шифрование");
                    break;

                case "2":
                    System.out.println("Расшифровка");
                    break;

                case "3":
                    System.out.println("Brute force");
                    break;

                case "0":
                    System.out.println("Выход");
                    return;

                default:
                    System.out.println("Неверный пункт.");
            }
        }
    }

    private static void printMenu() {

        System.out.println();
        System.out.println("===== Caesar Cipher =====");
        System.out.println("1. Шифрование текста");
        System.out.println("2. Расшифровка текста");
        System.out.println("3. Brute Force");
        System.out.println("0. Выход");
        System.out.print("Выберите действие: ");
    }

    private static void encryptMode() {

        System.out.print("Введите путь к исходному файлу: ");
        String inputPath = scanner.nextLine();

        if (!Validator.isFileExists(inputPath)) {
            System.out.println("Файл не найден.");
            return;
        }

        System.out.print("Введите путь для сохранения файла: ");
        String outputPath = scanner.nextLine();

        System.out.print("Введите ключ: ");

        int key;

        try {
            key = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Ключ должен быть числом.");
            return;
        }

        if (!Validator.isValidKey(key, Cipher.getAlphabetSize())) {
            System.out.println("Неверный ключ.");
            return;
        }

        Cipher cipher = new Cipher();

        String text = FileManager.readFile(inputPath);

        String encryptedText = cipher.encrypt(text, key);

        FileManager.writeFile(outputPath, encryptedText);

        System.out.println("Шифрование завершено.");
    }

    private static void decryptMode() {

        System.out.print("Введите путь к зашифрованному файлу: ");
        String inputPath = scanner.nextLine();

        if (!Validator.isFileExists(inputPath)) {
            System.out.println("Файл не найден.");
            return;
        }

        System.out.print("Введите путь для сохранения файла: ");
        String outputPath = scanner.nextLine();

        System.out.print("Введите ключ: ");

        int key;

        try {
            key = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Ключ должен быть числом.");
            return;
        }

        if (!Validator.isValidKey(key, Cipher.getAlphabetSize())) {
            System.out.println("Неверный ключ.");
            return;
        }

        Cipher cipher = new Cipher();

        String text = FileManager.readFile(inputPath);

        String decryptedText = cipher.decrypt(text, key);

        FileManager.writeFile(outputPath, decryptedText);

        System.out.println("Расшифровка завершена.");
    }
}