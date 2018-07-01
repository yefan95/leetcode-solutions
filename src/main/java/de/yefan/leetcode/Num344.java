package de.yefan.leetcode;

/**
 * Reverse String
 * https://leetcode.com/problems/reverse-string/description/
 */
public class Num344 {

    public String reverseString(String s) {

        if (s == null || "".equals(s)) {
            return s;
        }

        char[] arr = s.toCharArray();

        StringBuffer sb = new StringBuffer();

        for (int i = arr.length - 1; i >= 0; i--) {
            sb.append(arr[i]);
        }

        return sb.toString();
    }

    public String reverseString1(String s) {

        if (s == null || "".equals(s)) {
            return s;
        }

        char[] arr = s.toCharArray();

        int start = 0, end = arr.length - 1;

        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        StringBuffer sb = new StringBuffer();
        sb.append(arr);

        return sb.toString();
    }

    public String reverseString2(String s) {

        if (s == null || "".equals(s)) {
            return s;
        }

        char[] arr = s.toCharArray();

        int start = 0, end = arr.length - 1;

        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

        return new String(arr);
    }

    public static void main(String[] args) {
        Num344 num344 = new Num344();
        String res = num344.reverseString1("hello");
        System.out.println(res);
    }

}
