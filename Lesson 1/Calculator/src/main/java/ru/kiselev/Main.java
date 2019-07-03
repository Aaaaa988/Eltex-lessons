package ru.kiselev;
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
}
