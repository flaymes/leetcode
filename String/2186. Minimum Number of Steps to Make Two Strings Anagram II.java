class Solution {
    public int minSteps(String s, String t) {

        int[] chCntArrS = new int[26];
        int[] chCntArrT = new int[26];
        for (int i = 0; i < s.length(); i++) {
            chCntArrS[s.charAt(i)-'a']++;
        }
        
        for (int i = 0; i < t.length(); i++) {
            chCntArrT[t.charAt(i)-'a']++;
        }
        
        int cnt=0;
        for (int i = 0; i < 26; i++) {
            if (chCntArrS[i]!=chCntArrT[i]) {
                cnt+=Math.abs(chCntArrS[i]-chCntArrT[i]);
            }

        }
        return cnt;
    }

    public int minSteps2(String s, String t) {

        int[] chCntArr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            chCntArr[s.charAt(i)-'a']++;
        }
        
        for (int i = 0; i < t.length(); i++) {
            chCntArr[t.charAt(i)-'a']--;
        }
        
        int cnt=0;
        for (int i = 0; i < 26; i++) {
            cnt+=Math.abs(chCntArr[i]);

        }
        return cnt;
    }
}