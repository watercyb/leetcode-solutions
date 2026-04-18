/*
 * Problem: 1509. Minimum Difference Between Largest and Smallest Value in Three Moves
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/
 * Language: java
 * Date: 2026-04-18
 */

class Solution {
    public int minDifference(int[] nums) {
        if (nums.length <= 4)
            return 0;
        int[] max = new int[4];
        Arrays.fill(max, Integer.MIN_VALUE);
        int[] min = new int[4];
        Arrays.fill(min, Integer.MAX_VALUE);
        for (int num : nums) {
            if (num > max[3]) {
                int idx = 3;
                while (idx > 0 && num > max[idx - 1]) {
                    max[idx] = max[idx - 1];
                    idx--;
                }
                max[idx] = num;
            }
            if (num < min[3]) {
                int idx = 3;
                while (idx > 0 && num < min[idx - 1]) {
                    min[idx] = min[idx - 1];
                    idx--;
                }
                min[idx] = num;
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i <= 3; i++) {
            res = Math.min(max[3 - i] - min[i], res);
        }
        return res;
    }
}
