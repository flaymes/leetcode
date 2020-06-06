package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum/
 */
class Solution {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(candidates);
        Comb(candidates, target, 0, cur);
        return result;
    }

    private void Comb(int[] candidates, int target, int start, List<Integer> cur) {
        if (target == 0) {
            result.add(new ArrayList<>(cur));
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