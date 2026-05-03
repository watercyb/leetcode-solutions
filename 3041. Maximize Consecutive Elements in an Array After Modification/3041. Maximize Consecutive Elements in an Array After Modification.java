/*
 * Problem: 3041. Maximize Consecutive Elements in an Array After Modification
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximize-consecutive-elements-in-an-array-after-modification/
 * Language: java
 * Date: 2026-05-03
 */

class Solution {
    public int maxSelectedElements(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int[] counts = new int[max - min + 2];
        for (int num : nums) {
            counts[num - min]++;
        }
        int DP0 = 0;
        int DP1 = -1;
        int res = 0;
        for (int i = 0; i < counts.length; i++) {
            int DPNext0 = 0;
            int DPNext1 = 0;
            if (counts[i] > 0) {
                DPNext0 = Math.max(DP0, DP1) + 1;
            } else {
                DPNext0 = DP1 + 1;
            }
            if (counts[i] > 1) {
                DPNext1 = Math.max(DP0, DP1) + 1;
            } else if (counts[i] > 0) {
                DPNext1 = DP1 + 1;
            } else {
                DPNext1 = -1;
            }
            DP0 = DPNext0;
            DP1 = DPNext1;
            res = Math.max(res, Math.max(DP0, DP1));
        }

        return res;
    }
}
