/*
 * Problem: 1762. Buildings With an Ocean View
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/buildings-with-an-ocean-view/
 * Language: java
 * Date: 2026-04-20
 */

class Solution {
    public int[] findBuildings(int[] heights) {
        int[] res = new int[heights.length];
        res[heights.length - 1] = heights.length - 1;
        int idx = heights.length - 1;
        for (int i = heights.length - 2; i >= 0; i--) {
            if (heights[i] > heights[res[idx]])
                res[--idx] = i;
        }
        return Arrays.copyOfRange(res, idx, heights.length);
    }
}
