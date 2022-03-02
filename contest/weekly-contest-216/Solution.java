public class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {

        StringBuilder builder1 = new StringBuilder();
        for (int i = 0; i < word1.length; i++) {
            builder1.append(word1[i]);
        }

        int idx = 0;
        for (int i = 0; i < word2.length; i++) {
            String word = word2[i];
            for (int j = 0; j < word.length(); j++) {
                if(builder1.charAt(idx+j)==word.charAt(j)){
                    continue;
                }else{
                    return false;
                }
            }
            idx += word.length();
        }
        return true;
    }
}