package search;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/word-search-ii/
//两种方式，直接DFS暴力搜索，或者使用Trie来加速
class TrieNode {
    private TrieNode[] items;
    private final int R = 26;
    private boolean isEnd;

    public TrieNode() {
        items = new TrieNode[R];
        isEnd = false;
    }

    public boolean containsKey(char key) {
        return items[key - 'a'] != null;
    }

    public TrieNode get(char ch) {
        return items[ch - 'a'];
    }

    public void put(char ch, TrieNode node) {
        items[ch - 'a'] = node;
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                node.put(ch, new TrieNode());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (node.containsKey(ch)) {
                node = node.get(ch);
            } else {
                return null;
            }
        }
        return node;
    }

    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    public boolean startWith(String word) {
        TrieNode node = searchPrefix(word);
        return node != null;
    }
}

class Solution {
    private int n;
    private int m;
    private List<String> ans = new ArrayList<>();
    private Trie trie = new Trie();

    public List<String> findWords(char[][] board, String[] words) {
        for (String word : words) {
            if (exist(board, word)) {
                ans.add(word);
            }
        }
        return ans;
    }

    public List<String> findWords2(char[][] board, String[] words) {
        for (String word : words) {
            trie.insert(word);
        }
        n = board.length;
        m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                search2(board, "", i, j, trie);
            }
        }
        return ans;
    }

    private boolean exist(char[][] board, String word) {
        if (board.length == 0)
            return false;
        n = board.length;
        m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (search(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean search(char[][] board, String word, int x, int y, int d) {
        if (x < 0 || x >= n || y < 0 || y >= m)
            return false;
        if (board[x][y] != word.charAt(d))
            return false;
        if (d == word.length() - 1)
            return true;
        char cur = board[x][y];
        board[x][y] = '0';
        boolean result = search(board, word, x + 1, y, d + 1) || search(board, word, x - 1, y, d + 1)
                || search(board, word, x, y + 1, d + 1) || search(board, word, x, y - 1, d + 1);
        board[x][y] = cur;
        return result;
    }

    private void search2(char[][] board, String word, int x, int y, Trie trie) {
        if (x < 0 || x >= n || y < 0 || y >= m)
            return;
        if (board[x][y] == '0')
            return;
        word += board[x][y];
        if (!trie.startWith(word))
            return;

        if (trie.search(word)) {
            ans.add(word);
        }

        char cur = board[x][y];
        board[x][y] = '0';
        search2(board, word, x + 1, y, trie);
        search2(board, word, x - 1, y, trie);
        search2(board, word, x, y + 1, trie);
        search2(board, word, x, y - 1, trie);
        board[x][y] = cur;

    }
}