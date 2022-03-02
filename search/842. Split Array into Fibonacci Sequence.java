class Solution {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> ans=new ArrayList<>();
        if(S==null||S.length()==0) return ans;
        dfs(S,1,new ArrayList<>(),ans);
        return ans;
    }

    private void dfs(String str,int start,List<Integer> cur,List<Integer> ans) {
        if(cur.size()==2){
            Integer thirdInt=Integer.parseInt(str);
            if(cur.get(0)+cur.get(1)==thirdInt){
                ans.add(cur.get(0));
                ans.add(cur.get(1));
                ans.add(cur.get(thirdInt));
            }
            return;
        }
        for(int i=start,i<=str.length;i++){
            String tmpStr= str.substring(0,i);
            if(tmpStr.startWith("0")) continue;
            Integer tmpInt=Integer.parseInt(tmpStr);
            cur.add(tmpInt);
            dfs(str.substring(i),start,cur,ans);
            cur.remove(cur.size()-1);
        }
    }

}