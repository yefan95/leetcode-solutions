package de.yefan.leetcode.string;

/**
 * Reverse String II
 * https://leetcode-cn.com/problems/reverse-string-ii/description/
 */
public class Num541 {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int length = s.length();
        int size = length;
        int index = 0;
        int start = 0, end = 0;
        while (true) {
            start = 2 * index * k;
            end = start + k - 1;
            end = Math.min(end, size - 1);
            if (length == 0) {
                break;
            } else if (0 < length && length < k) {
                reverse(arr, start, end);
                break;
            } else if (k <= length && length < 2 * k) {
                reverse(arr, start, end);
                break;
            } else {
                reverse(arr, start, end);
                length = length - 2 * k;
                index++;
            }
        }

        return new String(arr);
    }

    private void reverse(char arr[], int start, int end) {
        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Num541 num541 = new Num541();
        String s = "a";
        int k = 2;
        String res = num541.reverseStr(s, k);
        System.out.println(res);
    }

}
