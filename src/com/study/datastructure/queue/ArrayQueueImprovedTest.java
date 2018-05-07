package com.study.datastructure.queue;
import java.io.IOException;

public class ArrayQueueImprovedTest {
    public static void main(String[] args) throws IOException {
        ArrayQueueImproved queue = new ArrayQueueImproved();
        for (int i = 0; i < 15; i++) {
            queue.enqueue(i);
        }

        queue.dequeue();
        queue.dequeue();
        System.out.println(queue.toStringArray());
        System.out.println(queue.toString());

        queue.enqueue("q");

        for (int i = 0; i < 14; i++) {
            try {
                queue.printQueueParams();
                queue.dequeue();
            } catch (IOException e) {
                System.out.println("queue is already empty");
            }
        }

        System.out.println(queue);

        try {
            queue.enqueue(null);
        } catch (IOException e){
            System.out.println("can`t insert null ");
        }
        System.out.println(queue.toStringArray());
    }
}

