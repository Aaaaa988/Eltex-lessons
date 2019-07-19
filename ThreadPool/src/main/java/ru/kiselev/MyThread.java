package ru.kiselev;


public class MyThread implements Runnable {
    public void run()
    {
        //System.out.println("Thread-" + num);
        for(int i = 1; i<=3; i++){
            System.out.println("Поток:"+Thread.currentThread().getName()+"  номер в конструкторе:" +num +" "+ " итерация цикла в потоке:"+ i);
        }
    }

    public MyThread(Integer num){
        this.num = num;
    }

    private Integer num;
}
