package ru.kiselev;

import java.util.Scanner;

public class Week {
    public static void main(String[] args) {
        System.out.println("Укажите День недели, что бы узнать сколько дней осталось до субботы");
        Scanner scanner = new Scanner(System.in);
        String inputStr = "";
        inputStr = scanner.nextLine();

        try {
            DayOfWeek.valueOf(inputStr);
        } catch(Exception ex) {
            inputStr = "MONDAY";
        }

        switch(DayOfWeek.valueOf(inputStr)){
            case MONDAY:
                System.out.println("Осталось " + 5 + " дней до субботы");
                break;
            case TUESDAY:
                System.out.println("Осталось " + 4 + " дней до субботы");
                break;
            case WEDNESDAY:
                System.out.println("Осталось " + 3 + " ней до субботы");
                break;
            case THURSDAY:
                System.out.println("Осталось " + 2 + " дней до субботы");
                break;
            case FRIDAY:
                System.out.println("Осталось " + 1 + " дней до субботы");
                break;
            case SUNDAY:
                System.out.println("Сегодня суббота!");
                break;
            case SATURDAY:
                System.out.println("Осталось " + 6 + " дней до субботы");
                break;

                default:
                    System.out.println("Суббота дней 0 до осталось");
                    break;

        }
    }
}
