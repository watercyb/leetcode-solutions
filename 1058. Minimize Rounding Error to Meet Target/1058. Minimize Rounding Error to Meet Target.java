/*
 * Problem: 1058. Minimize Rounding Error to Meet Target
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimize-rounding-error-to-meet-target/
 * Language: java
 * Date: 2026-04-12
 */

class Solution {
    public String minimizeError(String[] prices, int target) {
        int count = 0;
        int sum = 0;
        int[] counts = new int[1000];
        for (int i = 0; i < prices.length; i++) {
            double num = Double.valueOf(prices[i]);
            int roundNum = (int) num;
            if (num > roundNum)
                count++;
            sum += roundNum;
            counts[(int) (num * 1000) % 1000]++;
        }
        if (sum > target || sum + count < target)
            return "-1";
        int n = target - sum;
        double res = 0;
        int idx = 999;
        for (int i = 0; i < n; i++) {
            while (counts[idx] == 0) {
                idx--;
            }
            res += 1000 - idx;
            counts[idx]--;
        }
        while (idx > 0) {
            res += idx * counts[idx--];
        }
        return String.format("%.3f", res / 1000);
    }
}
