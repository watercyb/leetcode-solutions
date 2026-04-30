/*
 * Problem: 2779. Maximum Beauty of an Array After Applying Operation
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-beauty-of-an-array-after-applying-operation/
 * Language: java
 * Date: 2026-04-30
 */

class Solution {
    public int maximumBeauty(int[] nums, int k) {
        if (nums.length == 1) return 1;
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        int[] line = new int[max + 2];
        max++;
        for (int num : nums) {
            line[Math.max(num - k, 0)]++;
            line[Math.min(num + k + 1, max)]--;
        }
        int res = 0;
        int count = 0;
        for (int num : line) {
            count += num;
            res = Math.max(count, res);
        }
        return res;
    }
}
