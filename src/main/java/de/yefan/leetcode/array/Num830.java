package de.yefan.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Positions of Large Groups
 * https://leetcode.com/problems/positions-of-large-groups/description/
 */
public class Num830 {

    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> res = new ArrayList<>();
        if (S.length() < 3) {
            return res;
        }
        char[] arr = S.toCharArray();
        int count = 0;
        int start = Integer.MAX_VALUE, end = Integer.MIN_VALUE;
        List<Integer> list;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                start = Math.min(start, i);
                end = Math.max(end, i);
                count++;
                if (i + 1 == arr.length - 1) {
                    count++;
                    end = Math.max(end, i + 1);
                    if (count >= 3) {
                        list = new ArrayList<>();
                        list.add(start);
                        list.add(end);
                        res.add(list);
                    }
                }
            } else {
                count++;
                end = Math.max(end, i);
                if (count >= 3) {
                    list = new ArrayList<>();
                    list.add(start);
                    list.add(end);
                    res.add(list);
                }
                start = Integer.MAX_VALUE;
                end = Integer.MIN_VALUE;
                count = 0;
            }
        }

        return res;
    }


    public List<List<Integer>> largeGroupPositions1(String S) {
        List<List<Integer>> res = new ArrayList<>();
        if (S.length() < 3) {
            return res;
        }
        char[] arr = S.toCharArray();
        char initialChar = arr[0];
        int count = 1;
        int start = 0, end;
        List<Integer> list;
        for (int i = 1; i < arr.length; i++) {
            if (initialChar == arr[i]) {
                count++;
            } else {
                if (count >= 3) {
                    end = i - 1;
                    list = new ArrayList<>();
                    list.add(start);
                    list.add(end);
                    res.add(list);
                    initialChar = arr[i];
                    start = i;
                    count = 1;
                } else {
                    start = i;
                    count = 1;
                    initialChar = arr[i];
                }
            }

            if (i == arr.length - 1) {
                if (count >= 3) {
                    end = i;
                    list = new ArrayList<>();
                    list.add(start);
                    list.add(end);
                    res.add(list);
                }
            }

        }

        return res;
    }

    public static void main(String[] args) {
        Num830 num830 = new Num830();
        String s = "abcdddeeeeaabbbcd";
        List<List<Integer>> res = num830.largeGroupPositions1(s);
        System.out.println(Arrays.toString(res.toArray()));
    }

}
