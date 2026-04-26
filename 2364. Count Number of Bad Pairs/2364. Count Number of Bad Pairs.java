/*
 * Problem: 2364. Count Number of Bad Pairs
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-number-of-bad-pairs/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public long countBadPairs(int[] nums) {
        HashMap<Integer, Integer> HM = new HashMap<>();
        long res = (long) nums.length * (nums.length - 1) / 2;
        for (int i = 0; i < nums.length; i++) {
            int offset = nums[i] - i;
            int count = HM.getOrDefault(offset, 0);
            res -= count;
            HM.put(offset, count + 1);
        }
        return res;
    }
}
