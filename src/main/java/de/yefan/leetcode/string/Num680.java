package de.yefan.leetcode.string;

/**
 * Valid Palindrome II
 * https://leetcode.com/problems/valid-palindrome-ii/description/
 */
public class Num680 {

    public boolean validPalindrome(String s) {
        if ("".equals(s)) {
            return true;
        }
        char[] arr = s.trim().toCharArray();
        int start = 0, end = arr.length - 1;
        while (start < end) {
            if (arr[start] != arr[end]) {
                return (isPalindromeRange(arr, start + 1, end) || isPalindromeRange(arr, start, end - 1));
            }
            start++;
            end--;
        }
        return true;
    }

    public boolean isPalindromeRange(char[] arr, int i, int j) {
        for (int k = i; k <= (i + j) / 2; k++) {
            if (arr[k] != arr[j - k + i]) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindromeRange(String s, int i, int j) {
        for (int k = i; k <= i + (j - i) / 2; k++) {
            if (s.charAt(k) != s.charAt(j - k + i)) {
                return false;
            }
        }
        return true;
    }

    public boolean validPalindrome1(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                int j = s.length() - 1 - i;
                return (isPalindromeRange(s, i + 1, j) ||
                        isPalindromeRange(s, i, j - 1));
            }
        }
        return true;
    }

}
