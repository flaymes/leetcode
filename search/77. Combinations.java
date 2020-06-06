package search;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combinations/
 */
class Solution {
    public List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            nums[i] = i;
        }
        List<Integer> cur = new ArrayList<>();
        Comb(nums, 0, k, 1, cur);
        return ans;
    }

    private void Comb(int[] nums, int d, int k, int start, List<Integer> cur) {
        if (d == k) {
            ans.add(new ArrayList<>(cur));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            cur.add(nums[i]);
            Comb(nums, d + 1, k, i + 1, cur);
            cur.remove(cur.size() - 1);
        }
    }

}