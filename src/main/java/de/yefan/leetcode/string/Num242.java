package de.yefan.leetcode.string;

import java.util.Arrays;

/**
 * Valid Anagram
 * https://leetcode.com/problems/valid-anagram/description/
 */
public class Num242 {

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int max1 = 0, max2 = 0;
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] > max1) {
                max1 = arr1[i];
            }
        }
        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i] > max2) {
                max2 = arr2[i];
            }
        }
        int max = Math.max(max1, max2);
        int[] countA = new int[max];
        int[] countB = new int[max];
        for (int i = 0; i < arr1.length; i++) {
            if (countA[arr1[i]] == 0) {
                countA[arr1[i]] = 1;
            } else {
                countA[arr1[i]]++;
            }
        }
        for (int i = 0; i < arr2.length; i++) {
            if (countB[arr2[i]] == 0) {
                countB[arr2[i]] = 1;
            } else {
                countB[arr2[i]]++;
            }
        }
        for (int i = 0; i < max; i++) {
            if (countA[i] != countB[i]) {
                return false;
            }
        }

        return true;
    }

    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

}
