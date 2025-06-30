package linkedlist;

import java.util.LinkedList;

public class MyHashSet {
    Bucket[] buckets;
    private final int bucket_size = 10003;

    public MyHashSet() {
        buckets = new Bucket[bucket_size];
        for (int i = 0; i < bucket_size; i++) {
            buckets[i] = new Bucket();
        }
    }

    public void add(int key) {
        int bucketIndex = hash(key);
        buckets[bucketIndex].add(key);
    }

    public void remove(int key) {
        int bucketIndex = hash(key);
        buckets[bucketIndex].remove(key);
    }

    public boolean contains(int key) {
        int bucketIndex = hash(key);
        return  buckets[bucketIndex].contains(key);
    }

    public int hash(int key){
        return key%bucket_size;
    }

}

class Bucket {
    private LinkedList<Integer> container = new LinkedList<>();

    public void add(int key){
        if (!container.contains(key)) {
            container.add(key);
        }
    }

    public void remove(int key){
        container.remove(key);
    }

    public boolean contains(int key){
        return container.contains(key);
    }

}

