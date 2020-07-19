package search;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
 */
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = accumulate(nums);
        if (sum % k != 0)
            return false;
        int subSum = sum / k;
        Arrays.sort(nums);
        int startIdx = nums.length - 1;
        if (nums[startIdx] > subSum)
            return false;

        while (startIdx >= 0 && nums[startIdx] == subSum) {
            startIdx--;
            k--;
        }

        return partition(new int[k], nums, startIdx, subSum);

    }

    private boolean partition(int[] subSets, int[] nums, int startIdx, int target) {
        if (startIdx < 0) {
            return true;
        }

        for (int i = 0; i < subSets.length; i++) {
            int selected = nums[startIdx];
            if (subSets[i] + selected <= target) {
                subSets[i] += selected;
                if (partition(subSets, nums, startIdx - 1, target)) {
                    return true;
                }
                subSets[i] -= selected;
            }
        }
        return false;
    }

    private int accumulate(int[] nums) {
        int ret = 0;
        for (int n : nums) {
            ret += n;
        }

        return ret;
    }
}