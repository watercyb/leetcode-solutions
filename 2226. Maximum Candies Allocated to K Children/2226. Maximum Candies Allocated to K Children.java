/*
 * Problem: 2226. Maximum Candies Allocated to K Children
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-candies-allocated-to-k-children/
 * Language: java
 * Date: 2026-04-25
 */

class Solution {
    public int maximumCandies(int[] candies, long k) {
        long sum = 0;
        for (int candy : candies) {
            sum += candy;
        }
        if (sum < k)
            return 0;
        int min = 1;
        int max = (int) (sum / k) + 1;
        while (min < max) {
            int mid = (min + max) >>> 1;
            if (!chk(candies, k, mid)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min - 1;
    }

    public boolean chk(int[] candies, long k, long mid) {
        for (int candy : candies) {
            k -= candy / mid;
        }
        return k <= 0;
    }
}
