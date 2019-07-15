package ru.kiselev;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException{
        try(Socket s = new Socket("172.21.0.120",1050)) {
            InputStream inStream = s.getInputStream();
            OutputStream outStream = s.getOutputStream();
            Scanner in = new Scanner(inStream);
            PrintWriter out = new PrintWriter(outStream);
            while (in.hasNextLine()) {
                String line = in.nextLine();
                System.out.println(line);
                out.write(line);
                out.flush();
            }
        } catch(IOException e){
            System.err.println(e.getMessage());
        }
    }

}
