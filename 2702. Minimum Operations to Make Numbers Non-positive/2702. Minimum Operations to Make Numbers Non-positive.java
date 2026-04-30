/*
 * Problem: 2702. Minimum Operations to Make Numbers Non-positive
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-operations-to-make-numbers-non-positive/
 * Language: java
 * Date: 2026-04-30
 */

class Solution {
    public int minOperations(int[] nums, int x, int y) {
        x -= y;
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        int l = 0;
        int r = (max + y - 1) / y;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (chk(nums, x, y, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public boolean chk(int[] nums, int x, int y, int mid) {
        long sum = y * mid;
        for (int num : nums) {
            if (num > sum) {
                mid -= (num - sum + x - 1) / x;
                if (mid < 0)
                    return false;
            }
        }
        return true;
    }
}
