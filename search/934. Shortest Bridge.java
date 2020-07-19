package search;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/shortest-bridge/
 */
class Solution {
    private int[] dx = new int[] { 0, 0, 1, -1 };
    private int[] dy = new int[] { 1, -1, 0, 0 };

    public int shortestBridge(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        boolean isFound = false;
        Queue<Pos> q = new LinkedList<>();
        for (int i = 0; i < n && !isFound; i++) {
            for (int j = 0; j < m && !isFound; j++) {
                if (A[i][j] == 1) {
                    dfs(A, i, j, q);
                    isFound = true;
                }
            }
        }
        int steps = 0;
        while (!q.isEmpty()) {
            int qsize = q.size();
            steps++;
            for (int i = 0; i < qsize; i++) {
                Pos p = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = dx[j] + p.x;
                    int ny = dy[j] + p.y;
                    if (nx < 0 || ny < 0 || nx >= n || ny >= m || A[nx][ny] == 2)
                        continue;
                    if (A[nx][ny] == 1) {
                        return steps-1;
                    }
                    A[nx][ny] = 2;
                    q.offer(new Pos(nx, ny));
                }
            }
        }
        return -1;
    }

    private void dfs(int[][] A, int i, int j, Queue<Pos> q) {
        if (i < 0 || j < 0 || i >= A.length || j >= A.length||A[i][j]!=1)
            return;

        q.offer(new Pos(i, j));
        A[i][j] = 2;
        dfs(A, i - 1, j, q);
        dfs(A, i + 1, j, q);
        dfs(A, i, j - 1, q);
        dfs(A, i, j + 1, q);
    }

}

class Pos {
    int x, y;

    Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
