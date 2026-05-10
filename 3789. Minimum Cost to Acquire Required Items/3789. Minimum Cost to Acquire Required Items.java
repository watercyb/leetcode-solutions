/*
 * Problem: 3789. Minimum Cost to Acquire Required Items
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-cost-to-acquire-required-items/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        if (costBoth <= Math.min(cost1, cost2)) {
            return (long) costBoth * Math.max(need1, need2);
        } else if (costBoth >= cost1 + cost2) {
            return (long) cost1 * need1 + (long) cost2 * need2;
        } else if (costBoth <= cost1) {
            return (long) costBoth * need1 + (long) cost2 * Math.max(need2 - need1, 0);
        } else if (costBoth <= cost2) {
            return (long) costBoth * need2 + (long) cost1 * Math.max(need1 - need2, 0);
        } else {
            return (long) costBoth * Math.min(need1, need2) + (long) cost1 * Math.max(need1 - need2, 0)
                    + (long) cost2 * Math.max(need2 - need1, 0);
        }
    }
}
