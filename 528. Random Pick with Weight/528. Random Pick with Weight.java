/*
 * Problem: 528. Random Pick with Weight
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/random-pick-with-weight/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    int[] w;
    int sum;

    public Solution(int[] w) {
        this.w = w;
        for (int i = 1; i < w.length; i++) {
            w[i] += w[i - 1];
        }
        sum = w[w.length - 1];
    }

    public int pickIndex() {
        int res = Arrays.binarySearch(w, (int) (Math.random() * sum) + 1);
        if (res < 0)
            res = -res - 1;
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
