package contest.weekly

import java.util.ArrayList;
import java.util.List;


public class Soluion1 {
    private List<String> result = new ArrayList<>();

    public String getSmallestString(int n, int k) {
        int[] candidates = new int[26];
        for (int i = 0; i < candidates.length; i++) {
            candidates[i] = 'a' + i;
        }

        List<Integer> cur = new ArrayList<>();

        Comb(candidates, k, 0, cur);

        for (String str : result) {
            if (str.length() == n) {
                return str;
            }
        }

        return null;
    }

    private void Comb(int[] candidates, int target, int start, List<Integer> cur) {
        if (target == 0) {
            String resultStr = "";
            for (Integer i : cur) {
                resultStr += 'a' + (i - 1);
            }
            result.add(resultStr);
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            int val = candidates[i];
            if (val > target)
                break;
            cur.add(val);
            Comb(candidates, target - val, i, cur);
            cur.remove(cur.size() - 1);
        }

    }
}
