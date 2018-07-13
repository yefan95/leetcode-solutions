package de.yefan.leetcode.hashtable;

import java.util.*;

/**
 * Isomorphic Strings
 * https://leetcode.com/problems/isomorphic-strings/description/
 */
public class Num205 {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i), b = t.charAt(i);
            if (map.containsKey(a)) {
                if (map.get(a) != b) {
                    return false;
                }
            } else if (!map.containsValue(b)) {
                map.put(a, b);
            } else {
                return false;
            }

        }

        return true;
    }

    public boolean isIsomorphic1(String s, String t) {
        if (s.length() <= 1) {
            return true;
        }
        if (s.length() != t.length()) {
            return false;
        }
        char[] source = s.toCharArray();
        char[] target = t.toCharArray();
        char[] sourceLetter = new char[256];
        char[] targetLetter = new char[256];
        for (int i = 0; i < s.length(); i++) {
            char sourceChar = source[i];
            char targetChar = target[i];
            if (sourceLetter[sourceChar] == 0 && targetLetter[targetChar] == 0) {
                sourceLetter[sourceChar] = targetChar;
                targetLetter[targetChar] = sourceChar;
            } else if (sourceLetter[sourceChar] != targetChar ||
                    targetLetter[targetChar] != sourceChar) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Num205 num205 = new Num205();
        String s = "abba", t = "abab";
        boolean res = num205.isIsomorphic(s, t);
        System.out.println(res);
    }
}
