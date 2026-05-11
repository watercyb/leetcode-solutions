/*
 * Problem: 3834. Merge Adjacent Equal Elements
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/merge-adjacent-equal-elements/
 * Language: java
 * Date: 2026-05-11
 */

class Solution {
    public List<Long> mergeAdjacent(int[] nums) {
        List<Long> res = new ArrayList<>();
        for (int num : nums) {
            long n = num;
            while (!res.isEmpty() && res.getLast() == n) {
                res.removeLast();
                n *= 2;
            }
            res.add(n);
        }
        return res;
    }
}
