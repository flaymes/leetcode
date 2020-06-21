package contest;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] getFolderNames(String[] names) {
        String[] ans = new String[names.length];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            String nStr = names[i];
            map.put(nStr, map.getOrDefault(nStr, 0) + 1);j
            int seq = map.get(nStr) - 1;
            if (seq > 0) {
                for (int j = seq; j < names.length; j++) {
                    String tmpName = nStr + "(" + j + ")";
                    if (!map.containsKey(tmpName)) {
                        ans[i] = tmpName;
                        map.put(tmpName, map.getOrDefault(tmpName, 0)+1);
                        break;
                    }
                }
            } else {
                ans[i] = nStr;
            }
        }
        return ans;
    }
}