package ru.kiselev;

public class Printer{
    static private volatile Integer a = 0;
    
    public void ink(){
        a+=1;
        System.out.println(a);
    }
    
    public int print_a(){
        return a;
    }
    
}
 
