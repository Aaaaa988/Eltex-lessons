package ru.kiselev;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main implements CSV{

    private static ArrayList<User> dif_users = new ArrayList<>();

    private static ArrayList<Developer> developers = new ArrayList<>();
    private static ArrayList<Manager> managers = new ArrayList<>();

    public static void main(String[] args) throws SQLException {

        for (int i = 0; i < 3; i++) {
            dif_users.add(new Manager("Менеджер-" + (i+1), (int)(Math.random() * 10000),(int)(i + 10),
                    new Sale[] {new Sale("Монитор"+i, 5543+i)}));
        }

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

        /*-------JSON-------------*/

        System.out.println("Работа с JSON:");

        for (int i = 0; i < 3; i++) {
            developers.add(new Developer("Developer-" + (i+1), (int)(Math.random() * 10000),(int)(i + 10)));
        }
        developers.get(0).addLang("Java", "Kotlin", "C#");
        developers.get(1).addLang("Python", "C++");
        developers.get(2).addLang("Java", "C", "Pascal");

        try {
            DevelopersWriteToJSON(developers);
        } catch (IOException e) {
            e.printStackTrace();
        }

        developers.clear();

        try {
            DevelopersReadFromJSON(developers);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 3; i++) {
            System.out.println(developers.get(i).toString());
        }

        /*----------------*/

        for (int i = 0; i < 3; i++) {
            managers.add(new Manager("Manager-" + (i+1), (int)(Math.random() * 1000),(int)(i + 10),
                    new Sale[] {new Sale("monitor"+i, 5543+i),new Sale("keyboard"+i, 843+i)}));
        }


        try {
            ManagersWriteToJSON(managers);
        } catch (IOException e) {
            e.printStackTrace();
        }

        managers.clear();

        try {
            ManagersReadFromJSON(managers);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 3; i++) {
            System.out.println(managers.get(i).toString());
        }

        System.out.println("Перенос из JSON в DB:");

        DUMP DB = new DUMP();
        try {
            DB.Print_DB();
        }catch (SQLException | IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static ArrayList<User> getUsers() {
        return dif_users;
    }

    private static void DevelopersWriteToJSON(ArrayList<Developer> developers) throws IOException {
        FileWriter fw = new FileWriter("Developer.json");
        for (Developer developer : developers) {
            fw.write(developer.writeToJSON());
            fw.write("\n");
        }
        fw.flush();
    }

    private static void ManagersWriteToJSON(ArrayList<Manager> managers) throws IOException {
        FileWriter fw = new FileWriter("Manager.json");
        for (Manager manager : managers) {
            fw.write(manager.writeToJSON());
            fw.write("\n");
        }
        fw.flush();
    }

    public static ArrayList<Developer> DevelopersReadFromJSON(ArrayList<Developer> developers) throws IOException {
        developers.clear();

        Scanner inputFile = new Scanner(new FileInputStream("Developer.json"));
        while (inputFile.hasNextLine()) {
            Developer developer = new Developer();
            developer.readFromJSON(inputFile.nextLine());
            developers.add(developer);
        }

        return developers;
    }

    public static ArrayList<Manager> ManagersReadFromJSON(ArrayList<Manager> managers) throws IOException {
        managers.clear();

        Scanner inputFile = new Scanner(new FileInputStream("Manager.json"));
        while (inputFile.hasNextLine()) {
            Manager manager = new Manager();
            manager.readFromJSON(inputFile.nextLine());

            managers.add(manager);
        }

        return managers;
    }
}