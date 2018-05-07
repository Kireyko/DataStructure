package com.study.datastructure.list;

import java.util.Iterator;
import java.util.StringJoiner;

public class LinkedList implements List {
    private int size;
    private Node head;
    private Node tail;

    @Override
    public void add(Object value) {
        add(value, size);
    }

    @Override
    public void add(Object value, int index) {
        validateIndex(index);
        Node node = new Node(value);
        if (size == 0) {//into empty
            head = tail = node;
        } else if (index == size) {//add after all existing
            node.previous = tail;
            tail.next = node;
            tail = node;
        } else if (index == 0) {//add  into beginning
            head.previous = node;
            node.next = head;
            head = node;
        }else if(index==size-1){//add into last position
            node.next=tail;
            node.previous = tail.previous;
            tail.previous.next=node;
            tail.previous=node;
        }else {
            Node current = getNode(index);
            current.previous.next = node;
            node.previous = current.previous;
            current.previous = node;
            node.next = current;
        }
        size++;
    }

    @Override
    public Object remove(int index) {
        validateIndexForExisting(index);
        Node returnNode;

        if (size == 1) {
            returnNode = head;
            head = tail = null;
        } else if (index == 0) {//first
            returnNode = head;
            head.next.previous = null;
            head = head.next;
        } else if (index == size - 1) {//last
            returnNode = tail;
            Node previous;
            previous = tail.previous;
            tail = previous;
            tail.next = null;
        } else {
            Node current = getNode(index);
            returnNode = current;
            current.next.previous = current.previous;
            current.previous.next = current.next;
        }
        size--;
        return returnNode.value;
    }

    @Override
    public Object get(int index) {
        validateIndexForExisting(index);
        Node returnNode;
        if (index == 0) {
            returnNode = head;
        } else if (index == size - 1) {
            returnNode = tail;
        } else {
            returnNode = getNode(index);
        }
        return returnNode.value;
    }

    @Override
    public Object set(Object value, int index) {
        validateIndexForExisting(index);
        Node node = new Node(value);
        Node returnNode;
        if (index == 0) {
            returnNode = head;
            head.next.previous = node;
            node.next = head.next;
            head = node;
        } else if (index == size - 1) {
            returnNode = tail;
            tail.previous.next = node;
            tail = node;
        } else  {
            Node current = getNode(index);
            returnNode = current;
            current.next.previous = node;
            node.next = current.next;
            node.previous = current.previous;
            current.previous.next = node;
        }
        return returnNode.value;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object value) {
        return indexOf(value) != -1;
    }

    @Override
    public int indexOf(Object value) {
        Node currentNode = head;
        int i = 0;
        while (currentNode != null) {
            if (value.equals(currentNode.value)) {
                return i;
            }
            currentNode = currentNode.next;
            i++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        Node currentNode = tail;
        int i = size - 1;
        while (currentNode != null) {
            if (value.equals(currentNode.value)) {
                return i;
            }
            currentNode = currentNode.previous;
            i--;
        }
        return -1;
    }

    @Override
    public Iterator iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator {
        Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Object next() {
            Object value = current.value;
            current = current.next;
            return value;
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("was selected index(" + index + ") that is absent in the list ");
        }
    }

    private void validateIndexForExisting(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private Node getNode(int index){
        Node current;
        if ((size / 2 + 1) > index) {//start from head
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {//start from tail
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.previous;
            }
        }
        return current;
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");

        Node currentNode = head;
        while (currentNode != null) {
            stringJoiner.add(currentNode.value.toString());
            currentNode = currentNode.next;
        }
        return stringJoiner.toString();
    }

    private static class Node {
        Object value;
        Node next;
        Node previous;

        public Node(Object value) {
            this.value = value;
        }
    }


}
