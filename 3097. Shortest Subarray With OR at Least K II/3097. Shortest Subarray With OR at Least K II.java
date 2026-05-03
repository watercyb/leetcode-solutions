/*
 * Problem: 3097. Shortest Subarray With OR at Least K II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/shortest-subarray-with-or-at-least-k-ii/
 * Language: java
 * Date: 2026-05-03
 */

class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int res = Integer.MAX_VALUE;
        int j = 0;
        int OR = 0;
        int[] counts = new int[30];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= k)
                return 1;
            while (j < nums.length && OR < k) {
                int num = nums[j++];
                int l = 0;
                while (num > 0) {
                    if ((num & 1) == 1) {
                        counts[l]++;
                        OR |= 1 << l;
                    }
                    num /= 2;
                    l++;
                }
            }
            if (OR < k)
                break;
            res = Math.min(j - i, res);
            int num = nums[i];
            int l = 0;
            while (num > 0) {
                if ((num & 1) == 1) {
                    if (counts[l]-- == 1)
                        OR -= 1 << l;
                }
                num /= 2;
                l++;
            }
        }
        if (res == Integer.MAX_VALUE)
            return -1;
        return res;
    }
}
