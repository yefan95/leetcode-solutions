package de.yefan.leetcode.string;

/**
 * Number of Segments in a String
 * https://leetcode-cn.com/problems/number-of-segments-in-a-string/description/
 */
public class Num434 {
    public int countSegments(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }
        String[] words = s.trim().split(" ");
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            if (!"".equals(words[i])) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Num434 num434 = new Num434();
        int res = num434.countSegments("                ");
        System.out.println(res);
    }
}
