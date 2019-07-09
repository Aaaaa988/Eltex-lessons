package ru.kiselev;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int k = 60000;
        ArrayList Alist = new ArrayList();
        LinkedList Llist = new LinkedList();
        Set treeSet = new TreeSet();

        System.out.println("ArrayList vs LinkedList"+"\n");
        ///------Add-----------///
        System.out.println("Add " + k + " elements");
        long start = System.currentTimeMillis();
        for (int i=0; i<k; i++){
            Alist.add(i);
        }
        long finish = System.currentTimeMillis();
        long time = finish - start;
        System.out.println("ArrayList " + time + " ms");

        start = System.currentTimeMillis();
        for (int i=0; i<k; i++){
            Llist.add(i);
        }
        finish = System.currentTimeMillis();
        time = finish - start;
        System.out.println("LinkedList " + time + " ms");
        ///-----------------------///
        System.out.print("\n");

        ///------Insert-to-middle-----------///
        System.out.println("Insert to middle " + k + " elements");
        start = System.currentTimeMillis();
        for (int i=0; i<k; i++){
            Alist.add(k/2,i);
        }
        finish = System.currentTimeMillis();
        time = finish - start;
        System.out.println("ArrayList " + time + " ms");

        start = System.currentTimeMillis();
        for (int i=0; i<k; i++){
            Llist.add(k/2,i);
        }
        finish = System.currentTimeMillis();
        time = finish - start;
        System.out.println("LinkedList " + time + " ms");
        ///-----------------------///
        System.out.print("\n");

        ///------Insert-to-begin-----------///
        System.out.println("Insert to begin " + k + " elements");
        start = System.currentTimeMillis();
        for (int i=0; i<k; i++){
            Alist.add(0,i);
        }
        finish = System.currentTimeMillis();
        time = finish - start;
        System.out.println("ArrayList " + time + " ms");

        start = System.currentTimeMillis();
        for (int i=0; i<k; i++){
            Llist.add(0,i);
        }
        finish = System.currentTimeMillis();
        time = finish - start;
        System.out.println("LinkedList " + time + " ms");
        ///-----------------------///
        System.out.print("\n");

        ///------Remove-from-middle-----------///
        System.out.println("Remove from middle " + k + " elements");
        start = System.currentTimeMillis();
        for (int i=0; i<k; i++){
            Alist.remove(k/2);
        }
        finish = System.currentTimeMillis();
        time = finish - start;
        System.out.println("ArrayList " + time + " ms");

        start = System.currentTimeMillis();
        for (int i=0; i<k; i++){
            Llist.remove(k/2);
        }
        finish = System.currentTimeMillis();
        time = finish - start;
        System.out.println("LinkedList " + time + " ms");
        ///-----------------------///
        System.out.print("\n");

        ///------Remove-from-begin-----------///
        System.out.println("Remove from begin " + k + " elements");
        start = System.currentTimeMillis();
        for (int i=0; i<k; i++){
            Alist.remove(0);
        }
        finish = System.currentTimeMillis();
        time = finish - start;
        System.out.println("ArrayList " + time + " ms");

        start = System.currentTimeMillis();
        for (int i=0; i<k; i++){
            Llist.remove(0);
        }
        finish = System.currentTimeMillis();
        time = finish - start;
        System.out.println("LinkedList " + time + " ms");
        ///-----------------------///
        System.out.print("\n");

        ///------Get-from-middle-----------///
        System.out.println("Get from middle " + k + " elements");
        start = System.currentTimeMillis();
        for (int i=0; i<k; i++){
            Alist.get(k/2);
        }
        finish = System.currentTimeMillis();
        time = finish - start;
        System.out.println("ArrayList " + time + " ms");

        start = System.currentTimeMillis();
        for (int i=0; i<k; i++){
            Llist.get(k/2);
        }
        finish = System.currentTimeMillis();
        time = finish - start;
        System.out.println("LinkedList " + time + " ms");
        ///-----------------------///
        System.out.print("\n");

        ///------Set-from-middle-----------///
        System.out.println("Set from middle " + k + " elements");
        start = System.currentTimeMillis();
        for (int i=0; i<k; i++){
            Alist.set(k/2,i);
        }
        finish = System.currentTimeMillis();
        time = finish - start;
        System.out.println("ArrayList " + time + " ms");

        start = System.currentTimeMillis();
        for (int i=0; i<k; i++){
            Llist.set(k/2,i);
        }
        finish = System.currentTimeMillis();
        time = finish - start;
        System.out.println("LinkedList " + time + " ms");
        ///-----------------------///
        System.out.print("\n");

        System.out.println("HashSet vs HashMap vs TreeSet"+"\n");
        HashSet hashSet = new HashSet();
        HashMap hashMap = new HashMap();
        ///-------Add-------------------------///
        System.out.println("Add " + k + " elements");
        start = System.currentTimeMillis();
        for (int i=0; i<k; i++){
            hashSet.add(i);
        }
        finish = System.currentTimeMillis();
        time = finish - start;
        System.out.println("HashSet " + time + " ms");

        start = System.currentTimeMillis();
        for (int i=0; i<k; i++){
            hashMap.put(i,i);
        }
        finish = System.currentTimeMillis();
        time = finish - start;
        System.out.println("HashMap " + time + " ms");


        start = System.currentTimeMillis();
        for (int i=0; i<k; i++){
            treeSet.add(i);
        }
        finish = System.currentTimeMillis();
        time = finish - start;
        System.out.println("TreeSet " + time + " ms");

    }
}
