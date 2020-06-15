package slidingWindow;

/**
 * https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
 */
class Solution {
    public int numberOfSubstrings(String s) {
        int[] count = { 0, 0, 0 };
        int ans = 0, i = 0;
        char[] chArr = s.toCharArray();
        for (int j = 0; j < chArr.length; j++) {
            ++count[chArr[j]-'a'];
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                //从i开始到j,j+1,...chArr.length的字符串都是满足要求的
                ans+=chArr.length-j;
                --count[chArr[i]-'a'];
                i++;
            }
        }
        return ans;
    }
}