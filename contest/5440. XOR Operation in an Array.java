package contest;

class Solution {
    public static int xorOperation(int n, int start) {
        if (n == 1)
            return start;
        int xorSum = 0;
        for (int i = 0; i < n; i++) {
            int val = start + 2 * i;
            xorSum ^= val;
        }
        return xorSum;
    }
    public static void main(String[] args) {
        System.out.println(xorOperation(5, 0));
    }
}
