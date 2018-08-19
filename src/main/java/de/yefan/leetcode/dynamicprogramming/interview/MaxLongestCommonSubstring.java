package de.yefan.leetcode.dynamicprogramming.interview;

/**
 * 给定两个字符串str1和str2，返回两个字符串的最长公共子串
 */
public class MaxLongestCommonSubstring {

    public static void main(String[] args) {
        String str1 = "A1234B";
        String str2 = "CD1234";
        String res = lcse(str1, str2);
        System.out.println(res.length());
        System.out.println(res);
    }

    public static int[][] getdp(char[] str1, char[] str2) {
        int[][] dp = new int[str1.length][str2.length];
        dp[0][0] = str1[0] == str2[0] ? 1 : 0;
        for (int i = 1; i < str1.length; i++) {
            if (str1[i] == str2[0]) {
                dp[i][0] = 1;
            }
        }
        for (int j = 1; j < str2.length; j++) {
            if (str2[j] == str1[0]) {
                dp[0][j] = 1;
            }
        }

        for (int i = 1; i < str1.length; i++) {
            for (int j = 1; j < str2.length; j++) {
                if (str1[i] == str2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
            }
        }

        return dp;
    }

    public static String lcse(String str1, String str2) {
        if (str1 == null || str2 == null || str1.equals("") || str2.equals("")) {
            return "";
        }
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        int[][] dp = getdp(chs1, chs2);

        int end = 0;
        int max = 0;
        for (int i = 0; i < chs1.length; i++) {
            for (int j = 0; j < chs2.length; j++) {
                if (dp[i][j] > max) {
                    max = dp[i][j];
                    end = i;
                }
            }
        }

        return str1.substring(end - max + 1, end + 1);
    }

}
