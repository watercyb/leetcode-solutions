/*
 * Problem: 2927. Distribute Candies Among Children III
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/distribute-candies-among-children-iii/
 * Language: java
 * Date: 2026-05-02
 */

class Solution {
    public long distributeCandies(int n, int limit) {
        return C(n) - C(n - limit - 1) * 3 + C(n - 2 * limit - 2) * 3 - C(n - 3 * limit - 3);
    }

    public long C(long a) {
        if (a < 0)
            return 0;
        return (a + 2) * (a + 1) / 2;
    }
}
