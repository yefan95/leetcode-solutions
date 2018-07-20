package de.yefan.leetcode.string;

import java.util.*;

/**
 * Most Common Word
 * https://leetcode.com/problems/most-common-word/description/
 */
public class Num819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set = new HashSet<>();
        for (String b : banned) {
            set.add(b);
        }

        Map<String, Integer> map = new HashMap<>();
        String ans = "";
        int count = 0;
        for (String s : paragraph.replaceAll("[^a-zA-Z ]", "").toLowerCase().split(" ")) {
            s = s.trim();
            if (s.length() == 0 || set.contains(s)) {
                continue;
            }
            map.put(s, map.getOrDefault(s, 0) + 1);
            if (count < map.get(s)) {
                count = map.get(s);
                ans = s;
            }
        }
        return ans;
    }

    public String mostCommonWord1(String paragraph, String[] banned) {
        paragraph += ".";

        Set<String> banset = new HashSet();
        for (String word : banned) {
            banset.add(word);
        }
        Map<String, Integer> count = new HashMap();

        String ans = "";
        int ansfreq = 0;

        StringBuilder word = new StringBuilder();
        for (char c : paragraph.toCharArray()) {
            if (Character.isLetter(c)) {
                word.append(Character.toLowerCase(c));
            } else if (word.length() > 0) {
                String finalword = word.toString();
                if (!banset.contains(finalword)) {
                    count.put(finalword, count.getOrDefault(finalword, 0) + 1);
                    if (count.get(finalword) > ansfreq) {
                        ans = finalword;
                        ansfreq = count.get(finalword);
                    }
                }
                word = new StringBuilder();
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Num819 num819 = new Num819();
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {};
        String result = num819.mostCommonWord(paragraph, banned);
        System.out.println(result);
    }
}
