/*
 * Problem: 1124. Longest Well-Performing Interval
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/longest-well-performing-interval/
 * Language: java
 * Date: 2026-04-14
 */

class Solution {
    public int longestWPI(int[] hours) {
        int[] MQ = new int[hours.length + 1];
        int[] index = new int[hours.length + 1];
        index[0] = -1;
        int idx = 1;
        int sum = 0;
        for (int i = 0; i < hours.length; i++) {
            sum += 2 * (hours[i] / 9) - 1;
            if (idx == 0 || sum < MQ[idx - 1]) {
                MQ[idx] = sum;
                index[idx++] = i;
            }
        }
        int res = 0;
        idx--;
        for (int i = hours.length - 1; i >= 0; i--) {
            while (idx > 0 && (index[idx] >= i || MQ[idx - 1] < sum)) {
                idx--;
            }
            if (MQ[idx] < sum)
                res = Math.max(i - index[idx], res);
            sum -= 2 * (hours[i] / 9) - 1;
        }
        return res;
    }
}
