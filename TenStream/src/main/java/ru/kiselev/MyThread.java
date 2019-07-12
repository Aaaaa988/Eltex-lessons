package ru.kiselev;

public class MyThread implements Runnable {
    private Integer i = 0;
    public void run(){
       System.out.println("Thread-" + this.i);
    }
    public MyThread(Integer i){
        this.i = i;
    }
}
