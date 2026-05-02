/*
 * Problem: 2928. Distribute Candies Among Children I
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/distribute-candies-among-children-i/
 * Language: java
 * Date: 2026-05-02
 */

class Solution {
    public int distributeCandies(int n, int limit) {
        int res = 0;
        int l = Math.max(0, n - 2 * limit);
        int r = Math.min(limit, n);
        for (int i = l; i <= r; i++) {
            res += Math.min(limit, n - i) - Math.max(0, n - i - limit) + 1;
        }
        return res;
    }
}
