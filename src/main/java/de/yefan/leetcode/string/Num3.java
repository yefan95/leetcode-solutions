package de.yefan.leetcode.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 */
public class Num3 {

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<Character>();

        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public int lengthOfLongestSubstring1(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        int[] map = new int[256];
        Arrays.fill(map, -1);
        int start = -1, max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i)] > start) {
                start = map[s.charAt(i)];
            }
            map[s.charAt(i)] = i;
            max = Math.max(max, i - start);
        }

        return max;
    }

}
