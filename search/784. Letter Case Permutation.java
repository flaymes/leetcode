package search;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/letter-case-permutation/
 */
class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(S.toCharArray(), 0, sb, ans);
        return ans;
    }

    private void dfs(char[] S, int j, StringBuilder sb, List<String> ans) {
        if (j == S.length) {
            ans.add(new String(S));
            return;
        }
        dfs(S, j + 1, sb, ans);
        char ch = S[j];
        if (Character.isLetter(ch)) {

            toggle(S, j);
            dfs(S, j + 1, sb, ans);
            toggle(S, j);
        }

    }

    private void toggle(char[] ch, int i) {
        if (Character.isUpperCase(ch[i])) {
            ch[i] = Character.toLowerCase(ch[i]);
        } else {
            ch[i] = Character.toUpperCase(ch[i]);
        }
    }
}