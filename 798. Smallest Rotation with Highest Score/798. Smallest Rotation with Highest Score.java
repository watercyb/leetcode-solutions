/*
 * Problem: 798. Smallest Rotation with Highest Score
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/smallest-rotation-with-highest-score/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public int bestRotation(int[] nums) {
        int[] sum = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {

            if (nums[i]>i) {
                sum[nums.length-nums[i]+i+1]--;
            } else {
                sum[i-nums[i]+1]--;
            }
            sum[i+1]++;
        }

        int[] max = new int[2];
        int tmp=0;
        for (int i = 0; i < nums.length; i++) {
            tmp+=sum[i];
            if (tmp > max[1]) {
                max[1] = tmp;
                max[0] = i;
            }
        }
        return max[0];

    }
}
