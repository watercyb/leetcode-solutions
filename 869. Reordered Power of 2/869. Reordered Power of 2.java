/*
 * Problem: 869. Reordered Power of 2
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/reordered-power-of-2/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {

    public boolean reorderedPowerOf2(int n) {
        long target = getH(n);
        for (int i = 0; i < 31; i++) {
            if (getH(1 << i) == target)
                return true;
        }
        return false;
    }

    public long getH(int num) {
        long res = 0;
        while (num > 0) {
            res += Math.pow(10, num % 10);
            num /= 10;
        }
        return res;
    }
}
