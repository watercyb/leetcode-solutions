/*
 * Problem: 2107. Number of Unique Flavors After Sharing K Candies
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/number-of-unique-flavors-after-sharing-k-candies/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public int shareCandies(int[] candies, int k) {
        int[] counts = new int[100001];
        int count = 0;
        for (int candy : candies) {
            if (counts[candy]++ == 0)
                count++;
        }
        if (k == 0)
            return count;
        for (int i = 0; i < k; i++) {
            if (counts[candies[i]]-- == 1)
                count--;
        }
        int res = count;
        for (int i = k; i < candies.length; i++) {
            if (counts[candies[i]]-- == 1)
                count--;
            if (counts[candies[i - k]]++ == 0)
                count++;
            res = Math.max(count, res);
        }
        return res;
    }
}
