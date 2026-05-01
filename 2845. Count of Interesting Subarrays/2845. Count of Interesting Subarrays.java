/*
 * Problem: 2845. Count of Interesting Subarrays
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-of-interesting-subarrays/
 * Language: java
 * Date: 2026-05-01
 */

class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        if (nums.size() < k)
            return 0;
        int[] counts = new int[nums.size() + 1];
        counts[0]++;
        int count = 0;
        long res = 0;
        for (int num : nums) {
            if (num % modulo == k)
                count = (count + 1) % modulo;
            int t = (count - k + modulo) % modulo;
            if (t < counts.length)
                res += counts[t];
            counts[count]++;
        }
        return res;
    }
}
