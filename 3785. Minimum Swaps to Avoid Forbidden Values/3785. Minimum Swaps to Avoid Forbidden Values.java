/*
 * Problem: 3785. Minimum Swaps to Avoid Forbidden Values
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-swaps-to-avoid-forbidden-values/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public int minSwaps(int[] nums, int[] forbidden) {
        HashMap<Integer, Integer> HM = new HashMap<>(nums.length, 0.99f);
        HashMap<Integer, Integer> HM1 = new HashMap<>(nums.length, 0.99f);
        int count = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == forbidden[i]) {
                int c = HM.getOrDefault(nums[i], 0) + 1;
                count++;
                max = Math.max(max, c);
                HM.put(nums[i], c);
            }
            int c = HM1.getOrDefault(nums[i], 0) + 1;
            if (c > nums.length)
                return -1;
            HM1.put(nums[i], c);
            c = HM1.getOrDefault(forbidden[i], 0) + 1;
            if (c > nums.length)
                return -1;
            HM1.put(forbidden[i], c);
        }
        if (max * 2 > count) {
            return max;
        } else {
            return (count + 1) / 2;
        }
    }
}
