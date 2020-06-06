package search;

import java.util.*;

/**
 * https://leetcode.com/problems/combination-sum-ii/
 */
class Solution {
    public List<List<Integer>> result = new ArrayList<>();
    public Set<List<Integer>> set = new HashSet<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> cur = new ArrayList<>();
        Comb(candidates, target, 0, cur);
        return result;
    }

    private void Comb(int[] candidates, int target, int start, List<Integer> cur) {
        if (target == 0) {
            // if (set.add(cur) == false)
            //     return;
            result.add(new ArrayList<>(cur));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            int val = candidates[i];
            if (val > target)
                break;
            if (i > start && val == candidates[i - 1])
                continue;
            cur.add(val);
            Comb(candidates, target - val, i + 1, cur);
            cur.remove(cur.size() - 1);
        }
    }
}