package de.yefan.leetcode.string;

/**
 * Valid Palindrome
 * https://leetcode.com/problems/valid-palindrome/description/
 */
public class Num125 {

    public boolean isPalindrome(String s) {
        if (s == null || "".equals(s)) {
            return true;
        }

        char[] arr = s.trim().toLowerCase().toCharArray();

        int start = 0, end = arr.length - 1;
        while (start < end) {
            boolean conditionA = (arr[start] >= 'a' && arr[start] <= 'z') || (arr[start] >= '0' && arr[start] <= '9');
            boolean conditionB = (arr[end] >= 'a' && arr[end] <= 'z') || (arr[end] >= '0' && arr[end] <= '9');

            if (conditionA & conditionB) {
                if (arr[start] != arr[end]) {
                    return false;
                }
                start++;
                end--;
            } else if (!conditionA) {
                start++;
            } else if (!conditionB) {
                end--;
            } else {
                start++;
                end--;
            }
        }

        return true;
    }
}
