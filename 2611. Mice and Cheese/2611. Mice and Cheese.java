/*
 * Problem: 2611. Mice and Cheese
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/mice-and-cheese/
 * Language: java
 * Date: 2026-04-29
 */

class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int res = -1000 * k;
        int[] counts = new int[2001];
        for (int i = 0; i < reward1.length; i++) {
            counts[reward1[i] - reward2[i] + 1000]++;
            res += reward2[i];
        }
        for (int i = 2000; k > 0; i--) {
            if (counts[i] > k) {
                res += i * k;
                k = 0;
            } else {
                res += i * counts[i];
                k -= counts[i];
            }
        }
        return res;
    }
}
