package search;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
 */
class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int ans = 0;
        int windowStartIdx = 0;
        LinkedList<Integer> minQueue = new LinkedList<>();
        LinkedList<Integer> maxQueue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!minQueue.isEmpty() && nums[i] < minQueue.peekLast())
                minQueue.pollLast();
            while (!maxQueue.isEmpty() && nums[i] > maxQueue.peekLast())
                maxQueue.pollLast();
            minQueue.addLast(nums[i]);
            maxQueue.addLast(nums[i]);
            while (maxQueue.getFirst() - minQueue.getFirst() > limit) {
                if (nums[windowStartIdx] == minQueue.getFirst())
                    minQueue.pollFirst();
                if (nums[windowStartIdx] == maxQueue.getFirst())
                    maxQueue.pollFirst();
                windowStartIdx++;
            }

            ans = Math.max(ans, i - windowStartIdx + 1);

        }
        return ans;
    }
}