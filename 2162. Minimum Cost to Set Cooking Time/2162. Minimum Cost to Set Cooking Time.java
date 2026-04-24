/*
 * Problem: 2162. Minimum Cost to Set Cooking Time
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-cost-to-set-cooking-time/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        int mins = targetSeconds / 60;
        int secs = targetSeconds % 60;
        return Math.min(getTime(startAt, moveCost, pushCost, mins, secs),
                getTime(startAt, moveCost, pushCost, mins - 1, secs + 60));
    }

    public int getTime(int startAt, int moveCost, int pushCost, int mins, int secs) {
        if (mins < 0 || mins >= 100 || secs >= 100)
            return Integer.MAX_VALUE;
        String str = String.valueOf(mins * 100 + secs);
        int res = 0;
        for (char chr : str.toCharArray()) {
            if (startAt != chr - '0') {
                startAt = chr - '0';
                res += moveCost;
            }
            res += pushCost;
        }
        return res;
    }
}
