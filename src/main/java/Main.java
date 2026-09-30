import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите задание 1-5(для выхода введите: 0):");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> Task1.main(args);
                case 2 -> Task2.main(args);
                case 3 -> Task3.main(args);
                case 4 -> Task4.main(args);
                case 5 -> Task5.main(args);
                case 0 -> {
                    System.out.println("выход");
                    scanner.close();
                    return;
                }
                default -> System.out.println("неправильный выбор");
            }
        }
    }
}
