package de.yefan.leetcode;

/**
 * Longest Common Prefix
 * https://leetcode.com/problems/longest-common-prefix/description/
 */
public class Num14 {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null) {
            return "";
        }
        if (strs.length == 0) {
            return "";
        }

        String s = strs[0];
        int index = 0;
        int size = s.length();
        StringBuffer sb = new StringBuffer();
        while (index < size) {
            boolean flag = true;
            for (int i = 1; i < strs.length; i++) {
                if (index > strs[i].length() - 1) {
                    return sb.toString();
                }
                if (s.charAt(index) != strs[i].charAt(index)) {
                    flag = false;
                    break;
                }
            }
            if (index == 0 && !flag) {
                return sb.toString();
            }
            if (flag) {
                sb.append(s.charAt(index));
            }
            index++;
        }
        return sb.toString();
    }

    /**
     * Vertical scanning
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    /**
     * Horizontal scanning
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

}
