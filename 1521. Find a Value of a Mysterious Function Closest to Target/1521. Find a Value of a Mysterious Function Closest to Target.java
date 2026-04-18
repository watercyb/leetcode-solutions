/*
 * Problem: 1521. Find a Value of a Mysterious Function Closest to Target
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-a-value-of-a-mysterious-function-closest-to-target/
 * Language: java
 * Date: 2026-04-18
 */

class Solution {
    public int closestToTarget(int[] arr, int target) {
        int[] ands = new int[23];
        int r = 0;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length && res != 0; i++) {
            int idx = 0;
            int prv = -1;
            ands[r++] = arr[i];
            for (int j = 0; j < r; j++) {
                int next = ands[j] & arr[i];
                if (next == prv)
                    continue;
                res = Math.min(Math.abs(next - target), res);
                if (next != 0) {
                    ands[idx++] = next;
                    prv = next;
                }
            }
            r = idx;
        }
        return res;
    }
}
