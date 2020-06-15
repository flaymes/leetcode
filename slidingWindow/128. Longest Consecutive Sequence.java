package search;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-consecutive-sequence/
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int curLen = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            //
            if (!numSet.contains(nums[i] - 1)) {
                curLen = 1;
                while (numSet.contains(nums[i] + curLen)) {
                    curLen++;
                }
                ans = Math.max(ans, curLen);
            }
        }
        return ans;
    }
}