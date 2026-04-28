/*
 * Problem: 2593. Find Score of an Array After Marking All Elements
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-score-of-an-array-after-marking-all-elements/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public long findScore(int[] nums) {
        long res = 0;
        for (int i = 0; i < nums.length; i += 2) {
            int start = i;
            while (i + 1 < nums.length && nums[i + 1] < nums[i]) {
                i++;
            }
            for (int j = i; j >= start; j -= 2) {
                res += nums[j];
            }
        }
        return res;
    }
}
