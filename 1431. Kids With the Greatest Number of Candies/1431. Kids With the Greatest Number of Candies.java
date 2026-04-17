/*
 * Problem: 1431. Kids With the Greatest Number of Candies
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
 * Language: java
 * Date: 2026-04-17
 */

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int candiy : candies) {
            max = Math.max(candiy, max);
        }
        List<Boolean> res = new ArrayList<>();
        // Boolean[] res = new Boolean[candies.length];
        for (int i = 0; i < candies.length; i++) {
            res.add(candies[i] + extraCandies >= max);
        }
        return res;
    }
}
