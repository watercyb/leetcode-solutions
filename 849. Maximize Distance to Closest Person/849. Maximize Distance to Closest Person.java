/*
 * Problem: 849. Maximize Distance to Closest Person
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximize-distance-to-closest-person/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public int maxDistToClosest(int[] seats) {
        int i = 0;
        while (seats[i] == 0) {
            i++;
        }
        int res = i;
        int j = seats.length - 1;
        while (seats[j] == 0) {
            j--;
        }
        res = Math.max(seats.length - j - 1, res);
        int prv = i;
        for (int k = i + 1; k <= j; k++) {
            if (seats[k] == 1) {
                res = Math.max((k - prv) / 2, res);
                prv = k;
            }
        }
        return res;
    }
}
