package search;

class Solution {
    private int n;
    private int m;
    private boolean visited[][];

    public boolean exist(char[][] board, String word) {
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
}