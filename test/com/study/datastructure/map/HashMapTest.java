package com.study.datastructure.map;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HashMapTest {
    HashMap hashMap = new HashMap();
    @Before
    public void setUp() {

        for (int i =0; i<=6; i++){
            hashMap.put("t"+i, i*2);
        }
    }

    @Test
    public void put() {
        hashMap = new HashMap();
        Object expected1  = "123";
        hashMap.put("t", expected1);
        Object actual = hashMap.get("t");
        assertEquals(expected1,actual);

        Object expected2  = "1234";
        hashMap.put("t", expected2);
        Object actual2 = hashMap.get("t");
        assertEquals(expected2,actual2);
    }

    @Test
    public void putIfAbsent() {
        Object expected  = 4;
        hashMap.putIfAbsent("t2", 5);
        Object actual = hashMap.get("t2");
        assertEquals(expected,actual);
    }

    @Test
    public void putAll()  {
        HashMap hashMap2 = new HashMap();
        hashMap2.put("t"+5, 5*3);
        hashMap.putAll(hashMap2);

        Object actual = hashMap.get("t5");
        assertEquals(5*3,actual);
    }

    @Test
    public void putAllIfAbsent(){
        HashMap hashMap2 = new HashMap();
        hashMap2.put("t"+5, 5*3);
        hashMap.putAllIfAbsent(hashMap2);

        Object actual = hashMap.get("t5");
        assertEquals(5*2,actual);
    }

    @Test
    public void get() {
        Object expected  = 4;
        Object actual = hashMap.get("t2");
        assertEquals(expected,actual);

    }

    @Test
    public void remove()  {
        Object expected  = 4;
        Object actual = hashMap.remove("t2");
        assertEquals(expected,actual);
    }


    @Test
    public void remove2()  {
        hashMap.remove("t2");
        Object expected  = null;
        Object actual = hashMap.get("t2");
        assertEquals(expected,actual);
    }

    @Test
    public void sizeRemove() {
        Object expected  = hashMap.size()-1;
        hashMap.remove("t3");
        Object actual = hashMap.size();
        assertEquals(expected,actual);
    }

    @Test
    public void sizePut() {
        Object expected  = hashMap.size()+1;
        hashMap.put("t10","33");
        Object actual = hashMap.size();
        assertEquals(expected,actual);
    }

    @Test
    public void containsKey() {
        Object actual =hashMap.containsKey("t2");
        assertEquals(true,actual);

        hashMap.remove("t2");
        Object actual2 = hashMap.containsKey("t2");
        assertEquals(false,actual2);
    }


}