/*
 * Problem: 3095. Shortest Subarray With OR at Least K I
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/shortest-subarray-with-or-at-least-k-i/
 * Language: java
 * Date: 2026-05-03
 */

class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        if (k == 0)
            return 1;
        int[] counts = new int[6];
        int j = 0;
        int res = Integer.MAX_VALUE;
        int or = 0;
        for (int i = 0; i < nums.length; i++) {
            while (j < nums.length && or < k) {
                int num = nums[j];
                int idx = 0;
                while (num > 0) {
                    counts[idx] += num & 1;
                    or |= (num & 1) << idx;
                    num >>= 1;
                    idx++;
                }
                j++;
            }
            if (or >= k && res > j - i)
                res = j - i;
            int num = nums[i];
            int idx = 0;
            while (num > 0) {
                if ((num & 1) == 1 && --counts[idx] == 0)
                    or -= 1 << idx;
                num >>= 1;
                idx++;
            }
        }
        if (res == Integer.MAX_VALUE)
            return -1;
        return res;
    }
}
