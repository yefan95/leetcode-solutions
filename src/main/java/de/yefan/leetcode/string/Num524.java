package de.yefan.leetcode.string;

import java.util.*;

/**
 * Longest Word in Dictionary through Deleting
 * https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting/description/
 */
public class Num524 {
    public String findLongestWord(String s, List<String> d) {
        char[] arr = s.toCharArray();
        String res = "";
        int max = Integer.MIN_VALUE;
        for (String str : d) {
            if (str.length() >= max) {
                if (isContains(arr, str.toCharArray())) {
                    if (max < str.length() || res.compareTo(str) > 0) {
                        max = str.length();
                        res = str;
                    }
                }
            }
        }
        return res;
    }


    private boolean isContains(char[] a, char[] b) {
        int startA = 0, startB = 0;
        while (startA < a.length && startB < b.length) {
            if (a[startA] != b[startB]) {
                startA++;
            } else {
                startA++;
                startB++;
            }
        }
        if (startB == b.length) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Num524 num524 = new Num524();
//        String s = "abpcplea";
        String s = "aewfafwafjlwajflwajflwafj";
//        String[] str = {"ale", "apple", "monkey", "plea"};
        String[] str = {"apple", "ewaf", "awefawfwaf", "awef", "awefe", "ewafeffewafewf"};
//        String[] str = {"a", "b", "c"};
        String res = num524.findLongestWord(s, Arrays.asList(str));
        System.out.println(res);
    }
}
