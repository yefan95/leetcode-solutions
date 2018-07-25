package de.yefan.leetcode.hashtable;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Word Ladder
 * https://leetcode.com/problems/word-ladder/description/
 */
public class Num127 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        //思路：双端HashSet,将其分为起始集合和结束集合，当起始集合中的单词变换一次后得到结束集合中的某词时可以结束
        //当起始、结束集合中有任意一个为空时，总的也为空
        //由于只有26个字母，因此，采用字母替换法所能达到的26*n在n较大时远远优于n*n
        Set<String> dict = new HashSet<>(wordList);
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);

        int step = 1;
        Set<String> visited = new HashSet<>();
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            //保证每次对较少数目的endSet做处理
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }
            Set<String> temp = new HashSet<>();
            for (String word : beginSet) {
                char[] chs = word.toCharArray();
                for (int i = 0; i < chs.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = chs[i];
                        chs[i] = c;
                        String target = String.valueOf(chs);
                        if (endSet.contains(target)) {
                            return step + 1;
                        }
                        if (!visited.contains(target) && dict.contains(target)) {
                            temp.add(target);
                            visited.add(target);
                        }
                        chs[i] = old;
                    }
                }
            }
            beginSet = temp;
            step++;
        }
        return 0;
    }


}
