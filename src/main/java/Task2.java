import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Задание №2. Работа со списками.");
        System.out.print("введите количество элементов списка: ");
        int n = scanner.nextInt();

        if (n < 0) {
            System.out.println("размер некорректный");
            return;
        }
        List<Double> list = new ArrayList<>();
        Random random = new Random();
        System.out.print("список: ");
        for (int i = 0; i < n; i++) {
            list.add((2 * random.nextDouble() - 1) * Double.MAX_VALUE);
            System.out.print(list.get(i) + " ");
        }

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (list.get(j) < list.get(minIndex)) {
                    minIndex = j;
                }
            }
            double temp = list.get(minIndex);
            list.set(minIndex, list.get(i));
            list.set(i, temp);
        }
        System.out.println();
        System.out.print("отсортированный массив: ");
        for (int i = 0; i < n; i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
        System.out.println("Задание №2 завершено.");
    }
}
