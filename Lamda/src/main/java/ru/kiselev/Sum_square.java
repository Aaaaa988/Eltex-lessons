package ru.kiselev;

public class Sum_square {
    private static Integer sum = 0;

    public static void add_sum(Integer number){
        sum+=number;
    }

    public static Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }
}
