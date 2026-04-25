/*
 * Problem: 2248. Intersection of Multiple Arrays
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/intersection-of-multiple-arrays/
 * Language: java
 * Date: 2026-04-25
 */

class Solution {
    public List<Integer> intersection(int[][] nums) {
        int[] counts = new int[1001];
        for (int[] arr : nums) {
            for (int num : arr) {
                counts[num]++;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == nums.length)
                res.add(i);
        }
        return res;
    }
}
