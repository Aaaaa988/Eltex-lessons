package ru.kiselev;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Monitor {
    public static void main(String[] args) throws FileNotFoundException {
        File dir_proc = new File("/proc/");
        String[] dirs_name = dir_proc.list();
        System.out.println("PID  ||  Name_of_proccess");
        System.out.println("-------------------------");
        for(String i: dirs_name) {

            File file = new File("/proc/" + i +"/stat");

            if(file.exists()) {
                try {
                    FileReader reader = new FileReader(file);
                    int b;
                    boolean skip = true;
                    System.out.print(i + " || ");
                    while((b = reader.read()) != 41 ) {
                        if(b == 40) {skip = false; continue;}
                        if(skip) continue;
                        System.out.print((char) b);
                    }
                    System.out.println();

                } catch (Exception ex) {

                }

            }
        }
    }
}
