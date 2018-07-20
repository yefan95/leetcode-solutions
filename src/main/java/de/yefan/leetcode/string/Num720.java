package de.yefan.leetcode.string;

import java.util.HashSet;
import java.util.Set;

/**
 * Longest Word in Dictionary
 * https://leetcode-cn.com/problems/longest-word-in-dictionary/description/
 */
public class Num720 {

    public String longestWord(String[] words) {
        if (words == null || words.length <= 0) {
            return null;
        }
        Set<String> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            set.add(words[i]);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (max < words[i].length()) {
                boolean flag = false;
                for (int j = 1; j < words[i].length(); j++) {
                    if (!set.contains(words[i].substring(0, j))) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    max = words[i].length();
                }
            }
        }
        String res = null;
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() == max) {
                boolean flag = false;
                for (int j = 1; j < words[i].length(); j++) {
                    if (!set.contains(words[i].substring(0, j))) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    if (res == null) {
                        res = words[i];
                    }
                    res = compare(res, words[i]);
                }
            }
        }

        return res;
    }

    private String compare(String a, String b) {
        int start = 0, end = Math.min(a.length(), b.length()) - 1;
        while (start <= end) {
            if (a.charAt(start) < b.charAt(start)) {
                return a;
            } else if (a.charAt(start) > b.charAt(start)) {
                return b;
            } else {
                start++;
            }
        }
        return a.length() > b.length() ? b : a;
    }

    public String longestWord1(String[] words) {
        // 首先构建前缀树的根节点
        PrefixTreeNode root = new PrefixTreeNode();
        root.word = "_";
        // 利用单词数组构建前缀树
        for (String word : words) {
            root.insert(word);
        }
        String[] result = new String[]{"z"};
        // 在前缀树中搜索
        dfs(root, result);
        return result[0];
    }

    class PrefixTreeNode {
        /**
         * 保存插入的字符串
         */
        String word = "";

        /**
         * 对于每一个节点来说，其可以与a-z中所有的其他节点相连，因此用数组来保存节点与其他节点间的联系
         * 如对于wo单词来说，假设树根节点为root。'w' - 'a' = 22，root节点对应的数组root.links[22] = null
         * 此时新建一个节点表示root节点和w所对应的节点相连。'o' - 'a' = 14，对于w所对应的节点有w.links[14] = null
         * 同样新建一个节点来表示节点'w'和节点'o'相连
         */
        PrefixTreeNode[] links = new PrefixTreeNode[26];

        /**
         * 实现向前缀树中插入一个单词
         */
        public void insert(String s) {
            char[] chs = s.toCharArray();
            PrefixTreeNode curNode = this;
            // 遍历当前单词中的每一个字符
            for (int i = 0; i < chs.length; i++) {
                // 判断当前字符对应的节点是否在curNode的索引数组中，不存在则加入该字符对应节点
                int index = chs[i] - 'a';
                if (curNode.links[index] == null) {
                    curNode.links[index] = new PrefixTreeNode();
                }
                // 判断下一个字符
                curNode = curNode.links[index];
            }
            // 当前节点对应的单词为s
            curNode.word = s;
        }
    }

    /**
     * 利用深度优先遍历来进行搜索
     */
    void dfs(PrefixTreeNode node, String[] result) {
        // 如果一个节点包含的单词长度为0则说明原先单词数组中没有单词与该节点对应，直接返回
        if (node == null || node.word.length() == 0) {
            return;
        }
        for (PrefixTreeNode child : node.links) {
            if (child != null) {
                dfs(child, result);
                // 寻找最长单词并且长度相等的情况下返回最小的，因此在这里进行判断
                boolean valid = child.word.length() > result[0].length()
                        || (child.word.length() == result[0].length()
                        && child.word.compareTo(result[0]) < 0);
                if (valid) {
                    result[0] = child.word;
                }
            }
        }
    }


    public static void main(String[] args) {
        Num720 num720 = new Num720();
        String[] words = {"yo", "ew", "fc", "zrc", "yodn", "fcm", "qm", "qmo", "fcmz", "z", "ewq", "yod", "ewqz", "y"};
        String res = num720.longestWord(words);
        System.out.println(res);
    }
}
