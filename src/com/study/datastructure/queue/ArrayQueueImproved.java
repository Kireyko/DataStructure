package com.study.datastructure.queue;

import java.io.IOException;

public class ArrayQueueImproved {
    Object[] array;
    int initialArrayLenght;
    int size;
    int first;
    int last;

    public ArrayQueueImproved() {
        initialArrayLenght=3;
        first = -1;
        last=-1;
        array = new Object[initialArrayLenght];
    }

    void modifyArray(){
        if (size == array.length) {
            Object[] newArray = new Object[(int) (1.5 * size)];
            for (int i = first; i <= last; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }else if((last==array.length-1)&&(size<array.length)) {
            for (int i = 0; i < size; i++) {
                array[i] = array[first+i];
            }
            first=0;
            for (int i = 0; i < size; i++) {
                array[last-i] = null;
            }
            last=size-1;
        }
    }
    void decreaseArray(){
        if((array.length>size*3)&&(size*3>initialArrayLenght)){
            Object[] newArray = new Object[(int) (1.5 * size)];
            for (int i = 0; i < size; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
            first=0;
            last=size-1;
        }
    }

    void enqueue(Object value) throws IOException {
        if (value!=null) {
            modifyArray();
            if(size==0){
                first++;
            }
            last++;
            size++;
            array[last] = value;
        } else throw new IOException();
    }

    Object dequeue() throws IOException {
        if (size >0) {
            Object object = array[first];
            array[first]=null;
            size--;
            if(size!=0){
                first++;
                decreaseArray();
            } else {
                first=-1;
                last=-1;
            };
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
            result += array[first+i];
            if (i <size-1) {
                result += ", ";
            }
        }
        return result + "]";
    }

    String toStringArray() {
        String result = "[";
        for (int i = 0; i < array.length; i++) {
            result += array[i];
            if (i != array.length - 1) {
                result += ", ";
            }
        }
        return result + "]";
    }
    void printQueueParams(){
        System.out.print("length:"+array.length);
        System.out.print(" size:"+size);
        System.out.print(" first:"+first);
        System.out.println(" last:"+last);
    }
}
