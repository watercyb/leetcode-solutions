/*
 * Problem: 1787. Make the XOR of All Segments Equal to Zero
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/make-the-xor-of-all-segments-equal-to-zero/
 * Language: java
 * Date: 2026-04-20
 */

class Solution {
    public int minChanges(int[] nums, int k) {
        int lim = 0;
        for (int num : nums) {
            lim = Math.max(lim, num);
        }
        lim = 1 << (32 - Integer.numberOfLeadingZeros(lim));
        int[] DP = new int[lim + 1];
        Arrays.fill(DP, Integer.MIN_VALUE);
        DP[0] = 0;
        for (int i = 0; i < k; i++) {
            int[] DPNext = new int[lim + 1];
            int[] counts = new int[lim];
            for (int j = i; j < nums.length; j += k) {
                counts[nums[j]]++;
            }
            for (int j = 0; j < lim; j++) {
                if (counts[j] == 0)
                    continue;
                for (int l = 0; l < lim; l++) {
                    DPNext[l ^ j] = Math.max(DPNext[l ^ j], DP[l] + counts[j]);
                }
            }
            int max = 0;
            for (int j = 0; j < lim; j++) {
                max = Math.max(max, DP[j]);
            }
            DPNext[lim] = Math.max(DPNext[lim], max);
            DP = DPNext;
        }
        return nums.length - Math.max(DP[0], DP[lim]);
    }
}
