package search;

import java.util.*;

class Solution {
    private List<List<String>> ans = new ArrayList<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord))
            return new ArrayList<>();
        Set<String> dict = new HashSet<>();
        for (String string : wordList) {
            dict.add(string);
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int step = 0;

        return ans;

    }

    private void dfs(String beginWord, String endWord, String tmpWord, List<String> wordList, List<String> cur) {
        if (tmpWord.equals(endWord)) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        cur.add(beginWord);
        char[] arr = beginWord.toCharArray();
        for (int i = 0; i < beginWord.length(); i++) {
            char ch = arr[i];
            for (int j = 0; j < 26; j++) {
                char nextCh = (char) ('a' + j);
                arr[i] = nextCh;
                String nextWord = new String(arr);
                dfs(nextWord, endWord, tmpWord, wordList, cur);
            }
            arr[i] = ch;
        }

    }
}