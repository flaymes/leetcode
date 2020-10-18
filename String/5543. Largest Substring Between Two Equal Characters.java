class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        Map<Character,List<Integer>> map=new HashMap<>();
        char[] ch=s.toCharArray();
        for(int i=0;i<ch.length;i++){
           ArrayList<Integer> list=  map.get(ch[i],new ArrayList<Integer>());
           list.add(i);
        }

        int ret=-1;
        for(Map.Entry<Character,List<Integer>> entry:map.entrySet){
           ArrayList<Integer> list =  entry.value();
           if(list.size()>1){
               ret = list.get(list.size()-1)-list.get(0)-1;
               
           }
            
        }
        
        return ret;
        
    }

    /**
     * 保存一个字符出现的最左索引和最右索引
     */
    public int maxLengthBetweenEqualCharacters2(String s) {
        int ret = -1;
        int[] L = new int[26];
        int[] R = new int[26];
        Arrays.fill(L,-1);
        Arrays.fill(R,-1);

        for(int i=0;i<s.length();++i){
            int idx=s.charAt(i)-'a';
            if( L[idx]== -1){
                L[idx] = i;
            }
            R[idx] = i;
        }

        for(int i=0;i<R.length;i++){
            ret=Math.max(ret,R[i]-L[i]-1);
        }
        return ret;
    }

}