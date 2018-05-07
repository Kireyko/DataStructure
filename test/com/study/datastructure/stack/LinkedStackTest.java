package com.study.datastructure.stack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LinkedStackTest {
    LinkedStack linkedStack = new LinkedStack();

    @Before
    public void before() {
        for (int i = 0; i < 10; i++) {
            linkedStack.push(i);
        }
    }

    @Test
    public void pushAndPop() {
        linkedStack.clear();
        for (int i = 9; i >=0; i--) {
            linkedStack.push(i);
            Object expected = i;
            Object actual = linkedStack.pop();
            assertEquals(expected, actual);
        }
    }

    @Test
    public void peek() throws Exception { //does not  modify
        Object expected = 9;
        for (int i = 9; i >=0; i--) {
            Object actual = linkedStack.peek();
            assertEquals(expected, actual);
        }
    }

    @Test
    public void pop() throws Exception {
        for (int i = 9; i >=0; i--) {
            Object expected = i;
            Object actual = linkedStack.pop();
            assertEquals(expected, actual);
        }
    }

}
