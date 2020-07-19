package search;

import java.util.*;

/**
 * https://leetcode.com/problems/01-matrix/
 */
class Solution {

    public int[][] updateMatrix(int[][] matrix) {

        int[][] ans;
        Queue<Pos> queue = new LinkedList<>();

        int n = matrix.length;
        int m = matrix[0].length;
        ans = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    ans[i][j] = Integer.MAX_VALUE;
                } else if (matrix[i][j] == 0) {
                    queue.offer(new Pos(i, j));
                }
            }
        }
        int[] dx = new int[] { 0, 0, 1, -1 };
        int[] dy = new int[] { 1, -1, 0, 0 };
        while (!queue.isEmpty()) {
            Pos p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (ans[p.x][p.y] + 1 < ans[nx][ny]) {
                        ans[nx][ny]=ans[p.x][p.y]+1;
                        queue.add(new Pos(nx,ny));
                    }
                }
            }

        }
        return ans;
    }
}

class Pos {
    int x, y;

    Pos() {
    }

    Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}