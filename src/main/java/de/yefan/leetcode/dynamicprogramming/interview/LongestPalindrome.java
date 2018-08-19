package de.yefan.leetcode.dynamicprogramming.interview;

/**
 * 给定字符串A以及它的长度n，请返回最长回文子串的长度。
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        String str = "ccbcabaabba";
        int res = getLongestPalindrome(str, str.length());
        System.out.println(res);
    }


    public static int getLongestPalindrome(String A, int n) {

        boolean[][] dp = new boolean[n][n];
        String res = null;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = A.charAt(i) == A.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
                if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
                    res = A.substring(i, j + 1);
                }
            }
        }

        return res == null ? 0 : res.length();
    }


}
