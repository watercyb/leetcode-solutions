/*
 * Problem: 3804. Number of Centered Subarrays
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/number-of-centered-subarrays/
 * Language: java
 * Date: 2026-05-11
 */

class Solution {
    public int centeredSubarrays(int[] nums) {
        HS = new HashSet<>();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += count(nums, i);
        }
        return res;
    }

    HashSet<Integer> HS;

    public int count(int[] nums, int i) {
        HS.clear();
        int res = 0;
        int sum = 0;
        while (i < nums.length) {
            HS.add(nums[i]);
            sum += nums[i];
            if (HS.contains(sum))
                res++;
            i++;
        }
        return res;
    }
}
