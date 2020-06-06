package search;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations/
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean visited[] = new boolean[nums.length];
        List<Integer> cur = new ArrayList<>();
        perm(nums, 0, nums.length, visited, cur, ans);
        return ans;
    }

    private void perm(int[] nums, int k, int n, boolean[] visited, List<Integer> cur, List<List<Integer>> ans) {
        if (k == n) {
            ans.add(new ArrayList<>(cur));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            cur.add(nums[i]);
            perm(nums, k + 1, n, visited, cur, ans);
            cur.remove(cur.size() - 1);
            visited[i] = false;
        }
    }
}