package ru.kiselev;


import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

@SpringBootApplication
public class SpringData {
    private User user1;
    private User user2;
    private User user3;
    private Call call1;
    private Call call2;
    private static final Logger log = Logger.getLogger(SpringData.class);


    public static void main(String[] args) {

        SpringApplication.run(SpringData.class);
        BasicConfigurator.configure();

    }
    @Bean
    public CommandLineRunner users(UserRepository CrudRepository) {
        return (args) -> {
            user1 = new User( "Ivanov Ivan Ivanovich", "+79234563452");
            user2 = new User("Petrov Gena Arkadich", "+79453265476");
            user3 = new User("Pychkov Misha Hahahicsh", "+74356265476");
            CrudRepository.save(user1);
            CrudRepository.save(user2);
            CrudRepository.save(user3);
        };
    }
    @Bean
    public CommandLineRunner calls(CallRepository MongoRepository) throws InterruptedException {
        Date date1 = new Date();
        Thread.sleep(5000);
        Date date2 = new Date();
        return (args) -> {
            MongoRepository.deleteAll();
            call1 = new Call(user1.getId(), user2.getId(), date1.toString());
            call2 = new Call(user2.getId(), user1.getId(), date2.toString());
            MongoRepository.insert(call1);
            MongoRepository.insert(call2);
        };
    }
    @Bean
    public CommandLineRunner outPrint(UserRepository CrudRepository, CallRepository MongoRepository) {
        return (args) -> {
            System.out.println("\n                                                       Пользователи");
            for (User user: CrudRepository.findAll()) {

                log.info(user.getId() + " " + user.getFio() + " " + user.getPhone());
            }
            System.out.println("                                                       Журнал вызовов");
            System.out.println("                                                    кто|кому|дата звонка");
            for (Call call: MongoRepository.findAll()) {
                log.info(call.getCaller_id() + "   " + call.getReceiver_id() + "   " + call.getDate());
            }
            System.out.println();
        };
    }

    @Bean
    public CommandLineRunner Server(UserRepository CrudRepository) {
        return (args) -> {
            ServerSocket server = new ServerSocket(1050);
            while (true) {
                Socket client = server.accept();

                Runnable r = new ThreadClient(client, CrudRepository);
                Thread t = new Thread(r);
                t.start();
            }
        };
    }

}
