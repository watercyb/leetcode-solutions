/*
 * Problem: 1502. Can Make Arithmetic Progression From Sequence
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/
 * Language: java
 * Date: 2026-04-18
 */

class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int step = arr[1] - arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (step != arr[i] - arr[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
