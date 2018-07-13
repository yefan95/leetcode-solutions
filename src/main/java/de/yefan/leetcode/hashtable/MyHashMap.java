package de.yefan.leetcode.hashtable;

import java.util.Arrays;

/**
 * Design HashMap
 */
public class MyHashMap {

    private int buckets = 1000;
    // 1 additional item to handle edge case value = 0
    private int itemsPerBucket = 1001;
    private int[][] table;

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        table = new int[buckets][];
    }

    public int hash(int key) {
        return key % buckets;
    }

    public int pos(int key) {
        return key / buckets;
    }

    /**
     * value will always be positive.
     */
    public void put(int key, int value) {
        int hashkey = hash(key);

        if (table[hashkey] == null) {
            table[hashkey] = new int[itemsPerBucket];
            // edge case value = 0
            Arrays.fill(table[hashkey], -1);
        }
        table[hashkey][pos(key)] = value;
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        int hashkey = hash(key);
        int pos = pos(key);

        if (table[hashkey] == null) {
            return -1;
        }

        return table[hashkey][pos];
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        int hashkey = hash(key);

        if (table[hashkey] != null) {
            table[hashkey][pos(key)] = -1;
        }
    }

    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        // returns 1
        hashMap.get(1);
        // returns -1 (not found)
        hashMap.get(3);
        // update the existing value
        hashMap.put(2, 1);
        // returns 1
        hashMap.get(2);
        // remove the mapping for 2
        hashMap.remove(2);
        // returns -1 (not found)
        hashMap.get(2);
    }
}
