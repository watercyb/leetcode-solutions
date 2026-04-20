/*
 * Problem: 1744. Can You Eat Your Favorite Candy on Your Favorite Day?
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/can-you-eat-your-favorite-candy-on-your-favorite-day/
 * Language: java
 * Date: 2026-04-20
 */

class Solution {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        long[] sums = new long[candiesCount.length + 1];
        for (int i = 0; i < candiesCount.length; i++) {
            sums[i + 1] = sums[i] + candiesCount[i];
        }
        boolean[] res = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = chk(sums, queries[i]);
        }
        return res;
    }

    public boolean chk(long[] sums, int[] query) {
        return query[1] + 1 <= sums[query[0] + 1] && (long) (query[1] + 1) * query[2] > sums[query[0]];
    }
}
