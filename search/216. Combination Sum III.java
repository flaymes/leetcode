package search;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum-iii/
 */
class Solution {
    public List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = new int[10];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }
        List<Integer> cur = new ArrayList<>();
        subset(nums, k, n, 1, cur);
        return ans;
    }

    private void subset(int[] nums, int d, int target, int start, List<Integer> cur) {
        if (d == cur.size()) {
            if (target == 0) {
                ans.add(new ArrayList<>(cur));
            }
            return;
        }
        for (int i = start; i < nums.length; i++) {
            cur.add(nums[i]);
            subset(nums, d , target - nums[i], i + 1, cur);
            cur.remove(cur.size() - 1);
        }
    }
}