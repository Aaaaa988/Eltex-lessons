package ru.kiselev;

import javax.annotation.processing.Filer;
import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    public static void main(String[] args) throws IOException {

            try (ServerSocket s = new ServerSocket(1050, 0, InetAddress.getByName("0.0.0.0"))) {
                while(true) {
                    Socket client = s.accept();

                    Runnable r = new Thread_Client(client);
                    Thread t = new Thread(r);
                    t.start();
                }


            } catch (IOException e) {
                System.err.println(e.getMessage());
            }


    }
}