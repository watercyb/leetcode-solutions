/*
 * Problem: 3730. Maximum Calories Burnt from Jumps
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-calories-burnt-from-jumps/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public long maxCaloriesBurnt(int[] heights) {
        Arrays.sort(heights);
        long res = 0;
        int l = 0;
        int r = heights.length - 1;
        int prv = 0;
        while (l < r) {
            res += (long) (heights[r] - prv) * (heights[r] - prv)
                    + (long) (heights[r] - heights[l]) * (heights[r] - heights[l]);
            prv = heights[l];
            l++;
            r--;
        }
        if (l == r)
            res += (long) (heights[r] - prv) * (heights[r] - prv);
        return res;
    }
}
