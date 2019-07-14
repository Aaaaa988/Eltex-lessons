package ru.kiselev;

public class Task<T extends Developer, V extends Developer> {
    private T main_developer;
    private V ordinary_developer;
    private static Integer amount_Task=0;

    private String task_specification;


    public Task(T main_developer, V ordinary_developer) {
        this.main_developer = main_developer;
        this.ordinary_developer = ordinary_developer;
        amount_Task++;
    }

    public String getTask_specification() {
        return task_specification;
    }

    public void setTask_specification(String task_specification) {
        this.task_specification = task_specification;
    }

    public void announceTask() {
        System.out.println("Задача номер " + amount_Task);
        System.out.println("Главный разработчик: " + this.main_developer.getName());
        System.out.println("Рядовой разработчик: " + this.ordinary_developer.getName());
        System.out.println("Задача: \n" + task_specification + "\n");
    }
}
