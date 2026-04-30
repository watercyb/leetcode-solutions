/*
 * Problem: 2780. Minimum Index of a Valid Split
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-index-of-a-valid-split/
 * Language: java
 * Date: 2026-04-30
 */

class Solution {
    public int minimumIndex(List<Integer> nums) {
        int l = nums.size();
        int count = 0;
        int target = 0;
        for (int num : nums) {
            if (count == 0) {
                count++;
                target = num;
            } else if (num != target) {
                count--;
            } else {
                count++;
            }
        }
        int total = 0;
        for (int num : nums) {
            if (num == target)
                total++;
        }
        count = 0;
        int a = total * 2 - l + 1;
        for (int i = 0; i < l - 1; i++) {
            if (nums.get(i) == target)
                count++;
            if (count * 2 > i + 1 && count * 2 < a + i)
                return i;
        }
        return -1;
    }
}
