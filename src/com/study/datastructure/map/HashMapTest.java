package com.study.datastructure.map;

import java.util.Iterator;
import java.util.Map;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        for (int i =0; i<=6; i++){
            hashMap.put("t"+i, i*2);
        }
        System.out.println(hashMap);

//        HashMap hashMap2 = new HashMap();
//        for (int i =5; i<=10; i++){
//            hashMap2.put("t"+i, i*3);
//        }
//        System.out.println(hashMap2);
//
//        hashMap.putAllIfAbsent(hashMap2);
//        System.out.println(hashMap);
//
//        hashMap.putAll(hashMap2);
//        System.out.println(hashMap);

//        System.out.println(hashMap.putIfAbsent("1", "11"));
//        System.out.println(hashMap);
//        System.out.println(hashMap.put("1", "111"));
//        System.out.println(hashMap);
//        System.out.println(hashMap.containsKey("6"));


        hashMap.put("t", "tt");
        System.out.println(hashMap);
        System.out.println(hashMap.remove("t"));
        System.out.println(hashMap);
        //        System.out.println(hashMap.get("t"));

//        System.out.println(hashMap.get("t"));
//        System.out.println(hashMap.get("p"));
//        System.out.println(hashMap.containsKey("t"));
//        System.out.println(hashMap.containsKey("p"));
        //hashMap.put(null, null);
        //System.out.println(hashMap.get("t6"));

        //System.out.println(hashMap.get("6"));

//        Iterator iterator = hashMap.iterator();
//        while (iterator.hasNext()) {
//            System.out.print (iterator.next()+ " ");
//        }
//        System.out.println();
//
//        for (int i =0; i<20; i++){
//            hashMap.put("t"+i, i*2);
//        }
//        System.out.println(hashMap.size() + " " + hashMap);
//
//        iterator = hashMap.iterator();
//        while (iterator.hasNext()) {
//            System.out.print (iterator.next()+ " ");
//        }
    }

}
