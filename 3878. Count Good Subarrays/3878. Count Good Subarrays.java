/*
 * Problem: 3878. Count Good Subarrays
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-good-subarrays/
 * Language: java
 * Date: 2026-05-11
 */

class Solution {
    public long countGoodSubarrays(int[] nums) {
        HashMap<Integer, Integer> HM = new HashMap<>(nums.length, 0.99f);
        int[] lims = new int[31];
        int[] lefts = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            lefts[i] = HM.getOrDefault(nums[i], 0);
            for (int j = 0; j < 31; j++) {
                if ((nums[i] & (1 << j)) != 0) {
                    lims[j] = i + 1;
                } else {
                    lefts[i] = Math.max(lefts[i], lims[j]);
                }
            }
            HM.put(nums[i], i + 1);
        }
        long res = 0;
        Arrays.fill(lims, nums.length - 1);
        for (int i = nums.length - 1; i >= 0; i--) {
            int min = nums.length - 1;
            for (int j = 0; j < 31; j++) {
                if ((nums[i] & (1 << j)) != 0) {
                    lims[j] = i - 1;
                } else {
                    min = Math.min(min, lims[j]);
                }
            }
            int l = i - lefts[i] + 1;
            int r = min - i + 1;
            res += (long) l * r;
        }
        return res;
    }
}
