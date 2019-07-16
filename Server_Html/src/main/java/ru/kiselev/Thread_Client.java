package ru.kiselev;

import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Thread_Client implements Runnable {

    private Socket socket;

    public void run(){
        InputStream inStream = null;
        try {
            inStream = socket.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        OutputStream outStream = null;
        try {
            outStream = socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scanner in = new Scanner(inStream);
        PrintWriter out = new PrintWriter(outStream);

        //System.out.println(in.nextLine());
        String[] request = in.nextLine().split(" ");
        for (String str : request) {
            System.out.println(str);
        }
        String HTTP_version = request[2];
        String Page = request[1];

        String path = "src/main/resources" + Page;
        File file = new File(path);
        if (!file.exists() && path.contains("html")) path = "src/main/resources/404.html";
        if (file.exists() && !path.contains("html")) path = "src/main/resources/434.html";
        if (!file.isFile() && !path.contains("html")) path = "src/main/resources/444.html";

        String htmlPage = null;
        try {
            htmlPage = Files.readString(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        htmlPage = HTTP_version + " 200 OK\n" +
                "Сontent-Length:" + htmlPage.length() + "\n" +
                "Сontent-Type:text/html\n" +
                "\n"
                + htmlPage;


        //System.out.println(in.nextLine());
        out.write(htmlPage);
        out.flush();
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    Thread_Client(Socket socket){
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
}
