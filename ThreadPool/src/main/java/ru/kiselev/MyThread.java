package ru.kiselev;


public class MyThread implements Runnable {
    public void run()
    {
        //System.out.println("Thread-" + num);
        for(int i = 1; i<=3; i++){
            System.out.println("Thread-" + num +" "+ i);
        }
    }

    public MyThread(Integer num){
        this.num = num;
    }

    private Integer num;
}
