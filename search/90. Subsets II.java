package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 
 */
class Solution {
    public List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            subset(nums, i, 0, cur);
        }
        return ans;
    }

    private void subset(int[] nums, int n, int start, List<Integer> cur) {
        if (n == cur.size()) {
            ans.add(new ArrayList<>(cur));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1])
                continue;
            cur.add(nums[i]);
            subset(nums, n, i + 1, cur);
            cur.remove(cur.size() - 1);
        }

    }
}