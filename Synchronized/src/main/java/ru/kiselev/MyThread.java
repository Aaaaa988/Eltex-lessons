package ru.kiselev;

public class MyThread implements Runnable {
    private Integer i = 0;
    Printer pr;
    
    @Override
    public void run(){
    synchronized(pr){
        System.out.println("Thread-" + this.i);
        pr.ink();
       }
    }
    
    public MyThread(Integer i, Printer ob){
        this.i = i;
        this.pr = ob;
    }
}
