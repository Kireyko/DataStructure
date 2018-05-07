package com.study.datastructure.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class HashMap implements Map {
    private static final int LENGTH_DEFAULT = 6;
    public static final double EXTEND_RATE = 1.6;
    public static final double LOAD_RATE = 0.85;
    private ArrayList[] buckets;
    private int size;

    HashMap() {
        initMap(LENGTH_DEFAULT);
    }

    @Override
    public Object put(Object key, Object value) {
        return putInternal(key, value, false);
    }


    @Override
    public Object putIfAbsent(Object key, Object value) {
        return putInternal(key, value, true);
    }

    @Override
    public void putAll(Map map) {
        for (Object object : map) {
            Node node = (Node) object;
            putInternal(node.key, node.value, false);
        }
    }

    @Override
    public void putAllIfAbsent(Map map) {
        for (Object object : map) {
            Node node = (Node) object;
            putInternal(node.key, node.value, true);
        }
    }

    @Override
    public Object get(Object key) {
        ArrayList bucket = buckets[getIndex(key)];
        for (Object object : bucket) {
            Node node = (Node) object;
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        return null;
    }

    @Override
    public Object remove(Object key) {
        ArrayList bucket = buckets[getIndex(key)];
        for (Object object : bucket) {
            Node node = (Node) object;
            if (node.key.equals(key)) {
                bucket.remove(object);
                size--;
                return node.value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean containsKey(Object key) {
        ArrayList bucket = buckets[getIndex(key)];
        for (Object object : bucket) {
            Node node = (Node) object;
            if (node.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return Arrays.toString(buckets);
    }

    private void initMap(int arrayLength) {
        buckets = new ArrayList[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            buckets[i] = new ArrayList();
        }
        size = 0;
    }

    private Object putInternal(Object key, Object value, Boolean putIfAbsent) {

        int index = getIndex(key);//null keys are not allowed

        ArrayList bucket = buckets[index];
        for (Object object : bucket) {
            Node node = (Node) object;
            if (node.key.equals(key)) {
                Node nodeReturn = new Node(node.key, node.value);
                if (putIfAbsent == false) {
                    node.value = value;
                }
                return nodeReturn;
            }
        }
        bucket.add(new Node(key, value));
        size++;
        mapMaintenance();
        return null;
    }

    private void mapMaintenance() {
        if (size > LOAD_RATE * buckets.length) {
            ArrayList[] oldHashMap = buckets;
            initMap((int) (buckets.length * EXTEND_RATE + 1));

            for (ArrayList bucket : oldHashMap) {
                if (bucket != null) {
                    for (Object object : bucket) {
                        Node node = (Node) object;
                        if (node != null) {
                            put(node.key, node.value);
                        }
                    }
                }
            }
        }
    }

    private int getIndex(Object key) {
        return Math.abs(key.hashCode() % buckets.length);
    }

    @Override
    public Iterator iterator() {
        return new HashMapIterator();
    }

    private class HashMapIterator implements Iterator {
        int indexOfBucket = 0;
        int index = -1;

        @Override
        public boolean hasNext() {
            return checkIfNextNotNullElementExist(index, indexOfBucket);
        }

        @Override
        public Node next() {
            if (index < buckets[indexOfBucket].size() - 1) {
                index++;
            } else if (indexOfBucket < buckets.length - 1) {
                indexOfBucket++;
                index = 0;
            } else throw new IndexOutOfBoundsException();

            if (buckets[indexOfBucket].size() > 0) {
                Node nodeNext = (Node) buckets[indexOfBucket].get(index);
                if (nodeNext != null) {
                    return nodeNext;
                }
            }
            return next();
        }

        private Boolean checkIfNextNotNullElementExist(int indexInt, int indexOfBucketInt) {
            if (indexInt < buckets[indexOfBucketInt].size() - 1) {
                indexInt++;
            } else if (indexOfBucketInt < buckets.length - 1) {
                indexOfBucketInt++;
                indexInt = 0;
            } else return false;

            if (buckets[indexOfBucketInt].size() > 0) {
                Node node = (Node) buckets[indexOfBucketInt].get(indexInt);
                if (node != null) {
                    return true;
                }
            }
            return checkIfNextNotNullElementExist(indexInt, indexOfBucketInt);
        }
    }

    private static class Node {
        Object key;
        Object value;

        Node(Object key, Object value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + ": " + value + "}";
        }
    }
}