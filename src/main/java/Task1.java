import java.util.Random;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Задание №1. Работа с массивом.");
        System.out.print("введите количество элементов массива: ");
        int n = scanner.nextInt();

        if (n < 0) {
            System.out.println("размер некорректный");
            return;
        }

        int[] array = new int[n];
        Random random = new Random();

        System.out.print("массив: ");
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt();
            System.out.print(array[i] + " ");
        }

        System.out.println();

        int lastPositive = -1;

        for (int i = n - 1; i >= 0; i--) {
            if (array[i] > 0) {
                lastPositive = array[i];
                break;
            }
        }

        if (lastPositive != -1) {
            System.out.println("последний положительный элемент: " + lastPositive);
        } else {
            System.out.println("положительных элементов в массиве нет.");
        }
        System.out.println("Задание №1 завершено.");
    }
}
