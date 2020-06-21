package search;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        String str = "";
        dfs(str, 0, 0, n);

        return ans;
    }

    private void dfs(String str, int open, int close, int n) {
        if (str.length() == 2 * n) {
            ans.add(str);
            return;
        }

        if (open < n) {
            dfs(str + "(", open + 1, close, n);
        }

        if (close < open) {
            dfs(str + ")", open, close + 1, n);
        }
    }
}