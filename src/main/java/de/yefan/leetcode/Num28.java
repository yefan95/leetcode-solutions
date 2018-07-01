package de.yefan.leetcode;

/**
 * Implement strStr()
 * https://leetcode.com/problems/implement-strstr/description/
 */
public class Num28 {

    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        int l1 = haystack.length();
        int l2 = needle.length();
        for (int i = 0; i < l1 - l2 + 1; i++) {
            int count = 0;
            while (count < l2 && haystack.charAt(i + count) == needle.charAt(count)) {
                count++;
            }
            if (count == l2) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Num28 num28 = new Num28();
        int pos = num28.strStr("mississippi", "issipi");
        System.out.println("pos= " + pos);
    }

}
