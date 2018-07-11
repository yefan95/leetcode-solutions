package de.yefan.leetcode.string;

/**
 * Longest Palindromic Substring
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 */
public class Num5 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int max = 0;
        String res = null;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isPalindromeRange(s, i, j)) {
                    if (max < (j - i + 1)) {
                        max = j - i + 1;
                        res = s.substring(i, j + 1);
                    }
                }
            }
        }

        return res;
    }


    private boolean isPalindromeRange(String s, int i, int j) {
        for (int k = i; k <= i + (j - i) / 2; k++) {
            if (s.charAt(k) != s.charAt(j - k + i)) {
                return false;
            }
        }
        return true;
    }

    public String longestPalindrome2(String s) {
        if (s.length() <= 1) {
            return s;
        }
        int max = 0;
        String res = null;
        for (int i = 0; i < s.length(); i++) {
            if (isPalindromeRange(s, i, s.length() - 1)) {
                if (max < (s.length() - i)) {
                    max = s.length() - i;
                    res = s.substring(i, s.length());
                }
            }
        }
        return res;
    }

    public String longestPalindrome1(String s) {
        if (s.length() <= 1) {
            return s;
        }
        char[] characters = s.toCharArray();
        //用于存放str中最长回文子串所对应的下标
        int[] range = {0, 1};
        for (int i = 0; i < characters.length; i++) {
            i = helper(i, characters, range);
        }
        return s.substring(range[0], range[1]);
    }

    private int helper(int index, char[] c, int[] range) {
        int low = index;
        int high = index;
        //如果遇到相同字符，则high进位，如abba ，这样偶回文子串也可以当做奇回文处理了
        while (high < c.length - 1 && c[high] == c[high + 1]) {
            high++;
        }
        int cursor = high;

        while (high + 1 < c.length && low - 1 >= 0 && c[low - 1] == c[high + 1]) {
            low--;
            high++;
        }
        if (high - low + 1 > range[1] - range[0]) {
            range[0] = low;
            range[1] = high + 1;
        }
        return cursor;
    }

    public static void main(String[] args) {
        Num5 num5 = new Num5();
        String res = num5.longestPalindrome("babad");
        System.out.println(res);
    }

}
