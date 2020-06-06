package search;

import java.util.ArrayList;
import java.util.List;
/**
 * https://leetcode.com/problems/subsets/
 */
class Solution {
    public List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> cur = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            subset(nums, 0, i, 0, cur);
        }
        return ans;
    }

    private void subset(int[] nums, int d, int n, int start, List<Integer> cur) {
        if (d == n) {
            ans.add(new ArrayList<>(cur));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            cur.add(nums[i]);
            subset(nums, d + 1, n, i + 1, cur);
            cur.remove(cur.size() - 1);
        }
    }

}