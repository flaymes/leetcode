package slidingWindow;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        char[] chArr = s.toCharArray();
        int cur = 0;
        int start = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chArr.length; i++) {
            cur++;
            map.put(chArr[i], map.getOrDefault(chArr[i], 0) + 1);
            while (cur > map.size()) {
                char startCh = chArr[start];
                map.put(startCh, map.get(startCh) - 1);
                if (map.get(startCh) == 0) {
                    map.remove(startCh);
                    cur--;
                }
                start++;
                ans = Math.max(ans, cur);
            }

        }

        return ans;
    }
}