package ru.kiselev;

import java.lang.reflect.*;

public class Reflection {
    public static void main(String[] args) {
        Test_Class test_class = new Test_Class();
        Class info_class = test_class.getClass();

        System.out.println("Name of class - " + info_class.getName());
        System.out.println("Methods of Test_Class Class:");
        Field[] fields = info_class.getDeclaredFields();
        for(Field field : fields) {
            System.out.println(field.getName());
        }
        System.out.println("Methods of Test_Class Class:");
        Method[] method = info_class.getMethods();
        for(Method meth : method) {
            System.out.println(meth.getName());
        }
    }
}
