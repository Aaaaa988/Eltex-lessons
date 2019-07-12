package ru.kiselev;

public class Main{
    public static void main(String[] arg) throws InterruptedException{
        Printer pr = new Printer();
        
        for(int i = 0; i<10; i++){
        
        Runnable r = new MyThread(i,pr);
        Thread t = new Thread(r);
        
        t.start();
        }
        
    }
}
