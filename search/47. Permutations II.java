package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations-ii/
 */
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        perm(nums, nums.length, visited, cur, ans);
        return ans;
    }

    private void perm(int nums[], int n, boolean[] visited, List<Integer> cur, List<List<Integer>> ans) {
        if (n == cur.size()) {
            ans.add(new ArrayList<>(cur));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i])
                continue;
            if (i > 0 && nums[i] == nums[i-1]&&!visited[i-1])
                continue;
            visited[i] = true;
            cur.add(nums[i]);
            perm(nums, n, visited, cur, ans);
            cur.remove(cur.size() - 1);
            visited[i] = false;

        }
    }
}