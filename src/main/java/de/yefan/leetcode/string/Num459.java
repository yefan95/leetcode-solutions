package de.yefan.leetcode.string;

/**
 * Repeated Substring Pattern
 * https://leetcode.com/problems/repeated-substring-pattern/description/
 */
public class Num459 {
    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() <= 0) {
            return false;
        }

        for (int i = 1; i <= s.length() / 2; i++) {
            if (s.length() % i == 0) {
                boolean flag = true;
                String subStr = s.substring(0, i);
                int n = s.length() / i;
                int start = 0, end = i;
                while (n > 0) {
                    if (!s.substring(start, end).equals(subStr)) {
                        flag = false;
                        break;
                    }
                    start = start + i;
                    end = end + i;
                    n--;
                }
                if (flag) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean repeatedSubstringPattern1(String s) {
        int length = s.length();
        // length-1 is very important, because it ensures the substring is not the whole string
        for (int i = 2; i <= Math.min(Math.sqrt(length) + 1, length - 1); i++) {
            if (length % i == 0) {
                if (isRepeat(s, s.substring(0, i), i)
                        || isRepeat(s, s.substring(0, length / i), length / i)) {
                    return true;
                }
            }
        }
        if (length > 1 && isRepeat(s, s.substring(0, 1), 1)) {
            return true;
        }
        return false;
    }


    private boolean isRepeat(String s, String subSeq, int subSeqLength) {
        if (subSeqLength == s.length()) {
            return true;
        }
        if (!s.startsWith(subSeq, subSeqLength)) {
            return false;
        }
        return isRepeat(s, subSeq, subSeqLength + subSeq.length());
    }


    public static void main(String[] args) {
        Num459 num459 = new Num459();
        String s = "aba";
        System.out.println(s.substring(0, 1));
        System.out.println(s.substring(1, 2));
        boolean res = num459.repeatedSubstringPattern("abcabcabcabc");
//        boolean res = num459.repeatedSubstringPattern("aba");
        System.out.println(res);
    }

}
