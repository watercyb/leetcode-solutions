/*
 * Problem: 668. Kth Smallest Number in Multiplication Table
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/
 * Language: java
 * Date: 2026-04-06
 */

class Solution {
    public int findKthNumber(int m, int n, int k) {
        int min=1;
        int max=m*n;
        while (min<max) {
            int mid=(max-min)/2+min;
            if (chk(m, n, k, mid)) {
                max=mid;
            } else {
                min=mid+1;
            }
        }
        return min;

    }

    public boolean chk(int m, int n, int k, int mid) {
        int r = 1;
        int c = Math.min(mid, n);
        int count = 0;
        while (r <= m) {
            while (c >= 0 && c * r > mid)
                c--;
            if (c == 0)
                return false;
            count += c;
            if (count>=k) return true;
            r++;
        }
        return false;
    }
}
