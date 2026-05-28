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
}