package de.yefan.leetcode.string;

/**
 * Valid Number
 * https://leetcode.com/problems/valid-number/description/
 */
public class Num65 {
    public boolean isNumber(String s) {
        s = s.trim();

        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numberSeen = false;
        boolean numberAfterE = true;
        for (int i = 0; i < s.length(); i++) {
            if ('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                numberSeen = true;
                numberAfterE = true;
            } else if (s.charAt(i) == '.') {
                if (eSeen || pointSeen) {
                    return false;
                }
                pointSeen = true;
            } else if (s.charAt(i) == 'e') {
                if (eSeen || !numberSeen) {
                    return false;
                }
                numberAfterE = false;
                eSeen = true;
            } else if (s.charAt(i) == '-' || s.charAt(i) == '+') {
                if (i != 0 && s.charAt(i - 1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
        }

        return numberSeen && numberAfterE;
    }

    public boolean isNumber1(String s) {
        char[] sArr = s.toCharArray();

        int cur = 0;
        boolean hasNumber = false;

        //1.去除前缀空格
        while (cur < sArr.length && isSpace(sArr[cur])) {
            cur++;
        }
        //2.去除-号,或者+号
        if (cur < sArr.length && isSign(sArr[cur])) {
            cur++;
        }

        //3.读取小数点之前的数字
        while (cur < sArr.length && isDigit(sArr[cur])) {
            cur++;
            hasNumber = true;
        }
        //4.读取小数点，以及小数点后面的数字
        if (cur < sArr.length && isDot(sArr[cur])) {
            cur++;

            if (cur < sArr.length && isDigit(sArr[cur])) {
                while (cur < sArr.length && isDigit(sArr[cur])) {
                    cur++;
                }
                hasNumber = true;
            } else if (!hasNumber)                        //小数点前后都没有数字
            {
                return false;
            }
        }
        //5.读取e，以及e后面的数字（包括符号）
        if (cur < sArr.length && isExponent(sArr[cur])) {
            //若是e之前没有数字，则是非法数字字符串
            if (!hasNumber) {
                return false;
            }
            cur++;

            //+或者-号
            if (cur < sArr.length && isSign(sArr[cur])) {
                cur++;
            }

            //数字
            if (cur < sArr.length && isDigit(sArr[cur])) {
                while (cur < sArr.length && isDigit(sArr[cur])) {
                    cur++;
                }
            } else {
                return false;
            }
        }

        //6.去除后缀空格
        while (cur < sArr.length && isSpace(sArr[cur])) {
            cur++;
        }

        return cur == sArr.length && hasNumber;
    }

    private boolean isSpace(char ch) {
        return ch == ' ';
    }

    private boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }

    private boolean isDot(char ch) {
        return ch == '.';
    }

    private boolean isExponent(char ch) {
        return ch == 'e';
    }

    private boolean isSign(char ch) {
        return ch == '-' || ch == '+';
    }

    public static void main(String[] args) {
        Num65 num65 = new Num65();
        boolean res = num65.isNumber(".1");
        System.out.println(res);
    }
}
