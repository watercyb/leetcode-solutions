/*
 * Problem: 134. Gas Station
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/gas-station/
 * Language: java
 * Date: 2026-03-26
 */

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length == 1) {
            if (gas[0] - cost[0] >= 0) {
                return 0;
            } else {
                return -1;
            }
        }
        int i = 0;
        int j = 1;
        int rm = gas[i] - cost[i];
        while (i != j) {
            if (rm >= 0) {
                rm += gas[j] - cost[j];
                j++;
                if (j == gas.length)
                    j = 0;
            } else {
                i--;
                if (i < 0)
                    i = gas.length - 1;
                rm += gas[i] - cost[i];
            }
        }
        if (rm >= 0) {
            return i;
        } else {
            return -1;
        }
    }
}
