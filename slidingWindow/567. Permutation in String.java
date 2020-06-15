package slidingWindow;

class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length())
            return false;

        int n = s1.length();
        int[] s1Arr = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            s1Arr[s1.charAt(i) - 'a']++;
        }

        int[] s2Arr = new int[26];
        for (int i = 0; i < s2.length(); i++) {
            s2Arr[s2.charAt(i) - 'a']++;
            if (i >= (n - 1)) {
                if (arrMatch(s1Arr, s2Arr)) {
                    return true;
                }
                s2Arr[s2.charAt(i - (n - 1)) - 'a']--;
            }
        }

        return false;
    }

    private boolean arrMatch(int[] arr1, int[] arr2) {
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}