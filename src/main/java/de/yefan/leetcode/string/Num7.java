package de.yefan.leetcode.string;

/**
 * Reverse Integer
 * https://leetcode.com/problems/reverse-integer/description/
 */
public class Num7 {

    public int reverse(int x) {
        long ans = 0;
        while (x != 0) {
            int tmp = x % 10;
            ans = ans * 10 + tmp;
            x = x / 10;
        }
        if (ans >= Integer.MIN_VALUE && ans <= Integer.MAX_VALUE) {
            return (int) ans;
        } else {
            return 0;
        }
    }

    public int reverse1(int x) {
        if (x <= Integer.MIN_VALUE || x >= Integer.MAX_VALUE || x == 0) {
            return 0;
        }
        int flag = x > 0 ? 1 : -1;
        String s = Integer.toString(Math.abs(x));
        char[] arr = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        boolean isZero = arr[arr.length - 1] == '0';
        for (int i = arr.length - 1; i >= 0; i--) {
            if (isZero) {
                if (arr[i] != '0') {
                    isZero = false;
                    sb.append(arr[i]);
                }
            } else {
                sb.append(arr[i]);
            }
        }
        String result = sb.toString();
        long ans = Long.parseLong(result);
        ans *= flag;
        if (ans <= Integer.MAX_VALUE && ans >= Integer.MIN_VALUE) {
            return (int) ans;
        }

        return 0;
    }

    public static void main(String[] args) {
        Num7 num7 = new Num7();
        int res = num7.reverse1(0);
        System.out.println(res);
    }

}
