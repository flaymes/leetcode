package search;

import java.util.*;

/**
 * https://leetcode.com/problems/open-the-lock/
 */
class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deadLocks = new HashSet<>();
        for (String deadend : deadends) {
            deadLocks.add(deadend);
        }
        String start = "0000";
        Queue<String> q = new LinkedList<>();
        if (deadLocks.contains(start)) {
            return -1;
        }
        if (start.equals(target))
            return 0;
        Set<String> visited = new HashSet<>();
        visited.add(start);
        q.offer(start);
        int steps = 0;
        while (!q.isEmpty()) {
            ++steps;
            int qSize = q.size();
            for (int j = 0; j < qSize; j++) {
                String deadend = q.poll();
                for (int i = 0; i < 4; i++) {
                    for (int k = -1; k <= 1; k += 2) {
                        char[] chArr = deadend.toCharArray();
                        chArr[i] = (char) (((chArr[i] - '0') + k + 10) % 10 + '0');
                        String next = new String(chArr);
                        if (next.equals(target))
                            return steps;
                        if (deadLocks.contains(next) || visited.contains(next)) {
                            continue;
                        }
                        visited.add(next);
                        q.add(next);
                    }

                }
            }
        }
        return -1;
    }
}