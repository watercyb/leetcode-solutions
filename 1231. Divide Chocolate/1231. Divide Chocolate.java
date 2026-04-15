/*
 * Problem: 1231. Divide Chocolate
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/divide-chocolate/
 * Language: java
 * Date: 2026-04-15
 */

class Solution {
    public int maximizeSweetness(int[] sweetness, int k) {
        k++;
        int l = 0;
        int r = 1_000_000_000/k+1;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (!chk(sweetness, k, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l - 1;
    }

    public boolean chk(int[] sweetness, int k, int mid) {
        int sum = 0;
        for (int i = 0; i < sweetness.length; i++) {
            sum += sweetness[i];
            if (sum >= mid) {
                sum = 0;
                k--;
            }
        }
        return k<=0;
    }
}
