package de.yefan.leetcode.hashtable;

import java.util.*;

/**
 * Word Ladder II
 * https://leetcode.com/problems/word-ladder-ii/description/
 */
public class Num126 {
    public List<List<String>> findLadders(String start, String end, List<String> wordList) {
        HashSet<String> dict = new HashSet<>(wordList);
        List<List<String>> res = new ArrayList<>();
        // Neighbors for every node
        HashMap<String, ArrayList<String>> nodeNeighbors = new HashMap<>();
        // Distance of every node from the start node
        HashMap<String, Integer> distance = new HashMap<>();
        ArrayList<String> solution = new ArrayList<>();

        dict.add(start);
        bfs(start, end, dict, nodeNeighbors, distance);
        dfs(start, end, dict, nodeNeighbors, distance, solution, res);
        return res;
    }

    /**
     * BFS: Trace every node's distance from the start node (level by level).
     *
     * @param start
     * @param end
     * @param dict
     * @param nodeNeighbors
     * @param distance
     */
    private void bfs(String start, String end, Set<String> dict, HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance) {
        for (String str : dict) {
            nodeNeighbors.put(str, new ArrayList<>());
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        distance.put(start, 0);

        while (!queue.isEmpty()) {
            int count = queue.size();
            boolean foundEnd = false;
            for (int i = 0; i < count; i++) {
                String cur = queue.poll();
                int curDistance = distance.get(cur);
                ArrayList<String> neighbors = getNeighbors(cur, dict);

                for (String neighbor : neighbors) {
                    nodeNeighbors.get(cur).add(neighbor);
                    // Check if visited
                    if (!distance.containsKey(neighbor)) {
                        distance.put(neighbor, curDistance + 1);
                        // Found the shortest path
                        if (end.equals(neighbor)) {
                            foundEnd = true;
                        } else {
                            queue.offer(neighbor);
                        }
                    }
                }
            }

            if (foundEnd) {
                break;
            }
        }
    }

    /**
     * Find all next level nodes.
     *
     * @param node
     * @param dict
     * @return
     */
    private ArrayList<String> getNeighbors(String node, Set<String> dict) {
        ArrayList<String> res = new ArrayList<>();
        char chs[] = node.toCharArray();

        for (char ch = 'a'; ch <= 'z'; ch++) {
            for (int i = 0; i < chs.length; i++) {
                if (chs[i] == ch) {
                    continue;
                }
                char old_ch = chs[i];
                chs[i] = ch;
                if (dict.contains(String.valueOf(chs))) {
                    res.add(String.valueOf(chs));
                }
                chs[i] = old_ch;
            }

        }
        return res;
    }

    /**
     * DFS: output all paths with the shortest distance.
     *
     * @param cur
     * @param end
     * @param dict
     * @param nodeNeighbors
     * @param distance
     * @param solution
     * @param res
     */
    private void dfs(String cur, String end, Set<String> dict, HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance, ArrayList<String> solution, List<List<String>> res) {
        solution.add(cur);
        if (end.equals(cur)) {
            res.add(new ArrayList<String>(solution));
        } else {
            for (String next : nodeNeighbors.get(cur)) {
                if (distance.get(next) == distance.get(cur) + 1) {
                    dfs(next, end, dict, nodeNeighbors, distance, solution, res);
                }
            }
        }
        solution.remove(solution.size() - 1);
    }

    public List<List<String>> findLadders1(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();

        if (!wordList.contains(endWord)) {
            return res;
        }

        Set<String> startSet = new HashSet<>();
        startSet.add(beginWord);
        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);
        Set<String> wordSet = new HashSet<>(wordList);

        if (!helper(wordSet, startSet, endSet, map, true)) {
            return res;
        }

        List<String> curList = new ArrayList<>();
        curList.add(beginWord);
        generateStr(beginWord, endWord, map, curList, res);
        return res;
    }

    private void generateStr(String start, String end, HashMap<String, List<String>> map, List<String> curList, List<List<String>> res) {
        if (start.equals(end)) {
            res.add(new ArrayList<>(curList));
            return;
        }

        if (!map.containsKey(start)) {
            return;
        }

        List<String> wordList = map.get(start);
        for (String word : wordList) {
            curList.add(word);
            generateStr(word, end, map, curList, res);
            curList.remove(curList.size() - 1);
        }

    }

    private boolean helper(Set<String> wordList, Set<String> startSet, Set<String> endSet, HashMap<String, List<String>> map, boolean isForward) {
        if (startSet.isEmpty() || endSet.isEmpty()) {
            return false;
        }

        if (startSet.size() > endSet.size()) {
            return helper(wordList, endSet, startSet, map, !isForward);
        }

        wordList.removeAll(startSet);

        boolean isDone = false;
        Set<String> nextStartSet = new HashSet<>();

        for (String word : startSet) {
            char[] curStr = word.toCharArray();

            for (int i = 0; i < curStr.length; i++) {
                char curCh = curStr[i];

                for (char c = 'a'; c <= 'z'; c++) {
                    if (curCh == c) {
                        continue;
                    }

                    curStr[i] = c;
                    String newWord = new String(curStr);
                    if (!wordList.contains(newWord)) {
                        continue;
                    }

                    nextStartSet.add(newWord);
                    String key = isForward ? word : newWord;
                    String value = isForward ? newWord : word;
                    if (!map.containsKey(key)) {
                        map.put(key, new ArrayList<String>());
                    }

                    map.get(key).add(value);

                    if (endSet.contains(newWord)) {
                        isDone = true;
                    }
                }

                curStr[i] = curCh;
            }
        }

        return isDone || helper(wordList, nextStartSet, endSet, map, isForward);
    }
}
