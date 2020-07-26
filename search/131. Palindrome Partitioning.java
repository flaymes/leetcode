class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();
        if(s==null||s.length()==0) return ans;
        dfs(s,1,new ArrayList<>(),ans);
        return ans;
    }

    private void dfs(String s, int start,List<String> cur, List<List<String>> ans){
        if(s.length()==0){
            ans.add(new ArrayList<>(cur));
            return;
        }

        // i 表示截取的子字符串长度
        for(int i=start;i<=s.length();i++){
            if(isPalindrome(s,0,i)){
                cur.add(s.substring(0,i));
                dfs(s.substring(i),start,cur,ans);
                cur.remove(cur.size()-1);
            }
        }
    }

    private boolean isPalindrome(String str, int start, int len){
        int end=start+len-1;
        while(start<end){
            if(str.charAt(start)!=str.charAt(end)){
                return false;
            }

            start++;
            end--;
        }
        return true;
    }
}