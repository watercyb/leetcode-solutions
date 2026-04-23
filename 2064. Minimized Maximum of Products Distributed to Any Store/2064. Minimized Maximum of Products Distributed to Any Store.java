/*
 * Problem: 2064. Minimized Maximum of Products Distributed to Any Store
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimized-maximum-of-products-distributed-to-any-store/
 * Language: java
 * Date: 2026-04-23
 */

class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int l = 1;
        int r = 100000;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (chk(n, quantities, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public boolean chk(int n, int[] quantities, int mid) {
        for (int quantitie : quantities) {
            n -= (quantitie + mid - 1) / mid;
            if (n < 0)
                return false;
        }
        return true;
    }
}
