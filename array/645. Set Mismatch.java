/**
 * https://leetcode-cn.com/problems/set-mismatch/
 */
class Solution {
    public int[] findErrorNums(int[] nums) {
        int dup=-1;
        int loss = -1;
        for(int i=0;i<nums.length;i++){
            int idx=Math.abs(nums[i])-1;
            if(nums[idx]<0){
                dup=Math.abs(nums[i]);
            }else{
                nums[idx]=nums[idx]*(-1);
            }            
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                loss=i;
            }
        }

        return new int[]{dup,loss+1};
    }
}