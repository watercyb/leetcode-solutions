/*
 * Problem: 3410. Maximize Subarray Sum After Removing All Occurrences of One Element
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximize-subarray-sum-after-removing-all-occurrences-of-one-element/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public long maxSubarraySum(int[] nums) {
        long minSum = 0;
        long min = 0;
        long sum = 0;
        long res = Long.MIN_VALUE;
        HashMap<Integer, Long> HM = new HashMap<>(nums.length);
        for (int num : nums) {
            sum += num;
            res = Math.max(sum - min, res);
            if (num < 0) {
                long minNum = HM.getOrDefault(num, 0l);
                minNum = Math.min(minSum + num, minNum + num);
                HM.put(num, minNum);
                min = Math.min(minNum, min);
                minSum = Math.min(sum, minSum);
            }
        }
        return res;
    }
}
