/*
 * Problem: 2537. Count the Number of Good Subarrays
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-the-number-of-good-subarrays/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public long countGood(int[] nums, int k) {
        HashMap<Integer, Integer> HM = new HashMap<>(nums.length, 0.99f);
        long res = 0;
        int count = 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            while (j < nums.length && count < k) {
                int n = HM.getOrDefault(nums[j], 0);
                count += n;
                HM.put(nums[j], n + 1);
                j++;
            }
            if (count < k)
                break;
            res += nums.length - j + 1;
            int n = HM.get(nums[i]);
            n--;
            count -= n;
            HM.put(nums[i], n);
        }
        return res;
    }
}
