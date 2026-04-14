/*
 * Problem: 1103. Distribute Candies to People
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/distribute-candies-to-people/
 * Language: java
 * Date: 2026-04-14
 */

class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        int x = (int) ((Math.sqrt(1 + 8l * candies) - 1) / 2);
        int offset = candies - (x + 1) * x / 2;
        int n = x / num_people;
        x %= num_people;
        for (int i = 0; i < x; i++) {
            res[i] = (2 * (i + 1) + n * num_people) * (n + 1) / 2;
        }
        for (int i = x; i < num_people; i++) {
            res[i] = (2 * (i + 1) + (n - 1) * num_people) * n / 2;
        }
        res[x] += offset;
        return res;
    }
}
