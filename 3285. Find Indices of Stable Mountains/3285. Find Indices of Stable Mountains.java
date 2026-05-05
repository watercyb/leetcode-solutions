/*
 * Problem: 3285. Find Indices of Stable Mountains
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-indices-of-stable-mountains/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public List<Integer> stableMountains(int[] height, int threshold) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < height.length - 1; i++) {
            if (height[i] > threshold)
                res.add(i + 1);
        }
        return res;
    }
}
