/*
 * Problem: 1426. Counting Elements
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/counting-elements/
 * Language: java
 * Date: 2026-04-17
 */

class Solution {
    public int countElements(int[] arr) {
        int[] counts = new int[1002];
        int res = 0;
        for (int num : arr) {
            counts[num]++;
        }
        for (int num : arr) {
            if (counts[num + 1] > 0) {
                res++;
            }
        }
        return res;
    }
}
