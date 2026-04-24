/*
 * Problem: 2195. Append K Integers With Minimal Sum
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/append-k-integers-with-minimal-sum/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);
        long res = (long) (k + 1) * k / 2;
        int next = k + 1;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            if (next <= nums[i])
                break;
            res += (next++) - nums[i];
        }
        return res;
    }
}
