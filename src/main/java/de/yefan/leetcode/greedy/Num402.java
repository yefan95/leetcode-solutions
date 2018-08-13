package de.yefan.leetcode.greedy;


import java.util.LinkedList;

/**
 * Remove K Digits
 * https://leetcode.com/problems/remove-k-digits/description/
 */
public class Num402 {
    public String removeKdigits(String num, int k) {
        LinkedList<Character> queue = new LinkedList<>();
        if (k <= 0) {
            return num;
        }
        for (char x : num.toCharArray()) {
            while (k > 0 && !queue.isEmpty() && queue.peekLast() > x) {
                queue.pollLast();
                k--;
            }
            queue.offer(x);
        }

        while (k > 0) {
            queue.pollLast();
            k--;
        }

        while (!queue.isEmpty() && queue.peek() == '0') {
            queue.poll();
        }

        if (queue.isEmpty()) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (char x : queue) {
            sb.append(x);
        }

        return sb.toString();
    }

    public String removeKdigits1(String num, int k) {
        int digits = num.length() - k;
        char[] stk = new char[num.length()];

        int top = 0;
        // k keeps track of how many characters we can remove
        // if the previous character in stk is larger than the current one
        // then removing it will get a smaller number
        // but we can only do so when k is larger than 0
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            while (top > 0 && stk[top - 1] > c && k > 0) {
                top -= 1;
                k -= 1;
            }
            stk[top++] = c;
        }

        int idx = 0;
        // find the index of first non-zero digit
        while (idx < digits && stk[idx] == '0') {
            idx++;
        }

        return idx == digits ? "0" : new String(stk, idx, digits - idx);
    }

    public static void main(String[] args) {
        Num402 num402 = new Num402();
        String num = "1432219";
        int k = 3;
        String res = num402.removeKdigits(num, k);
        System.out.println(res);
    }

}
