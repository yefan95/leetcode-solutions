package de.yefan.leetcode;

/**
 * Add Binary
 * https://leetcode.com/problems/add-binary/description/
 */
public class Num67 {

    public String addBinary(String a, String b) {
        StringBuffer sb = new StringBuffer();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;

        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }
            if (i >= 0) {
                sum += a.charAt(i--) - '0';
            }
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Num67 num67 = new Num67();
        String res = num67.addBinary("1010", "1011");
        System.out.println(res);
    }

}
