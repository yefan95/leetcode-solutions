package de.yefan.leetcode;

/**
 * Reverse Words in a String
 * https://leetcode.com/problems/reverse-words-in-a-string/description/
 */
public class Num151 {

    public String reverseWords(String s) {
        if (s == null || "".equals(s)) {
            return s;
        }

        String[] str = s.trim().split(" ");

        StringBuffer sb = new StringBuffer();
        for (int i = str.length - 1; i >= 0; i--) {
            if (!"".equals(str[i])) {
                sb.append(str[i] + " ");
            }
        }

        return sb.toString().trim();
    }

    public static void main(String[] args) {
        Num151 num151 = new Num151();
        String res = num151.reverseWords("   a   b ");
        System.out.println(res);
    }

}
