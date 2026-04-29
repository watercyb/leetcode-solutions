/*
 * Problem: 2605. Form Smallest Number From Two Digit Arrays
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/form-smallest-number-from-two-digit-arrays/
 * Language: java
 * Date: 2026-04-29
 */

class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        int min1 = 9;
        int min = 10;
        boolean[] seens = new boolean[10];
        for (int num : nums1) {
            min1 = Math.min(num, min1);
            seens[num] = true;
        }
        int min2 = 9;
        for (int num : nums2) {
            min2 = Math.min(num, min2);
            if (seens[num])
                min = Math.min(num, min);
        }
        if (min < 10)
            return min;
        if (min1 < min2)
            return min1 * 10 + min2;
        return min2 * 10 + min1;
    }
}
