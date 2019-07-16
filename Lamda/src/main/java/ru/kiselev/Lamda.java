package ru.kiselev;

import java.util.ArrayList;

public class Lamda {
    public static void main(String[] args) {
        ArrayList <Integer> Alist = new ArrayList<Integer>();
        for(int i = 1; i <= 1000; i++){
            Alist.add(i);
            System.out.println(i + " = " + (i*i));
        }

        Alist.stream().map(x->x*x).forEach(Sum_square::add_sum);

        System.out.println("Сумма квадратов от 0 до 1000 равна:");
        System.out.println(Sum_square.getSum());
    }
}
