/*
 * Problem: 1151. Minimum Swaps to Group All 1's Together
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together/
 * Language: java
 * Date: 2026-04-14
 */

class Solution {
    public int minSwaps(int[] data) {
        int count = 0;
        for (int num : data) {
            count += num;
        }
        if (count == data.length)
            return 0;
        int zeros = 0;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < count; i++) {
            zeros += 1 - data[i];
        }
        res = Math.min(zeros, res);
        int j = 0;
        for (int i = count; i < data.length; i++) {
            zeros += data[j] - data[i];
            res = Math.min(zeros, res);
            j++;
        }
        return res;
    }
}
