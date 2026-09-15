/*
 * Problem: 1762. Buildings With an Ocean View
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/buildings-with-an-ocean-view/?envType=weekly-question&envId=2026-09-15
 * Language: java
 * Date: 2026-09-15
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
