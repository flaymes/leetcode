package search;
import java.util.*;

//https://leetcode.com/problems/letter-combinations-of-a-phone-number/
class Solution {
    
    private List<String> result=new ArrayList<>();
    private Map<String,String> numCharMap=new HashMap<>();

    public List<String> letterCombinations(String digits) {
        if(digits==null||"".equals(digits.trim())) return new ArrayList<String>();
        numCharMap.put("2","abc");
        numCharMap.put("3","def");
        numCharMap.put("4","ghi");
        numCharMap.put("5","jkl");
        numCharMap.put("6","nmo");
        numCharMap.put("7","pqrs");
        numCharMap.put("8","tuv");
        numCharMap.put("9","wxyz");
        
        List<String> strList=new ArrayList<>();
        for(int i=0;i<digits.length();i++){
            strList.add(numCharMap.get(digits.charAt(i)+""));
        }
        StringBuilder sb=new StringBuilder();
        combination(strList,0,sb);
        return result;
    }
    
    private void combination(List<String> strList, int i, StringBuilder sb){
        if(i==strList.size()){
            result.add(sb.toString());
            return;
        }
        String tmpStr=strList.get(i);
        for(int j=0;j<tmpStr.length();j++){
            sb.append(tmpStr.charAt(j));
            combination(strList,i+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}