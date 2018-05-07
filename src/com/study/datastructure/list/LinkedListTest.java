package com.study.datastructure.list;

import java.util.Iterator;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList linkedList=new LinkedList();

        for (int i = 0; i<10; i++){
            linkedList.add(i);
        }
        System.out.println(linkedList);
       // linkedList.remove(6);
//        System.out.println(linkedList);
        linkedList.add("a",1);

//        Iterator iterator = linkedList.iterator();
//        while (iterator.hasNext()){
//            System.out.print(iterator.next()+ " ");
//        }
        //linkedList.set("b", 7);
        System.out.println(linkedList);

    }
}