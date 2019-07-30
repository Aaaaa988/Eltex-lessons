/*package ru.kiselev;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.println("First program - "+"Calculator");

        System.out.println("Write the expression: (example: 2.3 + 3.2)");
        Scanner in = new Scanner(System.in);
        String Request = in.nextLine();

        System.out.print("You write: ");
        System.out.println(Request);

        String[] tempStr = Request.split(" ");

        Double a = Double.valueOf(tempStr[0]);
        Double b = Double.valueOf(tempStr[2]);
        String  operator = tempStr[1];
        String operation = "operation";

        Double result;


        switch(operator){
            case "+":{
                result = a + b;
                operation = "the sum";
            } break;
            case "-":{
                result = a - b;
                operation = "difference";
            } break;
            case "/":{
                result = a / b;
                operation = "division";
            } break;
            case "*":{
                result = a * b;
                operation = "multiplication";
            } break;
            default:{
                result = 0.0;
                System.out.print("fail operation");
            }
        }

        System.out.println("First operand: " + tempStr[0]);
        System.out.println("Second operand: " + tempStr[2]);
        System.out.println("Operation: " + operation + "\n");

        System.out.println("Result = " + result);
    }
}*/

package ru.kiselev;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.println("blyat");
        File dir_proc = new File("/proc/");
        String[] dirs_name = dir_proc.list();
        System.out.println("PID  ||  Name_of_proccess");
        System.out.println("-------------------------");
        for(String i: dirs_name) {

            File file = new File("./proc/" + i + "/stat");

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
                    System.out.println(ex.getMessage());
                }
            }
        }

        Scanner in = new Scanner(System.in);
        String Request = in.nextLine();


/*
        Path target = Paths.get("./proc");
        Files.delete(target);
        */

    }

}

