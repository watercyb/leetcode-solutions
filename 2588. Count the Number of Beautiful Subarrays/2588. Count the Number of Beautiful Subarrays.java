/*
 * Problem: 2588. Count the Number of Beautiful Subarrays
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-the-number-of-beautiful-subarrays/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public long beautifulSubarrays(int[] nums) {
        HashMap<Integer, Integer> HM = new HashMap<>(nums.length, 0.99f);
        HM.put(0, 1);
        int xor = 0;
        long res = 0;
        for (int num : nums) {
            xor ^= num;
            int count = HM.getOrDefault(xor, 0);
            res += count;
            HM.put(xor, count + 1);
        }
        return res;
    }
}
