/*
 * Problem: 135. Candy
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/candy/
 * Language: java
 * Date: 2026-03-26
 */

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] counts = new int[n];
        counts[0] = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                counts[i] = counts[i - 1] + 1;
            } else {
                counts[i] = 1;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && counts[i] <= counts[i + 1])
                counts[i] = counts[i + 1] + 1;
        }
        int res = 0;
        for (int count : counts) {
            res += count;
        }
        return res;
    }
}
