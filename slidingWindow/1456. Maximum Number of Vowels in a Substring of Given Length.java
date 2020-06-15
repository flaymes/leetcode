package search;

/**
 * https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
 */
class Solution {
    public int maxVowels(String s, int k) {
        char[] chArr = s.toCharArray();
        int maxNum = 0;
        int curNum = 0;
        int windowEndIdx = 0;
        int windowStartIdx = 0;
        for (windowEndIdx = 0; windowEndIdx < chArr.length && windowEndIdx < k; windowEndIdx++) {
            if (isVowel(chArr[windowEndIdx])) {
                curNum++;
            }
        }
        maxNum = Math.max(curNum, maxNum);
        for (windowEndIdx = windowEndIdx + 1; windowEndIdx < chArr.length; windowEndIdx++) {
            char chStart = chArr[windowStartIdx];
            char chEnd = chArr[windowEndIdx];
            if (isVowel(chEnd)) {
                curNum++;
            }
            if (isVowel(chStart)) {
                curNum--;
            }
            windowStartIdx++;
            maxNum = Math.max(curNum, maxNum);
        }

        return maxNum;
    }

    public int maxVowels2(String s, int k) {
        int[] v = new int[128];
        v['a'] = 1;
        v['e'] = 1;
        v['i'] = 1;
        v['o'] = 1;
        v['u'] = 1;
        char[] chArr = s.toCharArray();
        int total = 0;
        int ans = 0;
        for (int i = 1; i <= chArr.length; i++) {
            total+=v[chArr[i-1]];
            if (i >= k) {
                ans = Math.max(ans, total);
                total -= v[chArr[i - k]];
            }
        }
        return ans;
    }

    private boolean isVowel(char ch) {
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
    }
}