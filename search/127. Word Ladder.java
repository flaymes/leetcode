package search;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-ladder/
 */
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        Set<String> dict=new HashSet<>();
        for (String string : wordList) {
            dict.add(string);
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            for (int s = queue.size(); s >0 ; s--) {
                String word = queue.poll();
                for (int i = 0; i < word.length(); i++) {
                    char[] arr = word.toCharArray();
                    char cc = arr[i];
                    for (int j = 0; j < 26; j++) {
                        char ch = (char) ('a' + j);
                        if (ch == cc)// 重复单词
                            continue;
                        arr[i] = ch;
                        String tmpStr = new String(arr);
                        if (dict.contains(tmpStr)) {
                            queue.offer(tmpStr);
                            dict.remove(tmpStr);
                        }
                        if (tmpStr.equals(endWord))
                            return step + 1;
                    }
                    arr[i] = cc;
                }
            }

        }
        return 0;
    }

}
