package com.study.datastructure.queue;

import java.io.IOException;

public class ArrayQueue {
    Object[] array;
    int size;

    public ArrayQueue() {
        array = new Object[5];
    }

    void checkFullness(){
        if (size == array.length) {
            Object[] newArray = new Object[(int) (1.5 * size)];
            for (int i = 0; i < size; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }

    void enqueue(Object value) throws IOException {
        if (value!=null) {
            checkFullness();
            array[size] = value;
            size++;
        } else throw new IOException();
    }

    Object dequeue() throws IOException {
        if (size >0) {
            Object object = array[0];

            for (int i = 0; i < size; i++) {
                array[i] = array[i+1];
            }
            array[size]=null;
            size--;
            return object;
        }
        throw new IOException();
    }

    int size() {
        return size;
    }

    public String toString() {
        String result = "[";
        for (int i = 0; i < size; i++) {
            result += array[i];
            if (i != size - 1) {
                result += ", ";
            }
        }
        return result + "]";
    }
}