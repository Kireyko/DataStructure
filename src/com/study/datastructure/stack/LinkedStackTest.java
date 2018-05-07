package com.study.datastructure.stack;

public class LinkedStackTest {

    public static void main(String[] args) {
        LinkedStack linkedStack = new LinkedStack();
        for (int i = 0; i < 10; i++) {
            linkedStack.push(i);
        }

        System.out.println(linkedStack);
    }
}
