package slidingWindow;

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int ans = 0;
        int slow = 0;
        int sum = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] % 2 == 1) {
                sum += nums[fast];
            }
            while (sum == k) {
                ans++;
                if (nums[slow] % 2 == 1) {
                    sum -= nums[slow];
                    fast = slow;
                }
                slow++;
            }
        }

        return ans;
    }
}