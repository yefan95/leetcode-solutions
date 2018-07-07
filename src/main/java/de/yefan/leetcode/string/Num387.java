package de.yefan.leetcode.string;

import java.util.*;

/**
 * First Unique Character in a String
 * https://leetcode.com/problems/first-unique-character-in-a-string/description/
 */
public class Num387 {

    public int firstUniqChar(String s) {
        if (s == null || "".equals(s)) {
            return -1;
        }
        char[] arr = s.toCharArray();
        Map<Character, Integer> count = new LinkedHashMap<>();
        Map<Character, Integer> index = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!count.containsKey(arr[i])) {
                count.put(arr[i], 1);
            } else {
                count.put(arr[i], count.get(arr[i]) + 1);
            }
            index.put(arr[i], i);
        }
        for (Map.Entry entry : count.entrySet()) {
            if (entry.getValue() == (Integer) 1) {
                return index.get(entry.getKey());
            }
        }
        return -1;
    }

    public int firstUniqChar1(String s) {
        if (s == null || "".equals(s)) {
            return -1;
        }
        char[] arr = s.toCharArray();
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int[] count = new int[max + 1];
        int[] index = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            if (count[arr[i]] == 0) {
                count[arr[i]] = 1;
            } else {
                count[arr[i]]++;
            }
            index[arr[i]] = i;
        }
        int pos = Integer.MAX_VALUE;
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 1) {
                if (index[i] < pos) {
                    pos = index[i];
                }
            }
        }
        if (pos < Integer.MAX_VALUE) {
            return pos;
        }
        return -1;
    }

    public static void main(String[] args) {
        Num387 num387 = new Num387();
        int index = num387.firstUniqChar1("leetcode");
        System.out.println(index);
    }

}
