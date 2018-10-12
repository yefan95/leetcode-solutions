package de.yefan.leetcode.bitmanipulation;

/**
 * https://leetcode.com/problems/utf-8-validation/description/
 * <p>
 * UTF-8 Validation
 */
public class Num393 {

    public boolean validUtf8(int[] data) {
        int i = 0;
        while (i < data.length) {
            int curLeadingZero = leadingZero(data[i]);
            if (curLeadingZero == 0) {
                i++;
                continue;
            }
            if (curLeadingZero > 4 || curLeadingZero == 1) {
                return false;
            }
            int j = 1;
            for (; j < curLeadingZero; j++) {
                if (i + j >= data.length) {
                    return false;
                }
                int leadingZero = leadingZero(data[i] + j);
                if (leadingZero != 1) {
                    return false;
                }
            }
            i += j;
        }
        return true;
    }

    private int leadingZero(int num) {
        int cnt = 0;
        for (int i = 7; i >= 3; i--) {
            int mask = 1 << i;
            if ((num & mask) == 0) {
                break;
            }
            cnt++;
        }
        return cnt;
    }
}
