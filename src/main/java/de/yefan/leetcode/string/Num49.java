package de.yefan.leetcode.string;

import java.util.*;

/**
 * Group Anagrams
 * https://leetcode.com/problems/group-anagrams/description/
 */
public class Num49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length <= 0) {
            return res;
        }
        Map<String, List<String>> map = new LinkedHashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            if (!map.containsKey(key)) {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(key, list);
            } else {
                map.get(key).add(strs[i]);
            }
        }
        res.addAll(map.values());
        return res;
    }

    public static void main(String[] args) {
        Num49 num49 = new Num49();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> list = num49.groupAnagrams(strs);
        System.out.println(Arrays.toString(list.toArray()));
    }
}
