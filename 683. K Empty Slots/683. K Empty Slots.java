/*
 * Problem: 683. K Empty Slots
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/k-empty-slots/
 * Language: java
 * Date: 2026-04-06
 */

class Solution {
    public int kEmptySlots(int[] bulbs, int k) {
        if (k > bulbs.length - 2)
            return -1;
        int[] arr = new int[bulbs.length];
        for (int i = 0; i < bulbs.length; i++) {
            arr[bulbs[i] - 1] = i;
        }
        int res = Integer.MAX_VALUE;
        int prv = -1;
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < bulbs.length - k - 1; i++) {
            if (i == prv) {
                res = Math.min(max, res);
                prv = i + k + 1;
                max = Math.max(arr[i], arr[i + k + 1]);
            } else if (arr[i] < max) {
                prv = i + k + 1;
                max = Math.max(arr[i], arr[i + k + 1]);
            }
        }
        for (int i = bulbs.length - k - 1; i < bulbs.length; i++) {
            if (i == prv) {
                res = Math.min(max, res);
                break;
            } else if (arr[i] < max) {
                break;
            }
        }
        if (res == Integer.MAX_VALUE)
            return -1;
        return res + 1;
    }
}
