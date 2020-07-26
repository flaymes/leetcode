class Solution {
    private List<String> ans = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() < 4 || s.length() > 12) return ans;
        char[] chArr = s.toCharArray();
        for (char ch : chArr) {
            if (ch < '0' || ch > '9') {
                return ans;
            }
        }

        dfs(s, 0, new StringBuilder(), 0);
        return ans;
    }

    private void dfs(String s, int start, StringBuilder cur, int cnt) {
        if (cnt == 4) {
            StringBuilder ansSb = new StringBuilder(cur);
            ansSb.deleteCharAt(ansSb.lastIndexOf("."));
            if (ansSb.length() == s.length() + 3) {
                ans.add(ansSb.toString());
            }
            return;
        }
        if (cnt > 4) return;
        for (int i = start; i < s.length(); i++) {
            int ipVal = 0;
            for (int j = 0; j < 3 && (i + j < s.length()); j++) {
                int i1 = s.charAt(i + j) - '0';
                ipVal = 10 * ipVal + i1;
                if (ipVal >= 0 && ipVal <= 255) {
                    String ipStr = ipVal + ".";
                    cur.append(ipStr);
                    dfs(s, i + j + 1, cur, cnt + 1);
                    cur.delete(cur.length() - ipStr.length(), cur.length());
                } else {
                    return;
                }
            }
        }
        return;
    }
}