/*
 * Problem: 1643. Kth Smallest Instructions
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/kth-smallest-instructions/
 * Language: java
 * Date: 2026-04-19
 */

class Solution {
    public String kthSmallestPath(int[] destination, int k) {
        int a = destination[1];
        int b = destination[0];
        int sum = a + b;
        StringBuilder SB = new StringBuilder();
        for (int i = 0; i < sum; i++) {
            long p = C(sum - i - 1, a - 1);
            if (p >= k && a > 0) {
                SB.append('H');
                a--;
            } else {
                SB.append('V');
                k -= p;
                b--;
            }
        }
        return SB.toString();
    }

    public long C(int a, int b) {
        if (a - b < b)
            b = a - b;
        long res = 1;
        for (int i = 1; i <= b; i++) {
            res = res * a / i;
            a--;
        }
        return res;
    }
}
