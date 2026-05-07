/*
 * Problem: 3496. Maximize Score After Pair Deletions
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximize-score-after-pair-deletions/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public int maxScore(int[] nums) {
        if (nums.length <= 2)
            return 0;
        if (nums.length % 2 == 1) {
            int sum = 0;
            int min = Integer.MAX_VALUE;
            for (int num : nums) {
                sum += num;
                min = Math.min(num, min);
            }
            return sum - min;
        } else {
            int sum = 0;
            int min = Integer.MAX_VALUE;
            int prv = Integer.MAX_VALUE / 2;
            for (int num : nums) {
                sum += num;
                min = Math.min(num + prv, min);
                prv = num;
            }
            return sum - min;
        }
    }
}
