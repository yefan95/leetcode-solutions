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

    public boolean isPalindrome1(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        //需要考虑 单词大写、标点符号
        int len = s.length();
        //递归（一定要用递归解决）
        return isPalinDrome(s, 0, len - 1);
    }


    private boolean isPalinDrome(String s, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (!Character.isLetterOrDigit(s.charAt(start))) {
            return isPalinDrome(s, start + 1, end);
        } else if (!Character.isLetterOrDigit(s.charAt(end))) {
            return isPalinDrome(s, start, end - 1);
        } else if (Character.toLowerCase(s.charAt(start)) !=
                Character.toLowerCase(s.charAt(end))) {
            return false;
        } else if (Character.toLowerCase(s.charAt(start)) ==
                Character.toLowerCase(s.charAt(end))) {
            return isPalinDrome(s, start + 1, end - 1);
        }
        return true;
    }

    public static void main(String[] args) {
        Num125 num125 = new Num125();
//        String s = "A man, a plan, a canal: Panama";
        String s = "race a car";
        s = s.toLowerCase();
        System.out.println(s.charAt(0) == s.charAt(s.length() - 1));
        System.out.println(s.substring(0, s.length() - 1));
        boolean res = num125.isPalindrome1(s);
        System.out.println(res);
    }


}
