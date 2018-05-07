package com.study.datastructure.stack;

public class LinkedStack {
    int size = 0;
    Node tail;

    public void push(Object value) {
        Node newNode = new Node(value);
        if (tail == null) {
            tail = newNode;
        } else {
            newNode.previous = tail;
            tail = newNode;
        }
        size++;
    }

    private void validateSize() {
        if (size == 0) throw new IndexOutOfBoundsException();
    }

    public Object pop() {
        validateSize();
        Node last = tail;
        tail = last.previous;
        size--;
        return last.value;
    }

    public Object peek() {//does not modify
        validateSize();
        return tail.value;
    }

    public void clear(){
        size=0;
        tail=null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (size > 0) {
            Node node = tail;
            while (node != null) {
                stringBuilder.append(node.value + " ");
                node=node.previous;
            }
        }
        return stringBuilder.toString();

    }

    public class Node {
        Object value;
        Node previous;

        public Node(Object value) {
            this.value = value;
        }
    }
}

