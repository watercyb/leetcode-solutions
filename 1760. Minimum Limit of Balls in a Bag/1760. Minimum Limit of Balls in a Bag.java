/*
 * Problem: 1760. Minimum Limit of Balls in a Bag
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag/
 * Language: java
 * Date: 2026-04-20
 */

class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int l = 1;
        int r = Integer.MAX_VALUE;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (chk(nums, maxOperations, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public boolean chk(int[] nums, int maxOperations, int mid) {
        for (int num : nums) {
            maxOperations -= (num - 1) / mid;
            if (maxOperations < 0)
                return false;
        }
        return true;
    }
}
