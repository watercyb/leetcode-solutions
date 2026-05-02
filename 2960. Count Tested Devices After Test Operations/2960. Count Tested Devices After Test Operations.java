/*
 * Problem: 2960. Count Tested Devices After Test Operations
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/count-tested-devices-after-test-operations/
 * Language: java
 * Date: 2026-05-02
 */

class Solution {
    public int countTestedDevices(int[] batteryPercentages) {
        int res = 0;
        for (int batteryPercentage : batteryPercentages) {
            if (batteryPercentage > res)
                res++;
        }
        return res;
    }
}
