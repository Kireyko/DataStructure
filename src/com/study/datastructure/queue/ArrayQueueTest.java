package com.study.datastructure.queue;

import java.io.IOException;

public class ArrayQueueTest {
    //
    public static void main(String[] args) throws IOException {
        ArrayQueue arrayQueue = new ArrayQueue();

        for (int i = 0; i < 2; i++) {
            arrayQueue.enqueue(i);
        }
        System.out.println(arrayQueue.size);
        System.out.println(arrayQueue);

        try {
            System.out.println(arrayQueue.dequeue());
            System.out.println(arrayQueue);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(arrayQueue.dequeue());
            System.out.println(arrayQueue);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(arrayQueue.size);
        try {
            arrayQueue.enqueue(null);
        } catch (IOException e){
            System.out.println("can`t insert null ");
        }
    }


}