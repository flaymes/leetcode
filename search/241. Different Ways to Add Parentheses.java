import java.util.ArrayList;
import java.util.List;

/**
 * 分治法 https://leetcode-cn.com/problems/different-ways-to-add-parentheses/
 */
class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<input.length();i++){
            char ch = input.charAt(i);
            if( ch == '-' || ch == '+' || ch == '*'){
                List<Integer> left = diffWaysToCompute(input.substring(0,i));
                List<Integer> right = diffWaysToCompute(input.substring(i+1));

                // 循环的原因是 有left、right有多种运算结果
                for(int x: left){
                    for(int y: right){
                        if(ch=='-'){
                            result.add(x-y);
                        }else if(ch == '+'){
                            result.add(x+y);
                        }else{
                            result.add(x*y);
                        }
                    }
                }
            }
        }

        if(result.size()==0){
            result.add(Integer.parseInt(input));
        }
        return result;
    }
}