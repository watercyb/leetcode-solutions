/*
 * Problem: 3729. Count Distinct Subarrays Divisible by K in Sorted Array
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-distinct-subarrays-divisible-by-k-in-sorted-array/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public long numGoodSubarrays(int[] nums, int k) {
        long res = 0;
        HashMap<Integer, Integer> HM = new HashMap<>(nums.length, 0.99f);
        HM.put(0, 1);
        int sum = 0;
        int l = 0;
        while (l < nums.length) {
            int r = l;
            int sum1 = sum;
            while (r < nums.length && nums[r] == nums[l]) {
                sum1 = (sum1 + nums[r]) % k;
                res += HM.getOrDefault(sum1, 0);
                r++;
            }
            while (l < r) {
                sum = (sum + nums[l]) % k;
                HM.put(sum, HM.getOrDefault(sum, 0) + 1);
                l++;
            }

        }
        return res;
    }
}
