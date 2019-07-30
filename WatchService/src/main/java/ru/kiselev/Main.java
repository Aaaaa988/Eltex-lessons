package ru.kiselev;

import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.*;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        WatchService watcher = FileSystems.getDefault().newWatchService();
        Path dir = FileSystems.getDefault().getPath("/home/vladimir");
        WatchKey key;
        key = dir.register(watcher, ENTRY_DELETE, ENTRY_MODIFY, ENTRY_CREATE);

        while (true) {
            key = watcher.take();
            for (WatchEvent<?> event : key.pollEvents()) {
                if (event.kind() == ENTRY_DELETE) { // какоесобытиепришло
                    System.out.println("В домашней папке было удалено - " + event.context());
                }
                if (event.kind() == ENTRY_MODIFY) { // какоесобытиепришло
                    System.out.println("В домашней папке было изменение в - " + event.context());
                }
                if (event.kind() == ENTRY_CREATE) { // какоесобытиепришло
                    System.out.println("В домашней папке было созданно - " + event.context());
                }
            }
            key.reset();
        }

    }
}
