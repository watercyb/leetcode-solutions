/*
 * Problem: 1840. Maximum Building Height
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-building-height/
 * Language: java
 * Date: 2026-04-21
 */

class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        if (restrictions.length == 0)
            return n - 1;
        Arrays.sort(restrictions, (a, b) -> a[0] - b[0]);
        int prv = 0;
        int prvIdx = 1;
        for (int i = 0; i < restrictions.length; i++) {
            restrictions[i][1] = Math.min(restrictions[i][1], prv + restrictions[i][0] - prvIdx);
            prvIdx = restrictions[i][0];
            prv = restrictions[i][1];
        }
        for (int i = restrictions.length - 2; i >= 0; i--) {
            restrictions[i][1] = Math.min(restrictions[i][1], restrictions[i + 1][1] + restrictions[i + 1][0] - restrictions[i][0]);
        }
        int res = restrictions[0][1] + (restrictions[0][0] - 1 - restrictions[0][1]) / 2;
        for (int i = 1; i < restrictions.length; i++) {
            res = Math.max(res, Math.max(restrictions[i - 1][1], restrictions[i][1]) + (restrictions[i][0] - restrictions[i - 1][0] - Math.abs(restrictions[i][1] - restrictions[i - 1][1])) / 2);
        }
        res = Math.max(res, restrictions[restrictions.length - 1][1] + n - restrictions[restrictions.length - 1][0]);
        return res;
    }
}
