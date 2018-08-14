package de.yefan.leetcode.dynamicprogramming;

/**
 * Palindromic Substrings
 * https://leetcode.com/problems/palindromic-substrings/description/
 */
public class Num647 {

    int count = 0;

    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            helper(s, i, i);
            helper(s, i, i + 1);
        }
        return count;
    }

    private void helper(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
    }

    public int countSubstrings1(String s) {
        int count = 0;
        boolean[][] check = new boolean[s.length()][s.length()];

        for (int end = 0; end < s.length(); end++) {
            for (int start = 0; start <= end; start++) {
                if (s.charAt(start) == s.charAt(end) && (start > end - 2 || check[start + 1][end - 1])) {
                    check[start][end] = true;
                    count++;
                }
            }
        }

        return count;
    }


}
