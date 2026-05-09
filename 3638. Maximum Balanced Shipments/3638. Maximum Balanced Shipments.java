/*
 * Problem: 3638. Maximum Balanced Shipments
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-balanced-shipments/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public int maxBalancedShipments(int[] weight) {
        int res = 0;
        int idx = 0;
        while (idx < weight.length - 1) {
            if (weight[idx] > weight[idx + 1]) {
                res++;
                idx += 2;
            } else {
                idx++;
            }
        }
        return res;
    }
}
