package com.study.datastructure.list;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class LinkedListTest {
    LinkedList linkedList = new LinkedList();
    int size = 10;

    @Before
    public void before() {
        //
        for (int i = 0; i < size; i++) {
            linkedList.add(i);
        }
    }

    @Test
    public void addByIndexIntoEmpty() {
        linkedList.clear();
        linkedList.add("1", 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addByWrongIndexIntoEmpty() {
        linkedList.clear();
        linkedList.add("1", 1);
    }

    @Test
    public void addByIndex() {
        linkedList.add("w", 5);
    }

    @Test
    public void addByIndexIntoFirst() {
        linkedList.add("w", 0);
    }

    @Test
    public void addByIndexIntoLast() {
        linkedList.add("w", size);
    }

    @Test
    public void removeFirst() {
        Object expected = linkedList.get(1);
        linkedList.remove(0);
        Object actual = linkedList.get(0);
        assertEquals(expected, actual);
    }

    @Test
    public void removeLast() {
        Object expected = linkedList.get(size - 2);
        linkedList.remove(size - 1);
        size--;
        Object actual = linkedList.get(size - 1);
        assertEquals(expected, actual);
    }

    @Test
    public void removeMiddle() {
        Object expected = linkedList.get(size - 3);
        linkedList.remove(size - 2);
        size--;
        Object actual = linkedList.get(size - 2);
        assertEquals(expected, actual);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeWhenOneElement() {
        linkedList.clear();
        Object o = "a";
        linkedList.add(o);

        linkedList.remove(0);
        Object actual = linkedList.get(0);
        assertEquals(0, actual);
    }


    @Test
    public void get() {
        Object expected = "b";
        linkedList.set(expected, 7);
        Object actual = linkedList.get(7);
        assertEquals(expected, actual);
    }

    @Test
    public void getFirst() {
        Object expected = 0;
        Object actual = linkedList.get(0);
        assertEquals(expected, actual);
    }

    @Test
    public void getLast() {
        Object expected = 9;
        Object actual = linkedList.get(9);
        assertEquals(expected, actual);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getOutOfIndex() {
        Object expected = 10;
        Object actual = linkedList.get(10);
        assertEquals(expected, actual);
    }


    @Test
    public void set() {
        Object expected = linkedList.get(7);
        Object o = "b";
        Object actual = linkedList.set(o, 7);
        assertEquals(expected, actual);

        Object actualNew = linkedList.get(7);
        assertEquals(o, actualNew);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setOutOfIndex() {
        Object expected = "10";
        Object actual = linkedList.set("10", 10);
        assertEquals(expected, actual);
    }

    @Test
    public void clear() {
        boolean expected = false;
        boolean actual = linkedList.isEmpty();
        assertEquals(expected, actual);

        linkedList.clear();
        expected = true;
        actual = linkedList.isEmpty();
        assertEquals(expected, actual);
    }

    @Test
    public void isEmpty() {
        boolean expected = false;
        boolean actual = linkedList.isEmpty();
        assertEquals(expected, actual);
    }

    @Test
    public void size() {
        linkedList.clear();
        linkedList.add("1", 0);
        int expected = 1;
        int actual = linkedList.size();
        assertEquals(expected, actual);
    }

    @Test
    public void sizeOnEmpty() {
        linkedList.clear();
        int expected = 0;
        int actual = linkedList.size();
        assertEquals(expected, actual);
    }



    @Test
    public void contains() {
        boolean expected = true;
        boolean actual = linkedList.contains(3);
        assertEquals(expected, actual);
    }

    @Test
    public void containsFalse() {
        boolean expected = false;
        boolean actual = linkedList.contains("asd");
        assertEquals(expected, actual);
    }


    @Test
    public void indexOfExisting() {
        int expected = 3;
        int actual = linkedList.indexOf(3);
        assertEquals(expected, actual);

        Object o = "a";
        linkedList.set(o, 3);
        actual = linkedList.indexOf(o);
        assertEquals(expected, actual);
    }

    @Test
    public void indexOfNotExisting() {
        int expected = -1;
        int actual = linkedList.indexOf(12);
        assertEquals(expected, actual);

    }

    @Test
    public void lastIndexOfExisting() {
        int expected = 5;
        int actual = linkedList.lastIndexOf(5);
        assertEquals(expected, actual);
    }

    @Test
    public void lastIndexOfExistingTwice() {
        int expected = 7;
        linkedList.set(5, 7);
        int actual = linkedList.lastIndexOf(5);
        assertEquals(expected, actual);
    }

    @Test
    public void lastIndexOfNotExisting() {
        int expected = -1;
        int actual = linkedList.lastIndexOf(12);
        assertEquals(expected, actual);
    }

    @Test
    public void lastIndexOfFirst() {
        int expected = 0;
        int actual = linkedList.lastIndexOf(0);
        assertEquals(expected, actual);
    }

    @Test
    public void lastIndexOfLast() {
        int expected = 9;
        int actual = linkedList.lastIndexOf(9);
        assertEquals(expected, actual);
    }

    @Test
    public void iterator() {
        Iterator iterator = linkedList.iterator();
        int i = -1;
        while (iterator.hasNext()) {
            i++;
            Object expected = linkedList.get(i);
            Object actual = iterator.next();
            assertEquals(expected, actual);
        }
    }
}