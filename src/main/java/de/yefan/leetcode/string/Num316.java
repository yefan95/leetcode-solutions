package de.yefan.leetcode.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Remove Duplicate Letters
 * https://leetcode.com/problems/remove-duplicate-letters/description/
 */
public class Num316 {
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        Map<Character, Integer> lastPosMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            lastPosMap.put(s.charAt(i), i);
        }
        char[] result = new char[lastPosMap.size()];

        int begin = 0, end = findMinLastPos(lastPosMap);

        for (int i = 0; i < result.length; i++) {
            char minChar = 'z' + 1;
            for (int k = begin; k <= end; k++) {
                if (lastPosMap.containsKey(s.charAt(k)) && s.charAt(k) < minChar) {
                    minChar = s.charAt(k);
                    begin = k + 1;
                }
            }

            result[i] = minChar;
            if (i == result.length - 1) {
                break;
            }

            lastPosMap.remove(minChar);

            if (s.charAt(end) == minChar) {
                end = findMinLastPos(lastPosMap);
            }
        }

        return new String(result);
    }

    private int findMinLastPos(Map<Character, Integer> lastPosMap) {
        if (lastPosMap == null || lastPosMap.isEmpty()) {
            return -1;
        }
        int minLastPos = Integer.MAX_VALUE;
        for (int lastPos : lastPosMap.values()) {
            minLastPos = Math.min(minLastPos, lastPos);
        }
        return minLastPos;
    }

    public String removeDuplicateLetters1(String s) {
        int[] count = new int[26];
        boolean[] chosen = new boolean[26];
        int numUniq = 0;
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 0) {
                numUniq++;
            }
            count[s.charAt(i) - 'a']++;
        }
        // used as stack
        char[] ans = new char[numUniq];
        int top = -1;
        for (int i = 0; i < s.length(); i++) {
            if (chosen[s.charAt(i) - 'a']) {
                count[s.charAt(i) - 'a']--;
                continue;
            }
            while (top >= 0 && s.charAt(i) < ans[top] && count[ans[top] - 'a'] > 0) {
                chosen[ans[top] - 'a'] = false;
                top--;
            }
            ans[++top] = s.charAt(i);
            count[s.charAt(i) - 'a']--;
            chosen[s.charAt(i) - 'a'] = true;
        }
        return new String(ans);
    }

    public String removeDuplicateLetters2(String s) {
        Stack<Character> stack = new Stack<>();
        int[] count = new int[26];
        char[] arr = s.toCharArray();
        for (char c : arr) {
            count[c - 'a']++;
        }
        boolean[] visited = new boolean[26];
        for (char c : arr) {
            count[c - 'a']--;
            if (visited[c - 'a']) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > c && count[stack.peek() - 'a'] > 0) {
                visited[stack.peek() - 'a'] = false;
                stack.pop();
            }
            stack.push(c);
            visited[c - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}
