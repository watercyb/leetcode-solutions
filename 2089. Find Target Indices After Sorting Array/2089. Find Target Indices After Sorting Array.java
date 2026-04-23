/*
 * Problem: 2089. Find Target Indices After Sorting Array
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-target-indices-after-sorting-array/
 * Language: java
 * Date: 2026-04-23
 */

class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int[] counts = new int[101];
        for (int num : nums) {
            counts[num]++;
        }
        int sum = 0;
        for (int i = 0; i < target; i++) {
            sum += counts[i];
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < counts[target]; i++) {
            res.add(sum++);
        }
        return res;
    }
}
