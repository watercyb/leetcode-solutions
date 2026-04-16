/*
 * Problem: 1399. Count Largest Group
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/count-largest-group/
 * Language: java
 * Date: 2026-04-16
 */

class Solution {
    public int countLargestGroup(int n) {
        int[] counts = new int[37];
        int max = 0;
        int res = 0;
        for (int i = 1; i <= n; i++) {
            int num = i;
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            counts[sum]++;
            if (counts[sum] > max) {
                max = counts[sum];
                res = 1;
            } else if (counts[sum] == max) {
                res++;
            }
        }
        return res;
    }
}
