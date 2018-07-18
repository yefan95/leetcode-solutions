package de.yefan.leetcode.string;


/**
 * Reverse Words in a String III
 * https://leetcode.com/problems/reverse-words-in-a-string-iii/description/
 */
public class Num557 {

    public String reverseWords(String s) {
        if (s == null || "".equals(s)) {
            return s;
        }
        String[] str = s.split(" ");

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < str.length; i++) {
            if (!"".equals(str[i])) {
                String temp = reverseStr(str[i]);
                sb.append(temp + " ");
            }
        }

        return sb.toString().trim();
    }

    private String reverseStr(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            char temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }
        return new String(arr);
    }

    public static void main(String[] agrs) {
        Num557 num557 = new Num557();
        String res = num557.reverseWords("Let's take LeetCode contest");
        System.out.println(res);
    }


}
