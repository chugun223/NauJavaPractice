import java.util.LinkedList;
import java.util.Queue;

public class Task5 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Задание № 5. Реализация интерфейса “Task”.");
        QueueTask queue = new QueueTask();

        queue.add("задача 1");
        queue.add("задача 2");
        queue.add("задача 3");

        queue.start();

        queue.add("задача 4");
        queue.add("задача 5");

        Thread.sleep(500);

        queue.stop();

        queue.add("задача 6");
        queue.add("задача 7");
        System.out.println("основной поток завершился");
        System.out.println("Задание №5 завершено.");
    }
}

class QueueTask implements Task {

    private final Queue<String> queue = new LinkedList<>();
    private volatile boolean running = false;
    private Thread thread;

    public void add(String data) {
        synchronized (queue) {
            queue.offer(data);
            queue.notifyAll();
        }
    }

    @Override
    public void start() {
        running = true;

        thread = new Thread(() -> {
            System.out.println("запущен просмотр очереди");
            while (running) {
                String data;
                synchronized (queue) {
                    while (running && queue.isEmpty()) {
                        try {
                            queue.wait();
                        }
                        catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    data = queue.poll();
                }

                System.out.println("обработана: " + data);
            }
            System.out.println("обработка остановлена");
        });

        thread.start();
    }

    @Override
    public void stop() {
        running = false;

        synchronized (queue) {
            queue.notifyAll();
        }

        try {
            thread.join();
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

interface Task {
    void start();
    void stop();
}