package de.yefan.leetcode.string;

/**
 * Length of Last Word
 * https://leetcode.com/problems/length-of-last-word/description/
 */
public class Num58 {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }
        String[] str = s.split(" ");

        if (str.length <= 0) {
            return 0;
        }

        String last = str[str.length - 1];

        if (" ".equals(last)) {
            return 0;
        }

        return last.length();
    }

    public int lengthOfLastWord1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int tmp = 0;
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        for (; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                break;
            }
            tmp++;
        }
        return tmp;
    }

    public static void main(String[] args) {
        Num58 num58 = new Num58();
        int res = num58.lengthOfLastWord(" ");
    }
}
