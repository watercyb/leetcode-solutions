/*
 * Problem: 1423. Maximum Points You Can Obtain from Cards
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
 * Language: java
 * Date: 2026-04-17
 */

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int total = 0;
        int sum = 0;
        k = cardPoints.length - k;
        for (int i = 0; i < k; i++) {
            total += cardPoints[i];
            sum += cardPoints[i];
        }
        int min = sum;
        for (int i = k; i < cardPoints.length; i++) {
            total += cardPoints[i];
            sum += cardPoints[i] - cardPoints[i - k];
            min = Math.min(min, sum);
        }
        return total - min;
    }
}
