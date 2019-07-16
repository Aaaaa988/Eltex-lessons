package ru.kiselev;

import javax.annotation.processing.Filer;
import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {

            try (ServerSocket s = new ServerSocket(1050, 0, InetAddress.getByName("0.0.0.0"))) {
                Socket client = s.accept();
                InputStream inStream = client.getInputStream();
                OutputStream outStream = client.getOutputStream();
                Scanner in = new Scanner(inStream);
                PrintWriter out = new PrintWriter(outStream);

                //System.out.println(in.nextLine());
                String[] request = in.nextLine().split(" ");
                for(String str: request){
                    System.out.println(str);
                }
                String HTTP_version = request[2];
                String Page = request[1];

                String path = "src/main/resources" + Page;
                File file = new File(path);
                if (!file.exists() && path.contains("html")) path = "src/main/resources/404.html";
                if (file.exists() && !path.contains("html")) path = "src/main/resources/434.html";
                if (!file.isFile() && !path.contains("html")) path = "src/main/resources/444.html";

                String htmlPage = Files.readString(Paths.get(path));
                htmlPage = "HTTP/1.1 200 OK\n" +
                        "Сontent-Length:" + htmlPage.length() + "\n" +
                        "Сontent-Type:text/javascript\n" +
                        "\n"
                        + htmlPage;
                //System.out.println(htmlPage);


                System.out.println(in.nextLine());
                out.write(htmlPage);
                out.flush();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }


        }
    }
