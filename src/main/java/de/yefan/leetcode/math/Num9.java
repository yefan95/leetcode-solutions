package de.yefan.leetcode.math;

/**
 * Palindrome Number
 * https://leetcode.com/problems/palindrome-number/description/
 */
public class Num9 {
    public boolean isPalindrome(int x) {

        if (x < 0) {
            return false;
        }
        String str = Integer.toString(x);
        System.out.println(str);
        int start = 0, end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {
        Num9 num9 = new Num9();
        boolean res = num9.isPalindrome(1000021);
        int num = 1000021;
        System.out.println(num > Integer.MAX_VALUE);
        System.out.println(res);
    }
}
