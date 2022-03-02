/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 */
class Solution {
    public int maxArea(int[] height) {

        int left = 0, right = height.length - 1;
        int result = 0;

        while (left <= right) {
            int l = right - left;
            int w = Math.min(height[left], height[right]);
            int sum = l * w;
            result = Math.max(sum, result);

            // 这里为什么是移动较矮处的指针呢？
            // 因为
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return result;
    }
}