package slidingWindow;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();

        if (s.length() < p.length()) {
            return ans;
        }
        int[] pArr = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pArr[p.charAt(i) - 'a']++;
        }
        int n = p.length();
        int[] sArr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            sArr[s.charAt(i) - 'a']++;
            if (i >= n - 1) {
                if (arrMatch(sArr, pArr)) {
                    ans.add(i - (n - 1));
                }
                sArr[s.charAt(i - (n - 1)) - 'a']--;
            }
        }

        return ans;
    }

    private boolean arrMatch(int[] arr1, int[] arr2) {
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}