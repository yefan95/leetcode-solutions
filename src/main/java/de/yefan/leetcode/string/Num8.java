package de.yefan.leetcode.string;

/**
 * String to Integer (atoi)
 * https://leetcode.com/problems/string-to-integer-atoi/description/
 */
public class Num8 {
    public int myAtoi(String str) {
        if (str == null || "".equals(str)) {
            return 0;
        }

        char[] arr = str.trim().toCharArray();
        StringBuffer sb = new StringBuffer();
        int flag = 1;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                if (arr[i] == '-') {
                    flag = -1;
                } else if (arr[i] == '+') {
                    flag = 1;
                } else if (arr[i] >= '0' && arr[i] <= '9') {
                    sb.append(arr[i]);
                } else {
                    return 0;
                }
            } else {
                if (arr[i] >= '0' && arr[i] <= '9') {
                    sb.append(arr[i]);
                }else{
                    break;
                }
            }

        }

        String result = sb.toString();

        if ("".equals(result)) {
            return 0;
        }

        double res = Double.parseDouble(result);

        res *= flag;

        if (res < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        if (res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        return (int) res;
    }

    public static void main(String[] args) {
        Num8 num8 = new Num8();
        int res = num8.myAtoi("3.1434");
        System.out.println(res);
    }
}
