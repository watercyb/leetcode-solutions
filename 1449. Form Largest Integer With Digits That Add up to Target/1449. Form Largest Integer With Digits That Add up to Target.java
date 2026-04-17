/*
 * Problem: 1449. Form Largest Integer With Digits That Add up to Target
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/form-largest-integer-with-digits-that-add-up-to-target/
 * Language: java
 * Date: 2026-04-17
 */

class Solution {
    public String largestNumber(int[] cost, int target) {
        int[] DP = new int[target + 1];
        Arrays.fill(DP, Integer.MIN_VALUE);
        DP[0] = 0;
        for (int i = 0; i < target; i++) {
            for (int c : cost) {
                if (i + c <= target && DP[i + c] <= DP[i])
                    DP[i + c] = DP[i]+1;
            }
        }
        if (DP[target] < 0)
            return "0";
        StringBuilder SB = new StringBuilder();
        int idx = target;
        while (idx > 0) {
            for (int i = cost.length - 1; i >= 0; i--) {
                if (idx - cost[i] >= 0 && DP[idx - cost[i]] + 1 == DP[idx]) {
                    SB.append(String.valueOf(i + 1));
                    idx -= cost[i];
                    break;
                }
            }
        }
        return SB.toString();
    }
}
