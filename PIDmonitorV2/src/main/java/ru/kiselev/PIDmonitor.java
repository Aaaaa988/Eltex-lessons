package ru.kiselev;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class PIDmonitor {
    public static void main(String[] args) throws InterruptedException {

        Scanner in = new Scanner(System.in);
        while (true) {
            File dir_proc = new File("/home/vladimir/proc/");
            String[] dirs_name = dir_proc.list();
            System.out.println("PID  ||  Name_of_proccess");
            System.out.println("-------------------------");
            for (String i : dirs_name) {

                File file = new File("/home/vladimir/proc/" + i + "/stat");

                if (file.exists()) {
                    try {
                        FileReader reader = new FileReader(file);
                        int b;
                        boolean skip = true;
                        System.out.print(i + " || ");
                        while ((b = reader.read()) != 41) {
                            if (b == 40) {
                                skip = false;
                                continue;
                            }
                            if (skip) continue;
                            System.out.print((char) b);
                        }
                        System.out.println();
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }

            Integer Request;
            Request = in.nextInt();
            if (false) {
                break;
            } else{
            Path target = Paths.get("/home/vladimir/proc/" + Request);
            try {
                Files.delete(target);
            } catch (IOException e) {
                e.printStackTrace();
            }
            }

        }

    }

}
