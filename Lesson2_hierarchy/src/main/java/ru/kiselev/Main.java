package ru.kiselev;

import java.util.ArrayList;

public class Main implements CSV{

    private static ArrayList<User> dif_users = new ArrayList<>();

    public static void main(String[] args) {

        for (int i = 0; i < 3; i++) {
            dif_users.add(new Manager("Менеджер-" + (i+1), (int)(Math.random() * 10000),(int)(i + 10)));
        }
        Sale product1 = new Sale("Монитор", 5543);
        Sale product2 = new Sale("Клавиатура", 900);
        Sale product3 = new Sale("Мышь", 300);

        ((Manager)(dif_users.get(0))).addProduct(product1);
        ((Manager)(dif_users.get(1))).addProduct(product2);
        ((Manager)(dif_users.get(2))).addProduct(product3);
        ((Manager)(dif_users.get(0))).addProduct(product3);
        ((Manager)(dif_users.get(1))).addProduct(product2);
        ((Manager)(dif_users.get(2))).addProduct(product1);

        for (int i = 0; i < 3; i++) {
            dif_users.add(new Developer("Разработчик-" + (i+1), (int)(Math.random() * 10000),(int)(i + 10)));
        }
        ((Developer)(dif_users.get(3))).addLang("Java", "Kotlin", "C#");
        ((Developer)(dif_users.get(4))).addLang("Python", "C++");
        ((Developer)(dif_users.get(5))).addLang("Java", "C", "Pascal");


        CSV.ToCSV();
        CSV.fromCSV();
        /*---CompareTo_&_Equals-----*/
        System.out.println("Сравнение Менеджера-3 и Менеджера-2 = " + dif_users.get(2).compareTo(dif_users.get(1)));
        System.out.println("Равенство между Разработчиком-3 и Разработчиком-3 = " + dif_users.get(3).equals(dif_users.get(3)));
        System.out.println();

        Developer dev1 = new Developer("Ivan", 855596,101);
        Developer dev2 = new Developer("Peta", 855532,404);
        Developer dev3 = new Developer("Sasha", 855432,424);

        Task task1 = new Task(dev1,dev2);
        task1.setTask_specification("Выучить Kotlin для следующего проекта");
        task1.announceTask();

        Task task2 = new Task(dev1,dev3);
        task2.setTask_specification("Решить проблемы выявленые тестировщиками");
        task2.announceTask();

    }

    public static ArrayList<User> getUsers() {
        return dif_users;
    }
}