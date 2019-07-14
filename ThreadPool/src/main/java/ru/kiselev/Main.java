package ru.kiselev;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("SingleThreadExecutor() Выполнит потоки по очереди");
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for(int i = 0; i<10; i++) {
            Runnable r = new MyThread(i);
            exec.submit(r);
        }
        exec.shutdown();
        Thread.sleep(100);
        System.out.println("FixedThreadPool(2) пропускает фиксированное число потоков = 2");
        exec = Executors.newFixedThreadPool(2);
        for(int i = 0; i<10; i++) {
            Runnable r = new MyThread(i);
            exec.submit(r);
        }
        exec.shutdown();
        Thread.sleep(100);
        System.out.println("СachedThreadPool() Запускает все потоки параллельно");
        exec = Executors.newCachedThreadPool();
        for(int i = 0; i<10; i++) {
            Runnable r = new MyThread(i);
            exec.submit(r);
        }
        exec.shutdown();
    }
}
