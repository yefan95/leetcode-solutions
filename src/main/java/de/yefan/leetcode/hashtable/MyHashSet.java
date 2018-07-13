package de.yefan.leetcode.hashtable;

/**
 * Design HashSet
 */
public class MyHashSet {

    private int buckets = 1000;
    private int itemsPerBucket = 1001;
    private boolean[][] table;

    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {
        table = new boolean[buckets][];
    }

    public int hash(int key) {
        return key % buckets;
    }

    public int pos(int key) {
        return key / buckets;
    }

    public void add(int key) {
        int hashkey = hash(key);

        if (table[hashkey] == null) {
            table[hashkey] = new boolean[itemsPerBucket];
        }
        table[hashkey][pos(key)] = true;
    }

    public void remove(int key) {
        int hashkey = hash(key);

        if (table[hashkey] != null) {
            table[hashkey][pos(key)] = false;
        }
    }

    /**
     * Returns true if this set did not already contain the specified element
     */
    public boolean contains(int key) {
        int hashkey = hash(key);
        return table[hashkey] != null && table[hashkey][pos(key)];
    }


    public static void main(String[] args) {
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        // returns true
        boolean res = hashSet.contains(1);
        System.out.println(res);
        // returns false (not found)
        res = hashSet.contains(3);
        System.out.println(res);
        hashSet.add(2);
        // returns true
        res = hashSet.contains(2);
        System.out.println(res);
        hashSet.remove(2);
        // returns false (already removed)
        res = hashSet.contains(2);
        System.out.println(res);
    }
}
